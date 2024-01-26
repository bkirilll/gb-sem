package sem3.sem.task2;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ToDoListApp {

    public static final String FILE_JSON = "tasks.json";

    public static final String FILE_BIN = "tasks.bin";

    public static final String FILE_XML = "tasks.xml";

    private static final ObjectMapper objectMapper = new ObjectMapper();

    private static final XmlMapper xmlMapper = new XmlMapper();

    public static void addNewTask(Scanner scanner, List<ToDoV2> tasks) {
        System.out.println("Введите название задачи:");
        String newTaskTitle = scanner.nextLine();
        tasks.add(new ToDoV2(newTaskTitle));
        saveTaskToFile(FILE_JSON, tasks);
        saveTaskToFile(FILE_BIN, tasks);
        saveTaskToFile(FILE_XML, tasks);
        System.out.println("Новая задача добавлена.");
    }

    public static void markTaskAsDone(Scanner scanner, List<ToDoV2> tasks) {
        System.out.println("Введите номер задачи: ");
        String input = scanner.nextLine();
        try {
            int taskNumber = Integer.parseInt(input) - 1;
            if (taskNumber <= 0 && taskNumber < tasks.size()) {
                tasks.get(taskNumber).setDone(true);
                saveTaskToFile(FILE_JSON, tasks);
                saveTaskToFile(FILE_BIN, tasks);
                saveTaskToFile(FILE_XML, tasks);
            } else {
                System.out.println("Некорректный номер задачи.");
            }
        } catch (NumberFormatException e) {
            System.out.println("Некорректный ввод.");
        }
    }

    public static List<ToDoV2> loadTasksFromFile(String fileName) {

        List<ToDoV2> tasks = new ArrayList<>();

        File file = new File(fileName);

        if (file.exists()) {
            try {
                if (fileName.endsWith(".json")) {
                    tasks = objectMapper.readValue(file, objectMapper.getTypeFactory().constructCollectionType(List.class, ToDoV2.class));
                } else if (fileName.endsWith(".bin")) {
                    try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(file))) {
                        tasks = (List<ToDoV2>) in.readObject();
                    }
                } else if (fileName.endsWith(".xml")) {
                    tasks = xmlMapper.readValue(file, xmlMapper.getTypeFactory().constructCollectionType(List.class, ToDoV2.class));
                }
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
        return tasks;
    }

    public static void saveTaskToFile(String fileName, List<ToDoV2> tasks) {
        try {
            if (fileName.endsWith(".json")) {
                objectMapper.configure(SerializationFeature.INDENT_OUTPUT, true);
                objectMapper.writeValue(new File(fileName), tasks);
            } else if (fileName.endsWith(".bin")) {
                try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(fileName))) {
                    out.writeObject(tasks);
                }
            } else if (fileName.endsWith(".xml")) {
                xmlMapper.writeValue(new File(fileName), tasks);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void displayTasks(List<ToDoV2> tasks) {
        System.out.println("Список задач: ");
        for (int i = 0; i < tasks.size(); i++) {
            ToDoV2 task = tasks.get(i);
            String status = task.isDone() ? "[x]" : "[ ]";
            System.out.println((i+1) + ". " + status + " " + task.getTitle());
        }
    }


}
