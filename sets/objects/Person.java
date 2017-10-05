package sets.objects;

/**
 * A class for a person with a given first and last name.
 *
 * @author Stacy Black
 */
public class Person {

	private String firstName; // person's first name
	private String lastName;  // person's last name

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
		System.out.println(toString());
	}
}
