import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

enum Rome{
    // назначаем римские цифры
    I(1),
    IV(4),
    V(5),
    IX(9),
    X(10),
    XL(40),
    L(50),
   XC(90),
    C(100);

    // добавляем арабское значение к римскому
    private int value;

    Rome(int value) {
        this.value = value;
    }
// возвращаем арабское значение в код
    public int getValue() {
        return value;
    }
// извлекаем арабское значение из римского в порядке убывания
    public static List<Rome> getReverseSortedValues() {
        return Arrays.stream(values())
                .sorted(Comparator.comparing((Rome e) -> e.value).reversed())
                .collect(Collectors.toList());
    }
}
