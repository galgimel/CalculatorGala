public class Boolean {
    public static boolean isArabic(String stringToInt) {
        try {
            Integer.parseInt(stringToInt);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
