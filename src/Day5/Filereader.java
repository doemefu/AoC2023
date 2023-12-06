package Day5;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class Filereader {



    public ArrayList<long[]> read(String filename) {

        ArrayList<long[]> inputValues = null;

        try {
            File myObj = new File("src/Day5/" + filename);
            Scanner myReader = new Scanner(myObj);
            inputValues = new ArrayList<>();


            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();

                long[] map = new long[3];

                String temp1 = "";
                String temp2 = "";
                String temp3 = "";

                int next = 0;

                for(int j=0; j<data.length(); j++) {
                    if (data.charAt(j) == ' '){
                        next = j+1;
                        break;
                    }else{
                        temp1 += data.charAt(j);
                    }
                }

                map[0] = Long.parseLong(temp1);

                for(int j=next; j<data.length(); j++) {
                    if (data.charAt(j) == ' '){
                        next = j+1;
                        break;
                    }else{
                        temp2 += data.charAt(j);

                    }
                }

                map[1] = Long.parseLong(temp2);

                for(int j=next; j<data.length(); j++) {
                    if (data.charAt(j) == ' '){
                        next = j+1;
                        break;
                    }else{
                        temp3 += data.charAt(j);

                    }
                }

                map[2] = Long.parseLong(temp3);

                inputValues.add(map);
            }
            myReader.close();
        } catch (
                FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        System.out.println(inputValues);
        return inputValues;
    }


}
