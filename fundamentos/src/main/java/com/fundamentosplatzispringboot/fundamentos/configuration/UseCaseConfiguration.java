package com.fundamentosplatzispringboot.fundamentos.configuration;

import com.fundamentosplatzispringboot.fundamentos.service.UserService;
import com.fundamentosplatzispringboot.fundamentos.usecase.GetUser;
import com.fundamentosplatzispringboot.fundamentos.usecase.GetUserImplement;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.persistence.Column;

@Configuration
public class UseCaseConfiguration {

    @Bean
    GetUser getUser(UserService userService){
        return new GetUserImplement(userService);
    }
}
