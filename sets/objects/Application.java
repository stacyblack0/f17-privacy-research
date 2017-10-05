package sets.objects;

/**
 * A class for an application with a given name.
 *
 * @author Stacy Black
 */
public class Application {

	private String application; // the name of the application

	/**
	 * The constructor.
	 *
	 * @param application the name of the application.
	 */
	public Application(String application) {
		this.application = application;
	}

	public String toString() {
		return application;
	}

	/**
	 * For testing.
	 */
	public void eval() {
		System.out.println(toString());
	}
}
