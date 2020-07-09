package com.example.myapplication.ui.qgame;

import android.app.Application;

public class GlobalClass extends Application {


    private String userLogged;
    private String userName;
    private String userPassword;
    private String userPoints;
    private String userCredits;
    private Integer score;
    private Integer quantity;
    private String userID;
    private String userLastPoints;
    private String userLastScore;

    public String getUserLastPoints() {
        return userLastPoints;
    }

    public void setUserLastPoints(String userLastPoints) {
        this.userLastPoints = userLastPoints;
    }

    public String getUserLastScore() {
        return userLastScore;
    }

    public void setUserLastScore(String userLastScore) {
        this.userLastScore = userLastScore;
    }







    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }







    public String getUserLogged() {
        return userLogged;
    }

    public void setUserLogged(String userLogged) {
        this.userLogged = userLogged;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getUserPoints() {
        return userPoints;
    }

    public void setUserPoints(String userPoints) {
        this.userPoints = userPoints;
    }

    public String getUserCredits() {
        return userCredits;
    }

    public void setUserCredits(String userCredits) {
        this.userCredits = userCredits;
    }


}
