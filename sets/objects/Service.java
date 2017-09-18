package sets.objects;

/**
 * A class for a service with a given name.
 *
 * @author Stacy Black
 */
public class Service {

	private String service; // the name of the service

	public Service(String service) {
		this.service = service;
	}

	public String toString() {
		return service;
	}

	/**
	 * For testing.
	 */
	public void eval() {
		System.out.println(service);
	}
}
