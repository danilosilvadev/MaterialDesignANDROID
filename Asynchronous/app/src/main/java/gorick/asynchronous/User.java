package gorick.asynchronous;

import org.json.JSONObject;

/**
 * Created by sg-0036936 on 06/02/2017.
 */

public class User {

    private String name;
    private int followers;

    public User(String username, int followersCount) {
        this.name = username;
        this.followers = followersCount;
    }

    public User(JSONObject json){

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getFollowers() {
        return followers;
    }

    public void setFollowers(int followers) {
        this.followers = followers;
    }
}
