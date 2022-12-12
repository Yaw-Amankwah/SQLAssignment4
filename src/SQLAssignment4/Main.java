package SQLAssignment4;


import java.sql.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class Main {
    static final String url = "jdbc:mysql://localhost:3306/?autoReconnect=true&zeroDateTimeBehavior=convertToNull&useUnicode=yes&characterEncoding=UTF-8&allowLoadLocalInfile=true";
    static final String username = "root";
    static final String password = "Jynda$1226!";
    public static void main(String[] args) throws SQLException {

        StudentsDatabase DB = new StudentsDatabase(url, username,password);

        String createTable;
        String fileName = "/Users/yawamankwah/Desktop/FALL2022/CSC221/SQLAssignment4/Resources/ScheduleSpring2022.txt";
        String nameTable;
        Connection connection = DriverManager.getConnection(url, username,password);

        //Create Populate Table Schedule
        nameTable = "Students.Schedule";
        createTable = StudentsDatabaseInterface.createTableSchedule;
        DB.new Schedule(createTable,fileName,nameTable);

        //Create Populate Table Courses
        String nameToTable = "Students.Courses";
        String nameFromTable = "Students.Schedule";
        createTable = StudentsDatabaseInterface.createTableCourses;
        DB.new Courses(createTable,nameToTable,nameFromTable);

        //CREATE ARRAY OF STUDENT FIELDS
        int numStudents = 20;
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
            sql.append(studentList.get(i).getEmpId().replace(",", "''"));
            sql.append("', '");
            sql.append(studentList.get(i).getFirstName().replace(",", "''"));
            sql.append("', '");
            sql.append(studentList.get(i).getLastName().replace(",", "''"));
            sql.append("', '");
            sql.append(studentList.get(i).getEmail().replace(",", "''"));
            sql.append("', '");
            sql.append(studentList.get(i).getGender().toString().replace(",", "''"));
            sql.append("')");
            glue = ", ";
        }

        createTable = StudentsDatabaseInterface.createTableStudents;
        DB.new Students (createTable, nameTable, sql.toString());


        int numClasses = 4;
        String numClassesString = String.valueOf(numClasses);
       for (Student student: studentList) {
           Statement statement = connection.createStatement();
           String sqlString =
                   "SELECT DISTINCT courseId, sectionNumber,year,semester " +
                   "FROM Students.Schedule " +
                   //"WHERE program = 'Undergraduate' ";// +
                   "ORDER BY RAND() " +
                   "LIMIT " + numClassesString;
           ResultSet resultset = statement.executeQuery(sqlString);
           ArrayList<String> classes = new ArrayList<>();
           ArrayList<String> sectionNumbers = new ArrayList<>();
           ArrayList<String> classYears = new ArrayList<>();
           ArrayList<String> classSemester = new ArrayList<>();
           ArrayList<String> classGrades = new ArrayList<>();
           while (resultset.next()) {
               classes.add(resultset.getString("courseId"));
               sectionNumbers.add(resultset.getString("sectionNumber"));
               classYears.add(resultset.getString("year"));
               classSemester.add(resultset.getString("semester"));
               classGrades.add(myGrade.values()[new Random().nextInt(myGrade.values().length)].toString());
           }
           student.setClasses(classes);
           student.setStudentGrades(classGrades);
           student.setStudentYears(classYears);
           student.setStudentSemester(classSemester);
           student.setStudentSectionNumbers(sectionNumbers);
       }


        nameTable = "Students.Classes";
        StringBuilder sqlClasses = new StringBuilder();
        sqlClasses.append("INSERT INTO " + nameTable + " (empId, courseId, sectionNumber, year, semester, grade) VALUES ");
        String glueClasses = "";
        for (Student student:studentList) {
            for (int i = 0; i < numClasses; i++) {
                sqlClasses.append(glueClasses);
                sqlClasses.append("('");
                sqlClasses.append(student.getEmpId().replace(",", "''"));
                sqlClasses.append("', '");
                sqlClasses.append(student.getStudentClasses().get(i).replace(",", "''"));
                sqlClasses.append("', '");
                sqlClasses.append(student.getStudentSectionNumbers().get(i).replace(",", "''"));
                sqlClasses.append("', '");
                sqlClasses.append(student.getStudentYears().get(i).replace(",", "''"));
                sqlClasses.append("', '");
                sqlClasses.append(student.getStudentSemester().get(i).replace(",", "''"));
                sqlClasses.append("', '");
                sqlClasses.append(student.getStudentGrades().get(i).replace(",", "''"));
                sqlClasses.append("')");
                glueClasses = ", ";
            }
        }

        createTable = StudentsDatabaseInterface.createTableClasses;
        DB.new Classes(createTable, nameTable,sqlClasses.toString());


    }
}