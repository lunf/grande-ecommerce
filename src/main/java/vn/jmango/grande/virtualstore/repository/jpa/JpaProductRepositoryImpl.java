package vn.jmango.grande.virtualstore.repository.jpa;

import java.util.Collection;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import vn.jmango.grande.virtualstore.model.Product;
import vn.jmango.grande.virtualstore.repository.ProductRepository;

@Repository
public class JpaProductRepositoryImpl implements ProductRepository {

	@PersistenceContext
	private EntityManager em;

	@SuppressWarnings("unchecked")
	@Override
	public Collection<Product> findByName(String Name)
			throws DataAccessException {
		// TODO Auto-generated method stub
		Query query =this.em.createQuery("SELECT DISTINCT product FROM Product product WHERE product.name LIKE :name");
		query.setParameter("name", Name+"%");
		return query.getResultList();
	}

	@Override
	public Product findById(int id) throws DataAccessException {
		// TODO Auto-generated method stub
		Query query = this.em.createQuery("SELECT product FROM Product product WHERE product.id =:id");
		query.setParameter("id", id);
		return (Product)query.getSingleResult();
	}

	@Override
	@Transactional
	public void save(Product product) throws DataAccessException {
		// TODO Auto-generated method stub
		if (product.getId() == null) {
			this.em.persist(product);
		} else {
			this.em.merge(product);
		}
	}

}
