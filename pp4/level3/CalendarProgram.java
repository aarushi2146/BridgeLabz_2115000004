
import java.util.Scanner;
public class CalendarProgram {
    public static String getMonthName(int month) {
        String[] months = {
            "January", "February", "March", "April", "May", "June",
            "July", "August", "September", "October", "November", "December"
        };
        return months[month - 1];
    }
    public static int getDaysInMonth(int month, int year) {
        int[] daysInMonth = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        if (month == 2) {
            if (isLeapYear(year)) {
                return 29;
            } else {
                return daysInMonth[month - 1];
            }
        }
        return daysInMonth[month - 1];
    }
    public static boolean isLeapYear(int year) {
        if ((year % 4 == 0 && year % 100 != 0) || (year % 400 == 0)) {
            return true;
        }
        return false;
    }
    public static int getFirstDayOfMonth(int month, int year) {
        int y0 = year - (14 - month) / 12;
        int x = y0 + y0 / 4 - y0 / 100 + y0 / 400;
        int m0 = month + 12 * ((14 - month) / 12) - 2;
        int d0 = (1 + x + 31 * m0 / 12) % 7;
        return d0;
    }
    public static void displayCalendar(int month, int year) {
        String monthName = getMonthName(month);
        int daysInMonth = getDaysInMonth(month, year);
        int firstDayOfMonth = getFirstDayOfMonth(month, year);
        System.out.println("        " + monthName + " " + year);
        System.out.println("Sun Mon Tue Wed Thu Fri Sat");
        int dayOfMonth = 1;
        for (int i = 0; i < firstDayOfMonth; i++) {
            System.out.print("    ");
        }
        for (int i = firstDayOfMonth; dayOfMonth <= daysInMonth; i++) {
            System.out.printf("%3d ", dayOfMonth);
            if (i % 7 == 6) {
                System.out.println();
            }
            dayOfMonth++;
        }
        System.out.println();
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter month (1-12): ");
        int month = scanner.nextInt();
        System.out.print("Enter year: ");
        int year = scanner.nextInt();
        displayCalendar(month, year);
    }
}



