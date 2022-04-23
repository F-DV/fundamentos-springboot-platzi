## fundamentos-springboot-platzi

-----------

# ¿Que es una Dependencia?
- Es una Pequeña caracteristica de un objeto.
- Las dependencias nos ayudan a modularizar nuestro aplicación

# ¿Que es inversion de Control?
Transfiere el control del flijo del programa a un contendedor o framework.

-> VENTAJAS:
- Desacoplamiento cuando los objetos cuentan con sus dependencias
- Se oculta la implementacion de las dependencias, beneficio de segregacion de interfaces.
- Facil el testing por componentes o mocks de dependencias.
- Mayor modularidad de un programa.

# ¿Que es un Bean?
- Es una dependencia administrada por Spring.

# ¿Que es la Inyeccion de dependencias? 
- El patron que utiliza inversion de control para utilizar esas dependencias que se 
inicializan con el contenedeor de spring. Implementacion del principiodeinversion de control.
- Codigo mas limpio
- Codigo mas modularizado.

# Anotaciones principales de SpringBoot:
- @Component : Clases muy Genericas o abstracto
- @Controller: Representa lo que biene de la interface Grafica, respuestas http, etc.
- @Service: Logica de negocio adicional o validaciones adicionales.
- @Repository: Persistencia de datos, obtención de datos.

## Commits

# Inyeccion de dependencia Component
- Creación de Interface ComponentDependency
- Creación de clase ComponentImplement
- Creación de clase ComponentImplement2
- En la clase principal FundamentosApplication inyectamos la dependencia y en el constructor indicamos con qualifer
cual implementacion utilizará, Tambien podemos usar en el componente la anotacion @primary para indicar cual se utilizará

# Creacion de dependencia Propio
-> PARTE 1
- Creación de 2 Package: bean, configuration
- Creación de Interface MyBean
- Creación de Clase MyBeanImplement
- Creación de Clase MyBeanImplement2
- Creación de Clase MyConfigurationBean
- En este caso indicamos cual implementacion se va a utilizar desde la clase de configuración

-> PARTE 2
- Creación de interface(dependencia) MyOperation
- Creación de Clase(Implementacion) MyOperationimplement
- Configuración de la dependencia(MyOperation) en MyConfiguration
- Creación de dependencia MyBeanWithDependency
- Creación de Implementacion MyBeanWithdepenencyImplement
- Configuración de la dependencia(MyBeanWithDependency) en MyConfiguration
- La idea en este caso es inyectar la dependencia "MyOperation" dentro de la implementación (MyBeanWithdepenencyImplement),
e inyectar (MyBeanWithDependency) en FuntamentosApplication y asi hacer uso de una dependencia que tiene otra.

