package company.person;


import java.util.Set;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.service.annotation.GetExchange;
import org.springframework.web.service.annotation.HttpExchange;
import org.springframework.web.service.annotation.PostExchange;

/**
 * @author Olga Maciaszek-Sharma
 */
@HttpExchange("/persons")
public interface PersonService {

	@GetExchange
	Set<Person> getPersons();

	@PostExchange
	void add(@RequestBody Person person);

}