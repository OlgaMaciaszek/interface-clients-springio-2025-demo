package api.company;

/**
 * @author Olga Maciaszek-Sharma
 */
public record Office(
		long id,
		String name,
		String location,
		String phoneNumber,
		int capacity
) { }
