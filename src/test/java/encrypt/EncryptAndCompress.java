/* $Id: EncryptAndCompress.java,v 1.2 2005/03/13 17:46:35 woudt Exp $
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
import cryptix.openpgp.PGPArmouredMessage;
import cryptix.pki.KeyBundle;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.Collection;



/**
 * Detailed example for encrypting a message with compression.
 * This example assumes that the GenerateAndWriteKey example has been run first.
 *
 * @author  Edwin Woudt <edwin@cryptix.org>
 * @version $Revision: 1.2 $
 */
public class EncryptAndCompress {

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
        KeyBundle bundle = null;
        
        try {

            FileInputStream in = new FileInputStream("bob-public.pgp.asc");

            MessageFactory mf = MessageFactory.getInstance("OpenPGP");
            Collection msgs = mf.generateMessages(in);
            
            KeyBundleMessage kbm = (KeyBundleMessage)msgs.iterator().next();
            
            bundle = kbm.getKeyBundle();

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
        LiteralMessage litmsg = null;
        try {
            String msg = "This is a test message.\n" +
                         "This is another line.\n";
            LiteralMessageBuilder lmb = 
                LiteralMessageBuilder.getInstance("OpenPGP");
            lmb.init(msg);
            litmsg = (LiteralMessage)lmb.build();
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
        // Encrypt the message.
        //**********************************************************************
        Message msg = null;
        try {
            
            EncryptedMessageBuilder emb = 
                EncryptedMessageBuilder.getInstance("OpenPGP");
            emb.init(litmsg);
            emb.addRecipient(bundle);
            emb.setAttribute("compressed", "true");
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
            FileOutputStream out = new FileOutputStream("encrypted-to-bob.asc");
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
