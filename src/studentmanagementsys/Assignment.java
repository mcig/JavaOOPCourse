package studentmanagementsys;

public class Assignment {
    private final Student[] students = new Student[20];
    private final int[][] assignmentGrades = new int[20][5];

    public void simulate() {
        //student creation
        for (int i = 0; i < 20; i++) {
            String[] nameSurname = MyUtils.createRandomNameSurname();
            int departmentId = MyUtils.createRandomDepartmentId();
            String mail = MyUtils.createMail(nameSurname[0], nameSurname[1]);
            String phone = MyUtils.createRandomPhoneNumber();
            students[i] = new Student(nameSurname[0], nameSurname[1], departmentId, mail, phone);
            for (int j = 0; j < 5; j++) {
                assignmentGrades[i][j] = MyUtils.createRandomGrade();
            }
        }
    }

    public void report() {
        if (students == null) {
            System.out.println("ERROR!!! Run simulate() first.");
            return;
        }
        System.out.println("Here are the grades:");
        for (int i = 0; i < 20; i++) {
            float avg = 0.0f;
            for (int j = 0; j < 5; j++) {
                avg += assignmentGrades[i][j];
            }
            avg /= 5;
            Student student = students[i];
            System.out.println(i + 1 + "- " + student.getDepartmentName() + " " + student.getStudentId() + " " + student.getName() + " AVG:" + avg);
        }
    }
}
