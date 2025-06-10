import java.util.Scanner;

public class TemperatureConverter {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Temperature Conversion Program");
        System.out.println("-------------------------------");

        while (true) {
            printMenu();
            String choice = scanner.nextLine().toUpperCase();

            if (choice.equals("Q")) {
                System.out.println("Exiting program. Goodbye!");
                break;
            }

            try {
                System.out.print("Enter temperature value: ");
                double temperature = Double.parseDouble(scanner.nextLine());

                switch (choice) {
                    case "1" -> displayConversion(temperature, "Celsius", "Fahrenheit", TemperatureConverter::celsiusToFahrenheit);
                    case "2" -> displayConversion(temperature, "Fahrenheit", "Celsius", TemperatureConverter::fahrenheitToCelsius);
                    case "3" -> displayConversion(temperature, "Celsius", "Kelvin", TemperatureConverter::celsiusToKelvin);
                    case "4" -> displayConversion(temperature, "Kelvin", "Celsius", TemperatureConverter::kelvinToCelsius);
                    default -> System.out.println("Invalid choice! Please select 1-4 or Q.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid temperature! Please enter a numeric value.");
            }
        }
        scanner.close();
    }

    // Conversion methods
    public static double celsiusToFahrenheit(double celsius) {
        return (celsius * 9/5) + 32;
    }

    public static double fahrenheitToCelsius(double fahrenheit) {
        return (fahrenheit - 32) * 5/9;
    }

    public static double celsiusToKelvin(double celsius) {
        return celsius + 273.15;
    }

    public static double kelvinToCelsius(double kelvin) {
        return kelvin - 273.15;
    }

    // Helper methods
    private static void printMenu() {
        System.out.println("\nOptions:");
        System.out.println("1. Celsius to Fahrenheit");
        System.out.println("2. Fahrenheit to Celsius");
        System.out.println("3. Celsius to Kelvin");
        System.out.println("4. Kelvin to Celsius");
        System.out.println("Q. Quit");
        System.out.print("Enter your choice (1-4 or Q): ");
    }

    private static void displayConversion(double value, String fromUnit, String toUnit, Converter converter) {
        double result = converter.convert(value);
        System.out.printf("%.2f° %s = %.2f° %s%n", value, fromUnit, result, toUnit);
    }

    @FunctionalInterface
    private interface Converter {
        double convert(double temperature);
    }
}
