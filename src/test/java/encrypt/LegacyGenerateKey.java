/* $Id: LegacyGenerateKey.java,v 1.1 2005/03/13 17:12:58 woudt Exp $
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


import cryptix.openpgp.PGPArmouredMessage;
import cryptix.openpgp.PGPKeyBundle;

import cryptix.pki.CertificateBuilder;
import cryptix.pki.PrincipalBuilder;
import cryptix.pki.KeyBundle;
import cryptix.pki.KeyBundleFactory;

import java.io.FileOutputStream;

import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.Principal;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.SecureRandom;

import java.security.cert.Certificate;


/**
 * Example for generating a legacy key.
 *
 * @author  Edwin Woudt <edwin@cryptix.org>
 * @version $Revision: 1.1 $
 */
public class LegacyGenerateKey {


    public static void main(String[] args) {
    
        java.security.Security.addProvider(
            new cryptix.jce.provider.CryptixCrypto() );
        java.security.Security.addProvider(
            new cryptix.openpgp.provider.CryptixOpenPGP() );

    
        //**********************************************************************
        // Generate a legacy key
        //**********************************************************************
        try {
            PGPKeyBundle legacyPublicKey, legacyPrivateKey;
            SecureRandom sr = new SecureRandom();

            KeyBundleFactory kbf = 
                KeyBundleFactory.getInstance("OpenPGP");
            legacyPublicKey = (PGPKeyBundle)kbf.generateEmptyKeyBundle();
            legacyPrivateKey = (PGPKeyBundle)kbf.generateEmptyKeyBundle();
            KeyPairGenerator kpg = 
                KeyPairGenerator.getInstance("OpenPGP/Legacy/RSA");
            kpg.initialize(1024, sr);
            KeyPair kp = kpg.generateKeyPair();
            PublicKey pubkey = kp.getPublic();
            PrivateKey privkey = kp.getPrivate();
            PrincipalBuilder princbuilder = 
                PrincipalBuilder.getInstance("OpenPGP/UserID");
            Principal userid = 
                princbuilder.build("Ol D. Legacy <old@legacy.com>");
            CertificateBuilder certbuilder =
                CertificateBuilder.getInstance("OpenPGP/Legacy/Self");
            Certificate cert = certbuilder.build(pubkey, userid, privkey, sr);
            legacyPublicKey.addCertificate(cert);
            legacyPrivateKey.addCertificate(cert);
            legacyPrivateKey.addPrivateKey(privkey, pubkey, 
                "TestingPassphrase".toCharArray(), sr);
        
            PGPArmouredMessage armoured;
            FileOutputStream out;
            armoured = new PGPArmouredMessage(legacyPublicKey);
            out = new FileOutputStream("leg-pub.asc");
            out.write(armoured.getEncoded());
            out.close();
            armoured = new PGPArmouredMessage(legacyPrivateKey);
            out = new FileOutputStream("leg-sec.asc");
            out.write(armoured.getEncoded());
            out.close();

            out = new FileOutputStream("leg-pub.pgp");
            out.write(legacyPublicKey.getEncoded());
            out.close();
            out = new FileOutputStream("leg-sec.pgp");
            out.write(legacyPrivateKey.getEncoded());
            out.close();

        } catch (Exception e) {
            System.err.println("Whoops!!!");
            e.printStackTrace();
            System.exit(-1);
        }
    }
    
}
