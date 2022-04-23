package com.fundamentosplatzispringboot.fundamentos.bean;

public class MyBeanWithDependencyimplement implements MyBeanWithDependency{

    private MyOperation myOperation;

    public MyBeanWithDependencyimplement(MyOperation myOperation) {
        this.myOperation = myOperation;
    }

    @Override
    public void printWithDependency() {
        int number = 1;

        System.out.println(myOperation.sum(number));
        System.out.println("Hola, Esta es la implementación de un bean con dependencia");
    }
}
