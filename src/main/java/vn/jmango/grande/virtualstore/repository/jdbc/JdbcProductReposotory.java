package vn.jmango.grande.virtualstore.repository.jdbc;

import java.util.Collection;

import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import vn.jmango.grande.virtualstore.model.Product;
import vn.jmango.grande.virtualstore.repository.ProductRepository;

@Repository
public class JdbcProductReposotory implements ProductRepository {

	@Override
	public Collection<Product> findByName(String Name)
			throws DataAccessException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Product findById(int id) throws DataAccessException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void save(Product product) throws DataAccessException {
		// TODO Auto-generated method stub
		
	}

}
