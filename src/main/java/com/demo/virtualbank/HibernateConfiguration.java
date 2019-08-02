package com.demo.virtualbank;

import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configurable
@EnableTransactionManagement
public class HibernateConfiguration {
	
	@Value("${db.driver}")
	private String DRIVER;
 
	@Value("${db.password}")
	private String PASSWORD;
 
	@Value("${db.url}")
	private String URL;
 
	@Value("${db.username}")
	private String USERNAME;
 
	@Value("${hibernate.dialect}")
	private String DIALECT;
 
	@Value("${hibernate.show_sql}")
	private String SHOW_SQL;
 
	@Value("${hibernate.hbm2ddl.auto}")
	private String HBM2DDL_AUTO;
 
	@Value("${entitymanager.packagesToScan}")
	private String PACKAGES_TO_SCAN;
	
	@Bean
    public LocalSessionFactoryBean sessionFactory() {
    LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
    sessionFactory.setDataSource(dataSource());
    sessionFactory.setPackagesToScan("com.demo.virtualbank.models");
    sessionFactory.setHibernateProperties(hibernateProperties());

    return sessionFactory;
}

	@Bean
	public DataSource dataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName(DRIVER);
		dataSource.setUrl(URL);
		dataSource.setUsername(USERNAME);
		dataSource.setPassword(PASSWORD);
		return dataSource;
	}

	@Bean
	public PlatformTransactionManager hibernateTransactionManager() {
		HibernateTransactionManager transactionManager = new HibernateTransactionManager();
		transactionManager.setSessionFactory(sessionFactory().getObject());
		return transactionManager;
	}

	private final Properties hibernateProperties() {
		Properties hibernateProperties = new Properties();
		hibernateProperties.setProperty("hibernate.hbm2ddl.auto", "create-drop");
		hibernateProperties.setProperty("hibernate.dialect", "org.hibernate.dialect.H2Dialect");

		return hibernateProperties;
	}
}
