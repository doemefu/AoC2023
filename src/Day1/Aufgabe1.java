package Day1;

public class Aufgabe1 {
    public static void main(String[] args) {
        Aufgabe1 main = new Aufgabe1();
        main.run();
    }

    public void run(){
        Filereader filereader = new Filereader();
        Compute1 compute1 = new Compute1();

        System.out.println(compute1.compute(filereader.read()));
    }
}
