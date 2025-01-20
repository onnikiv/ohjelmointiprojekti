import java.util.LinkedList;
import java.util.Scanner;

class Customer {
    private final int id;
    private static int idCount = 1;
    private final long arrivalTime;

    public Customer() {
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

class CustomerGenerator {
    public static void createCustomer(int amountOfCustomers, Task6_ServicePoint servicePoint) {
        System.out.println("Added: " + amountOfCustomers + " customers to queue.");
        
        for (int i = 1; i <= amountOfCustomers; i++) {
            Customer customer = new Customer();
            servicePoint.addToQueue(customer);
        }
    }
}

public class Task6_ServicePoint {
    private final LinkedList<Customer> queue = new LinkedList<>();
    
    public void addToQueue(Customer customer) {
        queue.addFirst(customer);
    }

    Customer removeFromQueue() {
        return queue.removeLast();
    }

    public void serve() {
        while (!queue.isEmpty()) {
            Customer customer = removeFromQueue();

            int serviceTime = (int) ((Math.random() * 3000) + 1000);
            try {
                Thread.sleep(serviceTime);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            long currentTime = System.currentTimeMillis();
            long responseTime = currentTime - customer.getArrivalTime();

            System.out.println("Customer ID: " + customer.getId() + " served. Time in Queue: " + responseTime / 1000 + "s, Service Time: " + serviceTime / 1000 + "s");
        }

        System.out.println("All customers served.");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the amount of customers to serve: ");
        int amountOfCustomersToAdd = scanner.nextInt();

        Task6_ServicePoint servicePoint = new Task6_ServicePoint();
        CustomerGenerator.createCustomer(amountOfCustomersToAdd, servicePoint);

        System.out.println("Total customers in queue: " + servicePoint.queue.size());

        servicePoint.serve();
        scanner.close();
    }
}
