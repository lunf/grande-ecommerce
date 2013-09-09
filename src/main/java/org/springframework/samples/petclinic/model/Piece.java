package org.springframework.samples.petclinic.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.hibernate.validator.constraints.NotEmpty;

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

	@Column(name = "bar_code")
	protected String barcode;

	@Column(name = "unique_code", nullable = false, unique = true)
	@NotEmpty
	protected String uniqueCode;
}
