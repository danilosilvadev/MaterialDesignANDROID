package gorick.sqlite;

/**
 * Created by sg-0036936 on 28/01/2017.
 */

public class UserModel {

    private int id;
    private String username;
    private String password;

    public UserModel(String username, String password){
        this.username = username;
        this.password = password;
    }

    public UserModel(){}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }



}
