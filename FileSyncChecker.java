import java.io.File;
import java.util.*;

public class FileSyncChecker {
    public static void main(String[] args) {
        String folderA = "/path/to/local";
        String folderB = "/path/to/server";

        Set<String> filesA = listFileNames(new File(folderA));
        Set<String> filesB = listFileNames(new File(folderB));

        Set<String> onlyInA = new HashSet<>(filesA);
        onlyInA.removeAll(filesB);

        Set<String> onlyInB = new HashSet<>(filesB);
        onlyInB.removeAll(filesA);

        System.out.println("Only in Local: " + onlyInA);
        System.out.println("Only in Server: " + onlyInB);
    }

    private static Set<String> listFileNames(File dir) {
        Set<String> fileSet = new HashSet<>();
        for (File f : Objects.requireNonNull(dir.listFiles())) {
            if (f.isFile()) fileSet.add(f.getName());
        }
        return fileSet;
    }
}
