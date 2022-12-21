package io.github.ciroh;

import java.io.IOException;
import java.math.BigInteger;
import java.nio.file.Files;
import java.nio.file.Path;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public String generateMD5Checksum(String filePath) throws IOException, NoSuchAlgorithmException {
		byte[] data = Files.readAllBytes(Path.of(filePath));
		byte[] hash = MessageDigest.getInstance("MD5").digest(data);
		String checksum = new BigInteger(1,hash).toString(16);
		return checksum;
	}

}
