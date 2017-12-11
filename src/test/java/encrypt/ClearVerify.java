/* $Id: ClearVerify.java,v 1.2 2005/03/13 17:46:35 woudt Exp $
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
import cryptix.message.Message;
import cryptix.message.MessageException;
import cryptix.message.MessageFactory;
import cryptix.message.SignedMessage;

import cryptix.pki.KeyBundle;
import cryptix.pki.KeyBundleException;
import cryptix.pki.KeyBundleFactory;

import java.io.FileInputStream;
import java.io.IOException;

import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;


/**
 * Detailed example for verifying a cleartext signed message.
 * Assumes that the GenerateAndWriteKey and ClearSign examples have been run.
 *
 * @author  Edwin Woudt <edwin@cryptix.org>
 * @version $Revision: 1.2 $
 */
public class ClearVerify {


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

            FileInputStream in = new FileInputStream("alice-public.pgp");

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
        // Read the message.
        //**********************************************************************
        Message msg = null;
        
        try {
        
            MessageFactory mf = MessageFactory.getInstance("OpenPGP");

            FileInputStream in = new FileInputStream("cleartext.asc");

            msg = (Message)mf.generateMessages(in).iterator().next();
            
        } catch (NoSuchAlgorithmException nsae) {
            System.err.println("Cannot find the OpenPGP MessageFactory. "+
                "This usually means that the Cryptix OpenPGP provider is not "+
                "installed correctly.");
            nsae.printStackTrace();
            System.exit(-1);
        } catch (MessageException me) {
            System.err.println("Reading the message failed.");
            me.printStackTrace();
            System.exit(-1);
        } catch (IOException ioe) {
            System.err.println("Reading the message failed.");
            ioe.printStackTrace();
            System.exit(-1);
        }
        

        //**********************************************************************
        // Verify the signature.
        //**********************************************************************
        SignedMessage sm = null;

        try {
        
            if (! (msg instanceof SignedMessage)) {
                System.err.println("Message is not a SignedMessage");
                System.exit(-1);
            }
        
            sm = (SignedMessage)msg;
            if (sm.verify(bundle)) {
                System.out.println("Signature OK");
            } else {
                System.out.println("Signature BAD");
            }
        
        } catch (MessageException me) {
            System.err.println("Verifying the signature failed.");
            me.printStackTrace();
            System.exit(-1);
        }


        //**********************************************************************
        // Retrieve the original message
        //**********************************************************************

        try {
        
            if (! (sm.getContents() instanceof LiteralMessage)) {
                System.err.println("Not a cleartext signed message.");
                System.exit(-1);
            }

            LiteralMessage lm = (LiteralMessage)sm.getContents();

            System.out.println("The original message was: ");
            System.out.println(lm.getTextData());

        } catch (MessageException me) {
            System.err.println("Retrieving the original message failed.");
            me.printStackTrace();
            System.exit(-1);
        }

    }
    
}
