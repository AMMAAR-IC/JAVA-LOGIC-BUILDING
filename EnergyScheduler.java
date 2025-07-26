import java.util.*;

public class EnergyScheduler {
    public static void main(String[] args) {
        int energy = 100;
        Task[] tasks = {
            new Task("Math Assignment", 30),
            new Task("Code Debugging", 50),
            new Task("Emails", 10),
            new Task("UI Design", 40),
        };

        Arrays.sort(tasks, Comparator.comparingInt(t -> t.energyCost));
        List<String> schedule = new ArrayList<>();

        for (Task t : tasks) {
            if (energy >= t.energyCost) {
                schedule.add(t.name);
                energy -= t.energyCost;
            }
        }

        System.out.println("Scheduled tasks: " + schedule);
    }

    static class Task {
        String name;
        int energyCost;
        Task(String name, int cost) {
            this.name = name;
            this.energyCost = cost;
        }
    }
}
