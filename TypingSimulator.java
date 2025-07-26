public class TypingSimulator {
    public static void main(String[] args) throws InterruptedException {
        String message = "Hello, I am ChatGPT typing like a human!";
        simulateTyping(message);
    }

    static void simulateTyping(String text) throws InterruptedException {
        for (char c : text.toCharArray()) {
            System.out.print(c);
            if (c == ' ') {
                Thread.sleep(200); // Shorter pause for space
            } else if (Character.isUpperCase(c)) {
                Thread.sleep(180 + (int)(Math.random() * 150));
            } else {
                Thread.sleep(70 + (int)(Math.random() * 100));
            }
        }
        System.out.println();
    }
} 
