import java.io.InputStream;
import java.net.URL;

public class SpeedTest {
    public static void main(String[] args) throws Exception {
        String fileUrl = "https://speed.hetzner.de/100MB.bin"; // test file
        System.out.println("Testing download speed...");

        long start = System.nanoTime();
        InputStream in = new URL(fileUrl).openStream();
        byte[] buffer = new byte[8192];
        long total = 0;
        int bytesRead;
        while ((bytesRead = in.read(buffer)) != -1) {
            total += bytesRead;
        }
        in.close();

        long end = System.nanoTime();
        double seconds = (end - start) / 1e9;
        double mbps = (total / 1024.0 / 1024.0) / seconds;
        System.out.printf("Download speed: %.2f MB/s%n", mbps);
    }
}
