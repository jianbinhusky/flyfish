/* $Id: EncryptAndSign.java,v 1.3 2005/03/13 17:46:35 woudt Exp $
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


import cryptix.message.EncryptedMessageBuilder;
import cryptix.message.KeyBundleMessage;
import cryptix.message.LiteralMessageBuilder;
import cryptix.message.Message;
import cryptix.message.MessageException;
import cryptix.message.MessageFactory;
import cryptix.message.SignedMessageBuilder;

import cryptix.openpgp.PGPArmouredMessage;

import cryptix.pki.KeyBundle;
import cryptix.pki.KeyBundleException;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import java.security.NoSuchAlgorithmException;
import java.security.UnrecoverableKeyException;

import java.util.Collection;


/**
 * Detailed example for encrypting and signing a message.
 * This example assumes that the GenerateAndWriteKey example has been run first.
 *
 * @author  Edwin Woudt <edwin@cryptix.org>
 * @version $Revision: 1.3 $
 */
public class EncryptAndSign {

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
        // First read the keys. 
        //**********************************************************************
        KeyBundle publicBob   = null;
        KeyBundle secretAlice = null;
        
        try {

            FileInputStream in; Collection msgs; KeyBundleMessage kbm;
            
            MessageFactory mf = MessageFactory.getInstance("OpenPGP");

            in = new FileInputStream("bob-public.pgp.asc");
            msgs = mf.generateMessages(in);
            kbm = (KeyBundleMessage)msgs.iterator().next();
            publicBob = kbm.getKeyBundle();
            in.close();
        
            in = new FileInputStream("alice-secret.pgp");
            msgs = mf.generateMessages(in);
            kbm = (KeyBundleMessage)msgs.iterator().next();
            secretAlice = kbm.getKeyBundle();
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
        //  Build the literal message.
        //**********************************************************************
        Message msg = null;
        
        try {
            String data = "This is a test message.\n" +
                          "This is another line.\n";
            LiteralMessageBuilder lmb = 
                LiteralMessageBuilder.getInstance("OpenPGP");
            lmb.init(data);
            msg = lmb.build();
        } catch (NoSuchAlgorithmException nsae) {
            System.err.println("Cannot find the OpenPGP LiteralMessageBuilder."+
                " This usually means that the Cryptix OpenPGP provider is not "+
                "installed correctly.");
            nsae.printStackTrace();
            System.exit(-1);
        } catch (MessageException me) {
            System.err.println("Creating the literal message failed.");
            me.printStackTrace();
            System.exit(-1);
        }
        

        //**********************************************************************
        // Sign the message.
        //
        // Note that signing usually comes before encryption, such that
        // unauthorized parties cannot see who signed the message.
        //**********************************************************************
        try {
        
            SignedMessageBuilder smb = 
                SignedMessageBuilder.getInstance("OpenPGP");
            
            // use the following line for compatibility with older PGP versions

            // SignedMessageBuilder smb = 
            //     SignedMessageBuilder.getInstance("OpenPGP/V3");
            
            smb.init(msg);
            smb.addSigner(secretAlice, "TestingPassphrase".toCharArray());

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
        // Encrypt the message.
        //**********************************************************************
        try {
            
            EncryptedMessageBuilder emb = 
                EncryptedMessageBuilder.getInstance("OpenPGP");
            emb.init(msg);
            emb.addRecipient(publicBob);
            msg = emb.build();
        
        } catch (NoSuchAlgorithmException nsae) {
            System.err.println("Cannot find the OpenPGP "+
                "EncryptedMessageBuilder. "+
                "This usually means that the Cryptix OpenPGP provider is not "+
                "installed correctly.");
            nsae.printStackTrace();
            System.exit(-1);
        } catch (MessageException me) {
            System.err.println("Creating the encrypted message failed.");
            me.printStackTrace();
            System.exit(-1);
        }
        

        //**********************************************************************
        // Armour the message and write it to disk
        //**********************************************************************
        try {
            
            PGPArmouredMessage armoured;
        
            armoured = new PGPArmouredMessage(msg);
            FileOutputStream out = new FileOutputStream("encrypted-signed.asc");
            out.write(armoured.getEncoded());
            out.close();
        
        } catch (MessageException me) {
            System.err.println("Writing the encrypted message failed.");
            me.printStackTrace();
            System.exit(-1);
        } catch (IOException ioe) {
            System.err.println("Writing the encrypted message failed.");
            ioe.printStackTrace();
            System.exit(-1);
        }
        
    }

}
