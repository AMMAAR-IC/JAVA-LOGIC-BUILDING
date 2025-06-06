import java.util.Scanner;

public class ArmstrongCheck {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter a number: ");
        int num = sc.nextInt();
        int originalNum = num;
        int result = 0;

        // Count number of digits
        int n = 0;
        int temp = num;
        while (temp > 0) {
            temp /= 10;
            n++;
        }

        temp = num;
        while (temp > 0) {
            int digit = temp % 10;
            result += Math.pow(digit, n);
            temp /= 10;
        }

        if (result == originalNum) {
            System.out.println(originalNum + " is an Armstrong number.");
        } else {
            System.out.println(originalNum + " is NOT an Armstrong number.");
        }

        sc.close();
    }
}
