package vn.jmango.grande.virtualstore.repository.jpa;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import vn.jmango.grande.virtualstore.model.JmFile;
import vn.jmango.grande.virtualstore.repository.FileRepository;

@Repository
public class JpaFileRepository implements FileRepository {

	@PersistenceContext
	private EntityManager em;

	@Override
	@Transactional
	public void saveFile(JmFile file) throws DataAccessException {
		// TODO Auto-generated method stub
		if (file.getId() == null) {
			this.em.persist(file);
		} else {
			this.em.merge(file);
		}
	}

	@Override
	@Transactional
	public JmFile findFileById(int id) throws DataAccessException {
		// TODO Auto-generated method stub
		Query query = this.em.createQuery("SELECT jmFile FROM JmFile jmFile WHERE jmFile.id =:id");
		query.setParameter("id", id);
		return (JmFile)query.getSingleResult();
	}

}
