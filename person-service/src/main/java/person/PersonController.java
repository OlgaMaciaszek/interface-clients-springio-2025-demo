package person;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
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
public class PersonController {

	private final ConcurrentHashMap<UUID, Person> persons = new ConcurrentHashMap<>();

	@PostMapping("/persons")
	@ResponseStatus(HttpStatus.CREATED)
	public void add(@RequestBody Person person) {
		persons.put(UUID.randomUUID(), person);
	}

	@GetMapping("/persons")
	public Set<Person> getPersons() {
		return new HashSet<>(persons.values());
	}

}
