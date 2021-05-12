package MustafaCigGokpinarHW1;

public class OptionalCourse extends Course {
    public OptionalCourse(String courseCode, String courseName, int ects, Instructor instructor) {
        super(courseCode, courseName, ects);
        this.initializeInstructorsArray(1);
        this.initializeClassesArray(20);
    }

    public OptionalCourse() {
        super();
        this.initializeInstructorsArray(1);
        this.initializeClassesArray(20);
    }
}
