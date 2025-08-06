package CustomSerialization;
import java.io.*;
public class Test {
    public static void main(String[] args) {
        Student_1 s1 = new Student_1("Utkarsh", 101, "secret123");

        // Serialize
        try {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("student.ser"));
            oos.writeObject(s1);
            oos.close();
            System.out.println("✅ Serialized with custom logic");
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Deserialize
        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream("student.ser"));
            Student_1 s2 = (Student_1) ois.readObject();
            ois.close();
            System.out.println("✅ Deserialized object:");
            System.out.println(s2);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
