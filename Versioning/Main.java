package Versioning;
import java.io.*;
import java.io.FileInputStream;
import java.io.ObjectInputStream;

public class Main {

    public static void main(String[] args) {
        Employee e1 = new Employee("utkarsh", 123);

        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("system.sr"))) {
            oos.writeObject(e1);
            System.out.println("Serialized Successfully:->");
        } catch (IOException e) {
            e.printStackTrace();

        }
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("system.sr"))) {
            Employee emp = (Employee) ois.readObject();
            System.out.println("✅ Deserialized: " + emp);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

    }
}

