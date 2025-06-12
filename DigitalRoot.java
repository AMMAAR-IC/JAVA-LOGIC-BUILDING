public class DigitalRoot {
    public static int digitalRoot(int n) {
        if (n < 10) return n;
        int sum = 0;
        while (n > 0) {
            sum += n % 10;
            n /= 10;
        }
        return digitalRoot(sum);
    }

    public static void main(String[] args) {
        int num = 9875;
        System.out.println("Digital Root: " + digitalRoot(num));
    }
}
