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
        entityManagerFactoryRef = "db3ManagerFactory",
        transactionManagerRef = "db3TransactionManager",
        basePackages = {
                "com.serviciosAdministrativos.servicios.domain.repositories.DBActualizacionDatos"
        }
)
public class DBActualizacionDatos {
    private final Environment environment;

    public DBActualizacionDatos(Environment environment) {
        this.environment = environment;
    }

    @Bean(name = "db3DataSource")
    public DataSource dataSource3() {
        return DataSourceBuilder.create()
                .url(environment.getProperty("db3.datasource.jdbc.url"))
                .driverClassName(environment.getProperty("db3.datasource.driver-class-name"))
                .username(environment.getProperty("db3.datasource.username"))
                .password(environment.getProperty("db3.datasource.password"))
                .build();
    }
    @Bean(name = "db3ManagerFactory")
    public LocalContainerEntityManagerFactoryBean entityManagerFactoryBean1() {
        LocalContainerEntityManagerFactoryBean factoryBean = new LocalContainerEntityManagerFactoryBean();
        factoryBean.setDataSource(dataSource3());
        factoryBean.setPackagesToScan("com.serviciosAdministrativos.servicios.domain.entities.DBActualizacionDatos");
        HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        factoryBean.setJpaVendorAdapter(vendorAdapter);
        Map<String, Object> properties = new HashMap<>();
        properties.put("hibernate.dialect", environment.getProperty("db1.jpa.properties.hibernate.dialect"));
        factoryBean.setJpaPropertyMap(properties);
        return factoryBean;
    }

    @Bean(name = "db3TransactionManager")
    public PlatformTransactionManager platformTransactionManager3(
            @Qualifier(value = "db3ManagerFactory") EntityManagerFactory entityManagerFactory
    ) {
        return new JpaTransactionManager(entityManagerFactory);
    }
}
