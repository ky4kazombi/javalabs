import java.util.*;

public class Laba3 {
  public static void main(String[] args) {
    if (args.length == 0) {
      System.out.println("Не введенны аргументы");
    }
  }

  public static void zadanie1(String[] args) {
    String shortestString = "";
    String longestString = "";
    int shortestLenght = Integer.MAX_VALUE;
    int longestLenght = 0;

    for (int i = 0; i < args.length; i++) {
      if (args[i].length() < shortestLength) {
        shortestString = args[i];
        shortestLength = args[i].length();
      }
      if (args[i].length() > longestLength) {
        longestString = args[i];
        longestLength = args[i].length();
      }
    }

    System.out.println("Самая короткая строка: " + shortestString + ", ее длина: " + shortestLength);
    System.out.println("Самая длинная строка: " + longestString + ", ее длина: " + longestLength);
  }

  public static void zadanie2(String args[]) {
    Collections.sort(args, Comparator.comparing(String::length));

    // Вывод строк в порядке возрастания длины
    System.out.println("Строки в порядке возрастания длины:");
    for (String str : args) {
      System.out.println(str);
    }

    // Сортировка строк по убыванию длины
    Collections.sort(args, Comparator.comparing(String::length).reversed());

    // Вывод строк в порядке убывания длины
    System.out.println("Строки в порядке убывания длины:");
    for (String str : args) {
      System.out.println(str);
    }
  }

  public static void zadanie3(String[] args) {
    String minUniqueCharsWord = null;
    int minUniqueChars = Integer.MAX_VALUE;

    for (String word : args) {
      Set<Character> uniqueChars = new HashSet<>();
      for (char c : word.toCharArray()) {
        uniqueChars.add(c);
      }

      if (uniqueChars.size() < minUniqueChars) {
        minUniqueChars = uniqueChars.size();
        minUniqueCharsWord = word;
      }
    }

    System.out.println("Слово с минимальным числом различных символов: " + minUniqueCharsWord);
  }

  public static void zadanie4(String[] args) {
    int latingWordsCount = 0;
    int equalVowelsAndConsonants = 0;

    for (String word : args) {
      if (isLatinWord(word)) {
        latingWordsCount++;
        if (hasEqualVowelsAndConsonants(word)) {
          equalVowelsAndConsonants++;
        }
      }
    }
    System.out.println("Количество слов, содержащих только символы латинского алфавита: " + latinWordsCount);
    System.out.println("Количество таких слов с равным числом гласных и согласных букв: " + equalVowelsConsonantsCount);
  }

  public static boolean isLatinWord(String word) {
    return word.matches("[a-zA-Z]+");
  }

  public static boolean hasEqualVowelsAndConsonants(String word) {
    int vowels = 0;
    int consonants = 0;

    for (char c : word.toCharArray()) {
      if ("aeiouAEIOU".indexOf(c) != -1) {
        vowels++;
      } else if (Character.isLetter(c)) {
        consonants++;
      }
    }
    return vowels == consonants;
  }

  public static void zadanie5(String[] args) {
    String firstWordWithIncreasingCodes = null;

    for (String word : args) {
      if (hasIncreasingCodes(word)
          && (firstWordWithIncreasingCodes == null || word.compareTo(firstWordWithIncreasingCodes) < 0)) {
        firstWordWithIncreasingCodes = word;
      }
    }

    if (firstWordWithIncreasingCodes != null) {
      System.out
          .println("Первое слово с символами, идущими в порядке возрастания их кодов: " + firstWordWithIncreasingCodes);
    } else {
      System.out.println("Слово с символами, идущими в порядке возрастания их кодов, не найдено.");
    }
  }

  public static boolean hasIncreasingCodes(String word) {
    for (int i = 1; i < word.length(); i++) {
      if (word.charAt(i) <= word.charAt(i - 1)) {
        return false;
      }
    }
    return true;
  }

  public static void zadanie6(String[] args) {
    String firstWordWithUniqueCharacters = null;

    for (String word : args) {
      if (hasUniqueCharacters(word)
          && (firstWordWithUniqueCharacters == null || word.compareTo(firstWordWithUniqueCharacters) < 0)) {
        firstWordWithUniqueCharacters = word;
      }
    }

    if (firstWordWithUniqueCharacters != null) {
      System.out.println("Первое слово, состоящее только из различных символов: " + firstWordWithUniqueCharacters);
    } else {
      System.out.println("Слово, состоящее только из различных символов, не найдено.");
    }
  }

  public static boolean hasUniqueCharacters(String word) {
    for (int i = 0; i < word.length(); i++) {
      for (int j = i + 1; j < word.length(); j++) {
        if (word.charAt(i) == word.charAt(j)) {
          return false;
        }
      }
    }
    return true;
  }

  public static void zadanie7(String[] args) {
    String secondNumericPalindrome = null;
    int countNumericPalindromes = 0;

    for (String word : args) {
      if (isNumericPalindrome(word)) {
        countNumericPalindromes++;
        if (countNumericPalindromes == 2) {
          secondNumericPalindrome = word;
          break;
        }
      }
    }

    if (secondNumericPalindrome != null) {
      System.out.println("Второе слово-палиндром, состоящее только из цифр: " + secondNumericPalindrome);
    } else {
      System.out.println("Второе слово-палиндром, состоящее только из цифр, не найдено.");
    }
  }

  public static boolean isNumericPalindrome(String word) {
    // Проверяем, что слово состоит только из цифр
    if (!word.matches("[0-9]+")) {
      return false;
    }

    // Проверяем, является ли слово палиндромом
    int i = 0;
    int j = word.length() - 1;
    while (i < j) {
      if (word.charAt(i) != word.charAt(j)) {
        return false;
      }
      i++;
      j--;
    }
    return true;
  }

  // Part zadan
  public static void zadanie21(String str) {
    char lastchr = str.charAt(str.length());
    System.out.println(lastchr);
    if (str.endsWith("!!!")) {
      System.out.println("yes 1");
    }
    if (str.startsWith("I like")) {
      System.out.println("yes 2");
    }
    if (str.contains("Java")) {
      System.out.println("yes 3");
    }
    String str1 = "I like Java!!!";
    String subStr = "Java";

    // Преобразуем строку и подстроку к нижнему регистру для поиска без учета
    // регистра
    String lowerCaseStr = str1.toLowerCase();
    String lowerCaseSubStr = subStr.toLowerCase();

    // Находим позицию подстроки в строке (или -1, если подстрока не найдена)
    int position = lowerCaseStr.indexOf(lowerCaseSubStr);

    if (position != -1) {
      System.out.println("Подстрока \"" + subStr + "\" найдена на позиции " + position);
    } else {
      System.out.println("Подстрока \"" + subStr + "\" не найдена в строке");
    }
    String lowestr = str.toLowerCase();
    String upperstr = str.toUpperCase();
    System.out.println(lowestr);
    System.out.println(upperstr);

  }

  public static void zadanie22() {
    int num1 = 3;
    int num2 = 56;

    // Составляем строки с вычислениями
    StringBuilder sb = new StringBuilder();
    sb.append(num1).append(" + ").append(num2).append(" = ").append(num1 + num2);
    System.out.println(sb);

    sb = new StringBuilder();
    sb.append(num1).append(" - ").append(num2).append(" = ").append(num1 - num2);
    System.out.println(sb);

    sb = new StringBuilder();
    sb.append(num1).append(" * ").append(num2).append(" = ").append(num1 * num2);
    System.out.println(sb);

    // Заменяем символ "=" на слово "равно" с использованием методов insert() и
    // deleteCharAt()
    sb = new StringBuilder();
    sb.append(num1).append(" + ").append(num2).append(" = ").append(num1 + num2);
    int index = sb.indexOf("=");
    sb.insert(index, "равно").deleteCharAt(index + 5);
    System.out.println(sb);

    // Заменяем символ "=" на слово "равно" с использованием метода replace()
    sb = new StringBuilder();
    sb.append(num1).append(" - ").append(num2).append(" = ").append(num1 - num2);
    sb.replace(sb.indexOf("="), sb.indexOf("=") + 1, "равно");
    System.out.println(sb);
  }

  public static void zadanie23() {
    String input = "Object-oriented programming is a programming language model organized around objects rather than \"actions\" and data rather than logic. Object-oriented programming blabla. Object-oriented programming bla.";
    String output = replaceEverySecondOccurrence(input);
    System.out.println(output);
  }

  public static String replaceEverySecondOccurrence(String input) {
    String target = "object-oriented programming";
    String replacement = "OOP";

    int index = -1;
    int count = 0;
    while ((index = input.toLowerCase().indexOf(target, index + 1)) != -1) {
      count++;
      if (count % 2 == 0) {
        input = input.substring(0, index) + replacement + input.substring(index + target.length());
      }
    }

    return input;
  }

  public static void zadanie24() {
    System.out.println(getMiddleChars("string")); // Output: ri
    System.out.println(getMiddleChars("code")); // Output: od
    System.out.println(getMiddleChars("Practice")); // Output: ct
  }

  public static String getMiddleChars(String str) {
    int length = str.length();
    int middle = length / 2;
    return str.substring(middle - 1, middle + 1);
  }

  public static void zadanie25() {
    formatAndPrint("Иванов", 5, "Математика");
    formatAndPrint("Петров", 4, "Физика");
  }

  public static void formatAndPrint(String surname, int grade, String subject) {
    String formattedString = String.format("Студент %-15s получил %3d по %-10s.", surname, grade, subject);
    System.out.println(formattedString);
  }

  public static void zadanie26() {
    String input = "Versions: Java 5, Java 6, Java 7, Java 8, Java 12.";
    findAllAndPrintMatches(input);
  }

  public static void findAllAndPrintMatches(String input) {
    Pattern pattern = Pattern.compile("Java \\d+");
    Matcher matcher = pattern.matcher(input);

    while (matcher.find()) {
      System.out.println(matcher.group());
    }
  }

  public static void zadanie27() {
    String input = "fffff ab f 1234 jkjk";
    String minUniqueWord = findWordWithMinUniqueChars(input);
    System.out.println("Слово с минимальным количеством различных символов: " + minUniqueWord);
  }

  public static String findWordWithMinUniqueChars(String input) {
    String[] words = input.split("\\s+"); // Разбиваем строку на слова
    String minUniqueWord = null;
    int minUniqueChars = Integer.MAX_VALUE;

    for (String word : words) {
      int uniqueChars = countUniqueChars(word);
      if (uniqueChars < minUniqueChars) {
        minUniqueChars = uniqueChars;
        minUniqueWord = word;
      }
    }

    return minUniqueWord;
  }

  public static int countUniqueChars(String word) {
    int uniqueChars = 0;
    boolean[] visited = new boolean[256]; // Массив для отслеживания посещенных символов

    for (char c : word.toCharArray()) {
      if (!visited[c]) {
        visited[c] = true;
        uniqueChars++;
      }
    }

    return uniqueChars;
  }

  public static void zadanie28() {
    String sentence = "One two three раз два три one1 two2 123";
    int countLatinWords = countLatinWords(sentence);
    System.out.println("Количество слов, содержащих только символы латинского алфавита: " + countLatinWords);
  }

  public static int countLatinWords(String sentence) {
    String[] words = sentence.split("\\s+");
    int count = 0;

    for (String word : words) {
      if (word.matches("[a-zA-Z]+")) {
        count++;
      }
    }

    return count;
  }

  public static void zadanie29() {
    String sentence = "Если есть хвосты по дз, начните с 1 не сданного задания. 123 324 111 4554";
    String palindromeWord = findPalindromeWord(sentence);
    if (palindromeWord != null) {
      System.out.println("Найденное слово-палиндром: " + palindromeWord);
    } else {
      System.out.println("Среди слов, состоящих только из цифр, нет палиндромов.");
    }
  }

  public static String findPalindromeWord(String sentence) {
    String[] words = sentence.split("\\s+");

    for (String word : words) {
      if (word.matches("\\d+")) { // Проверка, что слово состоит только из цифр
        if (isPalindrome(word)) {
          return word;
        }
      }
    }

    return null;
  }

  public static boolean isPalindrome(String word) {
    int left = 0;
    int right = word.length() - 1;

    while (left < right) {
      if (word.charAt(left) != word.charAt(right)) {
        return false;
      }
      left++;
      right--;
    }

    return true;
  }
}
