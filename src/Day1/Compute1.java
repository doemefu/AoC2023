package Day1;

import java.util.List;

import static java.lang.Character.isDigit;

public class Compute1 {
    public int compute(List<String> inputFile){
        int summe = 0;

        StringBuilder sb2;

        for (String line : inputFile) {

            sb2 = new StringBuilder();

            boolean found1 = false;
            int number1 = 0;

            String numberWord1 = "";

            String zahl = "";

            for(int i = 0; i < line.length() && !found1; i++){


                char c = line.charAt(i);
                if(isDigit(c)){
                    found1 = true;
                    zahl += c;
                }else {
                    numberWord1 += line.charAt(i);

                    if (checkWord2(numberWord1) != -1){
                        found1 = true;
                        number1 = checkWord2(numberWord1);
                        zahl += number1;
                    }
                }
            }

            boolean found2 = false;
            int number2 =0;
            String numberWord2 = "";


            for(int j = line.length()-1; j >= 0 && !found2; j--){
                char d = line.charAt(j);
                if(isDigit(d)){
                    found2 = true;
                    zahl += d;
                }else{

                    sb2.insert(0, line.charAt(j));

                    if(checkWord2(sb2.toString()) != -1){
                        found2 = true;
                        number2 = checkWord2(sb2.toString());
                        zahl += number2;
                    }
                }
            }

            //int number = (number1*10) + number2;
            //System.out.println(number1);
            //System.out.println(number2);
            //System.out.println(number);
            System.out.println(zahl);

            int number = Integer.parseInt(zahl);

            summe += number;
        }


        return summe;
    }


    public int checkWord2(String word){
        if (word.contains("one")){
            return 1;
        }else if (word.contains("two")){
            return 2;
        } else if (word.contains("three")){
            return 3;
        } else if (word.contains("four")){
            return 4;
        } else if (word.contains("five")){
            return 5;
        } else if (word.contains("six")){
            return 6;
        } else if (word.contains("seven")){
            return 7;
        } else if (word.contains("eight")){
            return 8;
        } else if (word.contains("nine")){
            return 9;
        } else if (word.contains("zero")){
            return 0;
        } else {
            return -1;
        }
    }
}
