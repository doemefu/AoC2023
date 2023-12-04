package Day3;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Filereader {
    public Character[][] read() {

        Character[][] inputList = new Character[140][140];

        try {
            File myObj = new File("src/Day3/input");
            Scanner myReader = new Scanner(myObj);

            for(int i=0; myReader.hasNextLine(); i++) {
                String data = myReader.nextLine();
                for(int j=0; j<data.length(); j++) {
                    inputList[i][j] = data.charAt(j);
                }
                System.out.println(data);
            }

            myReader.close();
        } catch (
                FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        return inputList;
    }
}
