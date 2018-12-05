package main.java.inout;
import java.io.*;

//Podczas pisania pojawił sie błąd Try-with-resources are not supported at language level '5'. Trzeba zmienić project settings z 5 na 7.
//Klasa umozliwająca odczyt i zapis text do/z plików.
//Trzeba będzi jeszcze sformatować sposób zapisu do plików danych wpisanych przez użytkownika
public class WriteReadFile {

    public static StringBuilder readFromFile() throws IOException {
        StringBuilder sb = new StringBuilder();
        String line;
        try {
            BufferedReader fileReader = new BufferedReader(new FileReader("E:\\Robocze\\09. JAVA\\09.02 Java Projects\\09.02.01 Szkolenie\\Projekt-kalkulatorpaliw\\src\\main\\test.txt"));
            while ((line = fileReader.readLine()) != null) {
                sb.append(line)
                        .append(";")
                        .append("\n");
            }
            line = fileReader.readLine();
        } catch (FileNotFoundException e) {
            e.getMessage();
        }
        return sb;
    }

    public static void writeToFile(String string) throws IOException {
        try {
            BufferedReader fileReader = new BufferedReader(new FileReader("E:\\Robocze\\09. JAVA\\09.02 Java Projects\\09.02.01 Szkolenie\\Projekt-kalkulatorpaliw\\src\\main\\test.txt"));
        } catch (FileNotFoundException e) {
            e.getMessage();
        }
        try (FileWriter fw = new FileWriter("E:\\Robocze\\09. JAVA\\09.02 Java Projects\\09.02.01 Szkolenie\\Projekt-kalkulatorpaliw\\src\\main\\test.txt", true);
             BufferedWriter bw = new BufferedWriter(fw);
             PrintWriter out = new PrintWriter(bw)) {
            out.print(string + "\n");
        } catch (IOException e) {
            e.getMessage();
        }
    }

    //metoda zwracająca n-tą linię pliku
    public static String readNthLine(String path, int n){
        String line = "";
        try {
            BufferedReader reader = new BufferedReader(new FileReader(path));
            int currentLine = 1;
            while (currentLine<n) {
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
}
