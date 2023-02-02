package com.cjc.co.util;

import java.util.Properties;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.cjc.co.model.Address;
import com.cjc.co.model.Employee;

@Configuration
@ComponentScan(basePackages = "com.cjc.co")
@EnableWebMvc
public class AppConfig {

	@Bean
	public InternalResourceViewResolver iRVS()
	{
		InternalResourceViewResolver irvc = new InternalResourceViewResolver();
		irvc.setSuffix(".jsp");
		return irvc;
	}
	@Bean
	public DriverManagerDataSource dMDS()
	{
		DriverManagerDataSource dmds = new DriverManagerDataSource();
		dmds.setDriverClassName("com.mysql.jdbc.Driver");
		dmds.setUrl("jdbc:mysql://localhost:3306/springcrudjavaBased");
		dmds.setUsername("root");
		dmds.setPassword("root");
		return dmds;
	}
	@Bean
	public LocalSessionFactoryBean lSFB()
	{
		LocalSessionFactoryBean lsfb = new LocalSessionFactoryBean();
		lsfb.setDataSource(dMDS());
		
		Properties p = new Properties();
		p.setProperty("hibernate-dilect", "org.hibernate.dialect.MySQL55Dialect");
		p.setProperty("hibernate.hbm2ddl.auto", "update");
		
		lsfb.setHibernateProperties(p);
		lsfb.setAnnotatedClasses(Employee.class,Address.class);

		return lsfb;
	}
	
}
