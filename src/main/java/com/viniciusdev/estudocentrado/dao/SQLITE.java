package com.viniciusdev.estudocentrado.dao;

import com.viniciusdev.estudocentrado.models.Student;

import java.io.File;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SQLITE {
    String databaseSystemPath;

    public SQLITE(){
        String currentDirectory = System.getProperty("user.dir");
        databaseSystemPath = "jdbc:sqlite:" + currentDirectory + File.separator + "database.db";
    }

    public void CreateDatabase(){
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
                    "idStudent INTEGER PRIMARY KEY AUTOINCREMENT," +
                    "nameStudent TEXT NOT NULL," +
                    "numberDaysPerWeek INTEGER," +
                    "numberHoursPerWeek INTEGER," +
                    "mailStudent TEXT NOT NULL," +
                    "passwordStudent TEXT NOT NULL" +
                ");";

        String sql_table_studyCycle =
                "CREATE TABLE IF NOT EXISTS studyCycle (" +
                        "idStudyCycle INTEGER PRIMARY KEY AUTOINCREMENT," +
                        "monthName TEXT NOT NULL," +
                        "numberStages INTEGER NOT NULL," +
                        "student_idStudent INTEGER NOT NULL , FOREIGN KEY (student_idStudent) REFERENCES student(idStudent)" +
                        ");";

        String sql_table_stageCycle =
                "CREATE TABLE IF NOT EXISTS weekCycle (" +
                        "idStageCycle INTEGER PRIMARY KEY AUTOINCREMENT," +
                        "daysAlreadyStudied TEXT NOT NULL," +
                        "daysToBeStudied TEXT NOT NULL," +
                        "studyCycle_idStudyCycle INTEGER NOT NULL , FOREIGN KEY (studyCycle_idStudyCycle) REFERENCES studyCycle(idStudyCycle)" +
                        ");";

        String sql_table_session =
                "CREATE TABLE IF NOT EXISTS session (" +
                        "idSession INTEGER PRIMARY KEY AUTOINCREMENT," +
                        "subjectsOfTheSession TEXT NOT NULL," +
                        "stageCycle_idStageCycle INTEGER NOT NULL , FOREIGN KEY (stageCycle_idStageCycle) REFERENCES stageCycle(idStageCycle)" +
                        ");";

        String sql_table_card =
                "CREATE TABLE IF NOT EXISTS card (" +
                        "idCard INTEGER PRIMARY KEY AUTOINCREMENT," +
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

    private Connection connect() {
        try {
            Connection connection = DriverManager.getConnection(databaseSystemPath);
            return connection;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    public void createStudent(Student student){

        String sql_insert = "INSERT INTO student(nameStudent, mailStudent, passwordStudent) VALUES(?,?,?)";

        try{
            Connection conn = this.connect();
            PreparedStatement preparedStatement = conn.prepareStatement(sql_insert);
            preparedStatement.setString(1, student.getNameStudent());
            preparedStatement.setString(2, student.getMailStudent());
            preparedStatement.setString(3, student.getPasswordStudent());
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public Student selectStudent(String mail){
        Student student = new Student();

        try {
            Connection conn = this.connect();
            String sql_select = "SELECT * FROM student WHERE mailStudent = ?";
            PreparedStatement statement = conn.prepareStatement(sql_select);
            statement.setString(1, mail);

            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                student.setNameStudent(resultSet.getString("nameStudent"));
                student.setMailStudent(resultSet.getString("mailStudent"));
                student.setPasswordStudent(resultSet.getString("passwordStudent"));
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return student;
    }
}
