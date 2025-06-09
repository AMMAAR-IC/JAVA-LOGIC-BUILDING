public class FascinatingNumber {
    public static void main(String[] args) {
        int num = 192;  // You can take this as input from Scanner if needed
        String result = num + "" + (num * 2) + "" + (num * 3);

        if (result.length() != 9) {
            System.out.println(num + " is NOT a Fascinating Number.");
            return;
        }

        boolean[] digits = new boolean[10];  // Index 0-9

        for (char ch : result.toCharArray()) {
            int d = ch - '0';
            if (d == 0 || digits[d]) {
                System.out.println(num + " is NOT a Fascinating Number.");
                return;
            }
            digits[d] = true;
        }

        System.out.println(num + " is a Fascinating Number!");
    }
}
