package com.fundamentosplatzispringboot.fundamentos.configuration;

import com.fundamentosplatzispringboot.fundamentos.Pojo.UserPojo;
import com.fundamentosplatzispringboot.fundamentos.bean.MyBeanWithProperties;
import com.fundamentosplatzispringboot.fundamentos.bean.MyBeanWithPropertiesImplement;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import javax.sql.DataSource;

@EnableConfigurationProperties(UserPojo.class) //Referenciamos la clase UserPojo, ya puede ser inyectada
@PropertySource("classpath:conecction.properties")
@Configuration
public class GeneralConfiguration {

    @Value("${value.name}")
    private String name;

    @Value("${value.lastName}")
    private String lastName;

    @Value("${value.random}")
    private String random;

    @Value("${jdbc.url}")
    private String jdbcUrl;

    @Value("${driver}")
    private String driver;

    @Value("${username}")
    private String username;

    @Value("${password}")
    private String password;


    @Bean
    public MyBeanWithProperties function(){
        return new MyBeanWithPropertiesImplement(name,lastName);
    }

    //Configuracion de datasource con clases
    @Bean
    public DataSource dataSource(){
        DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create();
        dataSourceBuilder.driverClassName("org.h2.Driver");
        dataSourceBuilder.url("jdbc:h2:mem:testdb");
        dataSourceBuilder.username("sa");
        dataSourceBuilder.password("");
        return dataSourceBuilder.build();

    }
}
