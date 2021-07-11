package Package.Classes;

import java.io.Serial;
import java.io.Serializable;

public class Admin implements Serializable {
    @Serial
    private static final long serialVersionUID = 123456L;
    private String username;
    private String password;
    private String name = "admin";
    private String email ;

    public Admin(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public Admin(String username, String password, String name, String email) {
        this.username = username;
        this.password = password;
        this.name = name;
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String display() {
        return "Logged In User: " + username +", Name: " + name + ", Email: " + email;
    }
}
