import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String value;
        while (true) {
            System.out.println("Введите сумму вклада(руб): ");
            value = scanner.next();
            double sum;
            if (check(value))
                sum = Double.valueOf(value);
            else {
                System.out.println("Неверный формат (Пример: 10; 10.2)");
                continue;
            }
            System.out.println("Введите процентную ставку(%): ");
            value = scanner.next();
            double p;
            if (check(value))
                p = Double.valueOf(value);
            else {
                System.out.println("Неверный формат (Пример: 10; 10.2)");
                continue;
            }
            System.out.println("Введите требующуюся кратность: ");
            value = scanner.next();
            double k;
            if (check(value))
                k = Double.valueOf(value);
            else {
                System.out.println("Неверный формат (Пример: 10; 10.2)");
                continue;
            }
            System.out.println("Через " +
                    new DecimalFormat("#.#").format(Math.log(k) / Math.log(1 + p / 100)) +
                    " лет сумма вклада " + sum + " рублей учеличется в " + k + " раз.");
            break;
        }
    }

    private static boolean check(String value) {
        Pattern p = Pattern.compile("(^\\d+$)|(^\\d+[.]+\\d$)");
        Matcher m = p.matcher(value);
        return m.find();
    }
}
