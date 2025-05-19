package company;

import company.employee.EmployeeService;
import company.employee.TimeOffService;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.web.service.registry.ImportHttpServices;

@Configuration
@ImportHttpServices(basePackages = "company/person") // default group
@ImportHttpServices(group = "employee", types = { EmployeeService.class, TimeOffService.class })
@ImportHttpServices(group = "company", basePackages = "company/company")
@Import(EmployeeServiceRegistrar.class)
public class ServiceConfig {

	@Bean
	CustomHttpServiceGroupConfigurer customHttpServiceGroupConfigurer() {
		return new CustomHttpServiceGroupConfigurer();
	}

}

