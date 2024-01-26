package sem3.hw;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import sem3.sem.task2.ToDoV2;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class StudentService {

    public static final String FILE_JSON = "tasks.json";

    public static final String FILE_BIN = "tasks.bin";

    public static final String FILE_XML = "tasks.xml";

    private static final ObjectMapper objectMapper = new ObjectMapper();

    private static final XmlMapper xmlMapper = new XmlMapper();

    public static List<Student> loadStudentsFromFile(String fileName) {

        List<Student> students = new ArrayList<>();

        File file = new File(fileName);

        if (file.exists()) {
            try {
                if (fileName.endsWith(".json")) {
                    students = objectMapper.readValue(file, objectMapper.getTypeFactory().constructCollectionType(List.class, Student.class));
                } else if (fileName.endsWith(".bin")) {
                    try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(file))) {
                        students = (List<Student>) in.readObject();
                    }
                } else if (fileName.endsWith(".xml")) {
                    students = xmlMapper.readValue(file, xmlMapper.getTypeFactory().constructCollectionType(List.class, Student.class));
                }
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
        return students;
    }

    public static void saveStudentsToFile(String fileName, List<Student> students) {
        try {
            if (fileName.endsWith(".json")) {
                objectMapper.configure(SerializationFeature.INDENT_OUTPUT, true);
                objectMapper.writeValue(new File(fileName), students);
            } else if (fileName.endsWith(".bin")) {
                try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(fileName))) {
                    out.writeObject(students);
                }
            } else if (fileName.endsWith(".xml")) {
                xmlMapper.writeValue(new File(fileName), students);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void displayStudents(List<Student> students) {
        System.out.println("Список студентов: ");
        for (int i = 0; i < students.size(); i++) {
            Student student = students.get(i);
            System.out.println((i+1) + ". " + student.getName() + ", " + student.getAge() + " лет. gpa: " + student.getGpa());
        }
    }
}
