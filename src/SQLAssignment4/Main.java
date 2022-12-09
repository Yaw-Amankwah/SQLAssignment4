package SQLAssignment4;


import java.sql.*;

public class Main {
    static final String url = "jdbc:mysql://localhost:3306/";
    static final String username = "root";
    static final String password = "Jynda$1226!";
    public static void main(String[] args) throws SQLException {

        StudentsDatabase DB = new StudentsDatabase(url, username,password);
//
        String createTable;
        String fileName = "/Users/yawamankwah/Desktop/FALL2022/CSC221/SQLAssignment4/Resources/ScheduleSpring2022.txt";
        String nameTable;

        //Create Populate Table Schedule
        nameTable = "Students.Schedule";
        createTable = StudentsDatabaseInterface.createTableSchedule;
        StudentsDatabase.Schedule schedule = DB.new Schedule(createTable,fileName,nameTable);
//
//        //Create Populate Table Courses
//        String nameToTable = "Students.Courses";
//        String nameFromTable = "Students.Schedule";
//        createTable = StudentsDatabaseInterface.createTableCourses;
//        StudentsDatabase.Courses courses = DB.new Courses(createTable,nameToTable,nameFromTable);
//
////        //Create populate Table Students
////        nameTable = "Students.Students";
////        createTable = StudentsDatabaseInterface.createTableStudents;
////        StudentsDatabase.Students students = DB.new Students (createTable, nameTable);
//
//        //Create populate Table Classes
//        nameTable = "Students.Classes";
//        createTable = StudentsDatabaseInterface.createTableClasses;
//        StudentsDatabase.Classes classes = DB.new Classes(createTable,nameTable);









//        try {
//            Connection connection = DriverManager.getConnection(url, username, password);
//            Statement stmt = connection.createStatement();
//
//            stmt.execute("CREATE SCHEMA Students ");
//        }
//        catch (SQLException e) {
//            System.out.println(e);
//        }
//
//        String createTableSchedule = "CREATE TABLE Students.Schedule (" +
//                "courseId CHAR(12) NOT NULL UNIQUE, " +
//                "title VARCHAR(64), " +
//                "year INT, " +
//                "semester CHAR(6), " +
//                "instructor VARCHAR(24), " +
//                "department CHAR(16), " +
//                "program VARCHAR(48), " +
//                "PRIMARY KEY(courseId))";
//
//        String nameTable = "Students.Schedule";
//
//        try {
//            Connection connection = DriverManager.getConnection(url, username, password);
//            Statement stmt = connection.createStatement();
//
//            stmt.execute(createTableSchedule);
//        }
//        catch (SQLException e) {
//            System.out.println(e);
//        }





    }
}