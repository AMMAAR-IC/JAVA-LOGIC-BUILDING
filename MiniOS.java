import javax.swing.*;
import java.awt.*;

public class MiniOS {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Java Mini OS");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);

        JDesktopPane desktop = new JDesktopPane();

        // Notes App
        JInternalFrame notes = new JInternalFrame("Notes", true, true, true, true);
        JTextArea textArea = new JTextArea();
        notes.add(new JScrollPane(textArea));
        notes.setSize(300, 200);
        notes.setVisible(true);
        desktop.add(notes);

        // Calculator App
        JInternalFrame calc = new JInternalFrame("Calculator", true, true, true, true);
        calc.add(new JLabel("Calculator coming soon...", SwingConstants.CENTER));
        calc.setSize(200, 150);
        calc.setLocation(320, 0);
        calc.setVisible(true);
        desktop.add(calc);

        frame.add(desktop);
        frame.setVisible(true);
    }
}
