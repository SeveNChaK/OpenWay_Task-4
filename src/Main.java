import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String value;
        double sum, p, k;
        while (true) {

            System.out.println("Enter the deposit amount(RUR): ");
            value = scanner.next();
            if (check(value))
                sum = Double.valueOf(value);
            else {
                System.out.println("Invalid format (Example: 10; 10.2)");
                continue;
            }

            System.out.println("Enter the interest rate(%): ");
            value = scanner.next();
            if (check(value))
                p = Double.valueOf(value);
            else {
                System.out.println("Invalid format (Example: 10; 10.2)");
                continue;
            }

            System.out.println("Enter the required multiplicity: ");
            value = scanner.next();
            if (check(value))
                k = Double.valueOf(value);
            else {
                System.out.println("Invalid format (Example: 10; 10.2)");
                continue;
            }

            System.out.println("The deposit amount will increase " + k + " times in " +
                    new DecimalFormat("#.#").format(Math.log(k) / Math.log(1 + p / 100)) +
                    " years.");
            break;
        }
    }

    private static boolean check(String value) {
        Pattern p = Pattern.compile("(^\\d+$)|(^\\d+[.]+\\d$)");
        Matcher m = p.matcher(value);
        return m.find();
    }
}
