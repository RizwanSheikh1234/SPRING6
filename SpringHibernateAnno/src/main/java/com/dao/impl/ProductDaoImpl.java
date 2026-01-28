package com.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dao.ProductDao;
import com.model.Product;

@Repository
public class ProductDaoImpl implements ProductDao {
	@Autowired
	SessionFactory sessionFactory;

	public Product findProduct(int id) {
		return sessionFactory.getCurrentSession().getReference(Product.class, id);
	}

	public void persistProduct(Product product) {
		sessionFactory.getCurrentSession().persist(product);
	}

	public void removeProduct(Product product) {
		sessionFactory.getCurrentSession().createQuery("delete Product p where p.id= :id").setParameter("id", product.getId()).executeUpdate();
	}

	public void updateProduct(Product product) {
		sessionFactory.getCurrentSession().merge(product);
	}

	@Override
	public List<Product> getProducts() {
		List<Product> products = sessionFactory.getCurrentSession().createQuery("from Product",Product.class).getResultList();
		return products;
	}
}
