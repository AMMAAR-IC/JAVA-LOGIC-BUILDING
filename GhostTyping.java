public class GhostTyping {
    public static void main(String[] args) throws Exception {
        String msg = "The computer is alive...";
        for (char c : msg.toCharArray()) {
            System.out.print(c);
            Thread.sleep(150 + (int)(Math.random()*200));
        }
    }
}
