package MustafaCigGokpinarHW2;

public class Assignment {
    String name;
    Integer grade;
    Double percentage;

    public Assignment(String name, Integer grade, Double percentage) {
        this.name = name;
        this.grade = grade % 101;
        this.percentage = percentage % 1.01;
    }

    @Override
    public String toString() {
        return "Assignment{" +
                "name: '" + name + '\'' +
                ", grade: " + grade +
                " points, percentage: " + percentage * 100 +
                "%}";
    }

}
