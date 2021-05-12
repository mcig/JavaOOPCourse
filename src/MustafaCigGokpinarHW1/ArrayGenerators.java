package MustafaCigGokpinarHW1;

public class ArrayGenerators {
    //object generators
    static Instructor[] createInstructors(int cnt) {
        Instructor[] instructors = new Instructor[cnt];
        for (int i = 0; i < cnt; i++) {
            instructors[i] = new Instructor();
        }
        return instructors;
    }

    static Student[] createStudents(int cnt) {
        Student[] students = new Student[cnt];
        for (int i = 0; i < cnt; i++) {
            students[i] = new Student();
        }
        return students;
    }

    static MandatoryCourse[] createMandCourses(int cnt) {
        MandatoryCourse[] courses = new MandatoryCourse[cnt];
        for (int i = 0; i < cnt; i++) {
            courses[i] = new MandatoryCourse();
        }
        return courses;
    }

    static OptionalCourse[] createOptCourses(int cnt) {
        OptionalCourse[] courses = new OptionalCourse[cnt];
        for (int i = 0; i < cnt; i++) {
            courses[i] = new OptionalCourse();
        }
        return courses;
    }
}
