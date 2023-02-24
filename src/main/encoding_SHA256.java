package main;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;

public class encoding_SHA256 {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("introduzca una cadena a encriptar: ");
		String cadena = sc.next();
		try {
			modelSHA256(cadena);
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
	}

	public static void modelSHA256(String cadena) throws NoSuchAlgorithmException {
		final String model = "SHA-256";
		MessageDigest md = MessageDigest.getInstance(model);
		
		md.update(cadena.getBytes());
		byte byteData[] = md.digest();
		
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < byteData.length; i++) {
			sb.append(Integer.toString((byteData[i] & 0xff) + 0x100, 16).substring(1));
		}
		
		System.out.println("Output: " + sb.toString());
	}
}
