package sem3.sem.task1;

import java.io.*;

public class Program {

    public static void main(String[] args) {

        UserData user = new UserData("Kirill", 20, "12345");

        try (FileOutputStream fileOut = new FileOutputStream("userdata.bin")) {
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(user);
            System.out.println("Объект сериализован");
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (FileInputStream fileIn = new FileInputStream("userdata.bin")) {
            ObjectInputStream in = new ObjectInputStream(fileIn);
            user = (UserData) in.readObject();
            System.out.println("Объект десериализован");
            System.out.println(user.getName());
            System.out.println(user.getPassword());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
