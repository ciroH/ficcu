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
	
	public String generateMD5Checksum(String filePath) throws IOException, NoSuchAlgorithmException, IllegalAccessException {
		String checksum = "";
		if(validateFile(filePath)){
			byte[] data = Files.readAllBytes(Path.of(filePath));
			byte[] hash = MessageDigest.getInstance("MD5").digest(data);
			checksum = new BigInteger(1,hash).toString(16);
		} else throw new IllegalAccessException();
		return checksum;
	}
	
	public boolean validateFile(String filePath) throws IllegalAccessException {
		boolean fileIsValid = Files.isReadable(Path.of(filePath)) 
							//Implicit Files.exists(Path.of(filePath)); 
						   && Files.isRegularFile(Path.of(filePath));
		if(!fileIsValid) {
			throw new IllegalAccessException();
		}
		return fileIsValid;
	}

}
