package com.viniciusdev.estudocentrado.controllers;

import com.viniciusdev.estudocentrado.dao.SQLITE;

public class SQLITEController {

    SQLITE sqlite = new SQLITE();

    public void createDatabaseAndTables(){
        sqlite.CreateDatabase();
        sqlite.createTables();
    }

}
