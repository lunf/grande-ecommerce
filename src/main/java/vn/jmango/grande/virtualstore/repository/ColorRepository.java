package vn.jmango.grande.virtualstore.repository;

import java.util.List;

import org.springframework.dao.DataAccessException;

import vn.jmango.grande.virtualstore.model.Color;

public interface ColorRepository {
	
	List<Color> getAllColor() throws DataAccessException;
	
	String getCodeColor(String nameColor) throws DataAccessException;
	
	void saveColor(Color color) throws DataAccessException;

}
