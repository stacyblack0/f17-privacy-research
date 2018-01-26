import java.util.Calendar;

public class Environment {

	// environmental variables
	int time;
	int day;
	Calendar current;

	public Environment() {
		current = Calendar.getInstance();
		time = current.get(Calendar.HOUR_OF_DAY);
		day = current.get(Calendar.DAY_OF_WEEK);
	}

	public int getTime() {
		return time;
	}

	public int getDay() {
		return day;
	}

	public boolean isWeekend() {
		return day > 6 || day < 2;
	}

	public boolean isBusinessHours() {
		return time > 7 && time < 17;
	}

	public boolean isNight() {
		return time > 19 || time < 8;
	}
}
