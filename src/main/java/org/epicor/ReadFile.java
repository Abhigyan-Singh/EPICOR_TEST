package org.epicor;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

public class ReadFile {

    public static StringBuilder readTextFileFromURL(String urlString) {
        StringBuilder content = new StringBuilder();
        try {
            //Creating URL
            URL url = new URL(urlString);

            // Using Try-with-Resource so that later we don't have to close the connection manually.
            try (BufferedReader reader = new BufferedReader(
                    new InputStreamReader(url.openStream()))) {
                //Reading the lines and appending to the StringBuilder.
                reader.lines().forEach(line -> content.append(line).append("\n"));
            }
        } catch (IOException e) {
            System.out.println(e);
        }
        return content;
    }

}
