package task02;

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
        
        System.out.println((int)(Math.random()*35) +1);
        
    }
}