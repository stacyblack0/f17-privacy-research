import java.util.LinkedHashMap;

/**
 * This class contains a set of time span metadata (for example business
 * hours, weekend, night, etc).
 *
 * @author Stacy Black
 */
public class Metadata {

	private LinkedHashMap<String, MetadataItem> set;

	/**
	 * The constructor.
	 */
	public Metadata() {
		set = new LinkedHashMap<>();
	}

	public LinkedHashMap<String, MetadataItem> getSet() {
		return set;
	}

	public void addToSet(MetadataItem item) {
		set.put(item.getName(), item);
	}
}
