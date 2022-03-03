package com.example.optum.javaexercise.hashmapExample;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        File file = new File("/Users/admin/Desktop/Joanna Hong/java-exercise/src/main/java/com/example/optum/javaexercise/hashmapExample/Speech.txt");
        File outputFile = new File("/Users/admin/Desktop/Joanna Hong/java-exercise/src/main/java/com/example/optum/javaexercise/hashmapExample/CountTheWords.txt");
        Scanner scan = null;
        HashMap<String, Integer> map = new HashMap<>();

        try {
            scan = new Scanner(file);
            while (scan.hasNext()) {
                String line = scan.nextLine();
                String[] words = line.split("[., ]");
                for (String w : words) {
                    if (!w.isEmpty()) {
                        if (map.containsKey(w)) {
                            int count = map.get(w);
                            count++;
                            map.put(w, count);
                        } else {
                            map.put(w, 1);
                        }
                    }
                }
            }
            boolean fileExists = outputFile.exists();
            boolean createSuccess = false;

            if (!fileExists) {
                createSuccess = outputFile.createNewFile();
            }
            if (fileExists || createSuccess) {

                FileWriter writer = new FileWriter(outputFile, false);
                map.forEach((k, v) -> {
                    try {
                        writer.write(k + "\t" + v + "\n");
                        System.out.println(k + "\t" + v);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                });
                writer.close();
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            assert scan != null;
            scan.close();
        }
    }
}