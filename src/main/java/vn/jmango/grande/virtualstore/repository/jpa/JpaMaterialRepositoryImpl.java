package vn.jmango.grande.virtualstore.repository.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import vn.jmango.grande.virtualstore.model.Material;
import vn.jmango.grande.virtualstore.repository.MaterialRepository;

@Repository
public class JpaMaterialRepositoryImpl implements MaterialRepository {

	@PersistenceContext
	private EntityManager em;

	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public List<Material> getAllMaterial() throws DataAccessException {
		// TODO Auto-generated method stub
		Query query = this.em
				.createQuery("SELECT DISTINCT material FROM Material material");
		return query.getResultList();
	}

	@Override
	@Transactional
	public void saveMaterial(Material material) throws DataAccessException {
		// TODO Auto-generated method stub
		if (material.getId() == null) {
			this.em.persist(material);
		} else {
			this.em.merge(material);
		}
	}

	@Override
	@Transactional
	public Material findMaterialById(int id) throws DataAccessException {
		// TODO Auto-generated method stub
		Query query = this.em.createQuery("SELECT material FROM Material material WHERE material.id =:id");
		query.setParameter("id", id);
		return (Material)query.getSingleResult();
	}

	@Override
	@Transactional
	public void deleteMaterial(int id) throws DataAccessException {
		// TODO Auto-generated method stub
		Query query = this.em.createQuery("SELECT material FROM Material material WHERE material.id =:id");
		query.setParameter("id", id);
		this.em.remove((Material)query.getSingleResult());
	}
	
	

}
