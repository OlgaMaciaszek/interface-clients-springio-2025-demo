package company;

import java.util.Set;

import company.company.DepartmentService;
import company.company.Office;
import company.company.OfficeService;
import company.employee.BENEFIT;
import company.employee.BenefitsService;
import company.employee.Employee;
import company.employee.EmployeeService;
import company.employee.TimeOffService;
import company.person.Person;
import company.person.PersonService;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.service.annotation.GetExchange;
import org.springframework.web.service.annotation.PostExchange;
import org.springframework.web.service.registry.HttpServiceProxyRegistry;

/**
 * @author Olga Maciaszek-Sharma
 */
@RestController
@RequestMapping
public class ApiController {

	private final PersonService personService;
	private final EmployeeService employeeService;
	private final OfficeService officeService;
	private final DepartmentService departmentService;
	private final BenefitsService benefitsService;
	private final TimeOffService timeOffService;

	public ApiController(
			PersonService personService, EmployeeService employeeService,
			OfficeService officeService, DepartmentService departmentService,
			BenefitsService benefitsService, HttpServiceProxyRegistry registry) {

		this.personService = personService;
		this.employeeService = employeeService;
		this.officeService = officeService;
		this.departmentService = departmentService;
		this.benefitsService = benefitsService;

		// Retrieve the client bean directly from the registry
		this.timeOffService = registry.getClient(TimeOffService.class);
	}

	@PostMapping("/persons")
	@ResponseStatus(HttpStatus.CREATED)
	public void add(@RequestBody Person person) {
		personService.add(person);
	}

	@GetMapping("/persons")
	public Set<Person> getPersons() {
		return personService.getPersons();
	}

	@PostMapping("/employees")
	@ResponseStatus(HttpStatus.CREATED)
	public void add(@RequestBody Employee employee) {
		employeeService.add(employee);
	}

	@GetMapping("/employees/{id}")
	public Employee getEmployee(@PathVariable String id) {
		return employeeService.getEmployeeById(id);
	}

	@GetMapping("/employees")
	public Set<Employee> getEmployees() {
		return employeeService.getEmployees();
	}

	@GetMapping("/benefits")
	Set<BENEFIT> getBenefits() {
		return benefitsService.getBenefits();
	}

	@GetMapping("/time-off/{employeeId}")
	double getRemainingTimeOff(@PathVariable long employeeId) {
		return timeOffService.getRemainingTimeOff(employeeId);
	}

	@GetMapping("/departments")
	Set<String> getDepartments() {
		return departmentService.getDepartments();
	}

	@GetExchange("/offices")
	Set<Office> getOffices() {
		return officeService.getOffices();
	}

	@PostExchange("/offices")
	void addOffice(@RequestBody Office office) {
		officeService.addOffice(office);
	}
}
