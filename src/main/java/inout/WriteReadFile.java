package main.java.inout;
import java.io.*;

//Podczas pisania pojawił sie błąd Try-with-resources are not supported at language level '5'. Trzeba zmienić project settings z 5 na 7.
//Klasa umozliwająca odczyt i zapis text do/z plików.
//Trzeba będzie jeszcze sformatować sposób zapisu do plików danych wpisanych przez użytkownika
public class WriteReadFile {

    //Metoda czyta plik z path podanego jako argument oraz zwraca StringBuilder sb
    public static StringBuilder readFromFile(String filePath) throws IOException {
        StringBuilder sb = new StringBuilder();
        String line;
        try {
            BufferedReader fileReader = new BufferedReader(new FileReader(filePath));
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

    //Metoda dopisuje do pliku, jako argumenty należy podać scieżke do pliku i co chcemy zapisać (czyli UserInput od Łukasza)
    public static void writeToFile(String path, String whatToWrite) throws IOException {
        try {
            BufferedReader fileReader = new BufferedReader(new FileReader(path));
        } catch (FileNotFoundException e) {
            e.getMessage();
        }
        try (FileWriter fw = new FileWriter(path, true);
             BufferedWriter bw = new BufferedWriter(fw);
             PrintWriter out = new PrintWriter(bw)) {
            out.print(whatToWrite + "\n");
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

    //metoda do szybkiego nadpisania pliku
    public static void saveSimpleText(String text, String path) throws IOException {
        FileOutputStream out = new FileOutputStream(path);
        DataOutputStream save = new DataOutputStream(out);
        save.writeBytes(text);
    }
}
