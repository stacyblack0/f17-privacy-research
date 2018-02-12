/**
 * @author Stacy Black
 */
public class Action {

	String recipientSet;
	String individual;
	String information;

	public Action(String recipientSet, String individual, String information) {
		this.recipientSet = recipientSet;
		this.individual = individual;
		this.information = information;
	}

	public String getRecipientSet() {
		return recipientSet;
	}

	public String getIndividual() {
		return individual;
	}

	public String getInformation() {
		return information;
	}
}
