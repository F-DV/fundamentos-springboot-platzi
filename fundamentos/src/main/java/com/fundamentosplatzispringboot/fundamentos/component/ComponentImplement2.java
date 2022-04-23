package com.fundamentosplatzispringboot.fundamentos.component;

import org.springframework.stereotype.Component;

@Component
public class ComponentImplement2 implements ComponentDependency{
    @Override
    public void saludar() {
        System.out.println("Hola desde mi dependencia 2");
    }
}
