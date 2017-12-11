/* $Id: CreateKeyRing.java,v 1.2 2005/03/13 17:46:35 woudt Exp $
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
public class CreateKeyRing {


    //**************************************************************************
    // Variables where we save the keys.
    //**************************************************************************
    private static PGPKeyBundle alicePublicKey, alicePrivateKey;
    private static PGPKeyBundle bobPublicKey,   bobPrivateKey;



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
        // Read the keys
        //**********************************************************************
        readKeys();


        //**********************************************************************
        // Write keyrings
        //**********************************************************************
        writeKeyrings();
        
    }
    

    public static void readKeys() {
    
        //**********************************************************************
        // As you can see, the same code can be used for reading both binary
        // keys and ascii-armoured keys.
        //**********************************************************************

        alicePublicKey  = readKey("alice-public.pgp");
        alicePrivateKey = readKey("alice-secret.pgp");
        bobPublicKey    = readKey("bob-public.pgp.asc");
        bobPrivateKey   = readKey("bob-secret.pgp.asc");

    }
    
    
    public static PGPKeyBundle readKey(String filename) {

        PGPKeyBundle bundle = null;

        try {

            FileInputStream in = new FileInputStream(filename);

            MessageFactory mf = MessageFactory.getInstance("OpenPGP");
            Collection msgs = mf.generateMessages(in);
            
            in.close();
            
            KeyBundleMessage kbm = (KeyBundleMessage)msgs.iterator().next();
            bundle = (PGPKeyBundle)kbm.getKeyBundle();
        
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
        
        return bundle;
        
    }
    
    public static void writeKeyrings() {

        //**********************************************************************
        // We are going to create four PGP keyrings, which map to 
        // java.security.KeyStore objects in Java.
        // Because we want to use some extra features (like the ability to work
        // with KeyBundles) we use ExtendedKeyStore instead.
        //**********************************************************************

        ExtendedKeyStore alicePubRing  = null;
        ExtendedKeyStore alicePrivRing = null;
        ExtendedKeyStore bobPubRing    = null;
        ExtendedKeyStore bobPrivRing   = null;

        try {
        
            alicePubRing  = (ExtendedKeyStore)
                ExtendedKeyStore.getInstance("OpenPGP/KeyRing");
            alicePrivRing = (ExtendedKeyStore) 
                ExtendedKeyStore.getInstance("OpenPGP/KeyRing");
            bobPubRing    = (ExtendedKeyStore)
                ExtendedKeyStore.getInstance("OpenPGP/KeyRing");
            bobPrivRing   = (ExtendedKeyStore)
                ExtendedKeyStore.getInstance("OpenPGP/KeyRing");
        
        } catch (KeyStoreException kse) {
            System.err.println("KeyStoreException on creating a keyring. "+
                "This means that the KeyStore implementation could not be "+
                "found and that there is potentially a problem with the "+
                "provider");
            kse.printStackTrace();
            System.exit(-1);
        }
        
        
        //**********************************************************************
        // Before using them, KeyStore objects have to be initialized.
        // Because we want to create empty keystores, we are going to 
        // initialize them with null arguments.
        // Unfortunately we have to catch all sorts of exceptions that are
        // impossible to happen.
        //**********************************************************************

        try {
        
            alicePubRing.load  (null, null);
            alicePrivRing.load (null, null);
            bobPubRing.load    (null, null);
            bobPrivRing.load   (null, null);

        } catch (IOException ioe) {
            System.err.println("KeyStoreException on keyring init. "+
                "There should be no way for this exception to turn up.");
            ioe.printStackTrace();
            System.exit(-1);
        } catch (NoSuchAlgorithmException nsae) {
            System.err.println("NoSuchAlgorithmException on keyring init. "+
                "There should be no way for this exception to turn up.");
            nsae.printStackTrace();
            System.exit(-1);
        } catch (CertificateException ce) {
            System.err.println("CertificateException on keyring init. "+
                "There should be no way for this exception to turn up.");
            ce.printStackTrace();
            System.exit(-1);
        }


        //**********************************************************************
        // Filling up the keyrings is pretty easy now. Just add the right 
        // keybundles to the rings.
        //**********************************************************************

        try {
        
            alicePubRing.setKeyBundleEntry(alicePublicKey);
            alicePubRing.setKeyBundleEntry(bobPublicKey);

            alicePrivRing.setKeyBundleEntry(alicePrivateKey);
        
            bobPubRing.setKeyBundleEntry(alicePublicKey);
            bobPubRing.setKeyBundleEntry(bobPublicKey);

            bobPrivRing.setKeyBundleEntry(bobPrivateKey);
        
        } catch (KeyStoreException kse) {
            System.err.println("KeyStoreException on adding a key.");
            kse.printStackTrace();
            System.exit(-1);
        }

        //**********************************************************************
        // Now we're going to write the keyring files.
        // The second argument of the store method is a passphrase. Because
        // PGP keyrings are stored unencrypted, a 'null' value has to be 
        // provided here.
        //**********************************************************************
        FileOutputStream out;
        
        try {
        
            out = new FileOutputStream("alice.pkr");  // pkr = public key ring
            alicePubRing.store(out, null);
            out.close();

            out = new FileOutputStream("alice.skr");  // skr = secret key ring
            alicePrivRing.store(out, null);
            out.close();

            out = new FileOutputStream("bob.pkr");
            bobPubRing.store(out, null);
            out.close();

            out = new FileOutputStream("bob.skr");
            bobPrivRing.store(out, null);
            out.close();
            
        } catch (IOException ioe) {
            System.err.println("IOException on writing a keyring.");
            ioe.printStackTrace();
            System.exit(-1);
        } catch (NoSuchAlgorithmException nsae) {
            System.err.println("NoSuchAlgorithmException on writing a keyring."+
            " Given that no encryption is used while writing the keystore, "+
            "this should not happen!");
            nsae.printStackTrace();
            System.exit(-1);
        } catch (CertificateException ce) {
            System.err.println("CertificateException on writing a keyring.");
            ce.printStackTrace();
            System.exit(-1);
        } catch (KeyStoreException kse) {
            System.err.println("KeyStoreException on writing a keyring.");
            kse.printStackTrace();
            System.exit(-1);
        }
    }
    
}
