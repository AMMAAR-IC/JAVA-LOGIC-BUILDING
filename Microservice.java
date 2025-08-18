import java.util.*;
import java.util.concurrent.*;

class Microservice implements Runnable {
    private final String name;
    private volatile boolean running = true;

    public Microservice(String name) {
        this.name = name;
    }

    public void crash() {
        running = false;
        System.out.println("❌ " + name + " has crashed!");
    }

    public boolean isRunning() {
        return running;
    }

    @Override
    public void run() {
        while (true) {
            if (running) {
                System.out.println("✅ " + name + " is running...");
            }
            try {
                Thread.sleep(2000);
            } catch (InterruptedException ignored) {}
        }
    }
}

public class SelfHealingSystem {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newCachedThreadPool();
        List<Microservice> services = new ArrayList<>();

        for (int i = 1; i <= 3; i++) {
            Microservice ms = new Microservice("Service-" + i);
            services.add(ms);
            executor.submit(ms);
        }

        ScheduledExecutorService monitor = Executors.newScheduledThreadPool(1);

        monitor.scheduleAtFixedRate(() -> {
            for (Microservice ms : services) {
                if (!ms.isRunning()) {
                    System.out.println("🛠 Restarting " + ms);
                }
            }
        }, 3, 3, TimeUnit.SECONDS);

        ScheduledExecutorService chaos = Executors.newScheduledThreadPool(1);
        chaos.scheduleAtFixedRate(() -> {
            Microservice ms = services.get(new Random().nextInt(services.size()));
            ms.crash();
        }, 5, 7, TimeUnit.SECONDS);
    }
}
