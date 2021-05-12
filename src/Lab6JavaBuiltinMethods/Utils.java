package Lab6JavaBuiltinMethods;

import javax.swing.*;
import java.util.Random;

public class Utils {
    public static void charFreq(String[] strings) {
        for (String string : strings) {//foreach string
            System.out.println("Frequencies for word:\n" + string);

            String[] chars = string.split("");
            int length = chars.length;
            int[] freqs = new int[length];
            int i, j;

            for (i = 0; i < length; i++) {
                for (j = 0; j < length; j++) {
                    if (chars[i].equals(chars[j]))
                        freqs[i]++;
                }
            }

            //printing phase
            for (i = 0; i < length; i++) {
                System.out.println(chars[i] + ":" + freqs[i]);
            }
        }
    }

    public static String passwordGenerator() {
        String[] results = openInputPanel();
        String password = "";
        if (results == null)
            return password;

        Random r = new Random();
        Boolean includesCapital = results[0].equals("Yes");
        Boolean includesNums = results[1].equals("Yes");
        Boolean includesSpecial = results[2].equals("Yes");
        int length = Integer.parseInt(results[3]);

        while (password.length() < length) {
            int randomness = r.nextInt(4);

            if (randomness == 0 && includesCapital)
                password += getRandomCapital(r);
            else if (randomness == 1 && includesNums) {
                password += getRandomDigit(r);
            } else if (randomness == 2 && includesSpecial)
                password += getRandomSpecial(r);
            else
                password += getRandomChar(r);
        }

        System.out.println(password);
        return password;
    }

    private static char getRandomCapital(Random r) {
        int letterIndex = r.nextInt(26); // random number between 0 and 26
        return (char) ('A' + letterIndex);
    }

    private static char getRandomDigit(Random r) {
        return (char) (r.nextInt(9) + '0');
    }

    private static char getRandomSpecial(Random r) {
        int letterIndex = r.nextInt(12); // random number between 0 and 26
        return (char) ('!' + letterIndex);
    }

    private static char getRandomChar(Random r) {
        int letterIndex = r.nextInt(26); // random number between 0 and 26
        return (char) ('a' + letterIndex);
    }

    private static String[] openInputPanel() {
        JTextField capitalField = new JTextField(7);
        JTextField numberField = new JTextField(7);
        JTextField specialField = new JTextField(7);
        JTextField lengthField = new JTextField(7);

        JPanel myPanel = new JPanel();
        myPanel.add(new JLabel("Includes Capital Letters:"));
        myPanel.add(capitalField);
        myPanel.add(new JLabel("Includes numbers:"));
        myPanel.add(numberField);
        myPanel.add(new JLabel("Includes Special Characters:"));
        myPanel.add(specialField);
        myPanel.add(new JLabel("Length:"));
        myPanel.add(lengthField);

        int result = JOptionPane.showConfirmDialog(null, myPanel,
                "Please input Yes/No and a number to related fields", JOptionPane.OK_CANCEL_OPTION);
        if (result == JOptionPane.OK_OPTION) {
            return new String[]{capitalField.getText(), numberField.getText(), specialField.getText(), lengthField.getText()};
        }
        return null;
    }
}
