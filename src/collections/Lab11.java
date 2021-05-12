package collections;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Lab11 {

    /**
     * This method merges and sorts from small to large the given ArrayLists and
     * returns as another ArrayList. This method assumes that the given ArrayLists
     * are already sorted. This method does not use any sorting method, it just
     * sorts by merge.
     *
     * @param a the first ArrayList to be merged
     * @param b the second ArrayList to be merged
     * @return the sorted and merged ArrayList using a and b
     */
    public static ArrayList<Integer> mergeAndSort(ArrayList<Integer> a, ArrayList<Integer> b) {
        ArrayList<Integer> mergedList = new ArrayList<>();
        int counterA = 0, counterB = 0;
        while (counterA < a.size() && counterB < b.size()) {
            int elemMin, elemA = a.get(counterA), elemB = b.get(counterB);
            if (elemA < elemB) {
                elemMin = elemA;
                counterA++;
            } else {
                elemMin = elemB;
                counterB++;
            }
            mergedList.add(elemMin);
        }

        while (counterA < a.size()) {
            mergedList.add(a.get(counterA));
            counterA++;
        }

        while (counterB < b.size()) {
            mergedList.add(b.get(counterB));
            counterB++;
        }
        System.out.println(mergedList);
        return mergedList;
    }

    /**
     * This method reads the words in the given file one by one. The method finds
     * the frequency of the words and assigns them to a Map.
     *
     * @param file file to be counted
     * @return the Map containing strings and frequencies
     */
    public static Map<String, Integer> wordFrequencies(File file) {
        Scanner lineScanner = null;
        try {
            lineScanner = new Scanner(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        Map<String, Integer> wordFreqMap = new HashMap<>();

        while (lineScanner != null && lineScanner.hasNextLine()) {
            Scanner wordScanner = new Scanner(lineScanner.nextLine());
            while (wordScanner.hasNext()) {
                String word = wordScanner.next();
                int oldVal = 0;
                if(wordFreqMap.containsKey(word)){
                    oldVal = wordFreqMap.get(word);
                }
                wordFreqMap.put(word,oldVal+1);
            }
        }
        return wordFreqMap;
    }
}
