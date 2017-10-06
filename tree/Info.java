package tree;

/**
 * Contains the information for a rule.
 *
 * @author Stacy Black
 */
public class Info {

	private String information; // the information to be shared/not shared

	public Info(String information) {
		this.information = information;
	}

	public String getInformation() {
		return information;
	}

	public String toString() {
		return "Information: " + information;
	}

	/**
	 * For testing.
	 */
	public void eval() {
		System.out.println(toString());
	}
}
