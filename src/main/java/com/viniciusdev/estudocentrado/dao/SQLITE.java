package com.viniciusdev.estudocentrado.dao;

import java.io.File;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SQLITE {
    String databaseSystemPath;

    public SQLITE(){
        System.out.println("Criando");
    }

    public void CreateDatabase(){
        String currentDirectory = System.getProperty("user.dir");
        databaseSystemPath = "jdbc:sqlite:" + currentDirectory + File.separator + "database.db";

        try {
             Connection connection = DriverManager.getConnection(databaseSystemPath);

             if (connection != null){
                 DatabaseMetaData metaData = connection.getMetaData();
                 System.out.println("The driver name is " + metaData.getDriverName());
                 System.out.println("A new database has been created.");
             }

        }catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void createTables(){

        String sql_table_student =
                "CREATE TABLE IF NOT EXISTS student (" +
                    "idStudent INTEGER PRIMARY KEY NOT NULL," +
                    "nameStudent TEXT NOT NULL," +
                    "numberDaysPerWeek INTEGER NOT NULL," +
                    "numberHoursPerWeek INTEGER NOT NULL," +
                    "mailStudent TEXT NOT NULL," +
                    "passwordStudent TEXT NOT NULL" +
                ");";

        String sql_table_studyCycle =
                "CREATE TABLE IF NOT EXISTS studyCycle (" +
                        "idStudyCycle INTEGER PRIMARY KEY NOT NULL," +
                        "monthName TEXT NOT NULL," +
                        "numberStages INTEGER NOT NULL," +
                        "student_idStudent INTEGER NOT NULL , FOREIGN KEY (student_idStudent) REFERENCES student(idStudent)" +
                        ");";

        String sql_table_stageCycle =
                "CREATE TABLE IF NOT EXISTS weekCycle (" +
                        "idStageCycle INTEGER PRIMARY KEY NOT NULL," +
                        "daysAlreadyStudied TEXT NOT NULL," +
                        "daysToBeStudied TEXT NOT NULL," +
                        "studyCycle_idStudyCycle INTEGER NOT NULL , FOREIGN KEY (studyCycle_idStudyCycle) REFERENCES studyCycle(idStudyCycle)" +
                        ");";

        String sql_table_session =
                "CREATE TABLE IF NOT EXISTS session (" +
                        "idSession INTEGER PRIMARY KEY NOT NULL," +
                        "subjectsOfTheSession TEXT NOT NULL," +
                        "stageCycle_idStageCycle INTEGER NOT NULL , FOREIGN KEY (stageCycle_idStageCycle) REFERENCES stageCycle(idStageCycle)" +
                        ");";

        String sql_table_card =
                "CREATE TABLE IF NOT EXISTS card (" +
                        "idCard INTEGER PRIMARY KEY NOT NULL," +
                        "subjectOfCard TEXT NOT NULL," +
                        "textOfCard TEXT NOT NULL," +
                        "dataCreationCard DATA NOT NULL," +
                        "session_idSession INTEGER NOT NULL , FOREIGN KEY (session_idSession) REFERENCES session(idSession)" +
                        ");";

        List<String> listOfQuerys = new ArrayList<>();
        listOfQuerys.add(sql_table_student);
        listOfQuerys.add(sql_table_studyCycle);
        listOfQuerys.add(sql_table_stageCycle);
        listOfQuerys.add(sql_table_session);
        listOfQuerys.add(sql_table_card);

        for (String query:
                listOfQuerys) {
            try {
                // Estabelecer a conexão com o banco de dados
                Connection connection = DriverManager.getConnection(databaseSystemPath);
                Statement statement = connection.createStatement();
                statement.execute(query);

                System.out.println("Tabela criada com sucesso!");

            } catch (SQLException e) {
                System.out.println("Erro ao criar a tabela: " + e.getMessage());
            }
        }

    }

}
