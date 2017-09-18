package sets;

import java.util.HashSet;

/**
 * The people set of recipients.
 *
 * @author Stacy Black
 */
public class PeopleSet extends RecipientSet {

	public PeopleSet() {
		set = new HashSet<>();
	}

	public String toString() {
		return "People";
	}

	/**
	 * For testing.
	 */
	public void eval() {
		System.out.println("Recipient: people");
		for (Object o : set) {
			System.out.println(o.toString());
		}
	}
}
