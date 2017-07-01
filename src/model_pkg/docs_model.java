package model_pkg;

import java.io.InputStream;
import java.io.Serializable;

public class docs_model implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	private String ID;
	
	public String getID() {
		return ID;
	}
	public void setID(String iD) {
		ID = iD;
	}
	private InputStream File;
	public InputStream getFile() {
		return File;
	}
	public void setFile(InputStream file) {
		File = file;
	}
	private String FileName;
	private String FileType;
	private String Comments;
	
	public String getFileName() {
		return FileName;
	}
	public void setFileName(String fileName) {
		FileName = fileName;
	}
	public String getFileType() {
		return FileType;
	}
	public void setFileType(String fileType) {
		FileType = fileType;
	}
	public String getComments() {
		return Comments;
	}
	public void setComments(String comments) {
		Comments = comments;
	}

}
