package Day2;

import Day2.Filereader;

public class Aufgabe2 {
    public static void main(String[] args) {
        Aufgabe2 main = new Aufgabe2();
        main.run();
    }

    public void run(){
        Filereader filereader = new Filereader();
        //Compute compute = new Compute();
        ComputeAdvanced computeAdvanced = new ComputeAdvanced();

        //int zahl = compute.compute(filereader.read());
        int zahl2 = computeAdvanced.compute(filereader.read());

        System.out.println(zahl2);
    }
}