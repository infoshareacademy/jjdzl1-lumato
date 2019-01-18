package com.lumato.inout;

import java.io.*;
import java.util.Scanner;

public class WriteReadFile {

    /** get n-th line of file as String */
    public static void writeText(String whatToWrite, boolean toAppned, String fileName) {
        try {
            FileWriter pw = new FileWriter(FilePaths.getUserDir() + fileName, toAppned); // zmienić ściezkę do pliku, obecnie plik txt
            StringBuilder sb = new StringBuilder();
            //jeśli plik istnieje lub jest pusty to nie dodajemy nowej linii
            if (!isFileEmptyOrNonExisting(FilePaths.getUserDir() + fileName)) {
                sb.append("\n");
            }
            sb.append(whatToWrite);
            pw.write(sb.toString());
            pw.close();
        } catch (IOException e) {
            e.getMessage();
        }
    }

    //Metoda czyta plik i zwraca StringBuilder sb.
    public static StringBuilder readFromFile() throws IOException {
        StringBuilder sb = new StringBuilder();
        String line;
        try {
            BufferedReader fileReader = new BufferedReader(new FileReader(FilePaths.getUserDir()));
            while ((line = fileReader.readLine()) != null) {
                sb.append(line);
            }
            line = fileReader.readLine();
        } catch (FileNotFoundException e) {
            e.getMessage();
        }
        return sb;
    }

    public static String readNthLine(String path, int n) {
        String line = "";
        if (n <= 0) return "";
        try {
            BufferedReader reader = new BufferedReader(new FileReader(path));
            int currentLine = 1;
            while (currentLine < n) {
                reader.readLine();
                currentLine++;
            }
            line = reader.readLine();
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return line;
    }

    //Metoda czytające dane z poszczególnej kolumny
    public static void readCSV(int columnToPrint, String fileName) {
        File file = new File(FilePaths.getUserDir() + fileName);
        try {
            Scanner inputStream = new Scanner(file);
            inputStream.nextLine(); //Ignoruje pierwszą linię np hagłówek)

            while (inputStream.hasNextLine()) {
                String data = inputStream.nextLine();
                String[] array = data.split(";"); //Tworzy tablice stringów i dzieli linie w miejscu ';';
                System.out.println(array[columnToPrint]);
            }
        } catch (FileNotFoundException e) {
            e.getMessage();
            System.out.println("Plik nie istnieje!");
        }
    }

    //Metoda czytajaca kolumny z podanego zakresu.
    public static void readCSVinRange(String fileName, int columnToPrint, int beginning, int end) {
        StringBuilder sb = new StringBuilder();
        int lineCounter = 0;
        File file = new File(FilePaths.getUserDir() + fileName);
        try {
            Scanner inputStream = new Scanner(file);
            for (int i = 0; i < beginning - 1; i++) {
                inputStream.nextLine();
                lineCounter++;
            }
            while (inputStream.hasNextLine() && lineCounter != end) {
                String data = inputStream.nextLine();
                String[] array = data.split(";"); //Tworzy tablice stringów i dzieli linie w miejscu ';';
//                System.out.println(array[columnToPrint]);
                sb.append(array[columnToPrint]).append(";");
                lineCounter++;
            }
        } catch (FileNotFoundException e) {
            e.getMessage();
            System.out.println("Plik nie istnieje!");
        }
    }

    /** fast data save to file (does NOT append! erases current file if exists) */
    public static void saveSimpleText(String text, String path) throws IOException {
        try {
            FileOutputStream out = new FileOutputStream(path);
            DataOutputStream save = new DataOutputStream(out);
            save.writeBytes(text);
            save.close();
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static boolean isFileEmptyOrNonExisting(String path) {
        File file = new File(path);
        if (!file.exists()) return true;
        if (file.length() == 0) return true;
        return false;
    }
}