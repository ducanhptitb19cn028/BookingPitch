package model;

public class User {
    public String username;
    public String password;
    public String position;
    public User(String username, String password){
        this.username = username;
        this.password = password;
    }
    public String getPassword() {
        return password;
    }

    public String getUsername() {
        return username;
    }
    public String getPosition(){
        return position;
    }
}
