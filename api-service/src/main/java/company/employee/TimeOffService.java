package company.employee;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.service.annotation.GetExchange;
import org.springframework.web.service.annotation.HttpExchange;

/**
 * @author Olga Maciaszek-Sharma
 */
@HttpExchange("/time-off")
public interface TimeOffService {

	@GetExchange("/{employeeId}")
	double getRemainingTimeOff(@PathVariable long employeeId);
}
