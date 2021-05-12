package MustafaCigGokpinarHW1;

import java.util.Random;

public class MandatoryCourse extends Course {
    public String year;
    public String semester;

    public MandatoryCourse(String courseCode, String courseName, int ects, String year, String semester, Instructor[] instructors) {
        super(courseCode, courseName, ects);
        this.year = year;
        this.semester = semester;

        this.initializeInstructorsArray(2);
        this.initializeClassesArray(48);
    }

    public MandatoryCourse() {
        super();

        Random r = new Random();
        this.year = Integer.toString(r.nextInt(4 - 1) + 1);
        this.semester = Integer.toString(r.nextInt(2 - 1) + 1);

        this.initializeInstructorsArray(2);
        this.initializeClassesArray(48);
    }
}
