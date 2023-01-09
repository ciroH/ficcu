package io.github.ciroh;

import java.io.IOException;
import java.math.BigInteger;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

	public static void main(String[] args) {
		//Read user input
		String rootFolder = "/tmp";
		String fileFolder = "$HOME/Downloads/SerializedPOJO.xml";
		ArrayList<FileEntity> fileList = new ArrayList<>();
		try {
			FileEntity filePOJO;
			String fileMD5Checksum;
			//validate xml folder is writable
			//
			validateFile(rootFolder);
			List<Path> folderList = walkFolderPath(rootFolder);
			for (Path path : folderList) {
				fileMD5Checksum = generateMD5Checksum(path.toString());
				filePOJO = new FileEntity(path.toString(), fileMD5Checksum);
				fileList.add(filePOJO);
			}
			
		} catch (IllegalAccessException iae) {
			//iae.getMessage();
		} catch (IOException | NoSuchAlgorithmException e) {
			// ioe.getCause() + " : " + ioe.getMessage();
		}

	}
	
	public void walkFolderPath() {
		
	}
	
	public String generateMD5Checksum(String filePath) throws IOException, NoSuchAlgorithmException{
		String checksum = "";
			byte[] data = Files.readAllBytes(Path.of(filePath));
			byte[] hash = MessageDigest.getInstance("MD5").digest(data);
			checksum = new BigInteger(1,hash).toString(16);
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
