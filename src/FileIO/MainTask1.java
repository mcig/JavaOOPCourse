package FileIO;

import java.io.IOException;

public class MainTask1 {
    public static void main(String[] args) {
        FileCharFrequency task1 = new FileCharFrequency();
        try {
            task1.initiate("resources/task1_in.txt", "resources/task1_out.txt");
        } catch (IOException e) {
            System.err.println("Error inside frequencyFinder.initiate():\n" + e);
        }
        System.out.println("Task 1 is Finished...");
    }
}
