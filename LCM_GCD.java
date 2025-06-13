public class LCM_GCD {
    public static int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    public static int lcm(int a, int b) {
        return (a * b) / gcd(a, b);
    }

    public static void main(String[] args) {
        System.out.println("GCD: " + gcd(24, 36));
        System.out.println("LCM: " + lcm(24, 36));
    }
} 
