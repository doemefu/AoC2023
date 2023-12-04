package Day3;

import java.util.Arrays;

import static java.lang.Character.isDigit;

public class Compute {

    Character[] symbols =  {'/', '#', '%', '=', '@', '$', '&', '+', '-', '*'};
    Character[][] input;

    public int compute(Character[][] inputMethod){
        this.input = inputMethod;
        int count = 0;

        for(int i=0; i<input.length; i++){

            int number=0;
            String tempString = "";

            for(int j=0; j<input[i].length; j++){

                if(isDigit(input[i][j])){
                    tempString = tempString + input[i][j];
                }else{
                    int length = tempString.length();

                    if (length != 0){
                        for(int k=0; k<length; k++){
                            if (check2(i, j-length+k)){
                                number += Integer.parseInt(tempString);
                                break;
                            }
                        }
                    }

                    tempString = "";
                }
            }

            if(!tempString.isEmpty()){
                int length = tempString.length();
                for(int k=0; k<length; k++){
                    if (check2(i, input[i].length-length+k)){
                        number += Integer.parseInt(tempString);
                        break;
                    }
                }
            }

            System.out.println(Arrays.toString(input[i]));
            System.out.println(number);
            count += number;
            System.out.println(count);
        }
        return count;
    }

    public boolean check2 (int x, int y){
        try {
            if (check(input[x - 1][y - 1]))
                return true;
        }catch (ArrayIndexOutOfBoundsException ignored){
        }
        try{
            if (check(input[x - 1][y]))
                return true;
        }catch (ArrayIndexOutOfBoundsException ignored){
        }
        try{
            if (check(input[x - 1][y + 1]))
                return true;
        }catch (ArrayIndexOutOfBoundsException ignored){
        }
        try{
            if (check(input[x][y - 1]))
                return true;
        }catch (ArrayIndexOutOfBoundsException ignored){
        }
        try{
            if (check(input[x][y + 1]))
                return true;
        }catch (ArrayIndexOutOfBoundsException ignored){
        }
        try{
            if (check(input[x + 1][y - 1]))
                return true;
        }catch (ArrayIndexOutOfBoundsException ignored){
        }
        try{
            if (check(input[x + 1][y]))
                return true;
        }catch (ArrayIndexOutOfBoundsException ignored){
        }
        try{
            if (check(input[x + 1][y + 1]))
                return true;
        }catch (ArrayIndexOutOfBoundsException ignored){
        }
        return false;
    }

    public boolean check(char toCheck) {
        for (char c : symbols) {
            if (c == toCheck) {
                return true;
            }
        }
        return false;
    }


}
