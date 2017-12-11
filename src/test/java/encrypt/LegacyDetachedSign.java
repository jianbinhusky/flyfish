/* $Id: LegacyDetachedSign.java,v 1.2 2005/03/13 17:46:35 woudt Exp $
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


import cryptix.message.*;
import cryptix.openpgp.PGPSignedMessage;
import cryptix.pki.KeyBundle;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.security.UnrecoverableKeyException;
import java.util.Collection;


/**
 * Detailed example for creating a detached signature with a legacy key.
 * Assumes that the LegacyGenerateAKey example has been run.
 *
 * @author  Edwin Woudt <edwin@cryptix.org>
 * @version $Revision: 1.2 $
 */
public class LegacyDetachedSign {


    //**************************************************************************
    // Main method, will be run on startup.
    //**************************************************************************
    public static void main(String[] args) {
    
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
        KeyBundle bundle = null;
        MessageFactory mf     = null;
        
        try {

            FileInputStream in; Collection msgs; KeyBundleMessage kbm;

            mf = MessageFactory.getInstance("OpenPGP");

            in = new FileInputStream("leg-sec.asc");
            msgs = mf.generateMessages(in);
            kbm = (KeyBundleMessage)msgs.iterator().next();
            bundle = kbm.getKeyBundle();
            in.close();
        
        } catch (IOException ioe) {
            System.err.println("IOException... You did remember to run the "+
                "GenerateAndWriteKey example first, right?");
            ioe.printStackTrace();
            System.exit(-1);
        } catch (NoSuchAlgorithmException nsae) {
            System.err.println("Cannot find the OpenPGP KeyBundleFactory. "+
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
        // Create the message.
        //**********************************************************************
        Message originalMsg = null;
        byte[] originalData = "Hello world!\n".getBytes();
        
        try {
        
            LiteralMessageBuilder lmb = 
                LiteralMessageBuilder.getInstance("OpenPGP");

            // WARNING: detached signatures are usually binary.
            // Therefore, do not initialize the literal message with a string,
            // because that will cause a text signature to be generated.
            lmb.init(originalData);

            originalMsg = lmb.build();
            
        } catch (NoSuchAlgorithmException nsae) {
            System.err.println("Cannot find the OpenPGP LiteralMessageBuilder. "+
                "This usually means that the Cryptix OpenPGP provider is not "+
                "installed correctly.");
            nsae.printStackTrace();
            System.exit(-1);
        } catch (MessageException me) {
            System.err.println("Generating the message failed.");
            me.printStackTrace();
            System.exit(-1);
        }
        

        //**********************************************************************
        // Sign the message.
        //**********************************************************************
        Message detachedSig = null;

        try {
        
            SignedMessageBuilder smb = 
                SignedMessageBuilder.getInstance("OpenPGP/Legacy");

            smb.init(originalMsg);
            smb.addSigner(bundle, "TestingPassphrase".toCharArray());

            PGPSignedMessage msg = (PGPSignedMessage)smb.build();
            detachedSig = msg.getDetachedSignature();
        
        } catch (NoSuchAlgorithmException nsae) {
            System.err.println("Cannot find the OpenPGP SignedMessageBuilder. "+
                "This usually means that the Cryptix OpenPGP provider is not "+
                "installed correctly.");
            nsae.printStackTrace();
            System.exit(-1);
        } catch (UnrecoverableKeyException uke) {
            System.err.println("Incorrect passphrase.");
            uke.printStackTrace();
            System.exit(-1);
        } catch (MessageException me) {
            System.err.println("Generating the message failed.");
            me.printStackTrace();
            System.exit(-1);
        }


        //**********************************************************************
        // Write the message.
        //**********************************************************************
        try {
        
            FileOutputStream out;

            out = new FileOutputStream("leg-det");
            out.write(originalData);
            out.close();

            out = new FileOutputStream("leg-det.sig");
            out.write(detachedSig.getEncoded());
            out.close();

        } catch (IOException ioe) {
            System.err.println("Writing the message failed.");
            ioe.printStackTrace();
            System.exit(-1);
        } catch (MessageException me) {
            System.err.println("Writing the message failed.");
            me.printStackTrace();
            System.exit(-1);
        }

    }
    
}
