package com.service.impl;

import org.springframework.transaction.annotation.Transactional;

import com.dao.impl.ProductDaoImpl;
import com.model.Product;

public class ProductServiceImpl {
	private ProductDaoImpl productDaoImpl;

	public ProductDaoImpl getProductDaoImpl() {
		return productDaoImpl;
	}

	public void setProductDaoImpl(ProductDaoImpl productDaoImpl) {
		this.productDaoImpl = productDaoImpl;
	}

	@Transactional
	public Product getProduct(int id) {
		Product product = this.productDaoImpl.findProduct(id);
		if (product != null) {
			return product;
		}
		return null;
	}
}
