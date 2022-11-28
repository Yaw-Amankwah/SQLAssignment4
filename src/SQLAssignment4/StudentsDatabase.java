package SQLAssignment4;

public class StudentsDatabase implements StudentsDatabaseInterface, TableInterface{

    public class Schedule {

    }
    public class Students{
        private int empID;
        private String firstName;
        private String lastName;
        private String email;
        public enum gender { F, M, U};


    }
    public class Courses{
        private String courseID;
        private String courseTitle;
        private String department;

    }
    public class Classes{
        private String courseID;
        private int studentID; //SAME AS EMPID
        private int sectionNo;
        private int year;
        private String semester; //MAYBE MAKE THIS AN ENUM??
        public enum grade { A,B,C,D,F,W };



    }
    public class AggregateGrades{

    }
}

