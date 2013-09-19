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
	private Set<JmFile> files;

	@Column(name = "material")
	protected String material;

	@Column(name = "key_features")
	protected String keyFeatures;

	@Column(name = "bar_code")
	protected String barcode;

	@Column(name = "unique_code", nullable = false, unique = true)
	@NotEmpty
	protected String uniqueCode;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getShortDescription() {
		return shortDescription;
	}

	public void setShortDescription(String shortDescription) {
		this.shortDescription = shortDescription;
	}

	public String getLongDescription() {
		return longDescription;
	}

	public void setLongDescription(String longDescription) {
		this.longDescription = longDescription;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public Set<Piece> getPieces() {
		return pieces;
	}

	public void setPieces(Set<Piece> pieces) {
		this.pieces = pieces;
	}

	public String getWeight() {
		return weight;
	}

	public void setWeight(String weight) {
		this.weight = weight;
	}

	public String getLength() {
		return length;
	}

	public void setLength(String length) {
		this.length = length;
	}

	public String getHeight() {
		return height;
	}

	public void setHeight(String height) {
		this.height = height;
	}

	public String getWidth() {
		return width;
	}

	public void setWidth(String width) {
		this.width = width;
	}

	public String getDepth() {
		return depth;
	}

	public void setDepth(String depth) {
		this.depth = depth;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public Set<JmFile> getFiles() {
		return files;
	}

	public void setFiles(Set<JmFile> files) {
		this.files = files;
	}

	public String getMaterial() {
		return material;
	}

	public void setMaterial(String material) {
		this.material = material;
	}

	public String getKeyFeatures() {
		return keyFeatures;
	}

	public void setKeyFeatures(String keyFeatures) {
		this.keyFeatures = keyFeatures;
	}

	public String getBarcode() {
		return barcode;
	}

	public void setBarcode(String barcode) {
		this.barcode = barcode;
	}

	public String getUniqueCode() {
		return uniqueCode;
	}

	public void setUniqueCode(String uniqueCode) {
		this.uniqueCode = uniqueCode;
	}

}
