package com.examples.empapp.configuration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;

import com.examples.empapp.dao.EmployeeDB;
import com.examples.empapp.model.Employee;
import com.examples.empapp.service.EmployeeService;

//@ComponentScan(basePackages= {"com.examples.springcore"})
@Configuration
public class EmployeeBeanConfiguration {
	@Lazy
	@Bean
	  public Employee employee() {
	      return new Employee();
	      
	  }    
	@Lazy
	  @Bean
	  public EmployeeService empService() {
	      return new EmployeeService();
	  }
	@Lazy
	  @Bean
	  public EmployeeDB empDao()
	  {
		  return new EmployeeDB();
	  }
}
