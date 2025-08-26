package org.epicor;

import java.util.HashMap;

public class Count {

    public static void totalCount(HashMap<String, Long> hashMap){
        /*long totalCount = hashMap.values().stream()
                .mapToLong(Long::longValue)
                .sum();
        System.out.println(totalCount);*/

        //Applies Streams on Value's of HashMap, Mapping to Long and calling sum() method to perfprm Addition.
        System.out.println(hashMap.values().stream()
                .mapToLong(Long::longValue)
                .sum());
    }
}
