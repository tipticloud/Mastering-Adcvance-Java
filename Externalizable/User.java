package Externalizable;
import java.io.*;
public class User implements Externalizable {
    private String username;
    private transient String password;  // Will be manually serialized
    // Required public no-arg constructor
    public User() {
    }
    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }
    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        out.writeObject(username);
        out.writeObject(password); // manually writing even though it's transient
    }
    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        username = (String) in.readObject();
        password = (String) in.readObject();
    }
    @Override
    public String toString() {
        return "User{username='" + username + "', password='" + password + "'}";
    }
}
