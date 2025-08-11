import org.bytedeco.javacv.*;
import java.awt.image.BufferedImage;

public class AsciiWebcam {
    static String chars = "@#%*+=-:. ";

    public static void main(String[] args) throws Exception {
        OpenCVFrameGrabber grabber = new OpenCVFrameGrabber(0);
        grabber.start();

        while (true) {
            Frame frame = grabber.grab();
            Java2DFrameConverter conv = new Java2DFrameConverter();
            BufferedImage img = conv.convert(frame);
            if (img == null) continue;

            StringBuilder sb = new StringBuilder();
            for (int y = 0; y < img.getHeight(); y += 8) {
                for (int x = 0; x < img.getWidth(); x += 4) {
                    int rgb = img.getRGB(x, y);
                    int gray = (rgb >> 16 & 0xff) + (rgb >> 8 & 0xff) + (rgb & 0xff);
                    gray /= 3;
                    sb.append(chars.charAt(gray * chars.length() / 256));
                }
                sb.append("\n");
            }
            System.out.print("\033[H\033[2J");
            System.out.flush();
            System.out.println(sb);
        }
    }
}
