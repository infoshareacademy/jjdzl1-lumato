package appnavigation.login;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

public class Encoding {

    //proste szyfrowanie hasła
    public static String encodeMD5(String text) throws UnsupportedEncodingException, NoSuchAlgorithmException {
        byte[] bytesOfMessage = text.getBytes("UTF-8");
        MessageDigest md = MessageDigest.getInstance("MD5");
        byte[] thedigest = md.digest(bytesOfMessage);
        text = Arrays.toString(thedigest);
        text = text.replaceAll("[, \\]\\[]", "");
        return text; //returns encoded text
    }
}
