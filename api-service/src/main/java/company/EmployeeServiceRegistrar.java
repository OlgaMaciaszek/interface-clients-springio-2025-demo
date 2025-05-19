package company;

import company.employee.BenefitsService;

import org.springframework.core.type.AnnotationMetadata;
import org.springframework.web.service.registry.AbstractHttpServiceRegistrar;

class EmployeeServiceRegistrar extends AbstractHttpServiceRegistrar {

	// Programmatic registration of HTTP services

	@Override
	protected void registerHttpServices(GroupRegistry registry, AnnotationMetadata metadata) {
		registry.forGroup("employee").register(BenefitsService.class);
	}

}
