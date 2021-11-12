package com.koi.springmvc.entity;

import com.koi.springmvc.validation.FieldMatch;

@FieldMatch(first = "password", second = "matchingPassword", message = "The password fields must match")
public class RegisteredUser {

    private String userName;
    private String password;
    private String matchingPassword;

    public RegisteredUser() {
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMatchingPassword() {
        return matchingPassword;
    }

    public void setMatchingPassword(String matchingPassword) {
        this.matchingPassword = matchingPassword;
    }
}
