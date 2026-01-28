package com.configs;

import java.util.Properties;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.model.Product;
import com.service.impl.ProductServiceImpl;

@Configuration
@ComponentScan("com")
@PropertySource("classpath:hibernate.properties")
@EnableTransactionManagement
public class RootConfig {

	@Autowired
	Environment environment;

	@Bean
	public BasicDataSource dataSource() {
		BasicDataSource dataSource = new BasicDataSource();
		dataSource.setDriverClassName(environment.getProperty("db.driver"));
		dataSource.setUrl(environment.getProperty("db.url"));
		dataSource.setUsername(environment.getProperty("db.username"));
		dataSource.setPassword(environment.getProperty("db.password"));
		return dataSource;
	}

	@Bean
	public LocalSessionFactoryBean sessionFactory(BasicDataSource datasource) {
		LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
		sessionFactory.setDataSource(datasource);
		sessionFactory.setAnnotatedClasses(Product.class);
		Properties props = new Properties();
		props.put("hibernate.dialect", environment.getProperty("hibernate.dialect"));
		props.put("hibernate.show_sql", environment.getProperty("hibernate.show_sql"));
		props.put("hibernate.hbm2ddl.auto", environment.getProperty("hibernate.hbm2ddl.auto"));
		props.put("hibernate.format_sql", environment.getProperty("hibernate.format_sql"));
		sessionFactory.setHibernateProperties(props);
		return sessionFactory;
	}

	@Bean
	public HibernateTransactionManager transactionManager(LocalSessionFactoryBean sessionFactoryBean) {
		HibernateTransactionManager transactionManager = new HibernateTransactionManager();
		transactionManager.setSessionFactory(sessionFactoryBean.getObject());
		return transactionManager;
	}

}
