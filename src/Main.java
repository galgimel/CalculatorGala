import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Привет! Чтобы калькулятор работал - вводи выражение через пробел: 5 * 6 ИЛИ V - I");
        System.out.println("Введи выражение: ");
        String input = scanner.nextLine().trim();

        // 1 + 2 -выражение читается через пробел. Используем матрицу.
        String[] data = input.split(" ");

        // только 2 числа + 1 значение выражения- итого 3 символа
        if (data.length != 3) {
            throw new RuntimeException("Ошибка: Неверное количество чисел ИЛИ ты забыл пробел.");
        }

        // считываем строку с данными выражения
        String number1 = data[0];
        String number2 = data[2];
        String action = data[1];

        // решаем выражение, только если оба числа арабские
        boolean isFirstNumberArabic = Boolean.isArabic(number1);
        boolean isSecondNumberArabic = Boolean.isArabic(number2);

        // калькулятор арабских чисел
        if (isFirstNumberArabic && isSecondNumberArabic) {
            // переводим в целочисленное значение
            int a = Integer.parseInt(number1);
            int b = Integer.parseInt(number2);

            // числа от 1 до 10 включительно- если нет, то выбрасываем ошибку
            if (a < 1 || a > 10 || b < 1 || b > 10) {
                throw new RuntimeException("Ошибка: Введеное число больше 10 или меньше 1.");
            }

            // ответ + выброс ошибки на неверное действие

            switch (action) {
                case "+":
                    System.out.println("Ответ: " + (a + b));
                    break;
                case "-":
                    System.out.println("Ответ: " + (a - b));
                    break;
                case "*":
                    System.out.println("Ответ: " + (a * b));
                    break;
                case "/":
                    System.out.println("Ответ: " + (a / b));
                    break;
                default:
                    throw new RuntimeException("Ошибка: Нечитаемое действие.");

            }
            // чтение римских чисел
        } else if (!isFirstNumberArabic && !isSecondNumberArabic) {
            // переводим римское значение в арабское целочисленное значение
            int a = RomeToArab.romanToArabic(number1);
            int b = RomeToArab.romanToArabic(number2);

            // числа от 1 до 10 включительно- если нет, то выбрасываем ошибку
            if (a < 1 || a > 10 || b < 1 || b > 10) {
                throw new RuntimeException("Ошибка: Введеное число больше 10 или меньше 1.");
            }

            // калькулятор римских чисел
            switch (action) {
                case "+":
                    System.out.println("Ответ: " + (ArabToRome.arabicToRoman(a + b)));
                    break;
                case "-":
                    System.out.println("Ответ: " + (ArabToRome.arabicToRoman(a - b)));
                    break;
                case "*":
                    System.out.println("Ответ: " + (ArabToRome.arabicToRoman(a * b)));
                    break;
                case "/":
                    System.out.println("Ответ: " + (ArabToRome.arabicToRoman(a / b)));
                    break;
                default:
                    throw new RuntimeException("Ошибка: Нечитаемое действие.");
            }
        } else {
            // выброс ошибки в ином случае
            throw new RuntimeException("Ошибка: Введевены некоректные данные.");
        }
        System.out.println("Поздравляю, вы прошли игру!");
    }
}