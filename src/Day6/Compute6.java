package Day6;

public class Compute6 {
    //    long[] time = {59, 68, 82, 74};
    long[] time = {59688274};
    //
    //long[] distance = {543, 1020, 1664, 1022L};
    long[] distance = {543102016641022L};

    public Compute6(){}

    public long compute(){
        long result =1;

        for (int i = 0; i < time.length; i++) {
            long raceTime = time[i];
            long winnerDistance = distance[i];

            long wins =0;

            for (int j = 0; j < raceTime; j++) {
                long raceDistance = j * (raceTime - j);
                if (raceDistance > winnerDistance)
                    wins++;
            }

            result *= wins;

        }

        return result;
    }
}
