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

# ¿Que son los logs?
- Es una herramienta o utilidad que nos permite debuggerar la informacion de nuestro codigo
- Podemos saber por donde esta pasando nuestro codigo
- Ejemplo de logs: ERROR,INFO,DEBUG.

# ¿Que es JPA (Java Persistence API)?
- Es el estandar de la industria para modelar Objetos en java como base de datos
- Sirve para acceder, conservar y administrar los datos de una base de datos Realacional
- Nos permite modelar las tablas en Clases Java.

# ¿Que es JpaRepository?
- Es una interfaz que nos ofrece metodos para interactuar con las bases de datos
- recibe 2 parametros, 1)La entidad que queremos mappear 2)El tipo delvid

# ¿Que es JPQL?
- Es el lenguaje definido por JPA para trabajar con base de datos
- Es un parecido a SQL con la direfencia que SQL trabaja con tablas y JPQL trabaja con Objetos y propiedades
- Solo nos permite realizar: SELECT,UPDATES Y DELETE no podemos hacer insert con JPQL.

# ¿Que son los Query Methods?
- Es otra alternativa a las anotaciones query de JPQL.
- Se hacen por Clases o interfaces Java.
- No utilizamos las annotaciones de Query si no que hacemos uso de metodos directamente.

--------

## Commits
# Inyeccion de dependencia Component
- Creación de Interface ComponentDependency
- Creación de clase ComponentImplement
- Creación de clase ComponentImplement2
- En la clase principal FundamentosApplication inyectamos la dependencia y en el constructor indicamos con qualifer
cual implementacion utilizará, Tambien podemos usar en el componente la anotacion @primary para indicar cual se utilizará

# Creacion de dependencia Propia
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

# Cambio de Puerto y Path
- Se inyecta la dependencia en pom.xml starter.web
- Configuramos el server en el archivo application.properties, cambiando el puerto y el path
- Se crea el package y la clase TestController, y creamos un petición basica y respondemos con un mensaje
- le damos run e ingresamos al navegador con el puerto y el path configurado y veremos la respuesta.
-> Inyectamos una dependencia llamada devtools en pom.xml
- Esta herramienta sirve para cuando hagamos un cambio y guardemos se vea reflejado inmediatamente en el navegador

# Uso properties y generacion de pojo 1
- Agregamos valores al archivo application.properties
- Creamos un archivo de configuracion GeneralConfiguration, configuramos la dependencia y le pasamos a la implementación
2 valores de properties. 
- Creamos una dependencia(MybeanWithProperties)
- Creamos la implementacion de la dependencia(MybeanWithPropertiesImplement).
- Inyectamos la dependencia dentro de FundamentosApplication


# Uso de properties con ejemplo de generacion de pojo
- Creamos package Pojo y clase UserPojo, Creamos implementacion de un pojo sencillo
- utilizamos la anotacion @@ConstructorBinding  para construir el pojo
- Utilizamos la anotacion @ConfigurationProperties(prefix = "user") con un prefijo que se referenciara en application.properties
- Le damos valores al pojo desde el archivo application.properties
- utilizamos la anotacion @EnableConfigurationProperties(UserPojo.class) en la clase de GeneralConfiguration,
para darle una configuracion inicial y poderlo inyectar.
- Inyectamos en Fundamentos.properties
-> Aprendimos a configurar un pojo y como darle valores desde properties

# Uso de Logs
- Configuramos el tipo de log que nos muestra la aplicacion desde properties
- Utilizamos la libreria Apache e instanciamos en FundamentosApplication un Log
- Este log nos sirve para referenciar cuales con los errors y poder debugger el codigo
- Podemos utilizarlo en los try/catch
- Info es parecido a un system.out.print, para saber ha que metodos ingresa el codigo.
- Hacemos una implementación de Log en la clase MyBeanWithDependencyImplement.

# Modelado de Entidades con JPA
- Inicialmente se agrega la dependencia de JPA en pom.xml
- Creamos 2 clases para representar entidades Post,User
- Relacionamos las tabals con @ManytoOne y @OneToMany 
- Le damos nombre a las tablas
- NOTA: No olvidar los constructores, getter and setters y toString

# Configuracion de datasoure con properties y clases
- Primero se agrega la dependencia para trabajar con la base de datos h2
- Se realiza configuracion del datasource con el archivo application.properties
- Se realiza configuracion como un @Bean en la clase GeneralConfiguration
- Nota:Podemos configurarlo de cualquiera de las dos formas.

# Registro de Base de datos con JpaRepository
- Creamos la interface(dependencia) UserRepository y PostRepository extendemos de JpaRepository para usar los metodos del CRUD
- Creamos en FundamentosApplication un metodo y dentro creamos 10 usuarios
- Inyectamos la dependencia UserRepository en FundamentosApplication
- Los guardamos en una lista y luego aplicamos un stream para recorrelos y aplicarles save de JpaRepository
- En application.properties activamos spring.jpa.show-sql para ver en la consola como hibbernate agrega cada usuario en la base de datos H2

# JPQL en annotation query
  - 1PARTE
  - Nos dirigimos a User Repository y creamos un query para buscar un usuario por email.
  - Luego en FundamosApplication creamos un metodo en el cual hacemos uso del metodo para buscar por email
  - le pasamos un email y lanzamos una exception en caso de que no encuentre. Todo lo imprimimos con un LOGGER.info para visualizar en consola
    - 2PARTE
  - Creamos metodo en la dependencia UserRepository llamado findBySort para buscar y ordenar los usuarios,
   que empiezen por el parametro que se le pasa.
  - Cambiamos los nombre de algunos usuarios para poder visualizar el trabajo del metodo findAndSort.
  - Hacemos uso del metodo en FundamentosApplication buscardo a los usuaruis que empiezan por user y ordenandolos
de forma descendente con respecto a su id

# Value para apuntar a properties
  - Creamos un nuevo properties llamado conection.propertiespara crear variables a nivel de properties
  - Despues en GeneralConfiguration, con la anotacion @propertySource lo referenciamos.
  - y cremoa variables para utilar estos valores
  - NOTA: Cuando se crean variables para manejar base de datos es aconcejable manejar variables de entorno.

# Obtencion de informacion con QueryMethods
- No utilizamos la anotacion @Query, si no que hacemos uso directamente al metodo.
- Creamos dos los metodos en UserRepository 1 para buscar una lista de usuarios el otro para 1 solo usuario.
- Creamos las implementaciones en FundamentosApplication

# Query Methods con Or,And,orderBy,Between,sort
- Funcion Like :Agregamos funcion para buscar los usuarios que coincidan con la letra que le enviamos como parametro.
- Trae un lista de usuarios, en FundamentosApplication implementamos el metodo, enviando u como parametrp
- con %% trae los usuarios que tengan u en cualquier posicion del nombre.
- Funcion Or : Busca al usuario basado en cualquiera de los dos parametros que le enviemos 
- en este caso ya sea que le enviemos el nombre o el email.
- Funcion Between : Buscar a los usuarios que se encuentren en un rango de fechas
- Funcion OrderBy : Busca los usuarios que coincidan con el name que le enviamos y los ordena por su id
- Funcion Containing : Busca los usuarios que contengan la palabra que le indiquemos.

# Uso de JPQL con named Parameters
- Creamos Clase DTO para el usuario
- NOTA = DTO: Es un POJO que se usa para enviar los datos del servidor al cliente
- En userRepository Realizamos el Query named Parameters construyendo nuestro DTO con los parametros del usuario
- Mostramos en consola la lista de usuarios encontrados que tengan los parametros enviados, esta lista ya es de tipo UserDto
- En caso de que no encuentre ninguno , lanzamos una exception, la lista es optional.
- Nota : No olvidar los espacios entre " y los querys por ejemplo " FROM".
