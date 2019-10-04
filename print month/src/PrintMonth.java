public class PrintMonth {
    public static void main(String[] args) {
        int year = 2018;
        int month = 1;


        printMonth(year, month);

    }

     /***************
     *end of main start of methods
     ***************/

    public static boolean isLeapYear(int year) {
        return (year % 400 == 0 || (year % 4 == 0 && year % 100 != 0));
    }

    public static int getNumberOfDaysInMonth(int year, int month) {
        switch (month) {
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                return 31;
            case 4:
            case 6:
            case 9:
            case 11:
                return 30;
            case 2:
                if(isLeapYear(year)) {
                    return
                }
        }
    }

    public static int getTotalNumberOfDays(int year, int month) {
        return 10000;
    }

    public static int getStartDay(int year, int month)  {
        return 1;
    }

    public static String getMonthName(int month) {
        switch (month) {
            case 1: return "January";
            case 2: return "Frebruary";
            case 3: return "March";
            case 4: return "April";
            case 5: return "May";
            case 6: return "June";
            case 7: return "July";
            case 8: return "August";
            case 9: return "September";
            case 10: return "October";
            case 11: return "November";
            case 12: return "December";
        }

        return "error";
    }

    public static void printMonthTitle(int year, int month) {
        System.out.printf("        %s  %d\n", getMonthName(month), year);
        System.out.printf("-----------------------------\n");
        System.out.printf(" Sun Mon Tue Wed Thu Fri Sat\n");
    }

    public static void printMonth (int year, int month) {
        printMonthTitle(year, month);
        printMonthBody()
    }



}