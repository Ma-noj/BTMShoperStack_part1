package com.edu.jsp.shoperstack.dao.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.edu.jsp.shoperstack.dao.ProductDao;
import com.edu.jsp.shoperstack.entity.Product;
import com.edu.jsp.shoperstack.repository.ProductRepository;

@Repository
public class ProductDaoImpl implements ProductDao {
	@Autowired
	private ProductRepository repository;

	@Override
	public Product saveProduct(Product product) {
		return repository.save(product);
	}

	@Override
	public Optional<Product> findById(int productId) {

		return repository.findById(productId);
	}

	@Override
	public List<Product> findAll() {

		return repository.findAll();
	}

	@Override
	public void deleteProduct(int productId) {
		repository.deleteById(productId);
	}

}