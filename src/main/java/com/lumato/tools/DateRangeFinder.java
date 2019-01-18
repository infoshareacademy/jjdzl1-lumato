package com.lumato.tools;

import com.lumato.inout.FilePaths;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class DateRangeFinder {
    public static void dateRangeSelector(String beginning, String end){

        beginning = "3";


    }

    public static void readCSV(String fileName) {
        File file = new File(FilePaths.getUserDir() + fileName);
        int rowCounter = 0;
        try {
            Scanner inputStream = new Scanner(file);
            while (inputStream.hasNextLine()) {
                String data = inputStream.nextLine();
                String[] array = data.split(";"); //Tworzy tablice stringów i dzieli linie w miejscu ';';
                System.out.println(array[0]);
            }
        } catch (FileNotFoundException e) {
            e.getMessage();
            System.out.println("Plik nie istnieje!");
        }
    }
}
