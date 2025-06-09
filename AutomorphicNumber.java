public class AutomorphicNumber {
    public static void main(String[] args) {
        int num = 76;  // You can change or take Scanner input
        int square = num * num;

        String numStr = String.valueOf(num);
        String squareStr = String.valueOf(square);

        if (squareStr.endsWith(numStr)) {
            System.out.println(num + " is an Automorphic Number!");
        } else {
            System.out.println(num + " is NOT an Automorphic Number.");
        }
    }
}
