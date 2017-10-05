package sets;

import java.util.HashSet;

/**
 * A class that creates a set of recipients for a rule.
 *
 * @author Stacy Black
 */
public class RecipientSet {

	protected HashSet<Object> set; // the set of recipients

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
	 * Checks if a given recipient name is in the set.
	 *
	 * @param recipient the given recipient name
	 * @return true if the given recipient is in the set, false otherwise
	 */
	public boolean inSet(String recipient) {

		for (Object o : set) {
			if (recipient.equals(o.toString())) {
				return true;
			}
		}

		return false;
	}

	/**
	 * For testing.
	 */
	public void eval() {
		System.out.println("Recipient: ");
	}
}
