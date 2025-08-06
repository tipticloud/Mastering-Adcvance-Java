package Encryption;

import java.io.*;

public class Main {
    public static void main(String[] args) {
        UserProfile user = new UserProfile("utkarsh", "superSecret123", "utkarsh@email.com");

        // Serialize to file
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("user.ser"))) {
            oos.writeObject(user);
            System.out.println("UserProfile object serialized with encryption.");
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Deserialize from file
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("user.ser"))) {
            UserProfile deserializedUser = (UserProfile) ois.readObject();
            System.out.println("Deserialized and decrypted UserProfile:");
            System.out.println(deserializedUser);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
