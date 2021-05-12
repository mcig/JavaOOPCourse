package FileIO;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileCharFrequency {
    public void initiate(String inputName, String outputName) throws IOException {
        FileReader in = new FileReader(inputName);
        FileWriter out = new FileWriter(outputName);

        int c;
        String inputStr = "";
        while ((c = in.read()) != -1) {
            inputStr += (char)c;
        }
        out.write(charFreqLinear(inputStr));

        if (in != null) {
            in.close();
        }
        if (out != null) {
            out.close();
        }
    }

    private String charFreqLinear(String string){
        String[] chars = string.split("");
        char[] alphabet = "abcdefghijklmnopqrstuvwxyz".toCharArray();
        int[] freqs = new int[26];
        int length = chars.length;
        int i, j;

        for (i = 0; i < length; i++) {
            for (j = 0; j < freqs.length; j++) {
                if (chars[i].charAt(0) == (alphabet[j]))
                    freqs[j]++;
            }
        }

        String outputStr = "";
        for (i = 0; i < freqs.length; i++) {
            outputStr += (alphabet[i] + ":" + freqs[i] + "\n");
        }
        return outputStr;
    }
}
