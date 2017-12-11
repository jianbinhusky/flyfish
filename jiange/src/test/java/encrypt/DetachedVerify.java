/* $Id: DetachedVerify.java,v 1.2 2005/03/13 17:46:35 woudt Exp $
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


import cryptix.message.LiteralMessageBuilder;
import cryptix.message.Message;
import cryptix.message.MessageException;
import cryptix.message.MessageFactory;

import cryptix.openpgp.PGPDetachedSignatureMessage;

import cryptix.pki.KeyBundle;
import cryptix.pki.KeyBundleException;
import cryptix.pki.KeyBundleFactory;

import java.io.FileInputStream;
import java.io.IOException;

import java.security.NoSuchAlgorithmException;


/**
 * Detailed example for verifying a detached signature.
 * Assumes that the GenerateAndWriteKey and DetachedSign examples have been run.
 *
 * @author  Edwin Woudt <edwin@cryptix.org>
 * @version $Revision: 1.2 $
 */
public class DetachedVerify {


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
        // Read the signed file
        //**********************************************************************
        Message originalMsg = null;
        
        try {
        
            FileInputStream in = new FileInputStream("detached.test");
            byte[] data = new byte[in.available()];
            in.read(data);

            LiteralMessageBuilder lmb = 
                LiteralMessageBuilder.getInstance("OpenPGP");
            lmb.init(data);
            originalMsg = lmb.build();

        } catch (NoSuchAlgorithmException nsae) {
            System.err.println("Cannot find the OpenPGP LiteralMessageBuilder."+
                " This usually means that the Cryptix OpenPGP provider is not "+
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
        // Read the detached signature
        //**********************************************************************
        PGPDetachedSignatureMessage detachedSig = null;
        
        try {
        
            MessageFactory mf = MessageFactory.getInstance("OpenPGP");
            FileInputStream in = new FileInputStream("detached.test.sig");
            detachedSig = (PGPDetachedSignatureMessage)
                           mf.generateMessages(in).iterator().next();
            
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
        // Verify the message.
        //**********************************************************************
        try {
        
            if (detachedSig.verify(originalMsg, bundle)) {
                System.out.println("Signature OK");
            } else {
                System.out.println("Signature BAD");
            }
        
        } catch (MessageException me) {
            System.err.println("Verifying the signature failed.");
            me.printStackTrace();
            System.exit(-1);
        }

    }
    
}
