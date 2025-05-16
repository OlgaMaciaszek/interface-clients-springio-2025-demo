package service.employee;

import java.util.Set;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.service.annotation.GetExchange;
import org.springframework.web.service.annotation.HttpExchange;
import org.springframework.web.service.annotation.PostExchange;

/**
 * @author Olga Maciaszek-Sharma
 */
@HttpExchange("/employees")
public interface EmployeeService {

	@PostExchange
	void add(@RequestBody Employee employee);

	@GetExchange
	Set<Employee> getEmployees();

	@GetExchange("/{employeeId}")
	Employee getEmployeeById(@PathVariable String employeeId);
}
