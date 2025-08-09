public class FakeHack {
    public static void main(String[] args) throws InterruptedException {
        String[] logs = {
            "Connecting to secure server...",
            "Bypassing firewall...",
            "Accessing root privileges...",
            "Downloading classified data...",
            "Transfer complete. System compromised."
        };

        for (String log : logs) {
            for (char c : log.toCharArray()) {
                System.out.print(c);
                Thread.sleep(50);
            }
            System.out.println();
            Thread.sleep(500);
        }

        System.out.print("\nProgress: [");
        for (int i = 0; i < 50; i++) {
            System.out.print("#");
            Thread.sleep(100);
        }
        System.out.println("] 100%");
    }
}
