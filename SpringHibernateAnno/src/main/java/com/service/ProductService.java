package com.service;

import java.util.List;

import com.model.Product;

public interface ProductService {
	boolean createProduct(Product product);

	boolean deleteProduct(int id);

	boolean updateProduct(Product product);

	Product getProduct(int id);
	
	List<Product> getProducts();
}
