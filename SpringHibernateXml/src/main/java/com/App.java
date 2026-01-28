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
		ApplicationContext context = new ClassPathXmlApplicationContext("configs/root-context.xml");
		
		ProductServiceImpl service  = (ProductServiceImpl)context.getBean("productServiceImpl");
		
		Product product = service.getProduct(103);
		System.out.println(product);
	}
}
