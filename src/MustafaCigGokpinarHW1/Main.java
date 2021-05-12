package MustafaCigGokpinarHW1;

public class Main {

    public static void main(String[] args) {
        Student[] students = ArrayGenerators.createStudents(48);
        Instructor[] instructors = ArrayGenerators.createInstructors(12);

        MandatoryCourse[] mandCourses = ArrayGenerators.createMandCourses(4);
        OptionalCourse[] optCourses = ArrayGenerators.createOptCourses(2);

        //48 * 4 mandatory and 2 * 20 optional course registrations
        Registration[] registrations = new Registration[48 * 4 + 20 * 2];
        int registrationCounter = 0;

        //register each student and 2 instructors to the mandatory courses
        //also perform the upload download operations
        for (Student student : students) {
            for (MandatoryCourse course : mandCourses) {
                course.instructors[0] = getRandomInstructor(instructors);
                course.instructors[1] = getRandomInstructor(instructors);
                //upload
                upload14Files(course.instructors[0], course);
                //download
                download14Files(student, course);
                //register
                registrations[registrationCounter] = new Registration(student, course);
                registrationCounter++;
            }
        }
        //i is the total number of students now
        //now for the remaining wanted entries we will make some students pick optional courses

        //register random students and 1 instructor to optional courses
        for (; registrationCounter < registrations.length; ) {
            for (OptionalCourse course : optCourses) {
                Student randomStudent = students[(int) (Math.random() * students.length)];
                course.instructors[0] = getRandomInstructor(instructors);
                //upload
                upload14Files(course.instructors[0], course);
                //download
                download14Files(randomStudent, course);
                //register
                registrations[registrationCounter] = new Registration(randomStudent, course);
                registrationCounter++;
            }
        }

        //for each registered course make instructors upload data and students download data
        int idxMand = 0, idxOpt = 0;
        for (Registration registration : registrations) {
            Course currCourse = registration.course;
            Student currStudent = registration.user;

            if (registration.course instanceof MandatoryCourse) {
                mark14Files(currStudent, currCourse, idxMand);
                idxMand = idxMand < 47 ? idxMand + 1 : 0;
            } else if (registration.course instanceof OptionalCourse) {
                mark14Files(currStudent, currCourse, idxOpt);
                idxOpt = idxOpt < 19 ? idxOpt + 1 : 0;
            }
        }

        System.out.println("\nAll Students: \n");
        printUsers(students);
        System.out.println("\nAll Instructors: \n");
        printUsers(instructors);
        System.out.println("\nAll MandatoryCourses: \n");
        printCourses(mandCourses);
        System.out.println("\nAll OptionalCourses: \n");
        printCourses(optCourses);
        System.out.println("\nAll Registrations: \n");
        printRegistrations(registrations);

    }


    static void printRegistrations(Registration[] registrations) {
        for (Registration regis : registrations) {
            System.out.println(regis.toString());
        }
    }

    static void printUsers(User[] users) {
        for (User user : users) {
            System.out.println(user.toString());
        }
    }

    static void printCourses(Course[] courses) {
        for (Course course : courses) {
            System.out.println(course.toString());
        }
    }

    static Instructor getRandomInstructor(Instructor[] instructors) {
        return instructors[(int) (Math.random() * instructors.length)];
    }

    static void upload14Files(Instructor instructor, Course course) {
        for (int fileIdx = 0; fileIdx < 14; fileIdx++) {
            instructor.uploadFile(course, fileIdx, "xxx" + instructor.email + "xxx ");
        }
    }

    static void download14Files(Student student, Course course) {
        for (int fileIdx = 0; fileIdx < 14; fileIdx++) {
            student.downloadFile(course, fileIdx);
        }
    }

    static void mark14Files(Student student, Course course, int currRow) {
        for (int fileIdx = 0; fileIdx < 14; fileIdx++) {
            course.classes[currRow][fileIdx] = student.studentId;
        }
    }
}
