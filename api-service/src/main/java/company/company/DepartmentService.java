package company.company;

import java.util.Set;

import org.springframework.web.service.annotation.GetExchange;
import org.springframework.web.service.annotation.HttpExchange;

/**
 * @author Olga Maciaszek-Sharma
 */
@HttpExchange("/departments")
public interface DepartmentService {

	@GetExchange
	Set<String> getDepartments();
}
