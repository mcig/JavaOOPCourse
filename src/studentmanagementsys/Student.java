package studentmanagementsys;

public class Student {
    private static int[] autoIncrementedIds = {1, 1, 1, 1, 1};
    private int department;
    private String studentId;
    private String name;
    private String surname;
    private String mail;
    private String contactNumber;

    //simple constructor without mail and phone
    public Student(String name, String surname, int department) {
        this.name = name;
        this.surname = surname;
        if (department > 5 || department < 1) department = 1;
        this.department = department;

        this.studentId = createUniqueStudentId();
    }

    //detailed constructor with mail and phone
    public Student(String name, String surname, int department, String mail, String contactNumber) {
        this.name = name;
        this.surname = surname;
        if (department > 5 || department < 1) department = 1;
        this.department = department;

        this.mail = mail;
        this.contactNumber = contactNumber;

        this.studentId = createUniqueStudentId();
    }

    public Student(){
        MyUtils myutils = new MyUtils();
        String[] nameSurname = myutils.createRandomNameSurname();
        int departmentId = myutils.createRandomDepartmentId();
        String mail = myutils.createMail(nameSurname[0], nameSurname[1]);
        String phone = myutils.createRandomPhoneNumber();

        this.name = nameSurname[0];
        this.surname = nameSurname[1];
        this.department = departmentId;
        this.mail = mail;
        this.contactNumber = phone;

        this.studentId = createUniqueStudentId();
    }


    //private methods
    private String createUniqueStudentId() {
        String newId = Integer.toString(this.department) +"00"+ Integer.toString(this.autoIncrementedIds[department - 1]);
        autoIncrementedIds[department - 1]++;
        return newId;
    }


    //Getter Setters
    //custom getter
    public String getDepartmentName() {
        String departmentName = "";
        switch (this.department) {
            case 1:
                departmentName = "Computer Engineering";
                break;
            case 2:
                departmentName = "Electrical - Electronic Engineering";
                break;
            case 3:
                departmentName = "Industrial Engineering";
                break;
            case 4:
                departmentName = "Civil Engineering";
                break;
            case 5:
                departmentName = "Mechanical Engineering";
        }
        ;
        return departmentName;
    }

    //default getter setters
    public void setDepartment(int department) {
        this.department = department;
    }

    public String getStudentId() {
        return studentId;
    }

    public String getName() {
        return name + " " + surname;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public String toString(){
        return this.studentId + "-" + this.getDepartmentName() + " " + this.getName() + " " + this.getContactNumber() + " " + this.getMail();
    }
}
