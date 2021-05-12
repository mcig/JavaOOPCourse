package FileIO;

import java.io.IOException;

public class MainTask2 {
    public static void main(String[] args) {
        FileAverageFinder task2 = new FileAverageFinder();
        try {
            task2.initiate("resources/task2.txt", "resources/task2.txt");
        } catch (IOException e) {
            System.err.println("Error inside frequencyFinder.initiate():\n" + e);
        }
        System.out.println("Task 2 is Finished...");
    }
}
