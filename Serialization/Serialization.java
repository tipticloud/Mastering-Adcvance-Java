package Serialization;

import java.io.*;

public class Serialization {
    public static void main(String[] args) {
        // Create a Student object
        Student student1 = new Student("Utkarsh", 101, "mySecretPass");

        // ---------- SERIALIZATION ----------
        try {
            FileOutputStream fos = new FileOutputStream("student.ser");
            ObjectOutputStream oos = new ObjectOutputStream(fos);

            oos.writeObject(student1); // Serialize the object
            oos.close();
            fos.close();

            System.out.println("✅ Student object serialized successfully.");
        } catch (IOException e) {
            System.out.println("❌ Serialization error: " + e.getMessage());
            e.printStackTrace();
        }

        // ---------- DESERIALIZATION ----------
        try {
            FileInputStream fis = new FileInputStream("student.ser");
            ObjectInputStream ois = new ObjectInputStream(fis);

            Student deserializedStudent = (Student) ois.readObject(); // Deserialize the object
            ois.close();
            fis.close();

            System.out.println("✅ Student object deserialized successfully.");
            System.out.println("👉 " + deserializedStudent);
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("❌ Deserialization error: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
