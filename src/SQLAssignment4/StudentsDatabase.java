package SQLAssignment4;

import java.sql.*;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


enum Gender { F, M, U};
enum mySemester {FALL, WINTER, SUMMER, SPRING};
enum myGrade { A,B,C,D,F,W };
public class StudentsDatabase implements StudentsDatabaseInterface, TableInterface{
    String url;
    //String dbName = "Students";

    String username;
    String password;
    Connection connection;
    StudentsDatabase() {}
    StudentsDatabase (String url, String username, String password) throws SQLException {
        this.url = url;
        this.username = username;
        this.password = password;
        this.connection = getConnection (url, username,password);

        try (Statement statement = connection.createStatement()) {
            statement.executeUpdate(StudentsDatabaseInterface.dropSchema);
            System.out.println("Schema dropped");

        }
        catch (SQLException e) {
            System.out.println("Schema not dropped");
            e.printStackTrace();
        }

        //CREATE SCHEMA
        try (Statement statement = connection.createStatement()) {
            statement.executeUpdate(StudentsDatabaseInterface.createSchema);
            System.out.println("Schema created");

        }
        catch (SQLException e) {
            System.out.println("Schema not created");
            e.printStackTrace();
        }
    }
    public Connection getConnection (String url, String username, String password) {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(url, username, password);
            System.out.println("\nConnection to the database server successful!");
        } catch (SQLException e) {
            System.out.println(e);
        }
        return connection;
    }

    // Get map of aggregate grades
//    public Map<Character,Integer> getAggregateGrades (String nameTable) {
//        Map<Character,Integer> mapAggregateGrades = new HashMap<>();
//
//        try {
//            ResultSet RS = TableInterface.getTable(connection, nameTable);
//            while (RS.next()) {
//                mapAggregateGrades.put(RS.getString("grade").charAt(0), RS.getInt("numberStudents"));
//            }
//        }
//        catch (SQLException e) {System.out.println(e);}
//
//        return mapAggregateGrades;
//    }

    public class Schedule {
        String createTable;
        String populateTable;
        String updateCourseInstructor;
        String updateInstructor;
        String fileName;
        String nameTable;

        Schedule (String createTable, String fileName, String nameTable) throws SQLException {
            this.createTable = createTable;
            this.fileName = fileName;
            this.nameTable = nameTable;
            this.populateTable = TableInterface.loadDataInFileTable(fileName,nameTable);

            // Create Table
            TableInterface.dropTable(connection, nameTable);
            TableInterface.createTable(connection, createTable);


            // Populate Table
            TableInterface.setLocalInFileLoading(connection);
            TableInterface.populateTable(connection, populateTable);


        }

    }
//    public class Students{
//        Students() {
//            try (Connection connection1 = DriverManager.getConnection(url+dbName, username, password)) {
//                PreparedStatement stmt = connection1.prepareStatement(StudentsDatabaseInterface.createTableStudents);
//                stmt.executeUpdate();
//                System.out.println("Students Table created");
//            }
//            catch (SQLException e){
//                System.out.println("Students Table NOT created");
//                e.printStackTrace();
//            }
//        }
//
//        public Students(String createTable, String nameTable) {
//        }
//    }
    public class Courses{
        private String courseID;
        private String courseTitle;
        private String department;

        public Courses(String createTable, String nameToTable, String nameFromTable) {
        }
    }
    public class Classes{
        private String courseID;
        private int studentID; //SAME AS EMPID
        private int sectionNo;
        private int year;
        private mySemester semester;
        private myGrade grade;


        public Classes(String createTable, String nameTable) {
        }
    }
    public class AggregateGrades{

    }
}

