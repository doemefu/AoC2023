package Day4;

public class Aufgabe4 {
    public static void main(String[] args) {
        Filereader filereader = new Filereader();
        Compute4 computer = new Compute4();
        System.out.println(computer.compute(filereader.read()));
    }
}
