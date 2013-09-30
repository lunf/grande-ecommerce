package vn.jmango.grande.virtualstore.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name = "piece")
public class Piece extends BaseEntity {

	@ManyToOne
	@JoinColumn(name = "product_id")
	private Product product;

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

	@Column(name = "material")
	protected String material;

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

	@Column(name = "key_features")
	protected String keyFeatures;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "piece")
	private Set<JmFile> images;

	@Column(name = "bar_code")
	protected String barcode;

	@Column(name = "unique_code", nullable = false, unique = true)
	@NotEmpty
	protected String uniqueCode;

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

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

	public String getMaterial() {
		return material;
	}

	public void setMaterial(String material) {
		this.material = material;
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

	public Set<JmFile> getImages() {
		return images;
	}

	public void setImages(Set<JmFile> images) {
		this.images = images;
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

	public String getKeyFeatures() {
		return keyFeatures;
	}

	public void setKeyFeatures(String keyFeatures) {
		this.keyFeatures = keyFeatures;
	}
	
	

}
