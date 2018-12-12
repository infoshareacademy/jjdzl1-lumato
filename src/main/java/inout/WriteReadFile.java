/*package inout;
import java.io.*;
/*
//Podczas pisania pojawił sie błąd Try-with-resources are not supported at language level '5'. Trzeba zmienić project settings z 5 na 7.
//Klasa umozliwająca odczyt i zapis text do/z plików.
//Trzeba będzi jeszcze sformatować sposób zapisu do plików danych wpisanych przez użytkownika
public class WriteReadFile {

    public static StringBuilder readFromFile() throws IOException {
        StringBuilder sb = new StringBuilder();
        String line;
        try {
            BufferedReader fileReader = new BufferedReader(new FileReader("DataFuel.xlsx"));
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
            BufferedReader fileReader = new BufferedReader(new FileReader("FuelData.xlsx"));
        } catch (FileNotFoundException e) {
            e.getMessage();
        }
        try (FileWriter fw = new FileWriter("FuelData.xlsx", true);
             BufferedWriter bw = new BufferedWriter(fw);
             PrintWriter out = new PrintWriter(bw)) {
            out.print(string + "\n");
        } catch (IOException e) {
            e.getMessage();
        }
    }
}
*/