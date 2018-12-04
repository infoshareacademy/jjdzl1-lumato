package main.java.inout;

//klasa do nadpisywania prostych plików tekstowych

import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class TextSaveSimple {

    //pobiera tekst "text" i zapisuje do pliku w ścieżce "path"
    public static void saveSimpleText(String text, String path) throws IOException {
        FileOutputStream out = new FileOutputStream(path);
        DataOutputStream save = new DataOutputStream(out);
        save.writeBytes(text);
    }


}
