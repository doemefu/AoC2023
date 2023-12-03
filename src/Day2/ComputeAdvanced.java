package Day2;

import java.util.ArrayList;
import java.util.HashMap;

public class ComputeAdvanced {

    public int compute(HashMap<Integer, ArrayList<String>> inputList){


        int summe = 0;

        for (int i = 1; i <= inputList.size(); i++) {

            int redMin = 0;
            int greenMin = 0;
            int blueMin = 0;

            ArrayList<String> value = inputList.get(i);
            int zahl=0;

            for(int j = 0; j < value.size(); j++){

                String eintrag = value.get(j);

                zahl = Integer.parseInt(eintrag.substring(0, eintrag.indexOf(" ")));

                if(eintrag.contains("red") && zahl > redMin){
                    redMin = zahl;
                }
                if(eintrag.contains("green") && zahl > greenMin){
                    greenMin = zahl;
                }

                if(eintrag.contains("blue") && zahl > blueMin) {
                    blueMin = zahl;
                }
            }

            summe += redMin * greenMin * blueMin;

        }

        return summe;

    }

}
