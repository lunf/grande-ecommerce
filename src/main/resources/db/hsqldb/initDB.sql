DROP TABLE vet_specialties IF EXISTS;
DROP TABLE vets IF EXISTS;
DROP TABLE specialties IF EXISTS;
DROP TABLE visits IF EXISTS;
DROP TABLE pets IF EXISTS;
DROP TABLE types IF EXISTS;
DROP TABLE owners IF EXISTS;
DROP TABLE product IF EXISTS;


CREATE TABLE vets (
  id         INTEGER IDENTITY PRIMARY KEY,
  first_name VARCHAR(30),
  last_name  VARCHAR(30)
);
CREATE INDEX vets_last_name ON vets (last_name);

CREATE TABLE specialties (
  id   INTEGER IDENTITY PRIMARY KEY,
  name VARCHAR(80)
);
CREATE INDEX specialties_name ON specialties (name);

CREATE TABLE vet_specialties (
  vet_id       INTEGER NOT NULL,
  specialty_id INTEGER NOT NULL
);
ALTER TABLE vet_specialties ADD CONSTRAINT fk_vet_specialties_vets FOREIGN KEY (vet_id) REFERENCES vets (id);
ALTER TABLE vet_specialties ADD CONSTRAINT fk_vet_specialties_specialties FOREIGN KEY (specialty_id) REFERENCES specialties (id);

CREATE TABLE types (
  id   INTEGER IDENTITY PRIMARY KEY,
  name VARCHAR(80)
);
CREATE INDEX types_name ON types (name);

CREATE TABLE owners (
  id         INTEGER IDENTITY PRIMARY KEY,
  first_name VARCHAR(30),
  last_name  VARCHAR(30),
  address    VARCHAR(255),
  city       VARCHAR(80),
  telephone  VARCHAR(20)
);
CREATE INDEX owners_last_name ON owners (last_name);

CREATE TABLE pets (
  id         INTEGER IDENTITY PRIMARY KEY,
  name       VARCHAR(30),
  birth_date DATE,
  type_id    INTEGER NOT NULL,
  owner_id   INTEGER NOT NULL
);
ALTER TABLE pets ADD CONSTRAINT fk_pets_owners FOREIGN KEY (owner_id) REFERENCES owners (id);
ALTER TABLE pets ADD CONSTRAINT fk_pets_types FOREIGN KEY (type_id) REFERENCES types (id);
CREATE INDEX pets_name ON pets (name);

CREATE TABLE visits (
  id          INTEGER IDENTITY PRIMARY KEY,
  pet_id      INTEGER NOT NULL,
  visit_date  DATE,
  description VARCHAR(255)
);
ALTER TABLE visits ADD CONSTRAINT fk_visits_pets FOREIGN KEY (pet_id) REFERENCES pets (id);
CREATE INDEX visits_pet_id ON visits (pet_id);

CREATE TABLE product (
  id         			INTEGER IDENTITY PRIMARY KEY,
  name 		 			VARCHAR(255) NOT NULL,
  short_description     VARCHAR(255),
  long_description      VARCHAR(1024),
  color       			VARCHAR(80),
  weight  				VARCHAR(20),
  length 				VARCHAR(20),
  height 				VARCHAR(20),
  width 				VARCHAR(20),
  depth 				VARCHAR(20),
  price 				DOUBLE,
  material 				VARCHAR(255),
  key_features 			VARCHAR(1024),
  bar_code 				VARCHAR(255),
  unique_code 			VARCHAR(255)
);

CREATE TABLE piece (
  id          INTEGER IDENTITY PRIMARY KEY,
  product_id      INTEGER NOT NULL,
  name 		 			VARCHAR(255) NOT NULL,
  short_description     VARCHAR(255),
  long_description      VARCHAR(1024),
  color       			VARCHAR(80),
  weight  				VARCHAR(20),
  length 				VARCHAR(20),
  height 				VARCHAR(20),
  width 				VARCHAR(20),
  depth 				VARCHAR(20),
  price 				DOUBLE,
  material 				VARCHAR(255),
  key_features 			VARCHAR(1024),
  bar_code 				VARCHAR(255),
  unique_code 			VARCHAR(255)
);
ALTER TABLE piece ADD CONSTRAINT fk_piece FOREIGN KEY (product_id) REFERENCES product (id);


CREATE TABLE jmfile (
  id          INTEGER IDENTITY PRIMARY KEY,
  product_file_id      INTEGER NOT NULL,
  piece_file_id        INTEGER NOT NULL,
  name 		 			VARCHAR(255) NOT NULL,
  extension     		VARCHAR(20),
  data			        BLOB,
  content_type       	VARCHAR(80)
);
ALTER TABLE jmfile ADD CONSTRAINT fk_product_file FOREIGN KEY (product_file_id) REFERENCES product (id);
ALTER TABLE jmfile ADD CONSTRAINT fk_piece_file FOREIGN KEY (piece_file_id) REFERENCES piece (id);

