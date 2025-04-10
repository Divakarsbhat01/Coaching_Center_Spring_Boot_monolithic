package com.coacen.coacen_mono.Schemas;

public class StudentList
{
    String firstName;

    String courseName;

    public StudentList(String firstName, String courseName) {
        this.firstName = firstName;
        this.courseName = courseName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }
}
