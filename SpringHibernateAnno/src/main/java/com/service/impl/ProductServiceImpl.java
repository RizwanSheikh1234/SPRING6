package com.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dao.ProductDao;
import com.model.Product;
import com.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductDao productDao;

	@Transactional
	public boolean createProduct(Product product) {
		if (product == null) {
			return false;
		}
		this.productDao.persistProduct(product);
		return true;
	}

	@Transactional
	public boolean deleteProduct(int id) {
		Product product = getProduct(id);
		if (product == null) {
			return false;
		}
		this.productDao.removeProduct(product);
		return true;
	}

	@Transactional
	public boolean updateProduct(Product product) {
		if (product == null) {
			return false;
		}
		Product pr = getProduct(product.getId());
		if (pr == null) {
			return false;
		}
		this.productDao.updateProduct(product);
		return true;
	}

	@Transactional
	public Product getProduct(int id) {
		Product product = this.productDao.findProduct(id);
		if (product != null) {
			return product;
		}
		return null;
	}

	@Transactional
	public List<Product> getProducts() {
		return this.productDao.getProducts();
	}
}
