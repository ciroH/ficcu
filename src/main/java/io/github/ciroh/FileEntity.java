package io.github.ciroh;

public class FileEntity {
 String filePath;
 String fileHash;
 
 public FileEntity(String filePath, String FileHash) {
	 this.setFilePath(filePath);
	 this.setFileHash(FileHash);
 }
 
private String getFilePath() {
	return filePath;
}

private void setFilePath(String filePath) {
	this.filePath = filePath;
}

private String getFileHash() {
	return fileHash;
}

private void setFileHash(String fileHash) {
	this.fileHash = fileHash;
}

}
