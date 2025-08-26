package org.epicor;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Remove {

    public static Map<String, Long> remove (String str){

        //Preparing Prepositions Set
        Set<String> PREPOSITIONS = Set.of(
                "in", "on", "at", "by", "with", "about", "against", "between",
                "into", "through", "during", "before", "after", "above", "below",
                "to", "from", "up", "down", "over", "under", "again", "off", "near"
        );

        //Preparing Pronoun Set
        Set<String> PRONOUNS = Set.of(
                "i", "you", "he", "she", "it", "we", "they",
                "me", "him", "her", "us", "them", "my", "your",
                "his", "its", "our", "their", "mine", "yours",
                "hers", "ours", "theirs"
        );

        //Preparing Conjuction Set
        Set<String> CONJUNCTIONS = Set.of(
                "and", "or", "but", "because", "so", "although", "though",
                "if", "unless", "while", "whereas", "after", "before", "once",
                "until", "when", "whenever", "as", "than"
        );

        //Preparing Articles Set
        Set<String> ARTICLES = Set.of("a", "an", "the");

        //Preparing Modal Verbs Set
        Set<String> MODAL_VERBS = Set.of(
                "can", "could", "may", "might", "shall", "should",
                "will", "would", "must",
                "can't", "couldn't", "mayn't", "mightn't", "shan't", "shouldn't",
                "won't", "wouldn't", "mustn't",
                "could've", "should've", "would've", "might've", "must've"
        );

        //Preparing Auxiliary Verbs
        Set<String> AUXILIARY_VERBS = Set.of(
                "is", "am", "are", "was", "were", "be", "been", "being",
                "have", "has", "had",
                "do", "does", "did"
        );



        //Converted the String into Streams using Arrays and replacing the digits with no value
        return Arrays.stream(str.replaceAll("\\d","")
                //Replacing the plural postfix “'s” with no value
                        .replaceAll("'s","")
                //Replacing all the values which are not any Alphabetical Letter
                        .replaceAll("[^a-zA-Z\\s]", "")
                //Splitting over space
                        .split("\\s+"))

                //.map(word -> word.replaceAll("(?i)'s$", ""))

                //Filters has been applied.
                .filter(word -> !PREPOSITIONS.contains(word))
                .filter(word -> !MODAL_VERBS.contains(word))
                .filter(word -> !PRONOUNS.contains(word))
                .filter(word -> !CONJUNCTIONS.contains(word))
                .filter(word -> !ARTICLES.contains(word))
                .filter(word -> !AUXILIARY_VERBS.contains(word))
                //Storing the result in HashMap
                .collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
                /*.entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
                        (e1, e2) -> e1, LinkedHashMap::new
                ));*/
    }
}
