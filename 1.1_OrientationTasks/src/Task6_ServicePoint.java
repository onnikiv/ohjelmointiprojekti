import java.util.LinkedList;

class Customer6 {
    private final int id;
    private static int idCount = 1;
    private final long arrivalTime;

    public Customer6() {
        this.id = idCount++;
        this.arrivalTime = System.currentTimeMillis();
    }

    public int getId() {
        return id;
    }

    public long getArrivalTime() {
        return arrivalTime;
    }
}

class CustomerGenerator6 {
    public static void createCustomer(int amountOfCustomers, Task6_ServicePoint servicePoint) {
        System.out.println("Added: " + amountOfCustomers + " customers to queue.");
        
        for (int i = 1; i <= amountOfCustomers; i++) {
            Customer6 customer = new Customer6();
            servicePoint.addToQueue(customer);
        }
    }
}

public class Task6_ServicePoint {
    private final LinkedList<Customer6> queue = new LinkedList<>();
    private long totalServiceTime = 0;
    
    public void addToQueue(Customer6 customer) {
        queue.addFirst(customer);
    }

    Customer6 removeFromQueue() {
        return queue.removeLast();
    }

    public void serve() {
        int customersServed = 0;

        while (!queue.isEmpty()) {
            Customer6 customer = removeFromQueue();

            int serviceTime = (int) ((Math.random() * 3000) + 1000);
            try {
                Thread.sleep(serviceTime);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            totalServiceTime += serviceTime;
            customersServed++;

            long currentTime = System.currentTimeMillis();
            long responseTime = currentTime - customer.getArrivalTime();

            System.out.println("Customer ID: " + customer.getId() + " served. Time in Queue: " + responseTime / 1000 + "s, Service Time: " + serviceTime / 1000 + "s");
        }

        double averageServiceTime = 0;
        if (customersServed > 0) {
            averageServiceTime = (double) totalServiceTime / customersServed;
        }
        
        System.out.println("All customers served.");
        System.out.println("Average Service Time: " + averageServiceTime / 1000 + " seconds");
    }

    public static void main(String[] args) {
        int runs = 3;
        int customersPerRun = 6;
        
        for (int i = 1; i <= runs; i++) {
            System.out.println("\n--- Run #" + i + " ---");
            Task6_ServicePoint servicePoint = new Task6_ServicePoint();
            CustomerGenerator6.createCustomer(customersPerRun, servicePoint);
            servicePoint.serve();
        }
    }
}