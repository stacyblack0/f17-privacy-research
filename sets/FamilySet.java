package sets;

import java.util.HashSet;

/**
 * The family set of recipients.
 *
 * @author Stacy Black
 */
public class FamilySet extends PeopleSet {

	public FamilySet() {
		set = new HashSet<>();
	}

	public String toString() {
		return "People > Family";
	}

	/**
	 * For testing.
	 */
	public void eval() {
		System.out.println("Recipient: people > family");
		for (Object o : set) {
			System.out.println(o.toString());
		}
	}
}
