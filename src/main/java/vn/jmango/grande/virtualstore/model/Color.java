package vn.jmango.grande.virtualstore.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name="color")
public class Color extends NamedEntity{
	
	@Column(name="colordescription")
	protected String colorDescription;

	@Column(name="codecolor")
	@NotEmpty
	protected String codeColor;

	public String getColorDescription() {
		return colorDescription;
	}

	public void setColorDescription(String colorDescription) {
		this.colorDescription = colorDescription;
	}

	public String getCodeColor() {
		return codeColor;
	}

	public void setCodeColor(String codeColor) {
		this.codeColor = codeColor;
	}
	
	
	
}
