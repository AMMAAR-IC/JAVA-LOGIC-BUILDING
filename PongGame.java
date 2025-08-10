import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class PongGame extends JPanel implements ActionListener, KeyListener {
    int ballX = 250, ballY = 150, ballDX = 2, ballDY = 2;
    int p1Y = 100, p2Y = 100;
    Timer timer = new Timer(10, this);

    public PongGame() {
        JFrame frame = new JFrame("Java Pong");
        frame.setSize(500, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(this);
        frame.addKeyListener(this);
        frame.setVisible(true);
        timer.start();
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.fillRect(20, p1Y, 10, 60);
        g.fillRect(470, p2Y, 10, 60);
        g.fillOval(ballX, ballY, 10, 10);
    }

    public void actionPerformed(ActionEvent e) {
        ballX += ballDX; ballY += ballDY;
        if (ballY <= 0 || ballY >= getHeight()-10) ballDY = -ballDY;
        if (ballX <= 30 && ballY > p1Y && ballY < p1Y + 60) ballDX = -ballDX;
        if (ballX >= 460 && ballY > p2Y && ballY < p2Y + 60) ballDX = -ballDX;
        repaint();
    }

    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_W) p1Y -= 10;
        if (e.getKeyCode() == KeyEvent.VK_S) p1Y += 10;
        if (e.getKeyCode() == KeyEvent.VK_UP) p2Y -= 10;
        if (e.getKeyCode() == KeyEvent.VK_DOWN) p2Y += 10;
    }

    public void keyReleased(KeyEvent e) {}
    public void keyTyped(KeyEvent e) {}

    public static void main(String[] args) {
        new PongGame();
    }
}
