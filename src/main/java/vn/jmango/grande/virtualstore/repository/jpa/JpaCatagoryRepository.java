package vn.jmango.grande.virtualstore.repository.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import vn.jmango.grande.virtualstore.model.Catagory;
import vn.jmango.grande.virtualstore.repository.CatagoryRepository;

@Repository
public class JpaCatagoryRepository implements CatagoryRepository {

	@PersistenceContext
	private EntityManager em;

	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public List<Catagory> getAllCatagory() throws DataAccessException {
		// TODO Auto-generated method stub
		Query query = this.em
				.createQuery("SELECT DISTINCT catagory FROM Catagory catagory");
		return query.getResultList();
	}

	@Override
	@Transactional
	public void saveCatagory(Catagory catagory) throws DataAccessException {
		// TODO Auto-generated method stub
		if (catagory.getId() == null) {
			this.em.persist(catagory);
		} else {
			this.em.merge(catagory);
		}
	}

	@Override
	public Catagory findCatagoryById(int id) throws DataAccessException {
		// TODO Auto-generated method stub
		return null;
	}

}
