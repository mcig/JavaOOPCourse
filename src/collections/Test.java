package collections;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;
import java.util.Random;

public class Test {

    /**
     * This method tests the mergeAndSort method from Lab11 class. The method also
     * gives a clue as to why if the method is wrong.
     *
     * @return true if mergeAndSort method is probably true, false if mergeAndSort
     * method is definitely false
     */
    public static boolean testMergeAndSort() {
        Random rand = new Random();
        ArrayList<Integer> a = new ArrayList<Integer>();
        ArrayList<Integer> b = new ArrayList<Integer>();
        int r;
        for (int i = 0; i < 1000; ++i) {
            r = rand.nextInt(1000000);
            a.add(r);
            r = rand.nextInt(1000000);
            b.add(r);
        }
        for (int i = 0; i < 1000; ++i) {
            r = rand.nextInt(1000000);
            a.add(r);
        }
        Collections.sort(a);
        Collections.sort(b);
        ArrayList<Integer> c = Lab11.mergeAndSort(a, b);
        if (c == null) {
            System.err.println("The returned ArrayList is null.");
            return false;
        }
        if (c.size() != 3000) {
            System.err.println("The size of returned ArrayList is not expected. The size is " + c.size() + ".");
            return false;
        }
        @SuppressWarnings("unchecked")
        ArrayList<Integer> sorted = (ArrayList<Integer>) c.clone();
        Collections.sort(sorted);
        for (int i = 0; i < 3000; ++i) {
            if (c.get(i) != sorted.get(i)) {
                System.err.println("The ArrayList is not sorted.");
                return false;
            }
        }
        if (a.size() != 2000 || b.size() != 1000) {
            System.err.println("The input ArrayLists were affected by the method.");
            return false;
        }
        return true;
    }

    /**
     * This method tests the wordFrequencies method from Lab11 class. The method
     * also gives a clue as to why if the method is wrong.
     *
     * @return true if wordFrequencies method is probably true, false if
     * wordFrequencies method is definitely false
     */
    public static boolean testWordFrequencies() {
        File f = new File("resources/lastnames.txt");
        Map<String, Integer> map = Lab11.wordFrequencies(f);
        if (map == null) {
            System.err.println("The returned Map is null.");
            return false;
        }
        if (map.size() != 32) {
            System.err.println("The size of returned Map is not expected. The size is " + map.size() + ".");
            return false;
        }
        String strings[] = {"Macdonald", "Fernandez", "Bowen", "Zavala", "Bird", "Berg", "Sloan", "Dougherty",
                "Zuniga", "Irwin", "Marks", "Nielsen", "Hunt", "Kirk", "Fleming", "Espinoza", "Ramsey", "Hendricks",
                "Bass", "Robinson", "Mueller", "Montgomery", "Mcguire", "Haas", "Mays", "Barton", "Wilkerson",
                "Barnett", "Owens", "Bartlett", "Wu", "Sampson"};
        Integer frequencies[] = {27, 30, 34, 23, 30, 25, 29, 31, 23, 36, 26, 24, 27, 37, 32, 36, 29, 31, 36, 32, 25,
                38, 37, 31, 34, 33, 32, 28, 34, 42, 35, 33};
        for (int i = 0; i < 32; ++i) {
            if (map.get(strings[i]) == null) {
                System.err.println("Some of the expected strings are not included in the returned Map.");
                return false;
            }
            if (map.get(strings[i]) != frequencies[i]) {
                System.err.println("Some of the frequencies are not valid.");
                return false;
            }
        }
        return true;
    }
}
