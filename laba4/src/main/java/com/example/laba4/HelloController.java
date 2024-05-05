package com.example.laba4;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class HelloController {
    @FXML
    private Label label1;
    @FXML
    private Label label2;

    @FXML
    protected void onHelloButtonClick() {
        zadanie1();
    }
    @FXML
    protected void onHelloButtonClick2() {
        zadanie2();
    }
    @FXML
    protected void onHelloButtonClick3() {
        zadanie3();
    }
    @FXML
    protected void onHelloButtonClick4() {
        zadanie4();
    }
    @FXML
    protected void onHelloButtonClick5() {
        zadanie5();
    }
    @FXML
    protected void onHelloButtonClick6() {
        zadanie6();
    }
    @FXML
    protected void onHelloButtonClick7() {
        zadanie7();
    }


    public void zadanie1() {
        label1.setText("");
        label2.setText("");

        var books = new ArrayList<String>();
        books.add("ABC");
        books.add("BAC");
        books.add("AWC");
        Collections.sort(books);
        label1.setText(String.valueOf(books));
    }
    public void zadanie2() {
        label1.setText("");
        label2.setText("");

        List<Integer> list1 = List.of(1, 3, 5, 7, 9);
        List<Integer> list2 = List.of(2, 4, 6, 8, 10);

        List<Integer> mergedList = mergeLists(list1, list2);

        label1.setText("Merged List: " + mergedList);
    }
    public void zadanie3() {
        label1.setText("");
        label2.setText("");

        List<Integer> list3 = List.of(1, -23, 12321, 44, 6);
        List<Integer> positiveNumbers = new ArrayList<>();
        List<Integer> evenIndexedNumbers = new ArrayList<>();

        for (int i = 0; i < list3.size(); i++) {
            if (list3.get(i) > 0) {
                positiveNumbers.add(list3.get(i));
            }
            if (i % 2 == 0) {
                evenIndexedNumbers.add(list3.get(i));
            }
        }
        Collections.sort(positiveNumbers);
        Collections.sort(evenIndexedNumbers);

        label1.setText("Положительные числа по возрастанию: " + positiveNumbers);
        label2.setText("Элементы с четными порядковыми номерами: " + evenIndexedNumbers);
    }
    public void zadanie4() {
        label1.setText("");
        label2.setText("");

        List<Integer> list1 = List.of(1, 3, 5, 7, 9);
        List<Integer> list2 = List.of(2, 4, 6, 8, 10);
        Set<Integer> targetSet1 = new HashSet<>(list1);
        Set<Integer> targetSet2 = new HashSet<>(list2);
        if (targetSet1.equals(targetSet2)) {
            label1.setText("Они совпадают");
        } else {
            label1.setText("Нэ");
        }
    }
    public void zadanie5() {
        label1.setText("");
        label2.setText("");

        List<String> myList = new ArrayList<>();
        myList.add("java");
        myList.add("python");
        myList.add("javascript");
        myList.add("ruby");

        List<String> result = new ArrayList<>();
        for (int i = 0; i < myList.size(); i++) {
            result.addAll(myList.subList(0, i + 1));
        }

        label1.setText(String.valueOf(result));
    }
    public void zadanie6() {
        label1.setText("");
        label2.setText("");
    String fileName = "./for4laba.txt"; // Укажите путь к вашему текстовому файлу

    LinkedList<Integer> charCountsList = new LinkedList<>();

    try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
        String line;
        while ((line = reader.readLine()) != null) {
            charCountsList.add(line.length());
        }
    } catch (IOException e) {
        label2.setText("Ошибка чтения файла: " + e.getMessage());
    }

    // Выводим количество символов в каждой строке текста
    for (Integer count : charCountsList) {
       label1.setText("Количество символов в строке: " + count);
    }
    }
    public void zadanie7() {
        label1.setText("");
        label2.setText("");
        Faculty faculty = new Faculty();
        Group group1 = new Group("Группа 1");
        Group group2 = new Group("Группа 2");

        faculty.addGroup(group1);
        faculty.addGroup(group2);

        // Добавление студентов в группы
        group1.addStudent("Иванов");
        group1.addStudent("Петров");

        group2.addStudent("Сидоров");
        group2.addStudent("Козлов");


    }


    public static List<Integer> mergeLists(List<Integer> list1, List<Integer> list2) {
        List<Integer> mergedList = new ArrayList<>();
        int i = 0, j = 0;

        while (i < list1.size() && j < list2.size()) {
            if (list1.get(i) < list2.get(j)) {
                mergedList.add(list1.get(i));
                i++;
            } else {
                mergedList.add(list2.get(j));
                j++;
            }
        }

        while (i < list1.size()) {
            mergedList.add(list1.get(i));
            i++;
        }

        while (j < list2.size()) {
            mergedList.add(list2.get(j));
            j++;
        }

        return mergedList;
    }
}

class Group {
    String groupName;
    LinkedList<String> students;

    public Group(String groupName) {
        this.groupName = groupName;
        this.students = new LinkedList<>();
    }

    public void addStudent(String lastName) {
        students.add(lastName);
    }


}

class Faculty {
    LinkedList<Group> groups;

    public Faculty() {
        this.groups = new LinkedList<>();
    }

    public void addGroup(Group group) {
        groups.add(group);
    }
}
