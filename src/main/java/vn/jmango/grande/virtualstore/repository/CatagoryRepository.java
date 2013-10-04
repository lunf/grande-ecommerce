package vn.jmango.grande.virtualstore.repository;

import java.util.List;

import org.springframework.dao.DataAccessException;

import vn.jmango.grande.virtualstore.model.Catagory;

public interface CatagoryRepository {
	
	List<Catagory> getAllCatagory() throws DataAccessException;
	
	void saveCatagory(Catagory catagory) throws DataAccessException;
	
	Catagory findCatagoryById(int id) throws DataAccessException;

}
