import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;

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

  public void displayStudents() {
    System.out.println("Студенты в группе " + groupName + ":");
    for (String student : students) {
      System.out.println(student);
    }
    System.out.println();
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

  public void displayGroups() {
    for (Group group : groups) {
      group.displayStudents();
    }
  }
}

public class Laba4 {
  public static void main(String[] args) {
    var books = new ArrayList<String>();
    books.add("ABC");
    books.add("BAC");
    books.add("AWC");
    Collections.sort(books);
    System.out.println(books);

    List<Integer> list1 = List.of(1, 3, 5, 7, 9);
    List<Integer> list2 = List.of(2, 4, 6, 8, 10);

    List<Integer> mergedList = mergeLists(list1, list2);

    System.out.println("Merged List: " + mergedList);

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

    System.out.println("Положительные числа по возрастанию: " + positiveNumbers);
    System.out.println("Элементы с четными порядковыми номерами: " + evenIndexedNumbers);

    Set<Integer> targetSet1 = new HashSet<>(list1);
    Set<Integer> targetSet2 = new HashSet<>(list2);
    if (targetSet1.equals(targetSet2)) {
      System.out.println("Они совпадают");
    } else {
      System.out.println("Нэ");
    }

    List<String> myList = new ArrayList<>();
    myList.add("java");
    myList.add("python");
    myList.add("javascript");
    myList.add("ruby");

    List<String> result = new ArrayList<>();
    for (int i = 0; i < myList.size(); i++) {
      result.addAll(myList.subList(0, i + 1));
    }

    System.out.println(result);

    String fileName = "./for4laba.txt"; // Укажите путь к вашему текстовому файлу

    LinkedList<Integer> charCountsList = new LinkedList<>();

    try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
      String line;
      while ((line = reader.readLine()) != null) {
        charCountsList.add(line.length());
      }
    } catch (IOException e) {
      System.err.println("Ошибка чтения файла: " + e.getMessage());
    }

    // Выводим количество символов в каждой строке текста
    for (Integer count : charCountsList) {
      System.out.println("Количество символов в строке: " + count);
    }
    // Создание факультета
    Faculty faculty = new Faculty();

    // Создание групп и добавление их в факультет
    Group group1 = new Group("Группа 1");
    Group group2 = new Group("Группа 2");

    faculty.addGroup(group1);
    faculty.addGroup(group2);

    // Добавление студентов в группы
    group1.addStudent("Иванов");
    group1.addStudent("Петров");

    group2.addStudent("Сидоров");
    group2.addStudent("Козлов");

    // Вывод списка студентов в каждой группе
    faculty.displayGroups();
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
