package com.example.myapp.upload.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.example.myapp.upload.model.UploadFile;

@Repository
public class UploadFileRepository implements IUploadFileRepository {
	
	@Autowired
	JdbcTemplate jdbcTemplate;

	@Override
	public int getMaxFileId() {
		String sql = "SELECT NVL(MAX(file_id), 0) FROM upload_file2";
		return jdbcTemplate.queryForObject(sql, Integer.class);
	}

	@Override
	public void uploadFile(UploadFile file) {
		String sql = "INSERT INTO upload_file2 "
				+ "(file_id, category_name, file_name, uuid_file_name, "
				+ "file_size, file_content_type, file_upload_date) "
				+ "values (?, ?, ?, ?, ?, ?, SYSTIMESTAMP)"; 
		jdbcTemplate.update(sql, file.getFileId(),
								 file.getCategoryName(),
								 file.getFileName(),
								 file.getUuidFileName(),
								 file.getFileSize(),
								 file.getFileContentType());
	}
	
	private class UploadFileMapper implements RowMapper<UploadFile> {
		@Override
		public UploadFile mapRow(ResultSet rs, int rowNum) throws SQLException {
			UploadFile file = new UploadFile();
			file.setFileId(rs.getInt("file_id"));
			file.setCategoryName(rs.getString("category_name"));
			file.setFileName(rs.getString("file_name"));
			file.setUuidFileName(rs.getString("uuid_file_name"));
			file.setFileSize(rs.getLong("file_size"));
			file.setFileContentType(rs.getString("file_content_type"));
			file.setFileUploadDate(rs.getTimestamp("file_upload_date"));
			return file;
		}
	}

	@Override
	public List<UploadFile> getAllFileList() {
		String sql = "SELECT file_id, category_name, file_name, uuid_file_name, "
				+ "file_size, file_content_type, file_upload_date "
				+ "FROM upload_file2 "
				+ "ORDER BY file_upload_date DESC";
		return jdbcTemplate.query(sql, new UploadFileMapper());
	}

	@Override
	public UploadFile getFile(int fileId) {
		String sql = "SELECT file_id, category_name, file_name, uuid_file_name, "
				+ "file_size, file_content_type, file_upload_date "
				+ "FROM upload_file2 "
				+ "WHERE file_id=?";
		return jdbcTemplate.queryForObject(sql, new UploadFileMapper(), fileId);
	}

	@Override
	public void deleteFile(int fileId) {
		String sql = "DELETE FROM upload_file2 WHERE file_id = ?";
		jdbcTemplate.update(sql, fileId);
	}

	@Override
	public String getUuidFIleName(int fileId) {
		String sql = "SELECT uuid_file_name FROM upload_file2 WHERE file_id = ?";
		return jdbcTemplate.queryForObject(sql, String.class, fileId);
	}

}
