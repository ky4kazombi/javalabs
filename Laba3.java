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

}
