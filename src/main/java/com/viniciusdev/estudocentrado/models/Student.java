package com.viniciusdev.estudocentrado.models;

import java.util.ArrayList;

public class Student {

    private String nameStudent;
    private String mailStudent;
    private String passwordStudent;
    private Integer numberDaysPerWeek;
    private Integer numberHoursPerDay;
    private ArrayList<Subject> arrayList;

    public Student(String nameStudent, String mailStudent, String passwordStudent) {
        this.nameStudent = nameStudent;
        this.mailStudent = mailStudent;
        this.passwordStudent = passwordStudent;
    }

    public Student(){}

    public String getNameStudent() {
        return nameStudent;
    }

    public void setNameStudent(String nameStudent) {
        this.nameStudent = nameStudent;
    }

    public String getMailStudent() {
        return mailStudent;
    }

    public void setMailStudent(String mailStudent) {
        this.mailStudent = mailStudent;
    }

    public String getPasswordStudent() {
        return passwordStudent;
    }

    public void setPasswordStudent(String passwordStudent) {
        this.passwordStudent = passwordStudent;
    }

    public Integer getNumberDaysPerWeek() {
        return numberDaysPerWeek;
    }

    public void setNumberDaysPerWeek(Integer numberDaysPerWeek) {
        this.numberDaysPerWeek = numberDaysPerWeek;
    }

    public Integer getNumberHoursPerDay() {
        return numberHoursPerDay;
    }

    public void setNumberHoursPerDay(Integer numberHoursPerDay) {
        this.numberHoursPerDay = numberHoursPerDay;
    }

    public void setArrayList(ArrayList<Subject> arrayList) {
        this.arrayList = arrayList;
    }

    @Override
    public String toString() {
        return "Student{" +
                "nameStudent='" + nameStudent + '\'' +
                ", mailStudent='" + mailStudent + '\'' +
                ", passwordStudent='" + passwordStudent + '\'' +
                ", numberDaysPerWeek=" + numberDaysPerWeek +
                ", numberHoursPerDay=" + numberHoursPerDay +
                ", arrayList=" + arrayList +
                '}';
    }
}
