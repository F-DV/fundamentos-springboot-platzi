package com.fundamentosplatzispringboot.fundamentos.Pojo;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConstructorBinding;

@ConstructorBinding //Permite construir el pojo
@ConfigurationProperties(prefix = "user") //Recibe los valores de properties referenciandolo con este prefix
public class UserPojo {

    private String email;
    private String password;
    private String age;

    public UserPojo(String email, String password, String age) {
        this.email = email;
        this.password = password;
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }
}
