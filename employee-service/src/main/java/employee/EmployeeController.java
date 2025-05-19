package employee;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Olga Maciaszek-Sharma
 */
@RestController
@RequestMapping
public class EmployeeController {

	private final ConcurrentHashMap<UUID, Employee> employees = new ConcurrentHashMap<>();
	private final Set<String> departments = Set.of("DESIGN", "IT", "HR", "FINANCE", "LEGAL", "MARKETING", "SALES");

	@PostMapping("/employees")
	@ResponseStatus(HttpStatus.CREATED)
	public void add(@RequestBody Employee employee) {
		employees.put(UUID.randomUUID(), employee);
	}

	@GetMapping("/employees")
	public Set<Employee> getEmployees() {
		return new HashSet<>(employees.values());
	}

	@GetMapping("/employees/{employeeId}")
	Employee getEmployeeById(@PathVariable String employeeId) {
		return employees.values().stream()
				.filter(employee -> employee.getId() == Long.parseLong(employeeId))
				.findAny()
				.orElseThrow(() -> new IllegalArgumentException("No employee found for id" + employeeId));
	}

	@GetMapping("/departments")
	Set<String> getDepartments() {
		return departments;
	}

	@GetMapping("/benefits")
	Set<BENEFIT> getBenefits() {
		return Set.of(BENEFIT.values());
	}

	@GetMapping("/time-off/{employeeId}")
	double getTimeOff(@PathVariable long employeeId) {
		return Math.random();
	}

}
