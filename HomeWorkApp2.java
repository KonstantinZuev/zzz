/**
*Java 1. Home work #2
*
*@author Zuev Konstantin
*@version 19.02.2022
*/
class HomeWorkApp2 {

    public static void main(String[] args) {
        System.out.println(isBetween10And20(10,-2));
        System.out.println(isBetween10And20(12,5));
        System.out.println(isBetween10And20(20,1));

        printPositiveOrNegative(-1);
        printPositiveOrNegative(0);
        printPositiveOrNegative(1);

        System.out.println(isNegative(-1));
        System.out.println(isNegative(0));
        System.out.println(isNegative(1));

        repeatString("Hello, Java!", 3);

        System.out.println(isYearLeap(1904));
        System.out.println(isYearLeap(1900));
        System.out.println(isYearLeap(2000));
        System.out.println(isYearLeap(2005));
    }

    static boolean isBetween10And20(int a, int b) {
        return a + b >= 10 && a + b <=20;
    }

    static void printPositiveOrNegative(int a) {
        System.out.println(a >= 0? "Positive" : "Negative");
    }

    static boolean isNegative(int a) {
        return a < 0;
    }

    static void repeatString( String s, int count) {
        for (int i = 0; i < count; i++) {
        System.out.println(s);
        }
    }
    static boolean isYearLeap(int year) {
        return (year % 4 == 0 && year % 100 !=0) || year % 400 == 0;
        }
    }