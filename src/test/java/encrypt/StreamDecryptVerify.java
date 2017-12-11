/* $Id: StreamDecryptVerify.java,v 1.1 2005/03/29 11:22:49 woudt Exp $
 *
 * Copyright (C) 1999-2005 The Cryptix Foundation Limited.
 * All rights reserved.
 * 
 * Use, modification, copying and distribution of this software is subject 
 * the terms and conditions of the Cryptix General Licence. You should have 
 * received a copy of the Cryptix General License along with this library; 
 * if not, you can download a copy from http://www.cryptix.org/ .
 */

package encrypt;


import cryptix.message.KeyBundleMessage;
import cryptix.message.MessageException;
import cryptix.message.MessageFactory;

import cryptix.message.stream.DecodedMessageInputStream;
import cryptix.message.stream.DecryptionKeyCallback;
import cryptix.message.stream.DecryptionKeyRequest;
import cryptix.message.stream.DecryptionKeyReturnValue;
import cryptix.message.stream.MessageStreamException;
import cryptix.message.stream.VerificationKeyCallback;
import cryptix.message.stream.VerificationKeyRequest;
import cryptix.message.stream.VerificationKeyReturnValue;

import cryptix.openpgp.PGPKeyBundle;

import cryptix.pki.KeyBundle;
import cryptix.pki.KeyBundleFactory;
import cryptix.pki.KeyBundleException;
import cryptix.pki.KeyID;
import cryptix.pki.KeyIDFactory;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.security.UnrecoverableKeyException;

import java.util.Collection;
import java.util.Iterator;


/**
 * Detailed example for decrypting and verifying a message through streaming. 
 * This is especially handy for processing large files that do not fit in 
 * memory. 
 * This example assumes that the GenerateAndWriteKey and StreamEncryptSign 
 * examples have been run first.
 *
 * @author  Edwin Woudt <edwin@cryptix.org>
 * @version $Revision: 1.1 $
 */
public class StreamDecryptVerify 
    implements DecryptionKeyCallback, VerificationKeyCallback
{

    private PGPKeyBundle publicAlice = null;
    private PGPKeyBundle secretBob   = null;

    public static void main(String[] args) {
        (new StreamDecryptVerify()).run();
    }

    private void run() {

        //**********************************************************************
        // Dynamically register both the Cryptix JCE and Cryptix OpenPGP 
        // providers. 
        //**********************************************************************
        java.security.Security.addProvider(
            new cryptix.jce.provider.CryptixCrypto() );
        java.security.Security.addProvider(
            new cryptix.openpgp.provider.CryptixOpenPGP() );
            
        
        //**********************************************************************
        // First read the keys. 
        //**********************************************************************
        try {

            FileInputStream in; Collection msgs; KeyBundleMessage kbm;
            
            MessageFactory mf = MessageFactory.getInstance("OpenPGP");

            in = new FileInputStream("bob-secret.pgp.asc");
            msgs = mf.generateMessages(in);
            kbm = (KeyBundleMessage)msgs.iterator().next();
            secretBob = (PGPKeyBundle)kbm.getKeyBundle();
            in.close();
        
            in = new FileInputStream("alice-public.pgp");
            msgs = mf.generateMessages(in);
            kbm = (KeyBundleMessage)msgs.iterator().next();
            publicAlice = (PGPKeyBundle)kbm.getKeyBundle();
            in.close();
        
        } catch (IOException ioe) {
            System.err.println("IOException... You did remember to run the "+
                "GenerateAndWriteKey example first, right?");
            ioe.printStackTrace();
            System.exit(-1);
        } catch (NoSuchAlgorithmException nsae) {
            System.err.println("Cannot find the OpenPGP MessageFactory. "+
                "This usually means that the Cryptix OpenPGP provider is not "+
                "installed correctly.");
            nsae.printStackTrace();
            System.exit(-1);
        } catch (MessageException me) {
            System.err.println("Reading keybundle failed.");
            me.printStackTrace();
            System.exit(-1);
        }


        //**********************************************************************
        //  The actual stream decryption and verification.
        //**********************************************************************
        try {
            FileInputStream fileInputStream = 
                new FileInputStream("large-encrypted-signed.pgp");
            FileOutputStream fileOutputStream = 
                new FileOutputStream("large-encrypted-signed.out");
            DecodedMessageInputStream decodedInputStream = 
                DecodedMessageInputStream.getInstance("OpenPGP");
            decodedInputStream.init(fileInputStream, this, this);
            
            System.out.println("Decoding message...");
            
            byte[] buf = new byte[4096];
            int len = decodedInputStream.read(buf);
            while (len > 0) {
                fileOutputStream.write(buf, 0, len);
                len = decodedInputStream.read(buf);
            }
            decodedInputStream.close();
            fileInputStream.close();
            fileOutputStream.close();
            
            System.out.println("Decoding done.");
            
            switch(decodedInputStream.getVerificationResult()) {
                case DecodedMessageInputStream.VERIFICATION_NOT_SIGNED:
                    System.out.println("Message was not signed.");
                    break;
                case DecodedMessageInputStream.VERIFICATION_GOOD_SIGNATURE:
                    System.out.println("Message has a GOOD signature.");
                    break;
                case DecodedMessageInputStream.VERIFICATION_BAD_SIGNATURE:
                    System.out.println("Message has a BAD signature.");
                    break;
                default:
                    System.out.println("Unknown verification result.");
                    break;
            }

            switch(decodedInputStream.getIntegrityResult()) {
                case DecodedMessageInputStream.INTEGRITY_NOT_PROTECTED:
                    System.out.println("Message was not integrity protected.");
                    break;
                case DecodedMessageInputStream.INTEGRITY_GOOD:
                    System.out.println("Message integrity preserved.");
                    break;
                case DecodedMessageInputStream.INTEGRITY_VIOLATED:
                    System.out.println("Message integrity VIOLATED.");
                    break;
                default:
                    System.out.println("Unknown intregrity result.");
                    break;
            }

        } catch (NoSuchAlgorithmException nsae) {
            System.err.println("Cannot find OpenPGP implementation."+
                " This usually means that the Cryptix OpenPGP provider is not "+
                "installed correctly.");
            nsae.printStackTrace();
            System.exit(-1);
        } catch (MessageStreamException me) {
            System.err.println("Streaming the message failed.");
            me.printStackTrace();
            System.exit(-1);
        } catch (IOException ioe) {
            System.err.println("IO error.");
            ioe.printStackTrace();
            System.exit(-1);
        }
    }

    public VerificationKeyReturnValue getVerificationKey(
        VerificationKeyRequest request)
    {
        try {
            
            // If something goes wrong, this method is called again. In that 
            // case we could for example try another key. For this example, no
            // more keys are available, so return an error.

            if (request.getRetryCount() >= 1)
                return new VerificationKeyReturnValue(
                    VerificationKeyReturnValue.IGNORE);
            
            // The code below is just to check the keyid hints. If you know for 
            // sure what key to use, just return it without checking, like:
            //   return new VerificationKeyReturnValue(publicAlice);
            
            KeyID[] hintIDs = request.getKeyIDHints();
            
            KeyIDFactory kidf = KeyIDFactory.getInstance("OpenPGP");
            KeyID aliceID = kidf.generateKeyID(
                (PublicKey)publicAlice.getPublicKeys().next());
            
            for(int i=0; i<hintIDs.length; i++)
                if (hintIDs[i].match(aliceID))
                    return new VerificationKeyReturnValue(publicAlice);
    
            return new VerificationKeyReturnValue(
                VerificationKeyReturnValue.IGNORE);

        } catch (NoSuchAlgorithmException nsae) {
            System.err.println("Cannot find OpenPGP implementation."+
                " This usually means that the Cryptix OpenPGP provider is not "+
                "installed correctly.");
            nsae.printStackTrace();
            throw new RuntimeException();
        } catch (InvalidKeyException ike) {
            System.err.println("Invalid key.");
            ike.printStackTrace();
            throw new RuntimeException();
        }
    }
    
    public DecryptionKeyReturnValue getDecryptionKey(
        DecryptionKeyRequest request)
    {
        try {

            // If something goes wrong, this method is called again. In that 
            // case we could for example try another key. For this example, no
            // more keys are available, so return an error.
            
            if (request.getRetryCount() >= 1)
                return new DecryptionKeyReturnValue(
                    DecryptionKeyReturnValue.FAIL);
            
            // The code below is just to check the keyid hints. If you know for 
            // sure what key to use, just return it without checking, like:
            //   return new VerificationKeyReturnValue(secretBob);
            
            KeyID[] hintIDs = request.getKeyIDHints();
            
            KeyIDFactory kidf = KeyIDFactory.getInstance("OpenPGP");
            KeyID bobID = kidf.generateKeyID(
                (PublicKey)secretBob.getPublicKeys().next());
            
            for(int i=0; i<hintIDs.length; i++) 
            {
                if (hintIDs[i].match(bobID))
                    return new DecryptionKeyReturnValue(secretBob,
                        "TestingPassphrase".toCharArray());
                
                Iterator it = secretBob.getPublicSubKeys();
                while (it.hasNext())
                {
                    KeyID bobSubID = kidf.generateKeyID(
                        (PublicKey)it.next());
    
                    if (hintIDs[i].match(bobSubID))
                        return new DecryptionKeyReturnValue(secretBob,
                            "TestingPassphrase".toCharArray());
                }
            }
            
            return new DecryptionKeyReturnValue(DecryptionKeyReturnValue.FAIL);
    
        } catch (NoSuchAlgorithmException nsae) {
            System.err.println("Cannot find OpenPGP implementation."+
                " This usually means that the Cryptix OpenPGP provider is not "+
                "installed correctly.");
            nsae.printStackTrace();
            throw new RuntimeException();
        } catch (InvalidKeyException ike) {
            System.err.println("Invalid key.");
            ike.printStackTrace();
            throw new RuntimeException();
        }
    }
    
}
