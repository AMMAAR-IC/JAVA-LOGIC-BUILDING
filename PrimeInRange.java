public class PrimeInRange {
    public static void printPrimes(int start, int end) {
        for (int i = start; i <= end; i++) {
            if (PrimeCheck.isPrime(i)) System.out.print(i + " ");
        }
    }

    public static void main(String[] args) {
        printPrimes(10, 50);
    }
}
