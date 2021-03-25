package main;

import univer.Student;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        new Main().run();
    }

    private void run() {
        //List<Student> students = createList();

//
//        Student forDelete = new Student(3, "Masha", "2144", 65);
//        students.remove(forDelete);
//
//        printList(students);
        List<Integer> list = createListOfIntegers();
        int count = countOdds(list);
        System.out.println("count = " + count);

//        int studentsByRating = countStudentByRating(students, 70);
//        System.out.println("studentsByRating = " + studentsByRating);

        deleteOdds(list);
        printList(list);

        //writeStudentsToFile(students);
        List<Student> students = readFromFile("file.txt");
        printList(students);
    }

    private List<Student> readFromFile(String filename) {
        List<Student> students = new ArrayList<>();
        try (BufferedReader reader = Files.newBufferedReader(Path.of("file.txt"))) {
            String line;
            while ((line = reader.readLine())!=null) {
                //System.out.println(line);
                Student s = Student.parseFromString(line);
                students.add(s);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return students;
    }

    private void writeStudentsToFile(List<Student> students) {
        try (PrintWriter out = new PrintWriter("file.txt")) {
            for (Student student : students) {
                out.println(String.format("%d:::%s:::%s:::%f", student.getId(), student.getName(), student.getGroup(), student.getRating()));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private void deleteOdds(List<Integer> list) {
        list.removeIf(x -> x % 2 != 0);
//        for (int i = 0; i < list.size(); i++) {
//            if (list.get(i) % 2 != 0) list.remove(i);
//        }
    }

    public int countStudentByRating(List<Student> list, double rating) {
        int count = 0;
        for (Student student : list) {
            if (student.getRating() > rating) count++;
        }
        return count;
    }

    private List<Student> createList() {
        List<Student> students = new ArrayList<>();
        students.add(new Student(1, "Ivan", "1141", 87));
        students.add(new Student(2, "Vova", "1141", 75));
        students.add(new Student(3, "Masha", "2144", 65));
        students.add(new Student(4, "Katya", "2147", 92));
        students.add(new Student(5, "Petya", "1144", 99));
        students.add(new Student(6, "Ivanka", "1145", 59));
        return students;
    }

    private void printList(List<?> list) {
        for (Object elem : list) {
            System.out.println(elem);
        }
    }

    public int countOdds(List<Integer> list) {
        int result = 0;
        for (Integer x : list) {
            if (x % 2 != 0) result++;
        }
        return result;
    }

    public List<Integer> createListOfIntegers() {
        return new ArrayList<>(List.of(1, 5, 8, -5, 19, 0, -47, 55, 16, 18));
    }
}
