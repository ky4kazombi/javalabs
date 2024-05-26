import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class StringProcessor extends JFrame implements ActionListener {

    private JTextField inputField;
    private JTextArea outputArea;
    private JButton processButton;

    public StringProcessor() {
        super("String Processor");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 300);
        setLayout(new BorderLayout());

        JPanel inputPanel = new JPanel(new FlowLayout());
        inputField = new JTextField(30);
        processButton = new JButton("Process");
        processButton.addActionListener(this);
        inputPanel.add(inputField);
        inputPanel.add(processButton);

        outputArea = new JTextArea();
        outputArea.setEditable(false);

        add(inputPanel, BorderLayout.NORTH);
        add(new JScrollPane(outputArea), BorderLayout.CENTER);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == processButton) {
            String inputText = inputField.getText();
            String[] words = inputText.split("\\s+");
            List<String> lines = new ArrayList<>();
            Collections.addAll(lines, words); // Добавляем слова в список

            outputArea.setText(""); // Очищаем вывод

            // Задача 1: Найти самую короткую и самую длинную строки
            if (lines.size() > 0) {
                String shortestLine = lines.get(0);
                String longestLine = lines.get(0);

                for (String line : lines) {
                    if (line.length() < shortestLine.length()) {
                        shortestLine = line;
                    }
                    if (line.length() > longestLine.length()) {
                        longestLine = line;
                    }
                }
                outputArea.append("Самая короткая строка: " + shortestLine + " (" + shortestLine.length() + " символов)\n");
                outputArea.append("Самая длинная строка: " + longestLine + " (" + longestLine.length() + " символов)\n\n");
            }

            // Задача 2: Упорядочить строки по длине
            if (lines.size() > 0) {
                List<String> sortedLinesAscending = new ArrayList<>(lines);
                Collections.sort(sortedLinesAscending, Comparator.comparingInt(String::length));
                outputArea.append("Строки в порядке возрастания длины:\n");
                for (String line : sortedLinesAscending) {
                    outputArea.append(line + "\n");
                }

                List<String> sortedLinesDescending = new ArrayList<>(lines);
                Collections.sort(sortedLinesDescending, Comparator.comparingInt(String::length).reversed());
                outputArea.append("\nСтроки в порядке убывания длины:\n");
                for (String line : sortedLinesDescending) {
                    outputArea.append(line + "\n");
                }
                outputArea.append("\n");
            }

            // Задача 3: Вывести строки, длина которых меньше (больше) средней
            if (lines.size() > 0) {
                int totalLength = 0;
                for (String line : lines) {
                    totalLength += line.length();
                }
                double averageLength = (double) totalLength / lines.size();

                outputArea.append("Средняя длина строки: " + averageLength + "\n");
                outputArea.append("Строки короче средней длины:\n");
                for (String line : lines) {
                    if (line.length() < averageLength) {
                        outputArea.append(line + " (" + line.length() + " символов)\n");
                    }
                }

                outputArea.append("\nСтроки длиннее средней длины:\n");
                for (String line : lines) {
                    if (line.length() > averageLength) {
                        outputArea.append(line + " (" + line.length() + " символов)\n");
                    }
                }
                outputArea.append("\n");
            }

            // Задача 4: Найти слово с минимальным числом различных символов
            if (lines.size() > 0) {
                String minUniqueCharsWord = lines.get(0);
                int minUniqueCharsCount = countUniqueChars(minUniqueCharsWord);

                for (String word : lines) {
                    int currentUniqueCharsCount = countUniqueChars(word);
                    if (currentUniqueCharsCount < minUniqueCharsCount) {
                        minUniqueCharsWord = word;
                        minUniqueCharsCount = currentUniqueCharsCount;
                    }
                }
                outputArea.append("Слово с минимальным числом различных символов: " + minUniqueCharsWord + " (" + minUniqueCharsCount + " символов)\n\n");
            }

            // Задача 5: Найти количество слов, содержащих только символы латинского алфавита,
            // а среди них – количество слов с равным числом гласных и согласных букв
            if (lines.size() > 0) {
                int latinWordsCount = 0;
                int equalVowelConsonantCount = 0;

                for (String word : lines) {
                    if (isLatinWord(word)) {
                        latinWordsCount++;
                        if (isVowelConsonantEqual(word)) {
                            equalVowelConsonantCount++;
                        }
                    }
                }

                outputArea.append("Количество слов, содержащих только символы латинского алфавита: " + latinWordsCount + "\n");
                outputArea.append("Количество слов с равным числом гласных и согласных: " + equalVowelConsonantCount + "\n\n");
            }

            // Задача 6: Найти слово, символы в котором идут в строгом порядке возрастания их кодов
            if (lines.size() > 0) {
                String ascendingCharsWord = null;

                for (String word : lines) {
                    if (isCharsAscending(word)) {
                        ascendingCharsWord = word;
                        break;
                    }
                }

                if (ascendingCharsWord != null) {
                    outputArea.append("Слово, символы в котором идут в строгом порядке возрастания их кодов: " + ascendingCharsWord + "\n\n");
                } else {
                    outputArea.append("Таких слов нет.\n\n");
                }
            }

            // Задача 7: Найти слово, состоящее только из различных символов
            if (lines.size() > 0) {
                String uniqueCharsWord = null;

                for (String word : lines) {
                    if (isUniqueChars(word)) {
                        uniqueCharsWord = word;
                        break;
                    }
                }

                if (uniqueCharsWord != null) {
                    outputArea.append("Слово, состоящее только из различных символов: " + uniqueCharsWord + "\n\n");
                } else {
                    outputArea.append("Таких слов нет.\n\n");
                }
            }

            // Задача 8: Найти слово-палиндром среди слов, состоящих только из цифр
            if (lines.size() > 0) {
                List<String> digitWords = new ArrayList<>();

                for (String word : lines) {
                    if (isDigitWord(word)) {
                        digitWords.add(word);
                    }
                }

                if (digitWords.isEmpty()) {
                    outputArea.append("Слов, состоящих только из цифр, нет.\n\n");
                } else {
                    int palindromeCount = 0;
                    String palindromeWord = null;

                    for (String word : digitWords) {
                        if (isPalindrome(word)) {
                            palindromeCount++;
                            palindromeWord = word;
                        }
                    }

                    if (palindromeCount >= 2) {
                        outputArea.append("Второе слово-палиндром среди слов, состоящих только из цифр: " + palindromeWord + "\n\n");
                    } else if (palindromeCount == 1) {
                        outputArea.append("Слово-палиндром среди слов, состоящих только из цифр: " + palindromeWord + "\n\n");
                    } else {
                        outputArea.append("Слов-палиндромов среди слов, состоящих только из цифр, нет.\n\n");
                    }
                }
            }
        }
    }

    private static int countUniqueChars(String word) {
        return (int) word.chars().distinct().count();
    }

    private static boolean isLatinWord(String word) {
        for (char c : word.toCharArray()) {
            if (!Character.isLetter(c)) {
                return false;
            }
        }
        return true;
    }

    private static boolean isVowelConsonantEqual(String word) {
        int vowelCount = 0;
        int consonantCount = 0;

        for (char c : word.toLowerCase().toCharArray()) {
            if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' || c == 'y') {
                vowelCount++;
            } else if (Character.isLetter(c)) {
                consonantCount++;
            }
        }
        return vowelCount == consonantCount;
    }

    private static boolean isCharsAscending(String word) {
        for (int i = 1; i < word.length(); i++) {
            if (word.charAt(i) <= word.charAt(i - 1)) {
                return false;
            }
        }
        return true;
    }

    private static boolean isUniqueChars(String word) {
        return word.chars().distinct().count() == word.length();
    }

    private static boolean isDigitWord(String word) {
        for (char c : word.toCharArray()) {
            if (!Character.isDigit(c)) {
                return false;
            }
        }
        return true;
    }

    private static boolean isPalindrome(String word) {
        return new StringBuilder(word).reverse().toString().equals(word);
    }

    public static void main(String[] args) {
        new StringProcessor();
    }
}