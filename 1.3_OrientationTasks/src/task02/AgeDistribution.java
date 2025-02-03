package task02;
import java.util.HashMap;
import java.util.Random;

public class AgeDistribution {
    public static void main(String[] args) {
        // Ryhmänkoko 30, iät 18-35 välillä
        int testiPorukkaKoko = 30;
        int testiPorukka[][] = {
        // ikä, määrä
            {20, 3},    // 3        0. 3/30 = 10 %
            {21, 6},    // 6+3      1. 6/30 = 20 %
            {23, 4},    // 9+4      2. 4/30 = 13.33 %
            {24, 3},    // 13+3     3. 3/30 = 10 %
            {25, 1},    // 16+1     4. 1/30 = 3.33 %
            {26, 3},    // 17+3     5. 3/30 = 10 %
            {27, 5},    // 20+5     6. 5/30 = 16.67 %
            {28, 2},    // 25+2     7. 2/30 = 6.67 %
            {29, 3},    // 27+3     8. 3/30 = 10 %
                        // = 30 
        };

        int numSimulations = 1000;  // Simuloitavien arvojen määrä
        int[] simulatedAges = new int[numSimulations];

        // Luodaan kumulatiivinen jakauma (kumulatiivinen todennäköisyys)
        double[] cumulative = new double[testiPorukka.length];
        cumulative[0] = (double) testiPorukka[0][1] / testiPorukkaKoko;
        for (int i = 1; i < testiPorukka.length; i++) {
            cumulative[i] = cumulative[i - 1] + (double) testiPorukka[i][1] / testiPorukkaKoko;
        }

        // Satunnaislukugeneraattori
        Random rand = new Random();

        // Simuloidaan 1000 arvoa
        for (int i = 0; i < numSimulations; i++) {
            double r = rand.nextDouble();  // Satunnaisluku välillä [0,1)
            for (int j = 0; j < cumulative.length; j++) {
                if (r <= cumulative[j]) {
                    simulatedAges[i] = testiPorukka[j][0];  // Asetetaan ikä simulointitaulukkoon
                    break;
                }
            }
        }

        // Lasketaan kuinka monta kertaa kukin ikä esiintyy simuloidussa datassa
        HashMap<Integer, Integer> ageCounts = new HashMap<>();
        for (int age : simulatedAges) {
            ageCounts.put(age, ageCounts.getOrDefault(age, 0) + 1);
        }

        // Tulostetaan yhteenveto: ikäluokka, kuinka monta kertaa esiintyi ja prosenttiosuus
        System.out.println("Ikäjakauma simuloiduissa arvoissa:");
        int totalSimulated = 0;
        for (int[] ageGroup : testiPorukka) {
            int age = ageGroup[0];
            int count = ageCounts.getOrDefault(age, 0);
            double percentage = (double) count / numSimulations * 100;
            System.out.printf("Ikä: %d, Määrä: %d, Osuus: %.2f%%\n", age, count, percentage);
            totalSimulated += count;
        }

        // Varmistetaan, että lukuja on täsmälleen 1000
        System.out.println("\nTarkistus: Simuloitujen arvojen kokonaismäärä = " + totalSimulated);
    }
}
