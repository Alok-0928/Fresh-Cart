package com.freshcart.service;



import java.util.List;

import com.freshcart.entities.Product;



public interface ProductService {

	Product saveProduct(Product product);
	  List<Product> getAllProducts();
	    Product getProductById(Long id);
	    void deleteProduct(Long id);
}
