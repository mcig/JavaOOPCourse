package MustafaCigGokpinarHW1;

import java.util.Random;

public class MyUtilities {
    public static String createRandomCourse() {
        Random rnd = new Random();
        String[] courses = {"Database Design", "Data Structures", "Calculus",
                "Turkish", "English", "Economics",
                "Object Oriented Paradigms", "ISG", "Automata", "Lineer Algebra", "Physics", "Electronics", "Business", "Health"};

        return courses[rnd.nextInt(courses.length)];
    }

    public static String createRandomPhoneNumber(String startDigits) {
        String str = startDigits;
        str += 30 + new Random().nextInt(28);
        Random rnd = new Random();
        for (int i = 0; i < 7; i++) {
            str += rnd.nextInt(10);
        }
        return str;
    }

    public static String[] createRandomMailAndPassword(String name, String surname) {
        String randomNumsStr = "";
        Random rnd = new Random();
        for (int i = 0; i < 5; i++) {
            randomNumsStr += rnd.nextInt(10);
        }
        String mail = name + "." + surname + "@randomuni.edu.tr";
        String passwrd = name.charAt(0) + surname.charAt(surname.length() - 1) + randomNumsStr;
        return new String[]{mail, passwrd};
    }

    public static String[] createRandomNameSurname() {
        String[] names = {"Deniz", "Bulut", "Ateş", "Doğa", "Evren", "Tuna", "Güneş"};
        String[] surnames = {"Kısa", "Küçük", "Öz", "Demir", "Yıldırım", "Şimşek", "Gökpınar", "Gürer"};
        Random rnd = new Random();

        String name = names[rnd.nextInt(names.length)];
        String surname = surnames[rnd.nextInt(surnames.length)];

        return new String[]{name, surname};
    }

    public static String createRandomDepartment() {
        Random rnd = new Random();
        String[] departments = {"Health Management", "Psychology", "Computer Science",
                "Sociology", "Architecture", "Economy",
                "Electric Electronical Engineering"};

        return departments[rnd.nextInt(departments.length)];
    }

    public static String[] createRandomUserDatas() {
        Random r = new Random();

        String[] nameAndSurname = createRandomNameSurname();

        String birthDate = Integer.toString(r.nextInt(2003 - 1970) + 1970);

        String gender = r.nextInt() > 0.5 ? "Male" : "Female";

        String mobilePhone = createRandomPhoneNumber("+905");

        String[] emailPassword = createRandomMailAndPassword(nameAndSurname[0], nameAndSurname[1]);

        return new String[]{nameAndSurname[0], nameAndSurname[1], birthDate,
                gender, mobilePhone, emailPassword[0], emailPassword[1]};
    }
}
