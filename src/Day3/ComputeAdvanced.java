package Day3;

import java.util.ArrayList;
import java.util.Arrays;

import static java.lang.Character.isDigit;

public class ComputeAdvanced {

    Character[] symbols =  {'/', '#', '%', '=', '@', '$', '&', '+', '-', '*'};
    Character[][] input;
    StringBuilder sb;

    public int compute(Character[][] inputMethod){
        this.input = inputMethod;
        int count = 0;

        for(int i=0; i<input.length; i++){
            System.out.println(Arrays.toString(input[i]));

            int number=0;

            for(int j=0; j<input[i].length; j++){

                if(input[i][j] == '*'){
                    ArrayList<Integer> numbers = check2(i, j);
                    System.out.println(numbers);

                    if(numbers.size() == 2) {
                        number += numbers.get(0) * numbers.get(1);
                    }

                }
            }

            System.out.println(number);
            count += number;
            System.out.println(count);
        }
        return count;
    }

    public ArrayList<Integer> check2 (int x, int y){

        ArrayList<Integer> numbers = new ArrayList<>();

        boolean top=false;
        boolean bottom=false;

        try{
            if (isDigit(input[x - 1][y])){
                int zahl = findZahl(x-1, y);
                if (zahl != -1)
                    numbers.add(zahl);
                top = true;
            }
        }catch (ArrayIndexOutOfBoundsException ignored){
        }
        try {
            if (isDigit(input[x - 1][y - 1]) && !top){
                int zahl = findZahl(x-1, y-1);
                if (zahl != -1)
                    numbers.add(zahl);
            }
        }catch (ArrayIndexOutOfBoundsException ignored){
        }
        try{
            if (isDigit(input[x - 1][y + 1])&& !top){
                int zahl = findZahl(x-1, y+1);
                if (zahl != -1)
                    numbers.add(zahl);
            }
        }catch (ArrayIndexOutOfBoundsException ignored){
        }
        try{
            if (isDigit(input[x][y - 1])){
                int zahl = findZahl(x, y-1);
                if (zahl != -1)
                    numbers.add(zahl);
            }
        }catch (ArrayIndexOutOfBoundsException ignored){
        }
        try{
            if (isDigit(input[x][y + 1])){
                int zahl = findZahl(x, y+1);
                if (zahl != -1)
                    numbers.add(zahl);
            }
        }catch (ArrayIndexOutOfBoundsException ignored){
        }

        try{
            if (isDigit(input[x + 1][y])){
                int zahl = findZahl(x + 1, y);
                if (zahl != -1)
                    numbers.add(zahl);
                bottom = true;
            }
        }catch (ArrayIndexOutOfBoundsException ignored){
        }

        try{
            if (isDigit(input[x + 1][y - 1]) && !bottom){
                int zahl = findZahl(x + 1, y - 1);
                if (zahl != -1)
                    numbers.add(zahl);
            }
        }catch (ArrayIndexOutOfBoundsException ignored){
        }

        try{
            if (isDigit(input[x + 1][y + 1]) && !bottom) {
                int zahl = findZahl(x + 1, y + 1);
                if (zahl != -1)
                    numbers.add(zahl);
            }
        }catch (ArrayIndexOutOfBoundsException ignored){
        }
        return numbers;
    }

    public int findZahl(int x, int y) {
        sb = new StringBuilder();
        sb.append(input[x][y]);

        boolean end1 = false;
        boolean end2 = false;

        for (int i = y-1; !end1; --i) {
            try {
                if(isDigit(input[x][i])) {
                    sb.insert(0, input[x][i]);
                }else {
                    end1 = true;
                }
            }catch (ArrayIndexOutOfBoundsException ignored){
                end1 = true;
            }

        }
        for (int i = y+1; !end2; ++i) {
            try {
                if(isDigit(input[x][i])) {
                    sb.append( input[x][i]);
                }else {
                    end2 = true;
                }
            }catch (ArrayIndexOutOfBoundsException ignored){
                end2 = true;
            }        }
        if (sb.isEmpty()){
            return -1;
        }
        return Integer.parseInt(sb.toString());
    }
}
