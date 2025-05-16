package service.employee;

import service.person.Person;

/**
 * @author Olga Maciaszek-Sharma
 */
public class Employee extends Person {

	private long id;

	public Employee(String firstName, String lastName, String email, long id) {
		super(firstName, lastName, email);
		this.id = id;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
}
