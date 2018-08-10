/**
 * 
 */
package com.elecc.security.crypto;

import java.io.UnsupportedEncodingException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.codec.binary.Base64;

import com.elecc.exceptions.EleccSecurityException;
import com.elecc.util.Constants;

/**
 * @author Ramón Cigüenza Fuster
 *
 */
public class DataEncrypter {

	// Secrets keys
	private static final String key = "2018Elecc2309Ram"; // 128 bit key
	private static final String initVector = "RamELECCSecu2309"; // 16 bytes IV
	private static final CharSequence SALTPRE = "Elecc";
	private static final CharSequence SALTPOST = "2309";

	public String encrypt(String value) throws EleccSecurityException {

		try {
			IvParameterSpec iv = new IvParameterSpec(initVector.getBytes("UTF-8"));

			SecretKeySpec skeySpec = new SecretKeySpec(key.getBytes("UTF-8"), "AES");

			Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5PADDING");
			cipher.init(Cipher.ENCRYPT_MODE, skeySpec, iv);

			byte[] encrypted = cipher.doFinal(value.getBytes());
			System.out.println("encrypted string: " + Base64.encodeBase64String(encrypted));

			return Base64.encodeBase64String(encrypted);

		} catch (UnsupportedEncodingException | NoSuchAlgorithmException | NoSuchPaddingException | InvalidKeyException
				| InvalidAlgorithmParameterException | IllegalBlockSizeException | BadPaddingException e) {
			throw new EleccSecurityException(Constants.MsgExceptions.MSG_ERROR_ENCRYPT_MODULE, e);
		}

	}

	public String decrypt(String encrypted) throws EleccSecurityException {
		try {
			IvParameterSpec iv = new IvParameterSpec(initVector.getBytes("UTF-8"));
			SecretKeySpec skeySpec = new SecretKeySpec(key.getBytes("UTF-8"), "AES");

			Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5PADDING");
			cipher.init(Cipher.DECRYPT_MODE, skeySpec, iv);

			byte[] original = cipher.doFinal(Base64.decodeBase64(encrypted));

			return new String(original);
		} catch (UnsupportedEncodingException | NoSuchAlgorithmException | NoSuchPaddingException | InvalidKeyException
				| InvalidAlgorithmParameterException | IllegalBlockSizeException | BadPaddingException e) {
			throw new EleccSecurityException(Constants.MsgExceptions.MSG_ERROR_ENCRYPT_MODULE, e);
		}

	}
	
	public String extractSalt(String brutePass) {
		
		brutePass = brutePass.substring(SALTPRE.length(), brutePass.length() - SALTPOST.length());
		
		return brutePass;
	}

}
