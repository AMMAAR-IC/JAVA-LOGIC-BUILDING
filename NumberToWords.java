import java.util.Scanner;

public class NumberToWords {
    public static void main(String[] args) {
        String[] ones = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine"};
        String[] tens = {"", "", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
        String[] teens = {"Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen",
                          "Sixteen", "Seventeen", "Eighteen", "Nineteen"};

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number (0-999): ");
        int num = sc.nextInt();

        if (num == 0) {
            System.out.println("Zero");
            return;
        }

        String words = "";

        if (num >= 100) {
            words += ones[num / 100] + " Hundred ";
            num %= 100;
        }

        if (num >= 20) {
            words += tens[num / 10] + " ";
            num %= 10;
        } else if (num >= 10) {
            words += teens[num - 10] + " ";
            num = 0;
        }

        words += ones[num];

        System.out.println("In words: " + words.trim());
    }
}
