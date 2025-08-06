import javax.sound.sampled.*;

public class ToneGenerator {
    public static void main(String[] args) throws LineUnavailableException {
        int sampleRate = 44100;
        byte[] buf = new byte[1];
        AudioFormat af = new AudioFormat(sampleRate, 8, 1, true, false);
        SourceDataLine sdl = AudioSystem.getSourceDataLine(af);
        sdl.open(af);
        sdl.start();

        double freq = 440; // A4 tone
        for (int i = 0; i < sampleRate * 2; i++) { // 2 seconds
            double angle = i / ((double) sampleRate / freq) * 2.0 * Math.PI;
            buf[0] = (byte) (Math.sin(angle) * 127);
            sdl.write(buf, 0, 1);
        }
        sdl.drain();
        sdl.stop();
        sdl.close();
    }
}
