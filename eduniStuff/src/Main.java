import eduni.distributions.*;

public class Main {
    
    public static void main(String[] args) {

        Bernoulli bernoulli = new Bernoulli(0.7);

        // DiscreteGenerator dist = new Poisson(0.5);
        
        for (int i = 0; i < 100; i++) {
        
            System.out.println("Sample: " + bernoulli.sample());
            
        }
    }
    

}

