package Day2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class Filereader {

    HashMap<Integer, ArrayList<String>> inputList;

    public HashMap<Integer, ArrayList<String>> read() {

        inputList = new HashMap<>();
        ArrayList<String> inputValues;

        try {
            File myObj = new File("src/Day2/input");
            Scanner myReader = new Scanner(myObj);


            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                int anfang = data.indexOf(":");
                inputValues = new ArrayList<String>();

                int lastAnfang = anfang;
                int index = 0;
                for (int i = anfang; i < data.length(); i++) {

                    if (data.charAt(i) == ',' || data.charAt(i) == ';') {

                        String temp = data.substring(lastAnfang+2, i);
                        inputValues.add(index, temp);

                        lastAnfang = i;
                        index++;
                    }
                }

                String temp = data.substring(lastAnfang+2);
                inputValues.add(index, temp);

                inputList.put(Integer.parseInt(data.substring(5,anfang)), inputValues);
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

    public HashMap<Integer, ArrayList<String>> getInputList() {
        return inputList;
    }


}
