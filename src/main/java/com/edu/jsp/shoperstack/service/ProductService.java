package com.edu.jsp.shoperstack.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.edu.jsp.shoperstack.dao.ProductDao;
import com.edu.jsp.shoperstack.entity.Product;
import com.edu.jsp.shoperstack.exception.ProductNotFoundException;
import com.edu.jsp.shoperstack.util.ResponseStructure;

@Service
public class ProductService {
	@Autowired
	private ProductDao productDao;

	public ResponseEntity<ResponseStructure<Product>> saveProduct(Product product) {
		Product savedPrduct = productDao.saveProduct(product);
		ResponseStructure<Product> structure = new ResponseStructure<Product>();
		structure.setMessage("Created");
		structure.setData(savedPrduct);

		return new ResponseEntity<ResponseStructure<Product>>(structure, HttpStatus.CREATED);
	}

	public ResponseEntity<ResponseStructure<Product>> findById
	(int productId) {
		Optional<Product> optionalProduct = productDao.
				findById(productId);
		if (optionalProduct.isPresent()) {
			ResponseStructure<Product> structure = new 
					ResponseStructure<Product>();
			structure.setMessage("Found");
			structure.setData(optionalProduct.get());
			return new ResponseEntity<ResponseStructure<Product>>
			(structure, HttpStatus.OK);
		}
		throw new ProductNotFoundException("Product Withe Given id = " 
		+ productId + " Not Found");
	}
}
