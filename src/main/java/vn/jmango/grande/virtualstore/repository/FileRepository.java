package vn.jmango.grande.virtualstore.repository;

import java.util.List;

import org.springframework.dao.DataAccessException;

import vn.jmango.grande.virtualstore.model.JmFile;

public interface FileRepository {
	
	void saveFile(JmFile file) throws DataAccessException;
	
	JmFile findFileById(int id) throws DataAccessException;
	
	List<JmFile> getAllFile() throws DataAccessException;
	
	void deleteFile(int id) throws DataAccessException;

}
