package com.example.conf;

import com.mysql.cj.jdbc.Driver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.Properties;

@Configuration
@EnableJpaRepositories("com.example.dao")
@EnableTransactionManagement

public class JpaConfig {


    @Bean
    public DataSource dataSource(){
        SimpleDriverDataSource dataSource = new SimpleDriverDataSource();
        try {
            dataSource.setDriver(new Driver());
            dataSource.setUrl("jdbc:mysql://localhost:3306/spring_data_sample");
            dataSource.setPassword("");

            dataSource.setUsername("root");

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return dataSource;
    }

    private Properties jpaProperties() {
        Properties properties = new Properties();
        properties.setProperty("hibernate.hbm2ddl.auto","update");
        properties.setProperty("hibernate.show_sql","true");
        properties.setProperty("hibernate.format_sql","true");
        properties.setProperty("hibernate.dialect","org.hibernate.dialect.MySQL8Dialect");
        return properties;
    }



    @Bean
   public LocalContainerEntityManagerFactoryBean entityManagerFactory(@Autowired DataSource dataSource) {
        LocalContainerEntityManagerFactoryBean localContainerEntityManagerFactoryBean = new LocalContainerEntityManagerFactoryBean();
        localContainerEntityManagerFactoryBean.setDataSource(dataSource);
        localContainerEntityManagerFactoryBean.setPackagesToScan("com.example.model");
        localContainerEntityManagerFactoryBean.setJpaProperties(jpaProperties());
                localContainerEntityManagerFactoryBean.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
        return localContainerEntityManagerFactoryBean;
    }



    @Bean
   public PlatformTransactionManager transactionManager(){
JpaTransactionManager platformTransactionManager = new JpaTransactionManager();
return platformTransactionManager;
    }



}
