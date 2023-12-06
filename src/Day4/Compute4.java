package Day4;

import java.util.ArrayList;
import java.lang.Math;
import java.util.Arrays;

public class Compute4 {

    public double compute(ArrayList<ArrayList<int[]>> inputList) {

        int[] anzKarten = new int[219];
        Arrays.fill(anzKarten, 1);

        double points = 0;

        for(int a = 0; a < inputList.size(); a++){

            ArrayList<int[]> inputValues = inputList.get(a);

            double tempPoints = 0;
            int gefundeneZahlen = 0;

            int[] gewinnZahlen = inputValues.get(0);
            int[] vorhandeneZahlen = inputValues.get(1);

            for (int i = 0; i < gewinnZahlen.length; i++) {
                for (int j = 0; j < vorhandeneZahlen.length; j++) {
                    if (gewinnZahlen[i] == vorhandeneZahlen[j]) {
                        gefundeneZahlen++;
                    }
                }
            }


            System.out.println("gefundenen zahlen" + gefundeneZahlen);
            System.out.println("anzahl karten" + anzKarten[a]);

            for (int b = 1; b <= gefundeneZahlen; b++) {
                anzKarten[a+b]+= anzKarten[a];
            }

            gefundeneZahlen *= anzKarten[a];

            if (gefundeneZahlen == 0) {
                tempPoints = 0;
            }else{
                tempPoints = Math.pow(2, gefundeneZahlen-1);
            }

        }

        for (int number : anzKarten) {
            points += number;
        }

        return points;
    }
}
