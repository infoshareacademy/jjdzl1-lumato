package com.lumato.tools;

public class DataTypeConversion {


    public static Double[] stringBuilderToDouble(StringBuilder sb) {
        String[] stringArray = sb.toString().split(";");
        Double[] output = new Double[stringArray.length];
        for (int i = 0; i < stringArray.length - 1; i++) {
            output[i] = Double.parseDouble(stringArray[i]);
        }
        return output;
    }
}
