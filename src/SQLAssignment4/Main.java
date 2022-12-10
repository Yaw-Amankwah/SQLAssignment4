package SQLAssignment4;


import java.sql.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class Main {
    static final String url = "jdbc:mysql://localhost:3306/?autoReconnect=true&zeroDateTimeBehavior=convertToNull&useUnicode=yes&characterEncoding=UTF-8&allowLoadLocalInfile=true";
    static final String username = "root";
    static final String password = "Jynda$1226!";
    static final String fileName = "/Users/yawamankwah/Desktop/FALL2022/CSC221/SQLAssignment4/Resources/ScheduleSpring2022.txt";
    public static void main(String[] args) throws SQLException {

        StudentsDatabase DB = new StudentsDatabase(url, username,password);

        String createTable;
        String fileName = "/Users/yawamankwah/Desktop/FALL2022/CSC221/SQLAssignment4/Resources/ScheduleSpring2022.txt";
        String nameTable;
        Connection connection = DriverManager.getConnection(url, username,password);

        //Create Populate Table Schedule
        nameTable = "Students.Schedule";
        createTable = StudentsDatabaseInterface.createTableSchedule;
        StudentsDatabase.Schedule schedule = DB.new Schedule(createTable,fileName,nameTable);

        //Create Populate Table Courses
        String nameToTable = "Students.Courses";
        String nameFromTable = "Students.Schedule";
        createTable = StudentsDatabaseInterface.createTableCourses;
        StudentsDatabase.Courses courses = DB.new Courses(createTable,nameToTable,nameFromTable);

        //CREATE ARRAY OF STUDENT FIELDS
        int numStudents = 50;
        ArrayList<String> empIdList = new ArrayList<>();
        for (int i = 0; i < numStudents; i++) {
            Random rnd = new Random();
            int number = rnd.nextInt(10000000,99999999);
            empIdList.add(String.valueOf(number));
        }
        ArrayList<String> firstNameList = new ArrayList<>();
        Collections.addAll(firstNameList,
                "James",
                "Robert",
                "John",
                "Michael",
                "David",
                "William",
                "Richard",
                "Joseph",
                "Thomas",
                "Charles",
                "Mary",
                "Patricia",
                "Jennifer",
                "Linda",
                "Elizabeth",
                "Barbara",
                "Susan",
                "Jessica",
                "Sarah",
                "Karen");
        ArrayList<String> lastNameList = new ArrayList<>();
        Collections.addAll(lastNameList,
                "Smith",
                "Johnson",
                "Williams",
                "Brown",
                "Jones",
                "Garcia",
                "Miller",
                "Davis",
                "Rodriguez",
                "Martinez",
                "Hernandez",
                "Lopez",
                "Gonzales",
                "Wilson",
                "Anderson",
                "Thomas",
                "Taylor",
                "Moore",
                "Jackson",
                "Martin");
        ArrayList<Student> studentList = new ArrayList<>();
        Collections.shuffle(firstNameList);
        Collections.shuffle(lastNameList);
        int size = firstNameList.size();
        for (int i = 0; i < numStudents; i++) {
            if (i%size == 0) {
                Collections.shuffle(firstNameList);
                Collections.shuffle(lastNameList);
            }
            studentList.add(new Student(empIdList.get(i),firstNameList.get(i%size), lastNameList.get(i%size),
                    firstNameList.get(i%size) + "_"+ lastNameList.get(i%size) + "@myemail.com",
                    myGender.values()[new Random().nextInt(myGender.values().length)]));
        }

        //Create populate Table Students
        nameTable = "Students.Students";
        StringBuilder sql = new StringBuilder();
        sql.append("INSERT INTO " + nameTable + " (empId, firstName, lastName, email, gender) VALUES ");
        String glue = "";
        for (int i = 0; i < numStudents; i++) {
            sql.append(glue);
            sql.append("('");
            sql.append(studentList.get(i).getEmpId().toString().replace(",", "''"));
            sql.append("', '");
            sql.append(studentList.get(i).getFirstName().toString().replace(",", "''"));
            sql.append("', '");
            sql.append(studentList.get(i).getLastName().toString().replace(",", "''"));
            sql.append("', '");
            sql.append(studentList.get(i).getEmail().toString().replace(",", "''"));
            sql.append("', '");
            sql.append(studentList.get(i).getGender().toString().replace(",", "''"));
            sql.append("')");
            glue = ", ";
        }

        createTable = StudentsDatabaseInterface.createTableStudents;
        StudentsDatabase.Students students = DB.new Students (createTable, nameTable, sql.toString());
    }
}