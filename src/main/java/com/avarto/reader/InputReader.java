package com.avarto.reader;
/**
 * Read imputs from input.txt in same package
 */

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class InputReader {
    /**
     * Staitc method to read file and skill first line
     * @return List of string
     */
    public static List<String> readInput() {

        BufferedReader reader;
        List<String> inputList = new ArrayList<>();
        try {
            InputStream is = InputReader.class.getResourceAsStream("input.txt");
            reader = new BufferedReader(new InputStreamReader(is));
            String line = reader.readLine();
            while (line != null) {
                line = reader.readLine();
                if(line!=null)
                    inputList.add(line);
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return inputList;
    }
}
