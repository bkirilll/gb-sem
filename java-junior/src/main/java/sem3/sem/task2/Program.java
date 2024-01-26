package sem3.sem.task2;

import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

import static sem3.sem.task2.ToDoListApp.*;

public class Program {

    public static void main(String[] args) {

        List<ToDoV2> tasks;
        File f = new File(FILE_JSON);
        if (f.exists() && !f.isDirectory()) {
            tasks = ToDoListApp.loadTasksFromFile(FILE_JSON);
        } else {
            tasks = prepareTasks();
            ToDoListApp.saveTaskToFile(FILE_JSON, tasks);
            ToDoListApp.saveTaskToFile(FILE_BIN, tasks);
            ToDoListApp.saveTaskToFile(FILE_XML, tasks);
        }

        displayTasks(tasks);

    }

    static List<ToDoV2> prepareTasks() {
        ArrayList<ToDoV2> list = new ArrayList<>();
        list.add(new ToDoV2("a"));
        list.add(new ToDoV2("b"));
        list.add(new ToDoV2("c"));
        return list;
    }
}
