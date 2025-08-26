package org.epicor;

import java.util.HashMap;
import java.util.Map;

public class SortedWords {
    public static void sortedWords(HashMap<String, Long> hashMap){
        //Applied Stream on HashMap Collection
        hashMap.entrySet().stream()
                //Sorting the Hashmap on the basis of Key in Ascending Order
                .sorted(Map.Entry.comparingByKey())
                //Applies ForEachLoop to retrieve the key from Hashmap.
                .forEach(entry  -> System.out.println(entry.getKey()));

    }
}
