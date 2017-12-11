/* $Id: LegacyDecryptAndVerify.java,v 1.1 2005/03/13 17:12:58 woudt Exp $
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


import cryptix.message.EncryptedMessage;
import cryptix.message.KeyBundleMessage;
import cryptix.message.LiteralMessage;
import cryptix.message.Message;
import cryptix.message.MessageException;
import cryptix.message.MessageFactory;
import cryptix.message.NotEncryptedToParameterException;
import cryptix.message.SignedMessage;

import cryptix.pki.KeyBundle;
import cryptix.pki.KeyBundleException;

import java.io.FileInputStream;
import java.io.IOException;

import java.security.NoSuchAlgorithmException;
import java.security.UnrecoverableKeyException;

import java.util.Collection;


/**
 * This example is identical to the regular DecryptAndVerify, except for the
 * filenames. This is to show that for decryption and verification there is
 * no difference between what versions are used.
 *
 * @author  Edwin Woudt <edwin@cryptix.org>
 * @version $Revision: 1.1 $
 */
public class LegacyDecryptAndVerify {


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
        // First read the keys. 
        //**********************************************************************
        KeyBundle secretBob   = null;
        KeyBundle publicAlice = null;
        MessageFactory mf     = null;
        
        try {

            FileInputStream in; Collection msgs; KeyBundleMessage kbm;
            
            mf = MessageFactory.getInstance("OpenPGP");

            in = new FileInputStream("leg-sec.asc");
            msgs = mf.generateMessages(in);
            kbm = (KeyBundleMessage)msgs.iterator().next();
            secretBob = kbm.getKeyBundle();
            in.close();
        
            in = new FileInputStream("leg-pub.asc");
            msgs = mf.generateMessages(in);
            kbm = (KeyBundleMessage)msgs.iterator().next();
            publicAlice = kbm.getKeyBundle();
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
        //  Read the message.
        //**********************************************************************
        Message msg = null;
        
        try {

            FileInputStream in = new FileInputStream("leg-msg.asc");

            Collection msgs = mf.generateMessages(in);
            msg = (Message)msgs.iterator().next();

            in.close();
        
        } catch (IOException ioe) {
            System.err.println("IOException... You did remember to run one of "+
                "the LegacyEncrypt* or Legacy*Sign examples first, right?");
            ioe.printStackTrace();
            System.exit(-1);
        } catch (MessageException me) {
            System.err.println("Reading message failed.");
            me.printStackTrace();
            System.exit(-1);
        }
        

        //**********************************************************************
        // Decrypt the message (if encrypted).
        //**********************************************************************
        try {

            if (msg instanceof EncryptedMessage) {

                msg = ((EncryptedMessage)msg).decrypt(secretBob, 
                                            "TestingPassphrase".toCharArray());
                       
                System.out.println("Message has been decrypted.");

            } else {
            
                System.out.println("Message is not encrypted.");

            }
        
        } catch (NotEncryptedToParameterException netpe) {
            System.err.println("Not encrypted to this key.");
            netpe.printStackTrace();
            System.exit(-1);
        } catch (UnrecoverableKeyException uke) {
            System.err.println("Invalid passphrase.");
            uke.printStackTrace();
            System.exit(-1);
        } catch (MessageException me) {
            System.err.println("Decrypting message failed.");
            me.printStackTrace();
            System.exit(-1);
        }
        

        //**********************************************************************
        // Verify the signature (if signed).
        //**********************************************************************
        try {
        
            if (msg instanceof SignedMessage) {

                if (((SignedMessage)msg).verify(publicAlice)) {
                    System.out.println("Signature OK.");
                } else {
                    System.out.println("Signature BAD!");
                }

                msg = ((SignedMessage)msg).getContents();

            } else {

                System.out.println("Message is not signed.");

            }
        
        } catch (MessageException me) {
            System.err.println("Verifying the signature failed.");
            me.printStackTrace();
            System.exit(-1);
        }


        //**********************************************************************
        // Show the original message
        //**********************************************************************

        try {
        
            if (msg instanceof LiteralMessage) {

                System.out.println("Original message: ");
                System.out.println(((LiteralMessage)msg).getTextData());

            } else {
            
                System.out.println("Original message is not a literal message");
                System.out.println(msg);

            }

        } catch (MessageException me) {
            System.err.println("Retrieving the original message failed.");
            me.printStackTrace();
            System.exit(-1);
        }

    }
    
}
