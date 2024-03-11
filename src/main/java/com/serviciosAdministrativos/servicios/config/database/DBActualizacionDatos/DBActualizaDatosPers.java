package com.serviciosAdministrativos.servicios.config.database.DBActualizacionDatos;

import jakarta.persistence.EntityManagerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
        entityManagerFactoryRef = "db4ManagerFactory",
        transactionManagerRef = "db4TransactionManager",
        basePackages = {
                "com.serviciosAdministrativos.servicios.domain.repositories.DBActualizaDatosPers"
        }
)
public class DBActualizaDatosPers {
    private final Environment environment;

    public DBActualizaDatosPers(Environment environment) {
        this.environment = environment;
    }

    @Bean(name = "db4DataSource")
    public DataSource dataSource4() {
        return DataSourceBuilder.create()
                .url(environment.getProperty("db4.datasource.jdbc.url"))
                .driverClassName(environment.getProperty("db4.datasource.driver-class-name"))
                .username(environment.getProperty("db4.datasource.username"))
                .password(environment.getProperty("db4.datasource.password"))
                .build();
    }
    @Bean(name = "db4ManagerFactory")
    public LocalContainerEntityManagerFactoryBean entityManagerFactoryBean() {
        LocalContainerEntityManagerFactoryBean factoryBean = new LocalContainerEntityManagerFactoryBean();
        factoryBean.setDataSource(dataSource4());
        factoryBean.setPackagesToScan("com.serviciosAdministrativos.servicios.domain.entities.DBActualizaDatosPers");
        HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        factoryBean.setJpaVendorAdapter(vendorAdapter);
        Map<String, Object> properties = new HashMap<>();
        properties.put("hibernate.dialect", environment.getProperty("db4.jpa.properties.hibernate.dialect"));
        factoryBean.setJpaPropertyMap(properties);
        return factoryBean;
    }

    @Bean(name = "db4TransactionManager")
    public PlatformTransactionManager platformTransactionManager3(
            @Qualifier(value = "db4ManagerFactory") EntityManagerFactory entityManagerFactory
    ) {
        return new JpaTransactionManager(entityManagerFactory);
    }
}
