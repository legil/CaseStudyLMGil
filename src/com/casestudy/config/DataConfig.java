package com.casestudy.config;

import static org.hibernate.cfg.AvailableSettings.DIALECT;
import static org.hibernate.cfg.AvailableSettings.ENABLE_LAZY_LOAD_NO_TRANS;
import static org.hibernate.cfg.AvailableSettings.FORMAT_SQL;
import static org.hibernate.cfg.AvailableSettings.HBM2DDL_AUTO;
import static org.hibernate.cfg.AvailableSettings.SHOW_SQL;

import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories("com.casestudy.repository")
@PropertySource("classpath:db.properties") // there might be an error here
public class DataConfig {

	@Autowired
	Environment environment;
//


	/************* Start Spring JPA config details **************/
	@Bean(name = "entityManagerFactory")
	public LocalContainerEntityManagerFactoryBean getEntityManagerFactoryBean() {
		LocalContainerEntityManagerFactoryBean lcemfb = new LocalContainerEntityManagerFactoryBean();
		lcemfb.setJpaVendorAdapter(getJpaVendorAdapter());
		lcemfb.setDataSource(dataSource()); //JDBC
		lcemfb.setPersistenceUnitName("securityUnit");
		lcemfb.setPackagesToScan("com.casestudy.model");
		lcemfb.setJpaProperties(hibernateProperties()); //hibernate
		return lcemfb;
	}

	@Bean
	public JpaVendorAdapter getJpaVendorAdapter() {
		JpaVendorAdapter adapter = new HibernateJpaVendorAdapter();
		return adapter;
	}

	@Bean(name = "transactionManager")
	public PlatformTransactionManager txManager() {
		JpaTransactionManager jpaTransactionManager = new JpaTransactionManager(
				getEntityManagerFactoryBean().getObject());
		return jpaTransactionManager;
	}

	/************* End Spring JPA config details **************/

	// JDBC properties
	@Bean
	public DataSource dataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName(environment.getRequiredProperty("jdbc.driver"));
		dataSource.setUrl(environment.getRequiredProperty("jdbc.url"));
		dataSource.setUsername(environment.getRequiredProperty("jdbc.username"));
		dataSource.setPassword(environment.getRequiredProperty("jdbc.password"));
		return dataSource;
	}

	// hibernate properties
	private Properties hibernateProperties() {
		Properties properties = new Properties();
		properties.put(DIALECT, environment.getRequiredProperty("hibernate.dialect"));
		properties.put(SHOW_SQL, environment.getRequiredProperty("hibernate.show_sql"));
		properties.put(FORMAT_SQL, environment.getRequiredProperty("hibernate.format_sql"));
		properties.put(HBM2DDL_AUTO, environment.getRequiredProperty("hibernate.hbm2ddl.auto"));
		properties.put(ENABLE_LAZY_LOAD_NO_TRANS, environment.getRequiredProperty("hibernate.enable_lazy_load_no_trans"));
		return properties;
	}
}