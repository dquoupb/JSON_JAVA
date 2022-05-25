package e_EncryptionNDecryption;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64.*;

public class Base64Prac {
	static public void Base64(String TestString) throws UnsupportedEncodingException {
		// Base64 인코더
		Encoder encoder = java.util.Base64.getEncoder();
		// Base64 인코딩 후 문자열로 변환
		String encodedString = encoder.encodeToString(TestString.getBytes("UTF-8"));
		System.out.println(encodedString);
		
		// Base64 디코더
		Decoder decoder = java.util.Base64.getDecoder();
		// Base64 디코딩
		byte[] decodedBytes = decoder.decode(encodedString);
		// 디코딩 결과를 문자열로 변환
		String decodedString = new String(decodedBytes, "UTF-8");
		System.out.println(decodedString);
	}
	
	static public void SHA256(String input) throws NoSuchAlgorithmException {
		// SHA-256 messageDigest 인스턴스 생성
		MessageDigest mDigest = MessageDigest.getInstance("SHA-256");
		// SHA-256 암호화
		byte[] result = mDigest.digest(input.getBytes());
		
		StringBuffer sb = new StringBuffer();
		
		// 암호화 결과 문자열 반환
		for(int i=0; i<result.length; i++) {
			sb.append(Integer.toString((result[i]&0xFF)+0x100, 16).substring(1));
		}
		
		System.out.println(sb.toString());
	}
	
	public static void main(String[] args) throws UnsupportedEncodingException, NoSuchAlgorithmException {
		Base64("This is a Base64 test.");
		SHA256("1234");
	}
}
