import java.util.List;

public class ArabToRome {
    public static String arabicToRoman(int number) {
        if ((number <= 0) || (number > 100)) {
            throw new IllegalArgumentException(number + " Друг, нет отрицательных римских чисел, попробуй еще.");
        }

        List<Rome> romanNumerals = Rome.getReverseSortedValues();

        int i = 0;
        StringBuilder sb = new StringBuilder();

        while ((number > 0) && (i < romanNumerals.size())) {
                Rome currentSymbol = romanNumerals.get(i);
            if (currentSymbol.getValue() <= number) {
                    sb.append(currentSymbol.name());
                    number -= currentSymbol.getValue();
            } else {
                i++;
            }
        }

        return sb.toString();
    }
}