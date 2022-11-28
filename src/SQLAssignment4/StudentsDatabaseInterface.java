package SQLAssignment4;

public interface StudentsDatabaseInterface {
    String createSchema = "CREATE SCHEMA Students ";
    String createTableSchedule = "CREATE TABLE Schedule (" +
            "courseId CHAR(12) NOT NULL UNIQUE, " +
            "title VARCHAR(64), " +
            "year INT, " +
            "semester CHAR(6), " +
            "instructor VARCHAR(24), " +
            "department CHAR(16), " +
            "program VARCHAR(48), " +
            "PRIMARY KEY(courseId, sectionNumber))";
    String createTableStudents = "CREATE TABLE Student (" +
            "empId INT PRIMARY KEY, " +
            "name VARCHAR(32) NOT NULL, " +
            "gender CHAR CHECK (gender = 'F' OR gender = 'M' OR gender = 'U'), " +
            "dob DATE)";
    String createTableCourses = "CREATE TABLE Courses (" +
            "courseId CHAR(12) PRIMARY KEY REFERENCES Schedule(courseId), " +
            "title VARCHAR(64), " +
            "department CHAR(16), " +
            "program VARCHAR(48)";
    String createTableClasses = "CREATE TABLE Classes (" +
            "empId INT REFERENCES Student(empId), " +
            "courseId CHAR(12) REFERENCES Schedule (courseId), " +
            "sectionNumber VARCHAR(8) REFERENCES Schedule(sectionNumber), " +
            "year INT, " +
            "semester CHAR(6), " +
            "grade CHAR CHECK (grade = 'A' OR grade = 'B' OR grade = 'C' OR grade = 'D' OR grade = 'F' OR grade = 'W'), " +
            "PRIMARY KEY(empId, courseId,sectionNumber))";
    String aggregateGrades = "SELECT grade, count(grade) FROM Classes GROUP BY grade";

}

