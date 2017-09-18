package sets;

import java.util.HashSet;

/**
 * A class that creates a set of recipients for a rule.
 *
 * @author Stacy Black
 */
public class RecipientSet {

	protected HashSet<Object> set; // The set of recipients

	public RecipientSet() {
		set = new HashSet<>();
	}

	public HashSet<Object> getSet() {
		return set;
	}

	/**
	 * Adds a recipient to the set of recipients.
	 *
	 * @param o the recipient
	 */
	public void addTo(Object o) {
		set.add(o);
	}

	/**
	 * Adds all objects from given set to the current set.
	 *
	 * @param recipientSet the given set
	 */
	public void addAll(RecipientSet recipientSet) {
		set.addAll(recipientSet.getSet());
	}

	/**
	 * For testing.
	 */
	public void eval() {
		System.out.println("Recipient: ");
	}
}
