public class DisariumNumber {
    public static void main(String[] args) {
        int num = 135;  // You can replace with user input via Scanner
        int original = num;
        int length = String.valueOf(num).length();

        int sum = 0;
        int temp = num;

        while (temp > 0) {
            int digit = temp % 10;
            sum += Math.pow(digit, length--);
            temp /= 10;
        }

        if (sum == original)
            System.out.println(original + " is a Disarium Number!");
        else
            System.out.println(original + " is NOT a Disarium Number.");
    }
}
