import java.util.*;

class Customer {
    int id, arrivalTime, serviceTime;
    Customer(int id, int arrival, int service) {
        this.id = id;
        this.arrivalTime = arrival;
        this.serviceTime = service;
    }
}

public class BankSimulator {
    public static void main(String[] args) {
        Queue<Customer> queue = new LinkedList<>();
        int currentTime = 0, served = 0;

        for (int i = 1; i <= 5; i++) {
            int arrival = currentTime + (int)(Math.random() * 5 + 1);
            int service = (int)(Math.random() * 4 + 1);
            queue.add(new Customer(i, arrival, service));
        }

        while (!queue.isEmpty()) {
            Customer c = queue.poll();
            currentTime = Math.max(currentTime, c.arrivalTime);
            System.out.println("Serving customer " + c.id + " at time " + currentTime);
            currentTime += c.serviceTime;
            served++;
        }

        System.out.println("Total served: " + served);
    }
}
