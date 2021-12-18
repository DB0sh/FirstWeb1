package entity;

public class User {

    private int id;
    private String email;
    private String password;

    public User() {
        this.id = 0;
        this.email = "";
        this.password = "";
    }

    public User(int id, String email, String password) {
        this.id = id;
        this.email = email;
        this.password = password;
    }

    public int getId() {
        return this.id;
    }

    public String getEmail() {
        return this.email;
    }

    public String getPassword() {
        return this.password;
    }

    public void setUser(int id, String email, String password) {
        this.id = id;
        this.email = email;
        this.password = password;
    }
}
