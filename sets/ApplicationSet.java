package sets;

import java.util.HashSet;

/**
 * The applications set of recipients.
 *
 * @author Stacy Black
 */
public class ApplicationSet extends RecipientSet {

	public ApplicationSet() {
		set = new HashSet<>();
	}

	public String toString() {
		return "applications";
	}

	/**
	 * For testing.
	 */
	public void eval() {
		System.out.println("Recipient: applications");
		for (Object o : set) {
			System.out.println(o.toString());
		}
	}
}
