class DownloadThread extends Thread {
    private int start, end, id;

    public DownloadThread(int id, int start, int end) {
        this.id = id;
        this.start = start;
        this.end = end;
    }

    public void run() {
        for (int i = start; i <= end; i++) {
            System.out.println("Thread " + id + " downloading byte " + i);
            try { Thread.sleep(10); } catch (InterruptedException e) {}
        }
    }
}

public class MultiThreadDownloader {
    public static void main(String[] args) {
        int totalSize = 100;
        int threads = 4;
        int chunk = totalSize / threads;

        for (int i = 0; i < threads; i++) {
            int start = i * chunk;
            int end = (i == threads - 1) ? totalSize - 1 : (start + chunk - 1);
            new DownloadThread(i + 1, start, end).start();
        }
    }
}
