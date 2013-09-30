package vn.jmango.grande.virtualstore.repository.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import vn.jmango.grande.virtualstore.model.Color;
import vn.jmango.grande.virtualstore.repository.ColorRepository;

@Repository
public class JpaColorRepositoryImpl implements ColorRepository {

	@PersistenceContext
	private EntityManager em;

	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public List<Color> getAllColor() throws DataAccessException {
		// TODO Auto-generated method stub
		Query query = this.em
				.createQuery("SELECT DISTINCT color FROM Color color");
		return query.getResultList();
	}

	@Override
	@Transactional
	public String getCodeColor(String nameColor) throws DataAccessException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@Transactional
	public void saveColor(Color color) throws DataAccessException {
		// TODO Auto-generated method stub
		if (color.getId() == null) {
			this.em.persist(color);
		} else {
			this.em.merge(color);
		}
	}

}
