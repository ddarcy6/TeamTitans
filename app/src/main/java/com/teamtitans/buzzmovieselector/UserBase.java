package com.teamtitans.buzzmovieselector;

import java.util.HashMap;

/**
 * Created by Alex on 2/15/2016.
 */
public class UserBase {
    private static UserBase ourInstance = new UserBase();
    private HashMap<String, User> userbase = new HashMap<>();
    private String currentUserName;

    public static UserBase getInstance() {
        return ourInstance;
    }

    private UserBase() {
    }

    public boolean containsUsername(String username) {
        return userbase.containsKey(username);
    }

    public void addUser(String username, String password) {
        userbase.put(username, new User(password));
    }

    public void editName(String username, String input) {
        this.getUser(username).setName(input);
    }

    public User getUser(String username) {
        return userbase.get(username);
    }

    public void editYear(String username, int input) {
        this.getUser(username).setYear(input);
    }

    public void editMajor(String username, User.MajorDegree major) {
        this.getUser(username).setMajor(major);
    }

    public void setCurrentUserName(String userName) {
        this.currentUserName = userName;
    }

    public String getCurrentUserName() {
        return currentUserName;
    }
}
