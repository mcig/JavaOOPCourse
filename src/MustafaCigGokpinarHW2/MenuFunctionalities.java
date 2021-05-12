package MustafaCigGokpinarHW2;

import MustafaCigGokpinarHW2.MyExceptions.*;

import java.lang.reflect.Array;
import java.util.Scanner;

public class MenuFunctionalities {
    protected Scanner scanner = new Scanner(System.in);
    protected Student[] students = new Student[100];
    protected GradedStudent[] gradedStudents = new GradedStudent[100];
    Integer[] arrIdxes = {0, 0}; //arrIdxes[0]: students, arrIdxes[1]: gradedStudents

    protected void addAStudent() throws ArrayIndexOutOfBoundsException {
        System.out.println("\n*** Add a new Student ***\n");
        System.out.println("Please Enter The Needed Data");
        System.out.println("Name:");
        String name = scanner.nextLine();
        System.out.println("Surname:");
        String surname = scanner.nextLine();

        if (arrIdxes[0] >= 100) throw new ArrayIndexOutOfBoundsException();

        students[arrIdxes[0]] = new Student(name, surname);
        arrIdxes[0]++;
    }

    protected void listStudents(Student[] students, int size) {
        for (int i = 0; i < size; i++) {
            System.out.println((i + 1) + " - " + students[i]);
        }
    }

    //polymorphic helper
    protected void listStudents() {
        listStudents(this.students, arrIdxes[0]);
    }

    protected void addAGrade() throws ExcessPercentageException {
        System.out.println("\n*** Add a grade for a student ***\n");
        System.out.println("Initiating Student Finder...");

        Student foundStudent = findAStudent();
        if (foundStudent == null) {
            System.out.println("Couldn't find any results!");
            return;
        }

        System.out.println("Found Student:");
        System.out.println(foundStudent);

        System.out.println("Please Enter The Needed Data");

        System.out.println("Assignment Name:");
        String name = scanner.nextLine();
        int grade;
        double percentage;
        try {
            System.out.println("Grade (0 - 100):");
            grade = Integer.parseInt(scanner.nextLine());
            System.out.println("Percentage (0.00 - 1.00):");
            percentage = Double.parseDouble(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.err.println("Failed to add assignment due to input errors:\n" + e);
            return;
        }

        foundStudent.addAssignment(name, grade, percentage);
    }

    protected void findAndPrintStudent() {
        System.out.println("\n*** Find a Student ***\n");
        System.out.println("Initiating Student Finder...");

        Student foundStudent = findAStudent();

        if (foundStudent == null) {
            System.out.println("Couldn't find any results!");
            return;
        }

        System.out.println("Found Student:");
        System.out.println(foundStudent);
    }

    protected void findAndGradeStudent() throws InsufficientWeightException {
        System.out.println("\n*** Finish grading a Student ***\n");
        System.out.println("Initiating Student Finder...");

        Student foundStudent = findAStudent();

        if (foundStudent == null) {
            System.out.println("Couldn't find any results!");
            return;
        }

        GradedStudent newGraStu = new GradedStudent(foundStudent);
        gradedStudents[arrIdxes[1]] = newGraStu;
        arrIdxes[1]++;

        System.out.println(newGraStu);
    }

    protected void listGradStudents(GradedStudent[] gradedStudents, int size) {
        for (int i = 0; i < size; i++) {
            System.out.println((i + 1) + " - " + gradedStudents[i]);
        }
    }

    //polymorphic helper
    protected void listGradStudents() {
        listGradStudents(this.gradedStudents, arrIdxes[1]);
    }

    protected <S> ArrayIdxPair<S, Integer> findDuplicatesGeneric(S[] students, int studentArrayIndex, Class<S> clazz) {
        S[] duplicateStudents = (S[]) Array.newInstance(clazz, 100);
        int newIdx = 0;

        //finding duplicate students
        for (int i = 0; i < studentArrayIndex; i++) {
            for (int j = i + 1; j <= studentArrayIndex - 1; j++) {
                if (students[i].equals(students[j])) {
                    duplicateStudents[newIdx] = students[i];
                    newIdx++;
                }
            }
        }
        return new ArrayIdxPair<>(duplicateStudents, newIdx);
    }

    protected void findAllDuplicates() {
        ArrayIdxPair<Student, Integer> studentsPair
                = findDuplicatesGeneric(students, arrIdxes[0], Student.class);
        ArrayIdxPair<GradedStudent, Integer> gradedStudentsPair
                = findDuplicatesGeneric(gradedStudents, arrIdxes[1], GradedStudent.class);

        System.out.println("Duplicate Students:");
        listStudents(studentsPair.array, studentsPair.idx);
        System.out.println("Duplicate Graded Students:");
        listGradStudents(gradedStudentsPair.array, gradedStudentsPair.idx);
    }

    //helpers
    private Student findAStudent() {
        System.out.println("\n*** Student Finder ***\n");
        System.out.println("1 - Search");
        System.out.println("Any Other Number - Pick from the list");

        int selection;
        try {
            selection = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            e.printStackTrace();
            return null;
        }

        return selection == 1 ? handleSearch() : handlePick();
    }

    private Student handleSearch() {
        System.out.println("Please Enter The Needed Data");
        System.out.println("Name:");
        String name = scanner.nextLine();
        System.out.println("Surname:");
        String surname = scanner.nextLine();

        for (int i = 0; i < arrIdxes[0]; i++) {
            if (students[i].name.equals(name) && students[i].surname.equals(surname))
                return students[i];
        }
        return null;
    }

    private Student handlePick() {
        listStudents(); // list all students
        System.out.println("Please pick a Student by entering the corresponding number");
        int pick;

        try {
            pick = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            return null;
        }

        if (pick <= 0 || pick > arrIdxes[0]) {
            System.out.println("Invalid Input!!!");
            return null;
        }

        return students[pick - 1];
    }

    private static class ArrayIdxPair<A, I> {
        A[] array;
        I idx;

        public ArrayIdxPair(A[] array, I idx) {
            this.array = array;
            this.idx = idx;
        }
    }
}
