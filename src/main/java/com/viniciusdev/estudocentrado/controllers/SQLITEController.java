package com.viniciusdev.estudocentrado.controllers;

import com.viniciusdev.estudocentrado.dao.SQLITE;
import com.viniciusdev.estudocentrado.models.Student;

public class SQLITEController {

    SQLITE sqlite = new SQLITE();

    public void createDatabaseAndTables(){
        sqlite.CreateDatabase();
        sqlite.createTables();
    }

    public void insertStudent(Student student){
        sqlite.createStudent(student);
    }

    public Student receiveStudent(String mail){
        return sqlite.selectStudent(mail);
    }
}
