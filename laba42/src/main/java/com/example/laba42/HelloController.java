package com.example.laba42;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

import java.util.*;


class Student {
    String lastName;
    String firstName;
    String middleName;
    int birthYear;
    int course;
    String groupNumber;
    int[] grades;

    public Student(String lastName, String firstName, String middleName, int birthYear, int course, String groupNumber,
                   int[] grades) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.middleName = middleName;
        this.birthYear = birthYear;
        this.course = course;
        this.groupNumber = groupNumber;
        this.grades = grades;
    }

    public double getAverageGrade() {
        int sum = 0;
        for (int grade : grades) {
            sum += grade;
        }
        return (double) sum / grades.length;
    }

    public int getCourse() {
        return this.course;
    }
}




public class HelloController {
    @FXML
    private Label welcomeText;
    @FXML
    private Label welcomeText1;

    @FXML
    private Label welcomeText11;
    @FXML
    private Label welcomeText12;
    @FXML
    private Label welcomeText121;

    @FXML
    protected void onHelloButtonClick() {
        List<Student> students = new ArrayList<>();
        students.add(new Student("Иванов", "Иван", "Иванович", 1998, 3, "ГР-301", new int[] { 4, 5, 4, 3, 5 }));
        students.add(new Student("Петров", "Петр",
                "Петрович", 1999, 2, "ГР-201", new int[] { 5, 5, 4, 4, 5 }));
        students.add(new Student("Сидоров", "Сидор", "Сидорович", 1997, 3, "ГР-302", new int[] { 3, 4,
                4, 4, 5 }));
        students.add(new Student("Андреев", "Андрей", "Андреевич", 1998,
                2, "ГР-202", new int[] { 4, 3, 5, 4, 5 }));
        students.sort(Comparator.comparing(Student::getCourse).thenComparing(s -> s.lastName));
        welcomeText.setText(students.toString());

        Map<String, double[]> groupAverageGrades = new HashMap<>();
        for (Student student : students) {
            double[] averageGrades = groupAverageGrades.getOrDefault(student.groupNumber, new double[5]);
            for (int i = 0; i < 5; i++) {
                averageGrades[i] += student.grades[i];
            }
            groupAverageGrades.put(student.groupNumber, averageGrades);
        }

        for (String group : groupAverageGrades.keySet()) {
            double[] averageGrades = groupAverageGrades.get(group);
            for (int i = 0; i < 5; i++) {
                averageGrades[i] /= students.stream().filter(s -> s.groupNumber.equals(group)).count();
            }
            //System.out.println("Средний балл группы " + group + ": " + Arrays.toString(averageGrades));
            welcomeText1.setText("Средний балл группы " + group + ":" + Arrays.toString(averageGrades));
    }
        Student oldestStudent = students.stream().max(Comparator.comparing(s -> s.birthYear)).get();
        Student youngestStudent = students.stream().min(Comparator.comparing(s -> s.birthYear)).get();

        //System.out.println("Самый старший студент: " + oldestStudent.lastName + " " + oldestStudent.firstName + " "
               // + oldestStudent.middleName);
        //System.out.println("Самый младший студент: " + youngestStudent.lastName + " " + youngestStudent.firstName + " "
               // + youngestStudent.middleName);
        welcomeText11.setText("Самый старший студент: " + oldestStudent.lastName + " " + oldestStudent.firstName + " "
                 + oldestStudent.middleName);
        welcomeText12.setText("Самый младший студент: " + youngestStudent.lastName + " " + youngestStudent.firstName + " "
                + youngestStudent.middleName);


        Map<String, Student> bestStudents = new HashMap<>();
        for (String group : groupAverageGrades.keySet()) {
            Student bestStudent = students.stream()
                    .filter(s -> s.groupNumber.equals(group))
                    .max(Comparator.comparing(Student::getAverageGrade))
                    .get();
            bestStudents.put(group, bestStudent);
        }

        for (String group : bestStudents.keySet()) {
            Student bestStudent = bestStudents.get(group);
            welcomeText121.setText("Лучший студент группы " + group + ": " + bestStudent.lastName + " " + bestStudent.firstName
                    + " " + bestStudent.middleName);
    }}}