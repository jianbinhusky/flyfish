/* $Id: StreamSign.java,v 1.1 2005/03/29 11:22:49 woudt Exp $
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
 * Detailed example for signing a message through streaming. This is especially
 * handy for signing large files that do not fit in memory.
 * This example assumes that the GenerateAndWriteKey example has been run first.
 *
 * @author  Edwin Woudt <edwin@cryptix.org>
 * @version $Revision: 1.1 $
 */
public class StreamSign {

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
        //  The actual stream signing.
        //**********************************************************************
        try {
            FileOutputStream fileos = 
                new FileOutputStream("large-signed.pgp");
            LiteralMessageOutputStream litmos = 
                LiteralMessageOutputStream.getInstance("OpenPGP");
            SignedMessageOutputStream sigmos = 
                SignedMessageOutputStream.getInstance("OpenPGP");
            // note: for older PGP (7 and below) versions, one should use 
            //  SignedMessageOutputStream.getInstance("OpenPGP/V3");

            SecureRandom sr = new SecureRandom();
            
            litmos.init(sigmos, sr);   // Literal writes to Signed
            sigmos.init(fileos, sr);   // Signed writes to file
            
            sigmos.addSigner(bundle, "TestingPassphrase".toCharArray());
            
            for (int i=0; i<10000; i++) // we write to literal
                litmos.write( (i+" This is a large message.\r\n").getBytes() );

            litmos.close();

        } catch (NoSuchAlgorithmException nsae) {
            System.err.println("Cannot find OpenPGP implementation."+
                " This usually means that the Cryptix OpenPGP provider is not "+
                "installed correctly.");
            nsae.printStackTrace();
            System.exit(-1);
        } catch (UnrecoverableKeyException uke) {
            System.err.println("Incorrect passphrase.");
            uke.printStackTrace();
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
