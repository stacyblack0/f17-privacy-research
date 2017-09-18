package sets;

import java.util.HashSet;

/**
 * The services set of recipients.
 *
 * @author Stacy Black
 */
public class ServiceSet extends RecipientSet {

	public ServiceSet() {
		set = new HashSet<>();
	}

	public String toString() {
		return "Services";
	}

	/**
	 * For testing.
	 */
	public void eval() {
		System.out.println("Recipient: services");
		for (Object o : set) {
			System.out.println(o.toString());
		}
	}
}
