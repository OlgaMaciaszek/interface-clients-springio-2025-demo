package api.employee;

import java.util.Set;

import org.springframework.web.service.annotation.GetExchange;
import org.springframework.web.service.annotation.HttpExchange;

/**
 * @author Olga Maciaszek-Sharma
 */
@HttpExchange("/benefits")
public interface BenefitsService {

	@GetExchange
	Set<BENEFIT> getBenefits();

}
