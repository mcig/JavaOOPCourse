package MustafaCigGokpinarHW1;

import java.util.Random;

public class Instructor extends User {
    public String officePhone;
    public String employment;

    public Instructor(String name, String surname, String birthDate,
                      String gender, String mobilePhone, String email,
                      String password, String officePhone, String employment) {

        super(name, surname, birthDate, gender, mobilePhone, email, password);
        this.officePhone = officePhone;
        this.employment = employment;
    }

    public Instructor() {
        super();
        this.officePhone = MyUtilities.createRandomPhoneNumber("+232");
        String[] employments = {"Prof.", "Res.Asstnt.", "Asstnt.Prof.", "Intern"};
        this.employment = employments[new Random().nextInt(3)];
    }

    public void uploadFile(Course course, int index, String data) {
        course.files[index] = data;
        System.out.println("Uploaded " + data + "to course " + course.courseName + " files[" + index + "]");
    }

    //helpers
    @Override
    public String toString() {
        return this.employment + " " + this.name + " " + this.surname + " " + this.gender + " " + this.officePhone + " " + this.email;
    }
}
