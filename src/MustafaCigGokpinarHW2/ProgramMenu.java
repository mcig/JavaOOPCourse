package MustafaCigGokpinarHW2;

import MustafaCigGokpinarHW2.MyExceptions.*;

import java.util.Scanner;

public class ProgramMenu extends MenuFunctionalities {
    boolean wantToExit = false;

    public ProgramMenu() {
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.println("\n\nWelcome to Student Letter Grade Calculator System");
            System.out.println("Here are your options:");
            System.out.println("1 - Add a new Student");
            System.out.println("2 - List all Students");
            System.out.println("3 - Add a new grade to a Student");
            System.out.println("4 - Find a Student");
            System.out.println("5 - Finish grades of a Student");
            System.out.println("6 - Display all Graded Students");
            System.out.println("7 - Find Duplicate Students");
            System.out.println("0 - Exit Program\n\n");

            int selection = scanner.nextInt();
            try {
                handleSelection(selection);
            } catch (InvalidMenuSelectionException e) {
                System.err.println("Invalid selection inside ProgramMenu:\n" + e);
            }

        } while (!wantToExit);
    }

    private void handleSelection(int selection) throws InvalidMenuSelectionException {
        switch (selection) {
            case 0:
                System.out.println("Exiting program...");
                scanner.close();
                wantToExit = true;
                break;
            case 1:
                addAStudent();
                break;
            case 2:
                System.out.println("*** All Students ***");
                listStudents();
                break;
            case 3:
                try {
                    addAGrade();
                } catch (ExcessPercentageException e) {
                    System.err.println("Error inside selection three:\n" + e);
                }
                break;
            case 4:
                findAndPrintStudent();
                break;
            case 5:
                try {
                    findAndGradeStudent();
                } catch (InsufficientWeightException e) {
                    System.err.println("Error inside selection five:\n" + e);
                }
                break;
            case 6:
                System.out.println("*** All Graded Students ***");
                listGradStudents();
                break;
            case 7:
                findAllDuplicates();
                break;
            default:
                throw new InvalidMenuSelectionException("Invalid Input");
        }
    }
}
