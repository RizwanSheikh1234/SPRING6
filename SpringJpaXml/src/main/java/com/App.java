package com;

import java.time.LocalDate;

import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;

import com.model.Product;
import com.service.impl.ProductServiceImpl;

public class App {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("root-context.xml");
		
		ProductServiceImpl service  = context.getBean(ProductServiceImpl.class);
		Product p = new Product();
		p.setId(111);
		p.setCategory("elec");
		p.setTitle("abc");
		p.setPdate(LocalDate.of(1990, 8, 3));
		service.addOrUpdateProduct(p);
	}
}
