package sets;

import java.util.HashSet;

/**
 * The friends set of recipients.
 *
 * @author Stacy Black
 */
public class FriendSet extends PeopleSet {

	public FriendSet() {
		set = new HashSet<>();
	}

	public String toString() {
		return "People > Friends";
	}

	/**
	 * For testing.
	 */
	public void eval() {
		System.out.println("Recipient: people > friends");
		for (Object o : set) {
			System.out.println(o.toString());
		}
	}
}
