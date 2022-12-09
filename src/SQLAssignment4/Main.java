package SQLAssignment4;


import java.sql.*;

public class Main {
    static final String url = "jdbc:mysql://localhost:3306/?autoReconnect=true&zeroDateTimeBehavior=convertToNull&useUnicode=yes&characterEncoding=UTF-8&allowLoadLocalInfile=true";
    //jdbc.url=jdbc:mysql://127.0.0.1:<port>/<dbname>?autoReconnect=true&zeroDateTimeBehavior=convertToNull&useUnicode=yes&characterEncoding=UTF-8&allowLoadLocalInfile=true

    static final String username = "root";
    static final String password = "Jynda$1226!";
    static final String fileName = "/Users/yawamankwah/Desktop/FALL2022/CSC221/SQLAssignment4/Resources/ScheduleSpring2022.txt";
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
        //Create Populate Table Courses
        String nameToTable = "Students.Courses";
        String nameFromTable = "Students.Schedule";
        createTable = StudentsDatabaseInterface.createTableCourses;
        StudentsDatabase.Courses courses = DB.new Courses(createTable,nameToTable,nameFromTable);
//
        //Create populate Table Students
        nameTable = "Students.Students";
        createTable = StudentsDatabaseInterface.createTableStudents;
        StudentsDatabase.Students students = DB.new Students (createTable, nameTable);
//
//        //Create populate Table Classes
        nameTable = "Students.Classes";
        createTable = StudentsDatabaseInterface.createTableClasses;
        StudentsDatabase.Classes classes = DB.new Classes(createTable,nameTable);









//        Connection connection = DriverManager.getConnection(url, username, password);
//        try {
//
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
//            Statement stmt = connection.createStatement();
//
//            stmt.execute(createTableSchedule);
//        }
//        catch (SQLException e) {
//            System.out.println(e);
//        }
//
//
//        PreparedStatement psSetLocalInFileLoading = connection.prepareStatement("SET GLOBAL local_infile = 1"); //MORE STUFF TO TYPE HERE
//        try {
//            psSetLocalInFileLoading.executeUpdate();
//            System.out.println("\nGlobal local infile set successfully");
//        }
//        catch (SQLException e) {System.out.println(e);} //REMOVE THIS
//
//
//
//        try{
//
//            Statement statement = connection.createStatement();
//            statement.executeUpdate("LOAD DATA LOCAL INFILE '" + fileName + "' INTO TABLE " + nameTable +
//                    " FIELDS TERMINATED BY '\t'" +
//                    " LINES TERMINATED BY '\n'" +
//                    " IGNORE 1 LINES;");
//            System.out.println("\nTable populated successfully");
//        }
//        catch(SQLException e) {
//            System.out.println("\nError in populate Table");
//            System.out.println(e);
//        }
//
//        String createTableCourses = "CREATE TABLE Students.Courses (" +
//                "courseId CHAR(12) PRIMARY KEY REFERENCES Students.Schedule(courseId), " +
//                "title VARCHAR(64), " +
//                "department CHAR(16), " +
//                "program VARCHAR(48))";
//
//        nameTable = "Students.Courses";
//
//        try {
//            Statement stmt = connection.createStatement();
//
//            stmt.execute(createTableCourses);
//        }
//        catch (SQLException e) {
//            System.out.println(e);
//        }
//




    }
}