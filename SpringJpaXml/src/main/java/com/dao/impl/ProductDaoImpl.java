package com.dao.impl;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.model.Product;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;

public class ProductDaoImpl {

	@PersistenceContext
	EntityManager em;
	
	public void save(Product product) {
		em.persist(product);
	}
}
