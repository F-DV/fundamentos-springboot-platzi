package com.fundamentosplatzispringboot.fundamentos;

import com.fundamentosplatzispringboot.fundamentos.Pojo.UserPojo;
import com.fundamentosplatzispringboot.fundamentos.bean.MyBean;
import com.fundamentosplatzispringboot.fundamentos.bean.MyBeanWithDependency;
import com.fundamentosplatzispringboot.fundamentos.bean.MyBeanWithProperties;
import com.fundamentosplatzispringboot.fundamentos.component.ComponentDependency;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FundamentosApplication implements CommandLineRunner {

	private ComponentDependency componentDependency;
	private MyBean myBean;
	private MyBeanWithDependency myBeanWithDependency;
	private MyBeanWithProperties  myBeanWithProperties;
	private UserPojo userPojo;

	@Autowired
	public FundamentosApplication(
			@Qualifier("componentImplement2") ComponentDependency componentDependency
			, MyBean myBean
			, MyBeanWithDependency myBeanWithDependency
			, MyBeanWithProperties myBeanWithProperties
			, UserPojo userPojo){
		this.componentDependency = componentDependency;
		this.myBean = myBean;
		this.myBeanWithDependency = myBeanWithDependency;
		this.myBeanWithProperties = myBeanWithProperties;
		this.userPojo = userPojo;
	}
	public static void main(String[] args) {
		SpringApplication.run(FundamentosApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		componentDependency.saludar();
		myBean.print();
		myBeanWithDependency.printWithDependency();
		System.out.println(myBeanWithProperties.function());
		System.out.println(userPojo.getEmail() + "-" + userPojo.getPassword()+"-"+userPojo.getAge());
	}
}
