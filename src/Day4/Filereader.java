package Day4;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class Filereader {

    ArrayList<ArrayList<int[]>> inputList;

    //ab index 10 immer 3
    // dann ab 40 " |"
    // ab 42 immer 3 bis 116


    public ArrayList<ArrayList<int[]>> read() {

        inputList = new ArrayList<>();

        ArrayList<int[]> inputValues;



        String temp = "";

        try {
            File myObj = new File("src/Day4/input");
            Scanner myReader = new Scanner(myObj);


            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                int anfang = 9;
                inputValues = new ArrayList<int[]>();
                int[] gewinnZahlen = new int[10];
                int[] vorhandeneZahlen = new int[25];

                for (int i = 0; i < 10 ; i++) {

                    gewinnZahlen[i] = Integer.parseInt(data.substring(anfang, anfang+3).trim());
                    anfang += 3;
                }
                inputValues.add(gewinnZahlen);
                System.out.println(Arrays.toString(gewinnZahlen));

                anfang = 41;
                for (int i = 0; i < 25 ; i++) {

                    vorhandeneZahlen[i] = Integer.parseInt(data.substring(anfang, anfang+3).trim());
                    anfang += 3;
                }
                inputValues.add(vorhandeneZahlen);
                System.out.println(Arrays.toString(vorhandeneZahlen));

                inputList.add(inputValues);
            }
            myReader.close();
        } catch (
                FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        System.out.println(inputList);
        return inputList;
    }


}
