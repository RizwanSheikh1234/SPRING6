package com.dao.impl;

import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

import com.model.Product;

public class ProductDaoImpl {

	SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Transactional
	public Product findProduct(int id) {
		return sessionFactory.getCurrentSession().get(Product.class, id);
	}
}
