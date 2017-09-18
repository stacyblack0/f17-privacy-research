package sets.objects;

/**
 * A class for a person with a given first and last name.
 *
 * @author Stacy Black
 */
public class Person {

	private String firstName; // Person's first name
	private String lastName;  // Person's last name

	/**
	 * The constructor, given a first name and a last name.
	 *
	 * @param firstName
	 * @param lastName
	 */
	public Person(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public String toString() {
		return firstName + " " + lastName;
	}

	/**
	 * For testing.
	 */
	public void eval() {
		System.out.println(firstName + " " + lastName);
	}
}
