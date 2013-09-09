package org.springframework.samples.petclinic.model;

import javax.persistence.Column;

import org.hibernate.validator.constraints.NotEmpty;

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

	@Column(name = "content-type")
	@NotEmpty
	protected String contentType;
}
