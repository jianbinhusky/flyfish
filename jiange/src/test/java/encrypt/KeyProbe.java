/* $Id: KeyProbe.java,v 1.2 2005/03/13 17:46:35 woudt Exp $
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
import cryptix.openpgp.PGPArmouredMessage;
import cryptix.openpgp.PGPPublicKey;
import cryptix.openpgp.net.Hkp;
import cryptix.openpgp.net.KeyServerIOException;
import cryptix.openpgp.net.PGPKeyServer;
import cryptix.pki.KeyBundle;
import java.security.NoSuchAlgorithmException;
import java.security.Principal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;




/** 
 * The KeyProbe dowloads and displays public keys from a keyserver.
 *
 *
 *
 * @author Mathias Kolehmainen <mathiask@computer.org>
 * @version $Revision: 1.2 $
 */
public class KeyProbe {


	private static final int PORT = 80;


	public static final void main(String[] args) {
		if (args.length != 2) {
			System.err.println("Usage: KeyProbe KEYSERVER USER-ID");
			System.err.println(" (USER-ID is usually an email address)");
			System.exit(1);
		} 
		try {
			java.security.Security.addProvider
				(new cryptix.jce.provider.CryptixCrypto());
			java.security.Security.addProvider
				(new cryptix.openpgp.provider.CryptixOpenPGP());

			KeyProbe probe = new KeyProbe();
			List keys = probe.get(args[0], args[1]);
			System.out.println("Got " + keys.size() + " keys from server.");
			for(int i=0; i < keys.size(); ++i) {
				System.out.println("[Key " + i + "]");

				//
				// In cryptix.openpgp land, a KeyBundle is how keys are passed
				// around.  It actually contains quite a few actual PGP data
				// packets in addition to a public key.
				//
				KeyBundle bundle = (KeyBundle) keys.get(i);
				for(Iterator users = bundle.getPrincipals(); users.hasNext(); ) {
					Principal princ = (Principal) users.next();
					System.out.println("  Principal: " + princ);					
				}
				
				for(Iterator pkeys = bundle.getPublicKeys(); pkeys.hasNext(); ) {
					PGPPublicKey key = (PGPPublicKey) pkeys.next();
					System.out.println("  public key: {Alg: " + key.getAlgorithm() + 
														 ", BitLength: " + key.getBitLength() + 
														 ", Format: " + key.getFormat() + "}");
					
				}
				PGPArmouredMessage armoured = new PGPArmouredMessage(bundle);       
				System.out.println(armoured.getEncodedString());
			}
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}


	/** 
	 * Fetch keys from the keyserver.
	 *
	 * @param server the Hkp server name
	 * @param uid the user id (usually email address)
	 * @return a list of KeyBundle objects.
	 */
	public List get(String server, String uid) 
		throws NoSuchAlgorithmException, KeyServerIOException, MessageException 
	{
		PGPKeyServer keyserver = new Hkp(server, PORT);
		ArrayList list = new ArrayList();
		Collection keys = keyserver.fetchById(uid);
		for(Iterator i = keys.iterator(); i.hasNext(); ) {
			KeyBundleMessage msg = (KeyBundleMessage) i.next();
			list.add(msg.getKeyBundle());
		}
		return(list);
	}


}
