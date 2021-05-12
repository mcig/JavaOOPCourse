package MustafaCigGokpinarHW1;

import java.util.Random;

public class Course {
    protected static int id = 1;
    protected String courseCode;
    protected String courseName;
    protected int ects;
    public String[] files = new String[14];
    public int[][] classes; //will be initiated in subclasses
    public Instructor[] instructors;

    public Course(String courseCode, String courseName, int ects) {
        this.courseCode = courseCode;
        this.courseName = courseName;
        this.ects = ects;
        this.id++;
    }

    public Course() {
        Random r = new Random();
        this.courseCode = Integer.toString(r.nextInt(50 - 10) + 10) + "00" + this.id;
        this.courseName = MyUtilities.createRandomCourse();
        this.ects = r.nextInt(10 - 1) + 1;

        this.id++;
    }

    protected void initializeInstructorsArray(int cnt) {
        instructors = new Instructor[cnt];
    }

    protected void initializeClassesArray(int rowSize) {
        classes = new int[rowSize][14];
        int i, j;
        for (i = 0; i < rowSize; i++) {
            for (j = 0; j < 14; j++) {
                classes[i][j] = 0;
            }
        }
    }

    @Override
    public String toString() {
        return courseCode + " " + courseName + "\n" + stringifyFiles() + "\n" + stringifyClasses();
    }

    private String stringifyFiles() {
        String str = "Files: \n";
        for (String file : files) str += file + " ";
        return str;
    }

    private String stringifyClasses() {
        String str = "Classes: \n";
        for (int[] row : classes) {
            for (int id : row) {
                str += id + " ";
            }
            str += "\n";
        }
        return str;
    }
}
