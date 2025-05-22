import java.util.*;
import java.util.stream.*;

public class StreamClass {
    public StreamClass() {
        List<Integer> num = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        List<Integer> doubles = num.stream()
                                   .filter(n -> n % 2 == 0)
                                   .map(n -> n+n)
                                   .collect(Collectors.toList());
        System.out.println("Doubles: " + doubles);
    }
    public static void main(String[] args) {
        new StreamClass();
    }
}
