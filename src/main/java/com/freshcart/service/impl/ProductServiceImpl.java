package com.freshcart.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.freshcart.entities.Product;

import com.freshcart.repository.ProductRepository;

import com.freshcart.service.ProductService;

@Service

public class ProductServiceImpl implements ProductService{

	 @Autowired
	    private ProductRepository productRepository;

	    @Override
	    public Product saveProduct(Product product) {
	        return productRepository.save(product);
	    }

	    @Override
	    public List<Product> getAllProducts() {
	        return productRepository.findAll();
	    }

	    @Override
	    public Product getProductById(Long id) {
	        return productRepository.findById(id).orElse(null);
	    }

	    @Override
	    public void deleteProduct(Long id) {
	        productRepository.deleteById(id);
	    }
}
