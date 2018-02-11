package tree;

/**
 * @author Stacy Black
 */
public class Regex {

	String regexString;
	String interval;
	int frequency;

	public Regex(String regexString) {
		this.regexString = regexString;
		interval = "";
		frequency = 0;
	}

	public Regex(String interval, int frequency) {
		regexString = "";
		this.interval = interval;
		this.frequency = frequency;
	}

	public Regex(String regexString, String interval, int frequency) {
		this.regexString = regexString;
		this.interval = interval;
		this.frequency = frequency;
	}

	public String getRegexString() {
		return regexString;
	}

	public String getInterval() {
		return interval;
	}

	public int getFrequency() {
		return frequency;
	}
}
