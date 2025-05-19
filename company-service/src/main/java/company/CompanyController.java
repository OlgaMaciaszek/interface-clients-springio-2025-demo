package company;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.service.annotation.GetExchange;
import org.springframework.web.service.annotation.PostExchange;

/**
 * @author Olga Maciaszek-Sharma
 */
@RestController
@RequestMapping
public class CompanyController {

	private static final Log LOG = LogFactory.getLog(CompanyController.class);

	private final Set<String> departments = Set.of("DESIGN", "IT", "HR", "FINANCE", "LEGAL", "MARKETING", "SALES");
	private final ConcurrentHashMap<UUID, Office> offices = new ConcurrentHashMap<>();

	@GetMapping("/departments")
	Set<String> getDepartments(@RequestHeader("Custom-Header") String customHeader) {
		LOG.info("Custom Header: " + customHeader);
		return departments;
	}

	@GetExchange("/offices")
	Set<Office> getOffices() {
		return new HashSet<>(offices.values());
	}

	@PostExchange("/offices")
	void addOffice(@RequestBody Office office) {
		offices.put(UUID.randomUUID(), office);
	}

	/**
	 * @author Olga Maciaszek-Sharma
	 */
	public static record Office(long id, String name, String location, String phoneNumber, int capacity) {
	}
}
