package MustafaCigGokpinarHW2;

import MustafaCigGokpinarHW2.MyExceptions.InsufficientWeightException;

public class GradedStudent {
    String fullName;
    String letterGrade;

    public GradedStudent(Student student) throws InsufficientWeightException {
        fullName = student.name + " " + student.surname;
        letterGrade = calculateLetterGrade(student.assignments.calculateWeightedSum());
    }
    //for copy purposes
    public GradedStudent(GradedStudent student){
        fullName = student.fullName;
        letterGrade = student.letterGrade;
    }

    private String calculateLetterGrade(double weightedGrade) {
        if (weightedGrade < 55)
            return "F";
        if (weightedGrade < 60)
            return "D";
        if (weightedGrade < 70)
            return "C";
        if (weightedGrade < 80)
            return "B";
        return "A";
    }

    @Override
    public String toString() {
        return "Graded Student - " +
                "Full Name: '" + fullName + '\'' +
                ", Letter Grade: '" + letterGrade + '\'' +
                "\n";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof GradedStudent)) return false;
        GradedStudent gradedStudent2 = (GradedStudent) o;
        return fullName.equals(gradedStudent2.fullName) && letterGrade.equals(gradedStudent2.letterGrade);
    }
}
