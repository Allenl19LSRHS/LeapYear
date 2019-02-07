import java.util.Scanner;

public class LeapYearMain {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int input;
		boolean run = true;
		
		do {
			try {
				input = scan.nextInt();
			} catch (Exception e) {
				input = 0;
			}
			
			if (input == 0) {
				run = false;
				
			} else if (input == -1) {
				System.out.println("error");
			} else {
				System.out.println(isLeapYear(input));
				System.out.println(daysSinceYear(input));
			}
			
			input = 0;
		} while (run);
		scan.close();
	}
	
	public static String isLeapYear(int year) {
		return (((year % 4) == 0 && !((year % 100) == 0)) || (year % 400) == 0 ? "yes" : "no");
	}
	
	// super simple method to get the days since the inputted year to the current year, not including current date etc
	public static int daysSinceYear(int year) {
		final int NON_LEAP_DAYS = 365;
		final int LEAP_DAYS = 366;
		final int CUR_YEAR = 2018;
		int totalDays = 0;
		
		for (int i = year; i < CUR_YEAR; i++) {
			if (isLeapYear(i) == "yes") {
				totalDays += LEAP_DAYS;
			} else {
				totalDays += NON_LEAP_DAYS;
			}
		}
		
		return totalDays;
	}
}
