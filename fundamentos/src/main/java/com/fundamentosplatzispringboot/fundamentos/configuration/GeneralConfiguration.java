package com.fundamentosplatzispringboot.fundamentos.configuration;

import com.fundamentosplatzispringboot.fundamentos.Pojo.UserPojo;
import com.fundamentosplatzispringboot.fundamentos.bean.MyBeanWithProperties;
import com.fundamentosplatzispringboot.fundamentos.bean.MyBeanWithPropertiesImplement;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@EnableConfigurationProperties(UserPojo.class) //Referenciamos la clase UserPojo, ya puede ser inyectada
@Configuration
public class GeneralConfiguration {

    @Value("${value.name}")
    private String name;

    @Value("${value.lastName}")
    private String lastName;

    @Value("${value.random}")
    private String random;

    @Bean
    public MyBeanWithProperties function(){
        return new MyBeanWithPropertiesImplement(name,lastName);
    }

}
