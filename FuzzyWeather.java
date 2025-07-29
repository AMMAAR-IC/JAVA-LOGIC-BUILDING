import java.util.*;

public class FuzzyWeather {
    public static void main(String[] args) {
        predictComfort(35); // Hot
        predictComfort(24); // Warm
        predictComfort(10); // Cold
    }

    static void predictComfort(double temp) {
        double cold = Math.max(0, Math.min(1, (20 - temp) / 10));
        double warm = 1 - Math.abs((25 - temp) / 10.0);
        double hot = Math.max(0, Math.min(1, (temp - 25) / 10));

        String result;
        if (cold > warm && cold > hot) result = "Too Cold ❄️";
        else if (hot > cold && hot > warm) result = "Too Hot 🔥";
        else result = "Comfortable 😊";

        System.out.printf("Temp: %.1f°C -> Cold: %.2f, Warm: %.2f, Hot: %.2f → %s\n",
                temp, cold, warm, hot, result);
    }
}
