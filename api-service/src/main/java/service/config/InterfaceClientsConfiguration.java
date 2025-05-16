package service.config;

import service.employee.BenefitsService;
import service.employee.EmployeeService;
import service.employee.TimeOffService;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.web.service.registry.AbstractHttpServiceRegistrar;
import org.springframework.web.service.registry.ImportHttpServices;

/**
 * @author Olga Maciaszek-Sharma
 */
@Configuration
// Simple client with group configured and types provided
@ImportHttpServices(group = "employee-service", types = {EmployeeService.class,
		TimeOffService.class})
// Simple client with group configured and base package scan
@ImportHttpServices(group = "company-service", basePackages = "service/company")
// Simple client with a default group and base package scan
@ImportHttpServices(basePackages = "service/person")
// BenefitsService registered in `employee-service` by CustomRegistrar
@Import(InterfaceClientsConfiguration.CustomRegistrar.class)
public class InterfaceClientsConfiguration {

	// A custom RestClientHttpServiceGroupConfigurer
	@Bean
	CustomHttpServiceGroupConfigurer customHttpServiceGroupConfigurer() {
		return new CustomHttpServiceGroupConfigurer();
	}

	static class CustomRegistrar extends AbstractHttpServiceRegistrar {

		@Override
		protected void registerHttpServices(GroupRegistry registry, AnnotationMetadata importingClassMetadata) {
			registry.forGroup("employee-service")
					.register(BenefitsService.class);
		}

	}
}

