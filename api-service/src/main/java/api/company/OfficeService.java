package api.company;

import java.util.Set;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.service.annotation.GetExchange;
import org.springframework.web.service.annotation.HttpExchange;
import org.springframework.web.service.annotation.PostExchange;

/**
 * @author Olga Maciaszek-Sharma
 */
@HttpExchange("/offices")
public interface OfficeService {

	@GetExchange
	Set<Office> getOffices();

	@PostExchange
	void addOffice(@RequestBody Office office);

}
