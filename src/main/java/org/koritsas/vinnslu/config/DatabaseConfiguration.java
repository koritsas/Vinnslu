package org.koritsas.vinnslu.config;

import org.hibernate.ejb.HibernateEntityManagerFactory;
import org.hibernate.jpa.boot.internal.EntityManagerFactoryBuilderImpl;
import org.koritsas.vinnslu.utils.GeometryModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.orm.jpa.EntityManagerFactoryUtils;
import org.springframework.orm.jpa.LocalEntityManagerFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import java.util.Properties;

@Configuration
@EnableTransactionManagement
@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class})
@EnableJpaRepositories
public class DatabaseConfiguration {

    private static final String[] ENTITIES_PACKAGE = { "org.koritsas.vinnslu.models" };

    private Environment environment;

    @Autowired
    EntityManager entityManager;

    @Bean(name = "entityManager")
    public EntityManager getEntityManager(){

        return entityManager;
    }


    @Bean
	public GeometryModelMapper geometryModelMapper(){
    	return new GeometryModelMapper();
	}
/*
    @Autowired
    public void setEnvironment(Environment environment) { this.environment = environment; }

    @Bean
    public DataSource getConfiguredDataSource() {
	DriverManagerDataSource dataSource = new DriverManagerDataSource();
	dataSource.setDriverClassName(environment.getRequiredProperty("spring.datasource.driver-class-name"));
	dataSource.setUrl(environment.getRequiredProperty("spring.datasource.url"));
	dataSource.setUsername(environment.getRequiredProperty("spring.datasource.username"));
	dataSource.setPassword(environment.getRequiredProperty("spring.datasource.password"));

	return dataSource;
    }


    @Bean(name = "sessionFactory")
    public LocalSessionFactoryBean sessionFactory() {
	LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
	sessionFactory.setDataSource(getConfiguredDataSource());
	sessionFactory.setPackagesToScan(ENTITIES_PACKAGE);
	sessionFactory.setHibernateProperties(hibernateProperties());

	return sessionFactory;
    }

    @Bean(name = "entityManagerFactory")
    public LocalEntityManagerFactoryBean localEntityManagerFactoryBean(){
    	LocalEntityManagerFactoryBean bean = new LocalEntityManagerFactoryBean();
		return bean;
	}



    @Bean
    public HibernateTransactionManager transactionManager() {
	HibernateTransactionManager transactionManager = new HibernateTransactionManager();

	transactionManager.setSessionFactory(sessionFactory().getObject());

	return transactionManager;
    }



    Properties hibernateProperties() {
	return new Properties() {
	    {

		setProperty("hibernate.dialect",environment.getProperty("hibernate.dialect"));
		setProperty("hibernate.show_sql",environment.getProperty("hibernate.show_sql"));
		setProperty("hibernate.format_sql",environment.getProperty("hibernate.format_sql"));
		setProperty("hibernate.use_sql_comments",environment.getProperty("hibernate.use_sql_comments"));
		setProperty("hibernate.integration.spatial.enabled",environment.getProperty("hibernate.integration.spatial.enabled"));
		setProperty("hibernate.dll-auto",environment.getProperty("hibernate.ddl-auto"));
		setProperty("hibernate.physical_naming_strategy",environment.getProperty("hibernate.physical_naming_strategy"));
		setProperty("spring.jpa.hibernate.ddl-auto",environment.getProperty("spring.jpa.hibernate.ddl-auto"));
		setProperty("spring.jpa.hibernate.naming.physical-strategy",environment.getProperty("spring.jpa.hibernate.naming.physical-strategy"));

	    }
	};


    }

    */
}