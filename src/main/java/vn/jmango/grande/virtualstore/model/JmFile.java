package vn.jmango.grande.virtualstore.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name = "jmfile")
public class JmFile extends BaseEntity {

	@Column(name = "name")
	@NotEmpty
	protected String name;

	@Column(name = "extension")
	@NotEmpty
	protected String extension;

	@Column(name = "data")
	@NotEmpty
	protected byte[] data;

	@Column(name = "content_type")
	@NotEmpty
	protected String contentType;
	
	@ManyToOne
    @JoinColumn(name = "product_file_id")
    private Product product;
	
	@ManyToOne
    @JoinColumn(name = "piece_file_id")
    private Piece piece;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getExtension() {
		return extension;
	}

	public void setExtension(String extension) {
		this.extension = extension;
	}

	public String getContentType() {
		return contentType;
	}

	public void setContentType(String contentType) {
		this.contentType = contentType;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Piece getPiece() {
		return piece;
	}

	public void setPiece(Piece piece) {
		this.piece = piece;
	}

	public byte[] getData() {
		return data;
	}

	public void setData(byte[] data) {
		this.data = data;
	}
	
}
