import sets.objects.Application;
import sets.objects.Person;
import sets.objects.Service;
import sets.RecipientSet;
import sets.*;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

/**
 * Initializes sets with entries from files.
 *
 * @author Stacy Black
 */
public class InitializeSets {

	/**
	 * Initializes the application set.
	 *
	 * @param applicationSet the application set
	 */
	public static void InitApplications(ApplicationSet applicationSet) {
		PopulateSet("/recipients/services/transportation.txt", applicationSet, "application");
	}

	/**
	 * Initializes the people, colleague, family, and friend sets.
	 *
	 * @param peopleSet the people set
	 * @param colleagueSet the colleague set
	 * @param familySet the family set
	 * @param friendSet the friend set
	 */
	public static void InitPeople(PeopleSet peopleSet, ColleagueSet colleagueSet, FamilySet familySet, FriendSet friendSet) {

		PopulateSet("/recipients/people/colleagues.txt", colleagueSet, "person");
		PopulateSet("/recipients/people/family.txt", familySet, "person");
		PopulateSet("/recipients/people/friends.txt", friendSet, "person");

		peopleSet.addAll(colleagueSet);
		peopleSet.addAll(familySet);
		peopleSet.addAll(friendSet);
	}

	/**
	 * Initializes the service set.
	 *
	 * @param serviceSet the service set
	 */
	public static void InitServices(ServiceSet serviceSet) {
		PopulateSet("/recipients/services/transportation.txt", serviceSet, "service");
	}

	/**
	 * Initializes the recipient, application, people, and service sets.
	 *
	 * @param recipientSet the recipient set
	 * @param applicationSet the application set
	 * @param peopleSet the people set
	 * @param serviceSet the service set
	 */
	public static void InitRecipients(RecipientSet recipientSet, ApplicationSet applicationSet, PeopleSet peopleSet, ServiceSet serviceSet) {
		recipientSet.addAll(applicationSet);
		recipientSet.addAll(peopleSet);
		recipientSet.addAll(serviceSet);
	}

	/**
	 * Populates a given set with the entries from a specified file.
	 *
	 * @param path the file path
	 * @param set the given set to add objects to
	 * @param type the object type
	 */
	private static void PopulateSet(String path, RecipientSet set, String type) {

		// gets text file from within a package
		// https://stackoverflow.com/questions/4361338/
		File file = new File(InitializeSets.class.getResource(path).getFile());

		try {

			Scanner scan = new Scanner(file);

			while(scan.hasNext()){

				String name = scan.nextLine();

				if (type.equals("application")) {
					Application application = new Application(name);
					set.addTo(application);
				} else if (type.equals("person")) {
					String firstName = name.split(" ")[0];
					String lastName = name.split(" ")[1];
					Person person = new Person(firstName, lastName);
					set.addTo(person);
				} else if (type.equals("service")) {
					Service service = new Service(name);
					set.addTo(service);
				}
			}
		} catch (IOException io) {
			System.out.println("file not found!");
		}
	}

	/**
	 * Test for checking if sets are populated. Prints contents of sets to
	 * console.
	 */
	public static void testSets(ApplicationSet applicationSet, PeopleSet peopleSet, ColleagueSet colleagueSet, FamilySet familySet,
								FriendSet friendSet, ServiceSet serviceSet) {
		applicationSet.eval();
		peopleSet.eval();
		colleagueSet.eval();
		familySet.eval();
		friendSet.eval();
		serviceSet.eval();
	}
}
