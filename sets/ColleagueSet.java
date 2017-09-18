package sets;

import java.util.HashSet;

/**
 * The colleagues set of recipients.
 *
 * @author Stacy Black
 */
public class ColleagueSet extends PeopleSet {

	public ColleagueSet() {
		set = new HashSet<>();
	}

	public String toString() {
		return "People > Colleagues";
	}

	/**
	 * For testing.
	 */
	public void eval() {
		System.out.println("Recipient: people > colleagues");
		for (Object o : set) {
			System.out.println(o.toString());
		}
	}
}
