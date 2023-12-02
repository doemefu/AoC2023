package Day2;

import java.util.ArrayList;
import java.util.HashMap;

public class Compute {

    public int compute(HashMap<Integer, ArrayList<String>> inputList){
        int redMax = 12;
        int greenMax = 13;
        int blueMax = 14;

        int summe = 0;

        boolean overflow;

        for (int i = 1; i <= inputList.size(); i++) {
            overflow = false;

            ArrayList<String> value = inputList.get(i);
            int zahl=0;

            for(int j = 0; j < value.size(); j++){

                String eintrag = value.get(j);

                zahl = Integer.parseInt(eintrag.substring(0, eintrag.indexOf(" ")));

                if(eintrag.contains("red") && zahl > redMax){
                    overflow = true;
                    System.out.println(value);
                    System.out.println("red");
                    break;
                }
                if(eintrag.contains("green") && zahl > greenMax){
                    overflow = true;
                    System.out.println(value);
                    System.out.println("green");
                    break;
                }

                if(eintrag.contains("blue") && zahl > blueMax) {
                    overflow = true;
                    System.out.println(value);
                    System.out.println("blue");
                    break;
                }
            }

            if(!overflow){
                summe += i;
            }
        }

        return summe;

    }

}
