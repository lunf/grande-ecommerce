/*
 * Copyright 2002-2013 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package vn.jmango.grande.virtualstore.service;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import vn.jmango.grande.virtualstore.model.Catagory;
import vn.jmango.grande.virtualstore.model.Color;
import vn.jmango.grande.virtualstore.model.JmFile;
import vn.jmango.grande.virtualstore.model.Material;
import vn.jmango.grande.virtualstore.model.Piece;
import vn.jmango.grande.virtualstore.model.Product;
import vn.jmango.grande.virtualstore.repository.CatagoryRepository;
import vn.jmango.grande.virtualstore.repository.ColorRepository;
import vn.jmango.grande.virtualstore.repository.FileRepository;
import vn.jmango.grande.virtualstore.repository.MaterialRepository;
import vn.jmango.grande.virtualstore.repository.PieceRepository;
import vn.jmango.grande.virtualstore.repository.ProductRepository;

/**
 * Mostly used as a facade for all Petclinic controllers Also a placeholder for @Transactional
 * and @Cacheable annotations
 * 
 * @author Michael Isvy
 */
@Service
public class ClinicServiceImpl implements ClinicService {

	private ProductRepository productRepository;
	private ColorRepository colorRepository;
	private MaterialRepository materialRepository;
	private PieceRepository pieceRepository;
	private FileRepository fileRepository;
	private CatagoryRepository catagoryRepository;

	@Autowired
	public ClinicServiceImpl(ProductRepository productRepository,
			ColorRepository colorRepository,
			MaterialRepository materialRepository,
			PieceRepository pieceRepository, FileRepository fileRepository,
			CatagoryRepository catagoryRepository) {
		this.productRepository = productRepository;
		this.colorRepository = colorRepository;
		this.materialRepository = materialRepository;
		this.pieceRepository = pieceRepository;
		this.fileRepository = fileRepository;
		this.catagoryRepository = catagoryRepository;
	}

	@Override
	@Transactional
	public void saveProduct(Product product) throws DataAccessException {
		// TODO Auto-generated method stub
		productRepository.save(product);
	}

	@Override
	@Transactional(readOnly = true)
	public Collection<Product> findProductByName(String Name)
			throws DataAccessException {
		// TODO Auto-generated method stub
		return this.productRepository.findByName(Name);
	}

	@Override
	@Transactional(readOnly = true)
	public Product findProductById(int id) throws DataAccessException {
		// TODO Auto-generated method stub
		return this.productRepository.findById(id);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Color> getAllColor() throws DataAccessException {
		// TODO Auto-generated method stub
		System.out.println("get data COlor");
		return this.colorRepository.getAllColor();
	}

	@Override
	@Transactional
	public void saveColor(Color color) throws DataAccessException {
		// TODO Auto-generated method stub
		this.colorRepository.saveColor(color);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Material> getAllMaterial() throws DataAccessException {
		// TODO Auto-generated method stub
		return this.materialRepository.getAllMaterial();
	}

	@Override
	@Transactional
	public void saveMaterial(Material material) throws DataAccessException {
		// TODO Auto-generated method stub
		this.materialRepository.saveMaterial(material);
	}

	@Override
	@Transactional
	public void savePiece(Piece piece) throws DataAccessException {
		// TODO Auto-generated method stub
		this.pieceRepository.savePiece(piece);
	}

	@Override
	@Transactional(readOnly = true)
	public Piece findPieceById(int id) throws DataAccessException {
		// TODO Auto-generated method stub
		return this.pieceRepository.findPieceById(id);
	}

	@Override
	@Transactional
	public void saveFile(JmFile file) throws DataAccessException {
		// TODO Auto-generated method stub
		this.fileRepository.saveFile(file);
	}

	@Override
	@Transactional
	public JmFile findFileById(int id) throws DataAccessException {
		// TODO Auto-generated method stub
		return this.fileRepository.findFileById(id);
	}

	@Override
	@Transactional
	public List<Catagory> getAllCatagory() throws DataAccessException {
		// TODO Auto-generated method stub
		return this.catagoryRepository.getAllCatagory();
	}

	@Override
	@Transactional
	public void saveCatagory(Catagory catagory) throws DataAccessException {
		// TODO Auto-generated method stub
		this.catagoryRepository.saveCatagory(catagory);
	}
	
	

}
