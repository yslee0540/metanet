package com.example.myapp.upload.model;

import java.sql.Timestamp;

import lombok.Data;

@Data
public class UploadFile {
	private int fileId;
	private String categoryName;
	private String fileName;
	private String uuidFileName;
	private long fileSize;
	private String fileContentType;
	private Timestamp fileUploadDate;
}
