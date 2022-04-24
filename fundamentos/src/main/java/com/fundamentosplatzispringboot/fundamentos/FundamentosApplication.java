package com.fundamentosplatzispringboot.fundamentos;

import com.fundamentosplatzispringboot.fundamentos.Pojo.UserPojo;
import com.fundamentosplatzispringboot.fundamentos.bean.MyBean;
import com.fundamentosplatzispringboot.fundamentos.bean.MyBeanWithDependency;
import com.fundamentosplatzispringboot.fundamentos.bean.MyBeanWithProperties;
import com.fundamentosplatzispringboot.fundamentos.component.ComponentDependency;
import com.fundamentosplatzispringboot.fundamentos.entity.User;
import com.fundamentosplatzispringboot.fundamentos.repository.UserRepository;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.domain.Sort;

import java.lang.reflect.Array;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class FundamentosApplication implements CommandLineRunner {

	private final Log LOGGER = LogFactory.getLog(FundamentosApplication.class );
	private ComponentDependency componentDependency;
	private MyBean myBean;
	private MyBeanWithDependency myBeanWithDependency;
	private MyBeanWithProperties  myBeanWithProperties;
	private UserPojo userPojo;
	private UserRepository userRepository;

	@Autowired
	public FundamentosApplication(
			@Qualifier("componentImplement2") ComponentDependency componentDependency
			, MyBean myBean
			, MyBeanWithDependency myBeanWithDependency
			, MyBeanWithProperties myBeanWithProperties
			, UserPojo userPojo
	  		,UserRepository userRepository){
		this.componentDependency = componentDependency;
		this.myBean = myBean;
		this.myBeanWithDependency = myBeanWithDependency;
		this.myBeanWithProperties = myBeanWithProperties;
		this.userPojo = userPojo;
		this.userRepository = userRepository;
	}
	public static void main(String[] args) {
		SpringApplication.run(FundamentosApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		//ejemplosAnteriores();
		saveUsersInDatabase();
		getInformationJpqlFromUser();
	}

	private void getInformationJpqlFromUser(){
		LOGGER.info("El usuario Encontrado es: " + userRepository.findByUserEmail("felipe@gmail")
				.orElseThrow(()-> new RuntimeException("No se encontro el usuario con ese email")));

		userRepository.findAndSort("user",Sort.by("id").descending())
				.stream()
				.forEach(user -> LOGGER.info("Usuario con metodo sort: " + user));

	}
	private void
	saveUsersInDatabase(){
		User user1 = new User("Carlos","carlos@gmail", LocalDate.of(2021,04,3));
		User user2 = new User("Andres","andres@gmail", LocalDate.of(2021,05,4));
		User user3 = new User("Felipe","felipe@gmail", LocalDate.of(2021,06,5));
		User user4 = new User("Fernando","fernando@gmail", LocalDate.of(2021,07,6));
		User user5 = new User("user1","john@gmail", LocalDate.of(2021,04,7));
		User user6 = new User("user2","cesar@gmail", LocalDate.of(2021,04,8));
		User user7 = new User("user3","daniel@gmail", LocalDate.of(2021,10,9));
		User user8 = new User("user4","andredy@gmail", LocalDate.of(2021,11,10));
		User user9 = new User("Jose","jose@gmail", LocalDate.of(2021,02,11));
		User user10 = new User("Raul","raul@gamail", LocalDate.of(2021,01,12));

		List<User> list = Arrays.asList(user1,user2,user3,user4,user5,user6,user7,user8,user9,user10);
		list.stream().forEach(userRepository::save);


	}
	public void ejemplosAnteriores(){
		componentDependency.saludar();
		myBean.print();
		myBeanWithDependency.printWithDependency();
		System.out.println(myBeanWithProperties.function());
		System.out.println(userPojo.getEmail() + "-" + userPojo.getPassword()+"-"+userPojo.getAge());


		//ejemplo de usos de Log
		try{
			//Implementacion
		}catch (Exception e){
			LOGGER.error("Esto es un error",e);
		}
	}
}
