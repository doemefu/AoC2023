package Day5;

import java.util.ArrayList;
import java.util.Arrays;

public class Compute5 {

    long[] inputZahlen = {1187290020L, 247767461L, 40283135L, 64738286L, 2044483296L, 66221787L, 1777809491L, 103070898L, 108732160L, 261552692L, 3810626561L, 257826205L, 3045614911L, 65672948L, 744199732L, 300163578L, 3438684365L, 82800966L, 2808575117L, 229295075};
    //long[] inputZahlen = {1187290020L, 40283135L, 2044483296L, 1777809491L, 108732160L, 3810626561L, 3045614911L, 744199732L, 3438684365L, 2808575117L};
    long[] outputZahlen = new long[inputZahlen.length];


    ArrayList<long[]> seed_to_soil;
    ArrayList<long[]> soil_to_fertilizer;
    ArrayList<long[]> fertilizer_to_water;
    ArrayList<long[]> water_to_light;
    ArrayList<long[]> light_to_temperature;
    ArrayList<long[]> temperature_to_humidity;
    ArrayList<long[]> humidity_to_location;

    Filereader filereader = new Filereader();

    long minimum = Long.MAX_VALUE;

    public Compute5(){
        seed_to_soil = filereader.read("seed-to-soil");
        soil_to_fertilizer = filereader.read("soil-to-fertilizer");
        fertilizer_to_water = filereader.read("fertilizer-to-water");
        water_to_light = filereader.read("water-to-light");
        light_to_temperature = filereader.read("light-to-temperature");
        temperature_to_humidity = filereader.read("temperature-to-humidity");
        humidity_to_location = filereader.read("humidity-to-location");
    }

//destination, source, range

    public long compute(){
        int c = 0;

/*
        ArrayList<Long> seeds = new ArrayList<>();

        for (int i = 0; i < inputZahlen.length; i+=2) {
            for(int d=1; d<=inputZahlen[i+1]; d++){
                boolean found = false;
                for(long check : seeds){
                    if (check == inputZahlen[i] + d) {
                        found = true;
                        break;
                    }
                }
                if (!found)
                    seeds.add(inputZahlen[i]+d);
            }
        }

        ArrayList<Long> seedsOut = new ArrayList<>();

*/
        for(int q = 0; q < inputZahlen.length; q+=2){


            for(int r = 1; r<=inputZahlen[q+1]; r++){

                long seed = inputZahlen[q] + r;
                //for(long seed : inputZahlen){

                for (long[] seedToSoil : seed_to_soil) {
                    if (seedToSoil[1] <= seed && seedToSoil[1] + seedToSoil[2] > seed) {
                        seed = seedToSoil[0] + (seed - seedToSoil[1]);
                        break;
                    }
                }

                for (long[] soilToFertilizer : soil_to_fertilizer) {
                    if (soilToFertilizer[1] <= seed && soilToFertilizer[1] + soilToFertilizer[2] > seed) {
                        seed = soilToFertilizer[0] + (seed - soilToFertilizer[1]);
                        break;
                    }
                }

                for (long[] fertilizerToWater : fertilizer_to_water) {
                    if (fertilizerToWater[1] <= seed && fertilizerToWater[1] + fertilizerToWater[2] > seed) {
                        seed = fertilizerToWater[0] + (seed - fertilizerToWater[1]);
                        break;
                    }
                }

                for (long[] waterToLight : water_to_light) {
                    if (waterToLight[1] <= seed && waterToLight[1] + waterToLight[2] > seed) {
                        seed = waterToLight[0] + (seed - waterToLight[1]);
                        break;
                    }
                }

                for (long[] lightToTemperature : light_to_temperature) {
                    if (lightToTemperature[1] <= seed && lightToTemperature[1] + lightToTemperature[2] > seed) {
                        seed = lightToTemperature[0] + (seed - lightToTemperature[1]);
                        break;
                    }
                }

                for (long[] temperatureToHumidity : temperature_to_humidity) {
                    if (temperatureToHumidity[1] <= seed && temperatureToHumidity[1] + temperatureToHumidity[2] > seed) {
                        seed = temperatureToHumidity[0] + (seed - temperatureToHumidity[1]);
                        break;
                    }
                }

                for (long[] humidityToLocation : humidity_to_location) {
                    if (humidityToLocation[1] <= seed && humidityToLocation[1] + humidityToLocation[2] > seed) {
                        seed = humidityToLocation[0] + (seed - humidityToLocation[1]);
                        break;
                    }
                }

                if (seed < minimum){
                    minimum = seed;
                }
                //outputZahlen[c] = seed;
                //c++;
                //seedsOut.add(seed);
            }
        }


        //System.out.println(seeds);
        //System.out.println(seedsOut);
/*
        long lowest = Long.MAX_VALUE;

        for (long seed: outputZahlen) {
            if (seed < lowest){
                lowest = seed;
            }
        }
        return lowest;
        */
        return minimum;
    }

}
