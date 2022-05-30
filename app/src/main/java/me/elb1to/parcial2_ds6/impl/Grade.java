package me.elb1to.parcial2_ds6.impl;

public class Grade {

    private final String course;
    private String gradeLetter;
    private final int courseIcon;

    public Grade(String course, String gradeLetter, int courseIcon) {
        this.course = course;
        this.gradeLetter = gradeLetter;
        this.courseIcon = courseIcon;
    }

    public String getCourse() {
        return course;
    }

    public String getGradeLetter() {
        return gradeLetter;
    }

    public void setGradeLetter(String gradeLetter) {
        this.gradeLetter = gradeLetter;
    }

    public int getCourseIcon() {
        return courseIcon;
    }
}
