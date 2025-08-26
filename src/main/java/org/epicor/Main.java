package org.epicor;

import java.util.HashMap;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        int number = 5;
        String fileUrl = "https://courses.cs.washington.edu/courses/cse390c/22sp/lectures/moby.txt";
        //Calling the methods to read the file from given URL and its returning String and converting to Lower Case.
        String str = ReadFile.readTextFileFromURL(fileUrl).toString().toLowerCase();

        //Calling remove() to remove the unwanted words and Casting from Map to HashMap and storing the value for further use.
        HashMap<String, Long> strAfterUnwantedWordsRemove = (HashMap<String, Long>) Remove.remove(str);

        Count.totalCount(strAfterUnwantedWordsRemove);

        TopNWordUsage.findTopNWord(strAfterUnwantedWordsRemove,number);

        SortedWords.sortedWords(strAfterUnwantedWordsRemove);

    }

}