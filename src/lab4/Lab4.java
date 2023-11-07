package lab4;

import java.util.Arrays;
import java.util.Comparator;

/**
 * The class representing the Student object
 */
class Student {
    private String name;
    private int age;
    private double averageGrade;
    private String department;
    private int year;

    public Student(String name, int age, double averageGrade, String department, int year) {
        this.name = name;
        this.age = age;
        this.averageGrade = averageGrade;
        this.department = department;
        this.year = year;
    }

    //Getters and setters
    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getAverageGrade() {
        return averageGrade;
    }

    public void setAverageGrade(double averageGrade) {
        this.averageGrade = averageGrade;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", averageGrade=" + averageGrade +
                ", department='" + department + '\'' +
                ", year=" + year +
                '}';
    }
}

public class Lab4 {

    public static void main(String[] args) {

        final int C11 = 1517 % 11;//String
        System.out.println("C11 = " + C11 + " /Визначити клас студент, який складається як мінімум з 5-и полів.");

        Student[] students = {
                new Student("Denys", 19, 87.5, "FICE", 3),
                new Student("Ivan", 21, 90.3, "FICE", 3),
                new Student("Oleksandr", 18, 100, "ITS", 2),
                new Student("Mykola", 19, 60, "FMF", 1),
                new Student("Andrii", 22, 72.1, "FPM", 4)
        };

        Arrays.sort(students, Comparator.comparingDouble(Student::getAverageGrade));
        System.out.println("Sorted by average grade (ascending):");
        Arrays.stream(students).forEach(System.out::println);

        Arrays.sort(students, Comparator.comparingInt(Student::getYear).reversed());
        System.out.println("\nSorted by age (descending):");
        Arrays.stream(students).forEach(System.out::println);

        Arrays.sort(students, Comparator.comparing(Student::getDepartment));
        System.out.println("\nSorted by department (ascending):");
        for (Student st : students){
            System.out.println(st);
        }

    }

}
