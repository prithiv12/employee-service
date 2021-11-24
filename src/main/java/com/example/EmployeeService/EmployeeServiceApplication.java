package com.example.EmployeeService;

import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import com.example.EmployeeService.entity.Employee;
import com.example.EmployeeService.repo.EmployeeRepository;

import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Slf4j
@SpringBootApplication
@EnableSwagger2
@EnableEurekaClient
@EnableFeignClients
@ComponentScan("com.example.EmployeeService")
public class EmployeeServiceApplication implements CommandLineRunner{
	
	@Autowired
	private EmployeeRepository emprepo;

	public static void main(String[] args) {
		log.info("Inside EmployeeMicroService");
		SpringApplication.run(EmployeeServiceApplication.class, args);
	}
	@Bean
	public Docket productApi() {
		return new Docket(DocumentationType.SWAGGER_2).select()
				.apis(RequestHandlerSelectors.basePackage("com.example.EmployeeService")).build();
	}
	
	@Override
	public void run(String... args) throws Exception {
		
		Employee emp=new Employee();
		emp.setId(1);
		emp.setGender("male");
		emp.setAge(21);
		emp.setEName("Prithiv");
		emp.setPhoneNumber(9876543210L);
		emp.setEDepartment("Sales");
		emp.setEmail("prithiv@cognizant.com");
		emprepo.save(emp);
		
		Employee emp1=new Employee();
		emp1.setId(2);
		emp1.setGender("male");
		emp1.setAge(21);
		emp1.setEName("siva");
		emp1.setPhoneNumber(9876543211L);
		emp1.setEDepartment("Technical");
		emp1.setEmail("siva@cognizant.com");
		emprepo.save(emp1);
		
		Employee emp2=new Employee();
		emp2.setId(3);
		emp2.setGender("male");
		emp2.setAge(21);
		emp2.setEName("dhatchin");
		emp2.setPhoneNumber(9876543212L);
		emp2.setEDepartment("Intern");
		emp2.setEmail("dhatchin@cognizant.com");
		emprepo.save(emp2);
		
		Employee emp3=new Employee();
		emp3.setId(4);
		emp3.setGender("female");
		emp3.setAge(21);
		emp3.setEName("harshini");
		emp3.setPhoneNumber(9876543213L);
		emp3.setEDepartment("Human Resource");
		emp3.setEmail("harshini@cognizant.com");
		emprepo.save(emp3);
		
		Employee emp4=new Employee();
		emp4.setId(5);
		emp4.setGender("male");
		emp4.setAge(21);
		emp4.setEName("aadhi");
		emp4.setPhoneNumber(9876543214L);
		emp4.setEDepartment("Marketing");
		emp4.setEmail("aadhi@cognizant.com");
		emprepo.save(emp4);
		
		
	}
	
}
