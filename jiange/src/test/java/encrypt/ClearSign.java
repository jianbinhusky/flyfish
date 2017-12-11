/* $Id: ClearSign.java,v 1.3 2005/03/13 17:46:35 woudt Exp $
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


import cryptix.message.LiteralMessage;
import cryptix.message.LiteralMessageBuilder;
import cryptix.message.Message;
import cryptix.message.MessageException;
import cryptix.message.SignedMessage;
import cryptix.message.SignedMessageBuilder;

import cryptix.openpgp.PGPArmouredMessage;
import cryptix.openpgp.PGPKeyBundle;

import cryptix.pki.KeyBundle;
import cryptix.pki.KeyBundleException;
import cryptix.pki.KeyBundleFactory;

import java.io.FileOutputStream;
import java.io.FileInputStream;
import java.io.IOException;

import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.security.UnrecoverableKeyException;


/**
 * Detailed example for generating a clearsigned message.
 * Assumes that the GenerateAndWriteKey example has been run.
 *
 * @author  Edwin Woudt <edwin@cryptix.org>
 * @version $Revision: 1.3 $
 */
public class ClearSign {


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
        
        try {

            FileInputStream in = new FileInputStream("alice-secret.pgp");

            KeyBundleFactory kbf = 
                KeyBundleFactory.getInstance("OpenPGP");
            bundle = kbf.generateKeyBundle(in);

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
        } catch (KeyBundleException kbe) {
            System.err.println("Reading keybundle failed.");
            kbe.printStackTrace();
            System.exit(-1);
        }


        //**********************************************************************
        // Create the message.
        //**********************************************************************
        Message msg = null;
        
        try {
        
            LiteralMessageBuilder lmb = 
                LiteralMessageBuilder.getInstance("OpenPGP");

            lmb.init("This is a text message \n"+
                     "This is another line\n");

            msg = lmb.build();
            
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
        try {
        
            SignedMessageBuilder smb = 
                SignedMessageBuilder.getInstance("OpenPGP");

            // use the following line for compatibility with older PGP versions

            // SignedMessageBuilder smb = 
            //     SignedMessageBuilder.getInstance("OpenPGP/V3");

            smb.init(msg);
            smb.addSigner(bundle, "TestingPassphrase".toCharArray());

            msg = smb.build();
        
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
        // Armour the message.
        //**********************************************************************
        msg = new PGPArmouredMessage(msg);


        //**********************************************************************
        // Write the message.
        //**********************************************************************
        try {
        
            FileOutputStream out = new FileOutputStream("cleartext.asc");
            out.write(msg.getEncoded());
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
