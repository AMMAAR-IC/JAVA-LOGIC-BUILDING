import java.util.*;

interface StockObserver {
    void update(String company, double price);
}

class Stock {
    private final String name;
    private double price;
    private final List<StockObserver> observers = new ArrayList<>();
    private final Random rand = new Random();

    public Stock(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public void addObserver(StockObserver obs) {
        observers.add(obs);
    }

    public void notifyObservers() {
        for (StockObserver obs : observers) {
            obs.update(name, price);
        }
    }

    public void fluctuate() {
        double change = (rand.nextDouble() - 0.5) * 10;
        price = Math.max(1, price + change);
        notifyObservers();
    }
}

class Trader implements StockObserver {
    private final String name;
    private final Map<String, Double> portfolio = new HashMap<>();

    public Trader(String name) {
        this.name = name;
    }

    @Override
    public void update(String company, double price) {
        System.out.println("📈 " + name + " sees " + company + " at " + price);
        if (price < 50) {
            portfolio.put(company, price);
            System.out.println("💰 " + name + " buys " + company);
        }
    }
}

public class StockMarketSimulator {
    public static void main(String[] args) throws InterruptedException {
        Stock apple = new Stock("Apple", 100);
        Stock google = new Stock("Google", 120);

        Trader alice = new Trader("Alice");
        Trader bob = new Trader("Bob");

        apple.addObserver(alice);
        google.addObserver(bob);

        for (int i = 0; i < 10; i++) {
            apple.fluctuate();
            google.fluctuate();
            Thread.sleep(1000);
        }
    }
}
