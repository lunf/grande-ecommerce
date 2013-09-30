package vn.jmango.grande.virtualstore.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="material")
public class Material extends NamedEntity {
	
	@Column(name="materialdescription")
	protected String materialDescription;

	public String getMaterialDescription() {
		return materialDescription;
	}

	public void setMaterialDescription(String materialDescription) {
		this.materialDescription = materialDescription;
	}


}
