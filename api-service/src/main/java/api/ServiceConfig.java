package api;

import api.employee.EmployeeService;
import api.employee.TimeOffService;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.format.support.FormattingConversionService;
import org.springframework.web.client.support.RestClientHttpServiceGroupConfigurer;
import org.springframework.web.service.registry.ImportHttpServices;

@Configuration
@ImportHttpServices(basePackages = "api/person") // default group
@ImportHttpServices(group = "employee", types = {EmployeeService.class, TimeOffService.class})
@ImportHttpServices(group = "company", basePackages = "api/company")
@Import(EmployeeServiceRegistrar.class)
public class ServiceConfig {

	@Bean
	RestClientHttpServiceGroupConfigurer customHttpServiceGroupConfigurer() {
		return groups ->
				groups.filterByName("company").forEachGroup((_, clientBuilder, factoryBuilder) -> {

					clientBuilder.requestInterceptor((request, body, execution) -> {
								request.getHeaders().add("Custom-Header", "custom-header-value");
								return execution.execute(request, body);
							}
					);

					factoryBuilder.conversionService(new FormattingConversionService());
				});
	}

}

