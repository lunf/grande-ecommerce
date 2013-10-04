package vn.jmango.grande.virtualstore.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="catagory")
public class Catagory extends NamedEntity {
	
	@Column(name="catagorydescription")
	protected String catagoryDescription;
	
	public String getCatagoryDescription() {
		return catagoryDescription;
	}

	public void setCatagoryDescription(String catagoryDescription) {
		this.catagoryDescription = catagoryDescription;
	}
	
}
