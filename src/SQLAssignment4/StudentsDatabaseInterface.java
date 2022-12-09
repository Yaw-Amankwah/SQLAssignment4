package SQLAssignment4;

public interface StudentsDatabaseInterface {
    String dropSchema = "DROP SCHEMA IF EXISTS Students";
    String createSchema = "CREATE SCHEMA Students ";
    String createTableSchedule = "CREATE TABLE Students.Schedule (" +
            "courseId CHAR(12) NOT NULL UNIQUE, " +
            "title VARCHAR(64), " +
            "year INT, " +
            "semester CHAR(6), " +
            "instructor VARCHAR(24), " +
            "department CHAR(16), " +
            "program VARCHAR(48), " +
            "PRIMARY KEY(courseId))";//, sectionNumber))";
    String createTableStudents = "CREATE TABLE Students.Students (" +
            "empId INT PRIMARY KEY, " +
            "name VARCHAR(32) NOT NULL, " +
            "gender CHAR CHECK (gender = 'F' OR gender = 'M' OR gender = 'U'), " +
            "dob DATE)";
    String createTableCourses = "CREATE TABLE Students.Courses (" +
            "courseId CHAR(12) PRIMARY KEY REFERENCES Students.Schedule(courseId), " +
            "title VARCHAR(64), " +
            "department CHAR(16), " +
            "program VARCHAR(48))";
    String createTableClasses = "CREATE TABLE Students.Classes (" +
            "empId INT REFERENCES Student(empId), " +
            "courseId CHAR(12) REFERENCES Schedule (courseId), " +
            "sectionNumber VARCHAR(8) REFERENCES Schedule(sectionNumber), " +
            "year INT, " +
            "semester CHAR(6), " +
            "grade CHAR CHECK (grade = 'A' OR grade = 'B' OR grade = 'C' OR grade = 'D' OR grade = 'F' OR grade = 'W'), " +
            "PRIMARY KEY(empId, courseId,sectionNumber))";
    String aggregateGrades = "SELECT grade, count(grade) FROM Classes GROUP BY grade";

    static String upDateCourseInstructor (String courseId, String sectionNumber, String nameInstructor) {
     return  "UPDATE Schedule" +
             " SET instructor = " + nameInstructor +
             " WHERE courseId = " + courseId + " AND + " + "sectionNumber = " + sectionNumber;
    }
    static String updateInstructor (String nameInstructor, String nameNewInstructor) {
     return "UPDATE Schedule " +
             " SET instructor = " + nameInstructor +
             " WHERE instructor = " + nameNewInstructor; //SHOULDN'T THE TWO ABOVE BE SWITCHED??
    }

    static String insertTableCourses (String nameToTable, String nameFromTable) {
     return "INSERT INTO " + nameToTable +
             " SELECT courseId, title, department, program" +
             " FROM " + nameFromTable;
    }
    static String insertTableClasses (String nameToTable, String nameFromTable) {
        return "INSERT INTO " + nameToTable +
                " SELECT courseId, empId, sectionNumber, year, semester, grade" +
                " FROM " + nameFromTable;
    }

}

