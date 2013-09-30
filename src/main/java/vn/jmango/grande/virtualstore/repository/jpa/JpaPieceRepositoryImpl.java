package vn.jmango.grande.virtualstore.repository.jpa;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import vn.jmango.grande.virtualstore.model.Piece;
import vn.jmango.grande.virtualstore.repository.PieceRepository;

@Repository
public class JpaPieceRepositoryImpl implements PieceRepository {

	@PersistenceContext
	private EntityManager em;

	@Override
	@Transactional
	public void savePiece(Piece piece) throws DataAccessException {
		// TODO Auto-generated method stub
		if (piece.getId() == null) {
			this.em.persist(piece);
		} else {
			this.em.merge(piece);
		}
	}

}
