package task02;


public class AgeDistribution {
    public static void main(String[] args) {
        final int REITERATIONS = 1000;
        final int MAXAGE = 35;

        int agedistribution[][] = {
                {16, 20},  		// 16 %		// This line matches to random numbers 1..16,  gives age 20
                {34, 21},  		// 18 %    	// This line matches to random numbers 17..34, gives age 21
                {52, 22},		// 18 %    	// ...
                {68, 23},    	// 16 %
                {82, 24},  		// 14 %
                {89, 25}, 		// 7 %
                {94, 26},  		// 5 %
                {96, 28},		// 2 %
                {98, 30},  		// 2 %
                {100,MAXAGE}, 	// 2 %	  	// This line matches to random numbers 99 ja 100
        };

        int generatedAges[] = new int[MAXAGE+1];

        // Generate ages according to the distribution:
        for (int i = 1; i <= REITERATIONS; i++){
            int x = (int)(Math.random()*100)+1; 	// generate a random number 1..100 -> we get the row which gives the age
            int j = 0;
            while (x > agedistribution[j][0]) j++;  // search for the correct row to get the matching age
            generatedAges[agedistribution[j][1]]++; // age founded gives an index to the generated ages count table: increment it (by one)
        }

        // Output the result of the generation:
        System.out.println("Age  count     %-share");
        for (int age = 0; age <= MAXAGE; age++) {
            if (generatedAges[age] != 0) {
                String str = "%-4d %-8d %-8.2f\n";
                System.out.printf(str, age, generatedAges[age], ((double)generatedAges[age])/REITERATIONS*100 );
            }
        }
    }
}