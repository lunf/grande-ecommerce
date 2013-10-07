package vn.jmango.grande.virtualstore.repository;

import java.util.List;

import org.springframework.dao.DataAccessException;

import vn.jmango.grande.virtualstore.model.Piece;


public interface PieceRepository {
	
	void savePiece(Piece piece) throws DataAccessException;
	
	Piece findPieceById(int id) throws DataAccessException;
	
	List<Piece> getAllPiece() throws DataAccessException;
	
	void deletePiece(int id) throws DataAccessException;

}
