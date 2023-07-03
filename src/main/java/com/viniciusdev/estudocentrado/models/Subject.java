package com.viniciusdev.estudocentrado.models;

public class Subject {

    private final String subjectName;
    private final String subjectRelated;
    private final String subjectDificult;
    private final String subjectRelevance;

    public Subject(String subjectName, String subjectRelated ,String subjectDificult, String subjectRelevance){
        this.subjectName = subjectName;
        this.subjectRelated = subjectRelated;
        this.subjectDificult = subjectDificult;
        this.subjectRelevance = subjectRelevance;
    }

    public String getSubjectRelated() {
        return subjectRelated;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public String getSubjectDificult() {
        return subjectDificult;
    }

    public String getSubjectRelevance() {
        return subjectRelevance;
    }

    @Override
    public String toString() {
        return subjectName;
    }
}
