package com.edu.jsp.shoperstack.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.edu.jsp.shoperstack.entity.Product;
import com.edu.jsp.shoperstack.service.ProductService;
import com.edu.jsp.shoperstack.util.ResponseStructure;

@RestController
@RequestMapping("/api/version/products")
public class ProdcutController {
	@Autowired
	private ProductService service;

	@PostMapping("/save")
	public ResponseEntity<ResponseStructure<Product>> saveProduct(@RequestBody Product product) {
		return service.saveProduct(product);
	}

	@GetMapping
	public ResponseEntity<ResponseStructure<Product>> findById
	(@PathVariable int productId) {
		return service.findById(productId);
	}

}
