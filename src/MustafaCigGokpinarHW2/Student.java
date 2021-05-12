package MustafaCigGokpinarHW2;

import MustafaCigGokpinarHW2.MyExceptions.ExcessPercentageException;
import MustafaCigGokpinarHW2.MyExceptions.InsufficientWeightException;

public class Student {
    String name;
    String surname;
    StudentTasks assignments = new StudentTasks();

    public Student(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    public void printAssignments() {
        System.out.println("Assignments of " + name + " " + surname);
        System.out.println(assignments);
    }

    public void addAssignment(String name, Integer grade, Double percentage) throws ExcessPercentageException {
        assignments.addAssignment(new Assignment(name, grade, percentage));
    }

    @Override
    public String toString() {
        String str = "Student: " + name + " " + surname + "\n";
        str += assignments.toString() + "\n";
        if(assignments.currPercentage == 1.00){
            try {
                str += "Final Grade: " + assignments.calculateWeightedSum();
            } catch (InsufficientWeightException e) {
                System.err.println("Error occurred inside student.toString: \n" + e);
            }
        }
        return str;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Student)) return false;
        Student student2 = (Student) o;
        return name.equals(student2.name) && surname.equals(student2.surname);
    }

}
