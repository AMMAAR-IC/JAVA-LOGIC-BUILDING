public class DNADoubleHelix {
    public static void main(String[] args) throws InterruptedException {
        String[] helix = {
            "    A       T",
            "   A T     T A",
            "  A   T   T   A",
            " A     T T     A",
            "T      A A      T",
            " T     A A     T",
            "  T   A   A   T",
            "   T A     A T",
            "    T       A"
        };

        while (true) {
            for (String s : helix) {
                System.out.print("\033[H\033[2J");  
                System.out.flush();
                System.out.println(s);
                Thread.sleep(150);
            }
        }
    }
}
