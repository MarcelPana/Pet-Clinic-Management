package utils;

public class UtilMethods {

    public static String firstLetterToUpperCase(String string) {
        return string.substring(0, 1).toUpperCase() + string.substring(1).toLowerCase();
    }
}
