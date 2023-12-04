package Day3;

import java.util.Arrays;

public class Aufgabe3 {
    public static void main(String[] args) {
        Aufgabe3 aufgabe3 = new Aufgabe3();
        aufgabe3.run();
    }

    public  void run(){
        Filereader filereader = new Filereader();
        //Compute compute = new Compute();
        ComputeAdvanced computeAD = new ComputeAdvanced();

        Character[][] input = filereader.read();
        System.out.println(computeAD.compute(input));
    }
}
