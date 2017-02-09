package gorick.asynktask_json;


/**
 * Created by sg-0036936 on 06/02/2017.
 */

public class User {

    private String name;
    private String blog;
    private String JSON;

    public void setJSON(String JSON) {
        this.JSON = JSON;
    }

    public String getJSON() {
        return JSON;
    }

    public User(){}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBlog() {
        return blog;
    }

    public void setBlog(String blog) {
        this.blog = blog;
    }

    public User(String name, String blog){
        this.name = name;
        this.blog = blog;

    }

}
