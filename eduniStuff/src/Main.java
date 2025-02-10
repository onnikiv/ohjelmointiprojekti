import eduni.distributions.*;
import java.util.ArrayList;

public class Main {
    
    public static void main(String[] args) {

        Bernoulli bernoulli = new Bernoulli(0.69, System.currentTimeMillis());

        // DiscreteGenerator dist = new Poisson(0.5);
        ArrayList<Long> lista =  new ArrayList<>();
        
        for (int i = 0; i < 100; i++) {
            
            if (bernoulli.sample() == 1) {
                lista.add(bernoulli.sample());
                
            }
            // System.out.println("Sample: " + bernoulli.sample());
            
        }
        // pysyvä todennäköisyys, jos lisää just ton seedin, System.currentTimeMillis()
        System.out.println("Todnäk: " + lista.size());
    }
    

}

