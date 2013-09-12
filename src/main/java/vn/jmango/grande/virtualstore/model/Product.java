package vn.jmango.grande.virtualstore.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name = "product")
public class Product extends BaseEntity {

	@Column(name = "name")
	@NotEmpty
	protected String name;

	@Column(name = "short_description")
	protected String shortDescription;

	@Column(name = "long_description")
	protected String longDescription;

	@Column(name = "color")
	@NotEmpty
	protected String color;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "product")
	private Set<Piece> pieces;

	@Column(name = "weight")
	protected String weight;

	@Column(name = "length")
	protected String length;

	@Column(name = "height")
	protected String height;

	@Column(name = "width")
	protected String width;

	@Column(name = "depth")
	protected String depth;

	@Column(name = "price")
	protected double price;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "product")
	private Set<JmFile> images;

	@Column(name = "material")
	protected String material;

	@Column(name = "key_features")
	protected String keyFeatures;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "product")
	private Set<JmFile> assemblyInstructions;

	@Column(name = "bar_code")
	protected String barcode;

	@Column(name = "unique_code", nullable = false, unique = true)
	@NotEmpty
	protected String uniqueCode;
}
