package com.viniciusdev.estudocentrado.models;

public class Student {

    String nameStudent;
    String mailStudent;
    String passwordStudent;
    Integer numberDaysPerWeek;
    Integer getNumberHoursPerWeek;

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

    public Integer getGetNumberHoursPerWeek() {
        return getNumberHoursPerWeek;
    }

    public void setGetNumberHoursPerWeek(Integer getNumberHoursPerWeek) {
        this.getNumberHoursPerWeek = getNumberHoursPerWeek;
    }
}
