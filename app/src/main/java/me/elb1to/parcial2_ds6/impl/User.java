package me.elb1to.parcial2_ds6.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import me.elb1to.parcial2_ds6.R;

public class User implements Serializable {

    private String name;
    private String cedula;
    private String username;
    private String password;
    private List<Grade> grades = new ArrayList<>();

    public User(String name, String cedula, String username, String password) {
        this.name = name;
        this.cedula = cedula;
        this.username = username;
        this.password = password;

        registerAllCoursesAndGrades();
        /*grades.forEach(grade -> {
            System.out.println("Registed -> " + grade.getCourse() + " " + grade.getGradeLetter());
        });*/
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

    private void registerAllCoursesAndGrades() {
        this.grades.add(new Grade("Ciencias", "F", R.drawable.atom));
        this.grades.add(new Grade("Artistica", "F", R.drawable.arts));
        this.grades.add(new Grade("Aritmetica", "F", R.drawable.math));
        this.grades.add(new Grade("Biologia", "F", R.drawable.biology));
        this.grades.add(new Grade("Ed. Fisica", "F", R.drawable.sport));
        this.grades.add(new Grade("Geografia", "F", R.drawable.geology));
        this.grades.add(new Grade("Quimica", "F", R.drawable.chemistry));
        this.grades.add(new Grade("Literatura", "F", R.drawable.language));
        this.grades.add(new Grade("Geometria", "F", R.drawable.geometric));
        this.grades.add(new Grade("Astronomia", "F", R.drawable.astronomy));
    }

    // Get grade by name
    public Grade getGradeByName(String name) {
        for (Grade grade : grades) {
            if (grade.getCourse().equals(name)) {
                return grade;
            }
        }

        return null;
    }
}
