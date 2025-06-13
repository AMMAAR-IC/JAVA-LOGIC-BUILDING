public class NumberToWords {
    static final String[] words = {"Zero","One","Two","Three","Four","Five","Six","Seven","Eight","Nine"};

    public static void printWords(int num) {
        String str = String.valueOf(num);
        for (char c : str.toCharArray())
            System.out.print(words[c - '0'] + " ");
    }

    public static void main(String[] args) {
        printWords(123); // One Two Three
    }
}
