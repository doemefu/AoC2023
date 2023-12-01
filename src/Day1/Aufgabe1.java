package Day1;

public class Aufgabe1 {
    public static void main(String[] args) {
        Aufgabe1 main = new Aufgabe1();
        main.run();
    }

    public void run(){
        Filereader filereader = new Filereader();
        Compute compute = new Compute();

        System.out.println(compute.compute(filereader.read()));
    }
}
