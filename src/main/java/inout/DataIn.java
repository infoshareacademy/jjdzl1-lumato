package inout;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.Arrays;

public class DataIN {
    public static void(String[] args) {
        int[][][][] dataIn;
        double[] sumKm = new double[];
        double[] sumFuel = new double[];
        double[] sumPrice = new double[];
        double sumaKm = 0;
        double sumaFuel = 0;
        double sumaPrice = 0;


        for (int i = 0; i < dataIn.length; i++) {
            {
                sumaKm += sumKm[i];
            }
            for (int j = 0; j < dataIn.length; j++) {
                {
                    sumaFuel += sumFuel[j];
                }
                for (int k = 0; k < dataIn.length; k++) {
                    {
                        sumaPrice += sumPrice[k];
                    }
                    for (int l = 0; l < dataIn.length; l++) {
                    }
                }
            }
        }

        double avgConsumption = sumaFuel / sumaKm;
        double avgPrice = sumaPrice / sumPrice.length;
        double avgPriceByKm = (avgConsumption * avgPrice) * 100;

        DecimalFormat df = new DecimalFormat("#.##");
        df.setRoundingMode(RoundingMode.CEILING);
        for (Number n : Arrays.asList(avgConsumption, avgPrice, avgPriceByKm)) {

            System.out.println("Witaj");
            System.out.println("W wybranym okresie porzjechałeś w sumie: " + df.format(sumaKm) + "km.");
            System.out.println("Twoje średnie spalanie na 100 km wynosi: " + df.format(avgConsumption) + " l.");
            System.out.println("Średnia cena przejechania 100 km wynosi: " + df.format(avgPriceByKm)+" zł.");
            if (avgPriceByKm * 100 > 15) {
                System.out.println("Twoje spalanie jest powyżej normy spróbuj jeźcić ekonomiczniej.");
            } else {
                System.out.println("Twoje spalanie jest naprawdę eko. Tak trzymaj!");
            }
        }
    }

//niewiem czy to zaokrąglanie działa

