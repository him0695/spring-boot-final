package com.sapient.order.rest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;;

@SpringBootApplication
//@EnableTransactionManagement
public class SpringMvnRestDemoApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(SpringMvnRestDemoApplication.class, args);
		System.out.println(context);
	}

	@Bean
	public DriverManagerDataSource dataSource() {
		return new DriverManagerDataSource("jdbc:mysql://localhost:3306/order_management", "root", "root");
	}

	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
		LocalContainerEntityManagerFactoryBean emf = new LocalContainerEntityManagerFactoryBean();
		emf.setDataSource(dataSource());
		emf.setPackagesToScan(new String[] { "com.sapient.order.rest" });
		emf.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
		return emf;
	}

//	@Bean
//	public PlatformTransactionManager transactionManager() {
//		JpaTransactionManager transactionManager = new JpaTransactionManager();
//		transactionManager.setEntityManagerFactory(entityManagerFactoryBean().getObject());
//		return transactionManager;
//	}
}
