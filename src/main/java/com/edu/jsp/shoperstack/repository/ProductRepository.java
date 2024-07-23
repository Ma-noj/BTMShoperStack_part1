package com.edu.jsp.shoperstack.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.edu.jsp.shoperstack.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {

}
