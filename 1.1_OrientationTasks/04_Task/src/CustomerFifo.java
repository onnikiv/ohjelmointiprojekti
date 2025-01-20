import java.util.LinkedList;
import java.util.Scanner;

public class CustomerFifo {
    private int id;
    private long startTime;
    private long endTime;
    private static int idCount = 1;

    public CustomerFifo() {
        setId(idCount);
        idCount++;
    }

    public int getId() {
        return id;
    }
    private void setId(int id) {
        if (id > 0) { // varmistus että id on suurempi kuin 0
            this.id = id;
        } else {
            System.out.println("Id:n pitää olla suurempi kuin 0!");
        }
    }

    public long getStartTime() {
        return startTime;
    }
    public void setStartTime(long start) {
        startTime = start;
    }
    public long getEndTime() {
        return endTime;
    }
    public void setEndTime(long end) {
        endTime = end;
    }
    public long calculateTime() {
        if (endTime >= startTime) {
            return endTime - startTime;
        } else {
            System.out.println("End time must be greater than or equal to start time.");
            return 0;
        }
    }

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            LinkedList<CustomerFifo> queue = new LinkedList<>();
            boolean ongoing = true;
            System.out.println("\nEnter:");
            System.out.println("0 to Exit");
            System.out.println("1 to Add customer to queue");
            System.out.println("2 to Remove the first customer from queue\n"); 
            
            while (ongoing) {
                
                int command = scanner.nextInt();
                switch (command) {
                    case 0 -> {
                        ongoing = false;
                        System.out.println("Goodbye!\n");
                        
                    }
                    case 1 -> {
                        CustomerFifo customer = new CustomerFifo();
                        customer.setStartTime(System.currentTimeMillis());
                        queue.addFirst(customer);
                        System.out.println("Customer added - Id: " + customer.getId());
                        System.out.println(" ".repeat(40) + "(In queue: " + queue.size() + ")");
                    }
                    
                    case 2 -> {
                        if (!queue.isEmpty()) {
                            CustomerFifo customer = queue.removeLast();
                            customer.setEndTime(System.currentTimeMillis());
                            System.out.print("Customer removed - ");
                            System.out.println("Id: " + customer.getId() + " - Time spent: " + customer.calculateTime()/1000 + "s.");
                            System.out.println(" ".repeat(40) + "(In queue: " + queue.size() + ")");
                            
                        } else {System.out.println("No customers to remove!");}
                    }
                }
            } 
        }
    }
}