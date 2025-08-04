import java.io.IOException;
import java.nio.file.*;

public class FolderWatcher {
    public static void main(String[] args) throws IOException, InterruptedException {
        WatchService watchService = FileSystems.getDefault().newWatchService();
        Path path = Paths.get("."); // Current directory

        path.register(watchService, StandardWatchEventKinds.ENTRY_CREATE,
                                     StandardWatchEventKinds.ENTRY_DELETE);

        System.out.println("Watching folder: " + path.toAbsolutePath());

        while (true) {
            WatchKey key = watchService.take();
            for (WatchEvent<?> event : key.pollEvents()) {
                System.out.println("[" + event.kind() + "] " + event.context());
            }
            key.reset();
        }
    }
}
