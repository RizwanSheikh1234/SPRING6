package com.service.impl;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.dao.impl.ProductDaoImpl;
import com.model.Product;

public class ProductServiceImpl {

	private ProductDaoImpl productDaoImpl;

	public void setProductDaoImpl(ProductDaoImpl productDaoImpl) {
		this.productDaoImpl = productDaoImpl;
	}

	@Transactional
	public void addOrUpdateProduct(Product product) {
		 productDaoImpl.save(product);
	}

//	@Transactional(readOnly = true)
//	public Product getProduct(int id) {
//		return productDaoImpl.findProduct(id);
//	}
//
//	@Transactional(readOnly = true)
//	public List<Product> getAllProducts() {
//		return productDaoImpl.findAllProducts();
//	}
//
//	@Transactional
//	public void deleteProduct(int id) {
//		productDaoImpl.deleteProduct(id);
//	}
}