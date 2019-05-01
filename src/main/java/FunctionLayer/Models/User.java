package FunctionLayer.Models;

public class User {
    private int userId;
    private String email; //TODO regex
    private String password; //TODO hash
    private String surname;
    private String lastname;
    private int phone;
    private boolean admin;

    public User(String email, String password, String surname, String lastname, int phone) {
        this.userId = 0;
        this.email = email;
        this.password = password;
        this.surname = surname;
        this.lastname = lastname;
        this.phone = phone;
        this.admin = false;
    }

    public int getUserId() {
        return userId;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getSurname() {
        return surname;
    }

    public String getLastname() {
        return lastname;
    }

    public int getPhone() {
        return phone;
    }

    public boolean isAdmin() {
        return admin;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public void setAdmin(boolean admin) {
        this.admin = admin;
    }
}
