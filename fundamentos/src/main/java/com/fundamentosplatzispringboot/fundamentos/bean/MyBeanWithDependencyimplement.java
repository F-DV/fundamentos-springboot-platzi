package com.fundamentosplatzispringboot.fundamentos.bean;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class MyBeanWithDependencyimplement implements MyBeanWithDependency{

    private final Log LOGGER = LogFactory.getLog(MyBeanWithDependencyimplement.class);
    private MyOperation myOperation;

    public MyBeanWithDependencyimplement(MyOperation myOperation) {
        this.myOperation = myOperation;
    }

    @Override
    public void printWithDependency() {
        int number = 1;
        LOGGER.info("Ingresamos al printWithDependency");
        LOGGER.debug("El valor del numero es: " + number);

        System.out.println(myOperation.sum(number));
        System.out.println("Hola, Esta es la implementación de un bean con dependencia");
    }
}
