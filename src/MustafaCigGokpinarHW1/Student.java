package MustafaCigGokpinarHW1;

import java.util.Random;

public class Student extends User {
    public int studentId;
    public String department;
    public String yearsOfStudy;

    public Student(String name, String surname, String birthDate,
                   String gender, String mobilePhone, String email,
                   String password, String department, String yearsOfStudy) {
        super(name, surname, birthDate, gender, mobilePhone, email, password);
        this.department = department;
        this.yearsOfStudy = yearsOfStudy;
        assignStudentNumber();
    }

    public Student() {
        super();
        this.department = MyUtilities.createRandomDepartment();
        this.yearsOfStudy = Integer.toString(new Random().nextInt(10));
        assignStudentNumber();
    }

    public void downloadFile(Course course, int index) {
        System.out.println("Downloaded Course: " + course.courseName + " file:" + course.files[index]);
    }

    //helpers
    private void assignStudentNumber() {
        this.studentId = Integer.parseInt(this.department.charAt(0) + this.yearsOfStudy.charAt(0) + howManyZeros(this.id) + this.id);
    }

    /**
     * makes the ids equal length by adding conditional zeros
     *
     * @param number id
     * @return string of zeros
     */
    private String howManyZeros(int number) {
        int cnt = String.valueOf(number).length();
        String zeros = "";
        switch (cnt) {
            case 1:
                zeros += "0";
            case 2:
                zeros += "0";
            case 3:
                zeros += "0";
                break;
        }
        return zeros;
    }

    @Override
    public String toString() {
        return this.studentId + " " + this.name + " " + this.surname + " " + this.gender + " " + this.mobilePhone + " " + this.email + " " + this.department;
    }
}
