package vn.jmango.grande.virtualstore.repository;

import java.util.List;

import org.springframework.dao.DataAccessException;

import vn.jmango.grande.virtualstore.model.Material;

public interface MaterialRepository {
	
	List<Material> getAllMaterial() throws DataAccessException;
	
	void saveMaterial(Material material) throws DataAccessException;
	
	Material findMaterialById(int id) throws DataAccessException;
	
	void deleteMaterial(int id) throws DataAccessException;

}
