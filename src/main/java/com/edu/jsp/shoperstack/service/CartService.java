package com.edu.jsp.shoperstack.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.edu.jsp.shoperstack.dao.CartDao;
import com.edu.jsp.shoperstack.entity.Cart;
import com.edu.jsp.shoperstack.entity.Product;
import com.edu.jsp.shoperstack.util.ResponseStructure;

@Service
public class CartService {
	@Autowired
	private CartDao cartDao;

	public ResponseEntity<ResponseStructure<Cart>> saveCart(Cart cart) {

		cart = calculatePriceOfCart(cart);
		Cart savedCart = cartDao.saveCart(cart);

		ResponseStructure<Cart> structure = new ResponseStructure<Cart>();
		structure.setMessage("Created");
		structure.setData(savedCart);
		return new ResponseEntity<ResponseStructure<Cart>>(structure, HttpStatus.CREATED);
	}

	public Cart calculatePriceOfCart(Cart cart) {
		// Write a login to set the Number of Product and Total price
		if (cart.getProducts() != null) {

			// Calculate the Number of Product
			List<Product> listOfProducts = cart.getProducts();
			int numberOfProducts = listOfProducts.size();
			cart.setNumberOfPrducts(numberOfProducts);

			// Calculate the Total Price
			double totalPrice = 0.0;
			for (Product product : listOfProducts) {
				product.setCart(cart);
				totalPrice += product.getProductPrice();
			}
			cart.setTotalPrice(totalPrice);
		}
		return cart;
	}

//	public ResponseEntity<ResponseStructure<List<Cart>>> findAll() {
//
//	}
//
//	public ResponseEntity<ResponseStructure<Cart>> findById(int cartId) {
//
//	}
//
//	public ResponseEntity<ResponseStructure<String>> delete(int cartId) {
//
//	}
}
