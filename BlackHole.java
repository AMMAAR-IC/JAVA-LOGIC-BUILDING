public class BlackHole {
    public static void main(String[] args) throws Exception {
        int size = 20;
        while (true) {
            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    double val = Math.sin(i*0.3) + Math.cos(j*0.3);
                    System.out.print(val > 0 ? "@" : " ");
                }
                System.out.println();
            }
            Thread.sleep(200);
        }
    }
}
