package api;

import api.employee.EmployeeService;
import api.employee.TimeOffService;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.web.service.registry.ImportHttpServices;

@Configuration
@ImportHttpServices(basePackages = "api/person") // default group
@ImportHttpServices(group = "employee", types = { EmployeeService.class, TimeOffService.class })
@ImportHttpServices(group = "api", basePackages = "api/company")
@Import(EmployeeServiceRegistrar.class)
public class ServiceConfig {

	@Bean
	CustomHttpServiceGroupConfigurer customHttpServiceGroupConfigurer() {
		return new CustomHttpServiceGroupConfigurer();
	}

}

