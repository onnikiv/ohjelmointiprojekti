public class Customer {
    private int id;
    private long startTime;
    private long endTime;
    private static int idCount = 1;

    public Customer() {
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
        Customer customer = new Customer();
        Customer customer2 = new Customer();

        customer.setStartTime(123);
        customer.setEndTime(654);
        customer2.setStartTime(0);
        customer2.setEndTime(599);

        System.out.println("Asiakas id: " + customer.getId() + ", kulutettu aika palvelussa: " + customer.calculateTime() + " ms.");
        System.out.println("Asiakas id: " + customer2.getId() + ", kulutettu aika palvelussa: " + customer2.calculateTime() + " ms.");

    }
}