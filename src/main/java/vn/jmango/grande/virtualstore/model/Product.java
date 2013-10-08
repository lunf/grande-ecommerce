package vn.jmango.grande.virtualstore.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.beans.support.MutableSortDefinition;
import org.springframework.beans.support.PropertyComparator;

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

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "product", fetch = FetchType.EAGER, orphanRemoval=true)
	private Set<JmFile> files;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "product", fetch = FetchType.EAGER, orphanRemoval=true)
	private Set<Piece> pieces;

	@Column(name = "key_features")
	protected String keyFeatures;

	@Column(name = "bar_code")
	protected String barcode;

	@Column(name = "unique_code", nullable = false, unique = true)
	@NotEmpty
	protected String uniqueCode;
	
	@Column(name="catagory")
	@NotEmpty
	protected String catagories;
	
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

	public void setPieces(Set<Piece> pieces) {

		this.pieces = pieces;
	}

	protected void setPieceInternal(Set<Piece> pieces) {
		this.pieces = pieces;
	}

	protected Set<Piece> getPiecesInternal() {
		if (this.pieces == null) {
			this.pieces = new HashSet<Piece>();
		}
		return this.pieces;
	}

	public Set<Piece> getPieces() {
//		List<Piece> sortedPiece = new ArrayList<Piece>(getPiecesInternal());
//		PropertyComparator.sort(sortedPiece, new MutableSortDefinition("name",
//				true, true));
//		return Collections.unmodifiableList(sortedPiece);
		
		return this.pieces;
	}

	public void addPiece(Piece piece) {
		getPiecesInternal().add(piece);
		piece.setProduct(this);
	}

	protected Set<JmFile> getJmFileInternal() {
		if (this.files == null) {
			this.files = new HashSet<JmFile>();
		}
		return this.files;
	}

	public void addFile(JmFile file) {
		getJmFileInternal().add(file);
		file.setProduct(this);
	}

	public String getCatagories() {
		return catagories;
	}

	public void setCatagories(String catagories) {
		this.catagories = catagories;
	}

	
}
