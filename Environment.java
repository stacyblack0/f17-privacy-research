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

	/**
	 * Given a number of time variables, adjust the current time to match any
	 * supplied variables that do not equal to -1.
	 *
	 * @param year the year
	 * @param month the month
	 * @param day the day of the week (1 - 7)
	 * @param hour the hour in military time
	 * @param minute the minute
	 */
	public Environment(int year, int month, int day, int hour, int minute) {

		current = Calendar.getInstance();

		if (year != -1) {
			current.set(Calendar.YEAR, year);
		}
		if (month != -1) {
			current.set(Calendar.MONTH, month);
		}
		if (day != -1) {
			current.set(Calendar.DAY_OF_WEEK, day);
		}
		if (hour != -1) {
			current.set(Calendar.HOUR_OF_DAY, hour);
		}
		if (minute != -1) {
			current.set(Calendar.MINUTE, minute);
		}

		this.day = day;
		time = hour;
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
