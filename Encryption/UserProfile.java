package Encryption;
import java.io.*;

public class UserProfile implements Serializable {
    private String username;
    private transient String password; // Marked transient to skip default serialization
    private String email;

    public UserProfile(String username, String password, String email) {
        this.username = username;
        this.password = password;
        this.email = email;
    }

    // Custom Serialization
    private void writeObject(ObjectOutputStream out) throws IOException {
        out.defaultWriteObject(); // Serialize non-transient fields

        try {
            String encryptedPassword = CryptoUtils.encrypt(password);
            out.writeUTF(encryptedPassword);
        } catch (Exception e) {
            throw new IOException("Error during encryption", e);
        }
    }

    // Custom Deserialization
    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        in.defaultReadObject(); // Deserialize non-transient fields

        try {
            String encryptedPassword = in.readUTF();
            password = CryptoUtils.decrypt(encryptedPassword);
        } catch (Exception e) {
            throw new IOException("Error during decryption", e);
        }
    }

    @Override
    public String toString() {
        return "UserProfile{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
