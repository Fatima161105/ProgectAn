package models;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        CSVParser parser = new CSVParser();
        List<Student> students = parser.parseCsv("src/models/basicprogramming_2.csv");

        // Сортировка групп по сумме среднего балла ДЗ и среднего балла Упражнений
        Map<String, List<Student>> studentsByGroup = new HashMap<>();
        for (Student student : students) {
            studentsByGroup.computeIfAbsent(student.getGroup(), k -> new ArrayList<>()).add(student);
        }

        List<Map.Entry<String, List<Student>>> sortedGroups = new ArrayList<>(studentsByGroup.entrySet());
        // Явное приведение типов для entry в Comparator
        Collections.sort(sortedGroups, Comparator.comparingDouble((Map.Entry<String, List<Student>> entry) -> {
            List<Student> groupStudents = entry.getValue();
            double avgDz = groupStudents.stream().mapToInt(Student::getTotalGradeDz).average().orElse(0);
            double avgUp = groupStudents.stream().mapToInt(Student::getTotalGradeUp).average().orElse(0);
            return avgDz + avgUp; // Сумма средних баллов
        }).reversed());

        System.out.println("Успеваемость в зависимотси от группы по убыванию");
        for (Map.Entry<String, List<Student>> entry : sortedGroups) {
            List<Student> groupStudents = entry.getValue();
            System.out.println("Группа: " + entry.getKey());
            System.out.println("Средний балл по ДЗ за весь курс: " + Math.round(groupStudents.stream().mapToInt(Student::getTotalGradeDz).average().orElse(0))); // Округление до целого
            System.out.println("Средний балл по Упражнениям за весь курс: " + Math.round(groupStudents.stream().mapToInt(Student::getTotalGradeUp).average().orElse(0))); // Округление до целого
            System.out.println("--------------------");
        }
    }
}