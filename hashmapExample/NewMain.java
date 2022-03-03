package com.example.optum.javaexercise.hashmapExample;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;

public class NewMain {
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("/Users/admin/Desktop/Joanna Hong/java-exercise/src/main/java/com/example/optum/javaexercise/hashmapExample/Speech.txt");
        HashMap<String, Integer> map = new HashMap<>();
        Scanner readFile = new Scanner(file);
        int wordCount;
        while(readFile.hasNext()) {
            String word = String.valueOf(readFile.next().split("[ .,]"));
            if(map.containsKey(word)){
                wordCount = map.get(word) + 1;
                map.replace(word, wordCount);
            }
            else{
                map.put(word, 1);
            }
        }
        readFile.close();

    }
}
