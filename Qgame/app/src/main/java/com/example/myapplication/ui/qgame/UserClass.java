package com.example.myapplication.ui.qgame;

import android.app.Application;

public class UserClass extends Application {
    private String username;

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

    public Integer getCredits() {
        return credits;
    }

    public void setCredits(Integer credits) {
        this.credits = credits;
    }

    public Integer getPoints() {
        return points;
    }

    public void setPoints(Integer points) {
        this.points = points;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    private String password;
    private Integer credits;
    private Integer points;
    private String email;

    public UserClass(String username, String password, Integer credits, Integer points, String email) {
        this.username = username;
        this.password = password;
        this.credits = credits;
        this.points = points;
        this.email = email;
    }


}
