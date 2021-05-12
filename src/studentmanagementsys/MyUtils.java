package studentmanagementsys;

import java.util.Random;

public class MyUtils {
    public static int createRandomDepartmentId() {
        return 1 + new Random().nextInt(5);
    }

    public static String createRandomPhoneNumber() {
        String str = "+905";
        str += 30 + new Random().nextInt(28);
        Random rnd = new Random();
        for (int i = 0; i < 7; i++) {
            str += rnd.nextInt(10);
        }
        return str;
    }

    public static String createMail(String name, String surname) {
        return name + "." + surname + "@randuni.edu.tr";
    }

    public static String[] createRandomNameSurname() {
        String[] names = {"Ali", "Veli", "Ayşe", "Fatma", "Deniz", "Mustafa"};
        String[] surnames = {"Kısa", "Küçük", "Öz", "Demir", "Yıldırım", "Şimşek"};
        Random rnd = new Random();

        String name = names[rnd.nextInt(names.length)];
        String surname = surnames[rnd.nextInt(surnames.length)];

        String[] nameSurnameArr = {name, surname};
        return nameSurnameArr;
    }

    public static int createRandomGrade() {
        return 1 + new Random().nextInt(100);
    }
}
