/* $Id: ReadKeyRingSignKey.java,v 1.2 2005/03/13 17:46:35 woudt Exp $
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

import cryptix.openpgp.PGPKeyBundle;

import cryptix.pki.ExtendedKeyStore;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;

import java.security.cert.CertificateException;

import java.util.Collection;


/**
 * Detailed example for creating four keyrings based on the keys generated by
 * the GenerateAndWriteKey example.
 *
 * <p>Both Alice and Bob will get two keyrings: one public and one secret 
 * keyring. Their public keyrings will contain both public keys, while their
 * secret keyrings obviously only holds their own key. </p>
 *
 * @author  Edwin Woudt <edwin@cryptix.org>
 * @version $Revision: 1.2 $
 */
public class ReadKeyRingSignKey {


    //**************************************************************************
    // Variables where we save the keys.
    //**************************************************************************
    private static ExtendedKeyStore alicePublicRing, alicePrivateRing;
    private static ExtendedKeyStore bobPublicRing,   bobPrivateRing;



    //**************************************************************************
    // Main method, will be run on startup.
    //**************************************************************************
    public static void main(String[] args) {
    
        //**********************************************************************
        // Dynamically register both the Cryptix JCE and Cryptix OpenPGP 
        // providers. 
        //
        // You can also register them statically by putting lines like the
        // following in your java.security file:
        //
        //   security.provider.1=cryptix.jce.provider.CryptixCrypto
        //   security.provider.2=cryptix.openpgp.provider.CryptixOpenPGP
        //**********************************************************************
        java.security.Security.addProvider(
            new cryptix.jce.provider.CryptixCrypto() );
        java.security.Security.addProvider(
            new cryptix.openpgp.provider.CryptixOpenPGP() );

    
        //**********************************************************************
        // Read the keyrings
        //**********************************************************************
        readKeyrings();

    }
    

    public static void readKeyrings() {
    
        alicePublicRing  = readKeyRing("alice.pkr");
        alicePrivateRing = readKeyRing("alice.skr");
        bobPublicRing    = readKeyRing("bob.pkr");
        bobPrivateRing   = readKeyRing("bob.skr");

    }
    
    
    public static ExtendedKeyStore readKeyRing(String filename) {

        ExtendedKeyStore ring = null;

        try {

            FileInputStream in = new FileInputStream(filename);

            ring = (ExtendedKeyStore)
                ExtendedKeyStore.getInstance("OpenPGP/KeyRing");
            ring.load(in, null);
            
            in.close();
            
        } catch (IOException ioe) {
            System.err.println("IOException... You did remember to run the "+
                "GenerateAndWriteKey example first, right?");
            ioe.printStackTrace();
            System.exit(-1);
        } catch (NoSuchAlgorithmException nsae) {
            System.err.println("Cannot find the OpenPGP KeyRing. "+
                "This usually means that the Cryptix OpenPGP provider is not "+
                "installed correctly.");
            nsae.printStackTrace();
            System.exit(-1);
        } catch (KeyStoreException kse) {
            System.err.println("Reading keyring failed.");
            kse.printStackTrace();
            System.exit(-1);
        } catch (CertificateException ce) {
            System.err.println("Reading keyring failed.");
            ce.printStackTrace();
            System.exit(-1);
        }
        
        return ring;
        
    }
    
}
