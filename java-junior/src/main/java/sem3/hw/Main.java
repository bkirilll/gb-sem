package sem3.hw;

import sem3.sem.task2.ToDoListApp;
import sem3.sem.task2.ToDoV2;

import java.io.File;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static sem3.hw.StudentService.*;


public class Main {

    public static void main(String[] args) {


        Student student1 = new Student("Ivan", 17, 4.5);
        Student student2 = new Student("Oleg", 19, 4.8);
        Student student3 = new Student("Kirill", 20, 3.5);
        Student student4 = new Student("Petr", 20, 4.0);


        List<Student> students;
        File f = new File(FILE_JSON);
        if (f.exists() && !f.isDirectory()) {
            students = StudentService.loadStudentsFromFile(FILE_JSON);
        } else {
            students = Stream.of(student1, student2, student3, student4).collect(Collectors.toList());
            StudentService.saveStudentsToFile(FILE_JSON, students);
            StudentService.saveStudentsToFile(FILE_BIN, students);
            StudentService.saveStudentsToFile(FILE_XML, students);
        }

        displayStudents(students);

    }
}
