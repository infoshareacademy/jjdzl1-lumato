package com.lumato.tools;

public class DataTypeConversion {


    public static Double[] stringBuilderToDouble(StringBuilder sb) {
        String[] stringArray = sb.toString().split(";");
        Double[] output = new Double[stringArray.length];
        for (double item : output) {
            output[item] = Double.parseDouble(stringArray[item]);
        }
        return output;
    }
}
