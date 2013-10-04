DROP TABLE color IF EXISTS;
DROP TABLE material IF EXISTS;
DROP TABLE catagory IF EXISTS;
DROP TABLE subcatagory IF EXISTS;
DROP TABLE piece IF EXISTS;
DROP TABLE jmfile IF EXISTS;
DROP TABLE product IF EXISTS;


CREATE TABLE product (
  id         			INTEGER IDENTITY PRIMARY KEY,
  name 		 			VARCHAR(255) NOT NULL,
  short_description     VARCHAR(255),
  long_description      VARCHAR(1024),
  color					VARCHAR(20),
  material				VARCHAR(80),
  weight  				VARCHAR(20),
  length 				VARCHAR(20),
  height 				VARCHAR(20),
  width 				VARCHAR(20),
  depth 				VARCHAR(20),
  price 				DOUBLE,
  key_features 			VARCHAR(1024),
  bar_code 				VARCHAR(255),
  unique_code 			VARCHAR(255),
  catagory				VARCHAR(255),
);

CREATE TABLE piece (
  id          			INTEGER IDENTITY PRIMARY KEY,
  product_id      		INTEGER NOT NULL,
  name 		 			VARCHAR(255) NOT NULL,
  short_description     VARCHAR(255),
  long_description      VARCHAR(1024),
  color					VARCHAR(20),
  material				VARCHAR(80),
  weight  				VARCHAR(20),
  length 				VARCHAR(20),
  height 				VARCHAR(20),
  width 				VARCHAR(20),
  depth 				VARCHAR(20),
  price 				DOUBLE,
  key_features 			VARCHAR(1024),
  bar_code 				VARCHAR(255),
  unique_code 			VARCHAR(255)
);
ALTER TABLE piece ADD CONSTRAINT fk_piece_product FOREIGN KEY (product_id) REFERENCES product (id);


CREATE TABLE jmfile (
  id          			INTEGER IDENTITY PRIMARY KEY,
  product_file_id	    INTEGER,
  piece_file_id         INTEGER,
  name 		 			VARCHAR(255) NOT NULL,
  extension     		VARCHAR(20),
  data			        blob,
  content_type       	VARCHAR(80)
);
ALTER TABLE jmfile ADD CONSTRAINT fk_jmfile_product FOREIGN KEY (product_file_id) REFERENCES product (id);
ALTER TABLE jmfile ADD CONSTRAINT fk_jmfile_piece FOREIGN KEY (piece_file_id) REFERENCES piece (id);

CREATE TABLE color(
  id         			INTEGER IDENTITY PRIMARY KEY,
  name 		 			VARCHAR(150) NOT NULL,
  codecolor             VARCHAR(30) NOT NULL,
  colordescription      VARCHAR(1024),
);

CREATE TABLE material(
	id         				INTEGER IDENTITY PRIMARY KEY,
	name 		 			VARCHAR(150) NOT NULL,
	materialdescription     VARCHAR(1024) NOT NULL,
);

CREATE TABLE catagory(
	id         				INTEGER IDENTITY PRIMARY KEY,
	name 		 			VARCHAR(150) NOT NULL,
	catagorydescription     VARCHAR(1024),
);

CREATE TABLE subcatagory(
	id         				INTEGER IDENTITY PRIMARY KEY,
	piece_id				INTEGER NOT NULL,
	name 		 			VARCHAR(150) NOT NULL,
	subcatagorydescription  VARCHAR(1024) NOT NULL,
);
ALTER TABLE subcatagory ADD CONSTRAINT fk_piece_subcatagory FOREIGN KEY (piece_id) REFERENCES piece (id);
