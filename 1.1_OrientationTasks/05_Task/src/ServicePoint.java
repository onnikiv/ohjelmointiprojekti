import java.util.LinkedList;
import java.util.Scanner;


class Customer {
    private int id;
    private static int idCount = 1321;
    private long arrivalTime;

    public Customer() {
        this.id = idCount++;
        this.arrivalTime = System.currentTimeMillis();}

    public int getId() {
        return id;}

    public long getArrivalTime() {
        return arrivalTime;
    }
}


class CustomerGenerator {
    public static void createCustomer(int amountOfCustomers, ServicePoint servicePoint) {
        System.out.println("Added: " + amountOfCustomers + " customers.");
        for (int i = 1; i <= amountOfCustomers; i++) {
            Customer customer = new Customer();
            servicePoint.addtoQueue(customer);
            System.out.println("New customer added, ID: " + customer.getId() + "   ("+i+")");
        }
    }
}


public class ServicePoint {
    private LinkedList<Customer> queue = new LinkedList<>();
    
    public void addtoQueue(Customer customer) {
        queue.addFirst(customer);
        System.out.println(customer.getId()+" lisätty queen");}

    Customer removeFromQueue() {
        return queue.removeLast();
    }

    public void serve() {
        Customer customer = removeFromQueue();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the amount of customers to serve: ");
        int amountOfCustomers = scanner.nextInt();

        ServicePoint servicePoint = new ServicePoint();
        CustomerGenerator.createCustomer(amountOfCustomers, servicePoint);

    }
}
