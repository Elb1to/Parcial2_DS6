package me.elb1to.parcial2_ds6.impl;

import java.util.List;

public class User {

    private String name;
    private String cedula;
    private String username;
    private String password;
    private List<Grade> grades;

    public User(String name, String cedula, String username, String password) {
        this.name = name;
        this.cedula = cedula;
        this.username = username;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
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

    public List<Grade> getGrades() {
        return grades;
    }

    public void setGrades(List<Grade> grades) {
        this.grades = grades;
    }
}
