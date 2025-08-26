package org.epicor;

import java.util.HashMap;
import java.util.Map;

public class TopNWordUsage {
    public static void findTopNWord(HashMap<String, Long> hashMap, int n){

        //Applying Stream on HashMap
        hashMap.entrySet().stream()
                //Sorting the HshMap on the basis of Value in Revere Order
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                //Applying Limit
                .limit(n)
                //Printing the Key and Value by using ForEachLoop
                .forEach(entry -> System.out.println("Key : " + entry.getKey() + " | Value : " + entry.getValue()));

    }
}
