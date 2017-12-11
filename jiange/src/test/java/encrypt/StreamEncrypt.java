/* $Id: StreamEncrypt.java,v 1.1 2005/03/29 11:22:49 woudt Exp $
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

import cryptix.message.stream.EncryptedMessageOutputStream;
import cryptix.message.stream.LiteralMessageOutputStream;
import cryptix.message.stream.MessageStreamException;
import cryptix.message.stream.SignedMessageOutputStream;

import cryptix.pki.KeyBundle;
import cryptix.pki.KeyBundleFactory;
import cryptix.pki.KeyBundleException;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.UnrecoverableKeyException;

import java.util.Collection;


/**
 * Detailed example for encrypting a message through streaming. This is 
 * especially handy for encrypting large files that do not fit in memory.
 * This example assumes that the GenerateAndWriteKey example has been run first.
 *
 * @author  Edwin Woudt <edwin@cryptix.org>
 * @version $Revision: 1.1 $
 */
public class StreamEncrypt {

    public static void main (String[] args) {

        //**********************************************************************
        // Dynamically register both the Cryptix JCE and Cryptix OpenPGP 
        // providers. 
        //**********************************************************************
        java.security.Security.addProvider(
            new cryptix.jce.provider.CryptixCrypto() );
        java.security.Security.addProvider(
            new cryptix.openpgp.provider.CryptixOpenPGP() );
            
        
        //**********************************************************************
        // First read the key. 
        //**********************************************************************
        KeyBundle publicBob   = null;
        
        try {

            FileInputStream in; Collection msgs; KeyBundleMessage kbm;
            
            MessageFactory mf = MessageFactory.getInstance("OpenPGP");

            in = new FileInputStream("bob-public.pgp.asc");
            msgs = mf.generateMessages(in);
            kbm = (KeyBundleMessage)msgs.iterator().next();
            publicBob = kbm.getKeyBundle();
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
        //  The actual stream encryption.
        //**********************************************************************
        try {
            FileOutputStream fileos = 
                new FileOutputStream("large-encrypted.pgp");
            LiteralMessageOutputStream litmos = 
                LiteralMessageOutputStream.getInstance("OpenPGP");
            EncryptedMessageOutputStream encmos = 
                EncryptedMessageOutputStream.getInstance("OpenPGP");

            SecureRandom sr = new SecureRandom();
            
            litmos.init(encmos, sr);   // Literal writes to Encrypted
            encmos.init(fileos, sr);   // Encrypted writes to file
            
            encmos.addRecipient(publicBob);
            
            for (int i=0; i<10000; i++) // we write to literal
                litmos.write( (i+" This is a large message.\r\n").getBytes() );

            litmos.close();

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

}
