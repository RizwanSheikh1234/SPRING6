package com.dao;

import java.util.List;

import com.model.Product;

public interface ProductDao {

	Product findProduct(int id);

	void persistProduct(Product product);

	void removeProduct(Product product);

	void updateProduct(Product product);
	
	List<Product> getProducts();
}
