package FileIO;

import java.io.*;

public class FileAverageFinder {
    private int cnt = 0;
    private int sum = 0;
    private double avg = 0.0;

    public void initiate(String inputName, String outputName) throws IOException {
        BufferedReader in = new BufferedReader(new FileReader(inputName));
        BufferedWriter out = new BufferedWriter(new FileWriter(outputName, true));

        String inputStr = "";
        String line = in.readLine();
        while (line != null) {
            sum += Integer.parseInt(line);
            cnt++;
            line = in.readLine();
        }
        avg = sum/cnt;
        out.append("\nSum: " + sum + "\nAverage: " + avg);

        if (in != null) {
            in.close();
        }
        if (out != null) {
            out.close();
        }
    }
}
