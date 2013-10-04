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

import org.springframework.dao.DataAccessException;

import vn.jmango.grande.virtualstore.model.Catagory;
import vn.jmango.grande.virtualstore.model.Color;
import vn.jmango.grande.virtualstore.model.JmFile;
import vn.jmango.grande.virtualstore.model.Material;
import vn.jmango.grande.virtualstore.model.Piece;
import vn.jmango.grande.virtualstore.model.Product;


/**
 * Mostly used as a facade for all Petclinic controllers
 *
 * @author Michael Isvy
 */
public interface ClinicService {
    
    
    public void saveProduct(Product product) throws DataAccessException;
    
    Collection<Product> findProductByName(String Name) throws DataAccessException;
    
    public Product findProductById(int id) throws DataAccessException;
    
    List<Color> getAllColor() throws DataAccessException;
    
    public void saveColor(Color color) throws DataAccessException;
    
    List<Material> getAllMaterial() throws DataAccessException;
    
    public void saveMaterial(Material material) throws DataAccessException;
    
    public void savePiece(Piece piece) throws DataAccessException;
    
    public Piece findPieceById(int id) throws DataAccessException;
    
    public void saveFile(JmFile file) throws DataAccessException;
    
    JmFile findFileById(int id) throws DataAccessException;
    
    List<Catagory> getAllCatagory() throws DataAccessException;
    
    public void saveCatagory(Catagory catagory) throws DataAccessException;

}
