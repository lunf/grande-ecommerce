package vn.jmango.grande.virtualstore.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="subcatagory")
public class SubCatagory extends NamedEntity {

	@Column(name="subcatagorydescription")
	protected String subcatagoryDescription;

	@ManyToOne
	@JoinColumn(name="piece_id")
	private Piece piece;
	
	public String getSubcatagoryDescription() {
		return subcatagoryDescription;
	}

	public void setSubcatagoryDescription(String subcatagoryDescription) {
		this.subcatagoryDescription = subcatagoryDescription;
	}

	public Piece getPiece() {
		return piece;
	}

	public void setPiece(Piece piece) {
		this.piece = piece;
	}
	
}
