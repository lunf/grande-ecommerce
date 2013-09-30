package vn.jmango.grande.virtualstore.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="catagory")
public class Catagory extends NamedEntity {
	
	@Column(name="catagorydescription")
	protected String catagoryDescription;

	@ManyToOne
	@JoinColumn(name="product_id")
	private Product product;
	
	public String getCatagoryDescription() {
		return catagoryDescription;
	}

	public void setCatagoryDescription(String catagoryDescription) {
		this.catagoryDescription = catagoryDescription;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}
	
}
