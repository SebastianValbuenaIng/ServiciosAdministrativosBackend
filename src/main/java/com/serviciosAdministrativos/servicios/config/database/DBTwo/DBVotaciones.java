package com.serviciosAdministrativos.servicios.config.database.DBTwo;

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
        entityManagerFactoryRef = "db2ManagerFactory",
        transactionManagerRef = "db2TransactionManager",
        basePackages = {
                "com.serviciosAdministrativos.servicios.domain.repositories.DBTwo"
        }
)
public class DBVotaciones {
    private final Environment environment;


    public DBVotaciones(Environment environment) { this.environment = environment; }

    @Bean(name = "db2DataSource")
    public DataSource dataSource2() {
        return DataSourceBuilder.create()
                .url(environment.getProperty("db2.datasource.jdbc.url"))
                .driverClassName(environment.getProperty("db2.datasource.driver-class-name"))
                .username(environment.getProperty("db2.datasource.username"))
                .password(environment.getProperty("db2.datasource.password"))
                .build();
    }

    @Bean(name = "db2ManagerFactory")
    public LocalContainerEntityManagerFactoryBean entityManagerFactoryBean2() {
        LocalContainerEntityManagerFactoryBean factoryBean = new LocalContainerEntityManagerFactoryBean();
        factoryBean.setDataSource(dataSource2());
        factoryBean.setPackagesToScan("com.serviciosAdministrativos.servicios.domain.entities.DBTwo");
        HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        factoryBean.setJpaVendorAdapter(vendorAdapter);
        Map<String, Object> properties = new HashMap<>();
        properties.put("hibernate.default_schema", "vot");
        properties.put("hibernate.dialect", environment.getProperty("db2.jpa.properties.hibernate.dialect"));
        factoryBean.setJpaPropertyMap(properties);
        return factoryBean;
    }

    @Bean(name = "db2TransactionManager")
    public PlatformTransactionManager platformTransactionManager2(
            @Qualifier(value = "db2ManagerFactory") EntityManagerFactory entityManagerFactory
    ) {
        return new JpaTransactionManager(entityManagerFactory);
    }
}
