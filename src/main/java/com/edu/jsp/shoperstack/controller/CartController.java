package com.edu.jsp.shoperstack.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.edu.jsp.shoperstack.entity.Cart;
import com.edu.jsp.shoperstack.service.CartService;
import com.edu.jsp.shoperstack.util.ResponseStructure;

@RestController
@RequestMapping("/api/version/carts")
public class CartController {
	@Autowired
	private CartService service;

	@PostMapping("/save")
	public ResponseEntity<ResponseStructure<Cart>> 
	saveCart(@RequestBody Cart cart) {
		return service.saveCart(cart);
	}

}
