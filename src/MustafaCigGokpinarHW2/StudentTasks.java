package MustafaCigGokpinarHW2;

import MustafaCigGokpinarHW2.MyExceptions.*;

public class StudentTasks {
    Assignment[] assignments = new Assignment[100];
    private int arrayIdx = 0;
    public double currPercentage = 0.0;

    public Boolean CheckTotalPercentage(Assignment newAssignment) {
        double newPercentage = currPercentage + newAssignment.percentage;
        return (newPercentage <= 1.0) && (newPercentage >= 0.0);
    }

    public void addAssignment(Assignment newAssignment) throws ExcessPercentageException {
        if (arrayIdx >= 100) {
            System.err.println("You can only add up to 100 assignments for now.");
            return;
        }
        if (!CheckTotalPercentage(newAssignment))
            throw new ExcessPercentageException("Student total percentage can only be between 0.00 - 1.00");

        assignments[arrayIdx] = newAssignment;
        currPercentage += newAssignment.percentage;
        arrayIdx++;
    }

    public double calculateWeightedSum() throws InsufficientWeightException {
        double sum = -1;
        if (currPercentage < 1.0)
            throw new InsufficientWeightException("Student total percentage cannot be lower than 1.00");

        for (int i = 0; i < arrayIdx; i++) {
            sum += assignments[i].grade * assignments[i].percentage;
        }

        return sum;
    }

    @Override
    public String toString() {
        String str = "All Assignments:";
        for (int i = 0; i < arrayIdx; i++) {
            str += assignments[i].toString() + "\n";
        }
        return str;
    }
}
