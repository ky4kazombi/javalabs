import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class Main {
    public static void main(String[] args) {
    }
    public static void zadanie1() {
        String input = "abcdefghijklmnopqrstuv18340";
        String pattern = "abcdefghijklmnopqrstuv18340";

        Pattern p = Pattern.compile(pattern);
        Matcher m = p.matcher(input);

        if (m.matches()) {
            System.out.println("Строка соответствует паттерну");
        } else {
            System.out.println("Строка не соответствует паттерну");
        }
    }
    public static void zadanie2() {
        String input = "e02fd0e4-00fd-090A-ca30-0d00a0038ba0";
	String pattern = "\\b[0-9a-fA-F]{8}-[0-9a-fA-F]{4}-[0-9a-fA-F]{4}-[0-9a-fA-F]{4}-[0-9a-fA-F]{12}\\b|\\b\\{[0-9a-fA-F]{8}-[0-9a-fA-F]{4}-[0-9a-fA-F]{4}-[0-9a-fA-F]{4}-[0-9a-fA-F]{12}\\}\\b";

        Pattern p = Pattern.compile(pattern);
        Matcher m = p.matcher(input);

        if (m.matches()) {
            System.out.println("Строка соответствует паттерну");
        } else {
            System.out.println("Строка не соответствует паттерну");
        }
    }
    public static void zadanie3() {
        String input = "aE:dC:cA:56:76:54";
	String pattern = "^([0-9A-Fa-f]{2}[:-]){5}([0-9A-Fa-f]{2})$";

        Pattern p = Pattern.compile(pattern);
        Matcher m = p.matcher(input);

        if (m.matches()) {
            System.out.println("Строка соответствует паттерну");
        } else {
            System.out.println("Строка не соответствует паттерну");
        }
    }
    public static void zadanie4() {
        String input = "http://www.example.com";
	String pattern = "^(https?://)?([a-zA-Z0-9](?:[a-zA-Z0-9-]{0,61}[a-zA-Z0-9])?\\.)+[a-zA-Z]{2,}(?::\\d{2,5})?(?:/[^\\s]*)?(?:\\?[^\\s]*)?(?:#[^\\s]*)?$";

        Pattern p = Pattern.compile(pattern);
        Matcher m = p.matcher(input);

        if (m.matches()) {
            System.out.println("Строка соответствует паттерну");
        } else {
            System.out.println("Строка не соответствует паттерну");
        }
    }
    public static void zadanie5() {
        String input = "#FFFFFF";
	String pattern = "^#([A-Fa-f0-9]{6}|[A-Fa-f0-9]{3})$";

        Pattern p = Pattern.compile(pattern);
        Matcher m = p.matcher(input);

        if (m.matches()) {
            System.out.println("Строка соответствует паттерну");
        } else {
            System.out.println("Строка не соответствует паттерну");
        }
    }
    public static void zadanie6() {
        String input = "30/04/2003";
	String pattern = "^(0[1-9]|[12][0-9]|3[01])/(0[1-9]|1[0-2])/((16|17|18|19|20)\\d{2}|9999)$";

        Pattern p = Pattern.compile(pattern);
        Matcher m = p.matcher(input);

        if (m.matches()) {
            System.out.println("Строка соответствует паттерну");
        } else {
            System.out.println("Строка не соответствует паттерну");
        }
    }
    public static void zadanie7() {
        String input = "user@example.com";
	String pattern = "^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

        Pattern p = Pattern.compile(pattern);
        Matcher m = p.matcher(input);

        if (m.matches()) {
            System.out.println("Строка соответствует паттерну");
        } else {
            System.out.println("Строка не соответствует паттерну");
        }
    }
    public static void zadanie8() {
        String input = "127.0.0.1";
	String pattern = "^((25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)$";

        Pattern p = Pattern.compile(pattern);
        Matcher m = p.matcher(input);

        if (m.matches()) {
            System.out.println("Строка соответствует паттерну");
        } else {
            System.out.println("Строка не соответствует паттерну");
        }
    }
    public static boolean isPasswordSecure(String password) {
        // Проверяем длину пароля (8 символов или более)
        if (password.length() < 8) {
            return false;
        }

        // Проверяем наличие хотя бы одной заглавной буквы, одной маленькой буквы и одной цифры
        Pattern upperCasePattern = Pattern.compile("[A-Z]");
        Pattern lowerCasePattern = Pattern.compile("[a-z]");
        Pattern digitPattern = Pattern.compile("[0-9]");

        Matcher upperCaseMatcher = upperCasePattern.matcher(password);
        Matcher lowerCaseMatcher = lowerCasePattern.matcher(password);
        Matcher digitMatcher = digitPattern.matcher(password);

        return upperCaseMatcher.find() && lowerCaseMatcher.find() && digitMatcher.find();
    }

    public static void zadanie9(String[] args) {
        String password = "SecurePass123";
        if (isPasswordSecure(password)) {
            System.out.println("Пароль надежный.");
        } else {
            System.out.println("Пароль не надежный.");
        }
    }
    public static boolean isSixDigitNumber(String input) {
        // Проверяем, что строка состоит из 6 цифр
        Pattern pattern = Pattern.compile("^[1-9]\\d{5}$");
        Matcher matcher = pattern.matcher(input);

        return matcher.matches();
    }
    public static void zadanie10() {
	String input = "123456"; // Заданная строка
        if (isSixDigitNumber(input)) {
            System.out.println("Строка \"" + input + "\" является шестизначным числом без нулей в старших разрядах.");
        } else {
            System.out.println("Строка \"" + input + "\" не является шестизначным числом без нулей в старших разрядах.");
        }
    }
    public static void zadanie11() {
        String text = "Список цен: 23.78 USD, 1500 RUR, 10.50 EU. Некорректные цены: 22 UDD, 0.002 USD.";

        Pattern pattern = Pattern.compile("\\b(\\d+\\.\\d{2})\\s(USD|RUR|EU)\\b");
        Matcher matcher = pattern.matcher(text);

        while (matcher.find()) {
            String price = matcher.group(1);
            String currency = matcher.group(2);
            System.out.println("Цена: " + price + " " + currency);
        } 
    }	 
    public static void zadanie12() {
        String text = "(3 + 5) - 9 × 4. 2 * 9 - 6 × 5.";

        Pattern pattern = Pattern.compile("\\b\\d+\\s(?!\\+)\\b");
        Matcher matcher = pattern.matcher(text);

        while (matcher.find()) {
            System.out.println("Найдено число без символа '+': " + matcher.group());
        } 
    }
    public static void zadanie13() {
        String text = "(3 + 5) - 9 × 4. ((3 + 5) - 9 × 4.";

        Pattern pattern = Pattern.compile("\\([^()]*\\)");
        Matcher matcher = pattern.matcher(text);

        while (matcher.find()) {
            String expression = matcher.group();
            if (expression.chars().filter(ch -> ch == '(').count() == expression.chars().filter(ch -> ch == ')').count()) {
                System.out.println("Найдено правильное выражение: " + expression);
            }
        } 
    }
    public static void zadanie14() {
        Pattern pattern = Pattern.compile("c+a+b");
        Matcher matcher = pattern.matcher("cccab");
        boolean b = matcher.matches();
        System.out.println(b); 
    }
    public static void zadanie15() {
        System.out.println(test("google.com"));
        System.out.println(test("reference1.ua"));
        System.out.println(test("reference1.org"));
    }

    public static boolean test(String testString) {
        Pattern pattern = Pattern.compile(".+\\.(com|ua|ru|org)");
        Matcher matcher = pattern.matcher(testString);
        return matcher.matches();
    } 
}

