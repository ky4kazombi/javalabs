import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Laba1_1
 */
public class Laba1_1 {

    public static void main(String[] args) {
        int n = 0;
        
        System.err.println("Введите число строк:");
        Scanner sc1 = new Scanner(System.in);
        try {
            n = sc1.nextInt();
        } catch (InputMismatchException fq) {
            System.err.println("NaN");
        }
        String[] str = new String[n];
        Scanner sc2 = new Scanner(System.in);
        for (int i = 0; i < n; i++) {
            System.err.println("Введите строку " + (i+1)); 
            str[i] = sc2.nextLine();
        } 
        String shortestString = findShortestString(str);
        System.out.println("Самая короткая строка: " + shortestString);
        
    }
    public static String findShortestString(String[] strings) {
        if (strings.length == 0) {
            return null;
        }

        String shortest = strings[0];
        for (int i = 1; i < strings.length; i++) {
            if (strings[i].length() < shortest.length()) {
                shortest = strings[i];
            }
        }
        return shortest;
    }
    public static void increasingStings(String[] strings) {
        for (int i = 0; i < strings.length - 1; i++) {
            for (int j = 0; j < strings.length; j++) {
                if (strings[i].length() > strings[j].length()) {
                    String temp = strings[i];
                    strings[i] = strings[j];
                    strings[j] = temp;
                } 
            } 
        }
        for (int i = 0; i < strings.length; i++) {
            System.err.println(strings[i]);
        }
    }
    public static void printAvgString(String[] strings) {
        int avg = 0;
        for (int i = 0; i < strings.length; i++) {
            avg += strings[i].length();
        }
        avg = avg / strings.length;
        for (int i = 0; i < strings.length; i++) {
            if (strings[i].length() < avg) {
                System.err.println(strings[i] + strings[i].length());
            }
        }
    }
    /**
     * Доделать бы желательно
     */
    public static void zadanie4() {
        Scanner sc = new Scanner(System.in);
        int k = sc.nextInt();
        String text = "alkjglfkjadlkjf";   
        for (int i = 0; i < text.length(); i += k) {
            text[i] = '2'; 
        }

    }
}
