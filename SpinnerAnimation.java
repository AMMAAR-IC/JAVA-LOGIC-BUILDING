public class SpinnerAnimation {
    static char[] frames = {'|', '/', '-', '\\'};

    public static void spin(int cycles) throws InterruptedException {
        if (cycles == 0) return;
        for (char c : frames) {
            System.out.print("\r" + c);
            Thread.sleep(100);
        }
        spin(cycles - 1);
    }

    public static void main(String[] args) throws InterruptedException {
        System.out.println("Loading...");
        spin(50);
        System.out.println("\rDone!");
    }
}
