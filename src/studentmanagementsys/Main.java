package studentmanagementsys;

public class Main {
    public static void main(String[] args) {
        Assignment asgnmnt = new Assignment();
        asgnmnt.simulate();
        asgnmnt.report();
        System.out.println("");
        System.out.println("************************************");
        System.out.println("");

        Student randomStd = new Student();
        System.out.println(randomStd.toString());
    }
}
