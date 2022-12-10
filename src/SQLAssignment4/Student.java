package SQLAssignment4;

public class Student {
    private String empId;
    private String firstName;
    private String lastName;
    private String email;
    private myGender gender;

    public Student(){}
    public Student(String empId, String firstName, String lastName, String email, myGender gender) {
        this.empId = empId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.gender = gender;
    }

    //SETTERS
    public void setEmpId(String empId) {
        this.empId = empId;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setGender(myGender gender) {
        this.gender = gender;
    }

   //GETTERSS
    public String getEmpId() {
        return empId;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public myGender getGender() {
        return gender;
    }
}
