package kr.go.ddm.test;

import java.io.UnsupportedEncodingException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.InvalidParameterSpecException;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

import kr.go.ddm.util.AES256;

public class AES256Test {

	public static void main(String[] args) throws InvalidKeyException, NoSuchAlgorithmException, InvalidKeySpecException, NoSuchPaddingException, InvalidParameterSpecException, UnsupportedEncodingException, BadPaddingException, IllegalBlockSizeException, InvalidAlgorithmParameterException{
		String plainText = "1234";
        String key = "%15x";

        System.out.println("MD5 : " + plainText + " - " + AES256.md5(plainText));
        System.out.println("SHA-256 : " + plainText + " - " + AES256.sha256(plainText));

        String encrypted = AES256.encryptAES256("Hello, World!", key);
        System.out.println("AES-256 : enc - " + encrypted);
        System.out.println("AES-256 : dec - " + AES256.decryptAES256(encrypted, key));
	}
}
