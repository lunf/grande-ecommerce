package vn.jmango.grande.virtualstore.repository;

import org.springframework.dao.DataAccessException;

import vn.jmango.grande.virtualstore.model.Piece;


public interface PieceRepository {
	
	void savePiece(Piece piece) throws DataAccessException;
	
	

}
