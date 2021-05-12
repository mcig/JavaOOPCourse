package MustafaCigGokpinarHW1;

import java.util.Random;

public class Registration {
    public Student user;
    public Course course;
    public String date;
    public String time;

    public Registration(Student user, Course course) {
        this.user = user;
        this.course = course;

        Random r = new Random();
        this.date = Integer.toString(r.nextInt(30 - 1) + 1) + "/" + Integer.toString(r.nextInt(12 - 1) + 1) + "/2021";
        this.time = Integer.toString(r.nextInt(24 - 1) + 1) + ":" + Integer.toString(r.nextInt(60 - 1) + 1);
    }

    @Override
    public String toString() {
        return "\t" + user.studentId + "\t" + course.courseCode + " " + course.courseName;
    }
}
