package com.example.geo.museumguide.bean;

/**
 * Created by Geo on 1/7/2017.
 */

public class LoginBean {

    private String username;
    private String password;

    public LoginBean(String usernameTxt, String passwordTxt) {
        this.username = usernameTxt;
        this.password  = passwordTxt;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {

        return username;
    }

    public String getPassword() {
        return password;
    }
}
