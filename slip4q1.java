import java.awt.*;
import javax.swing.*;
class BlinkText extends JFrame implements Runnable {
        JLabel label;
        Thread t;
        public BlinkText() {
                label = new JLabel("BLINKING TEXT");
                label.setFont(new Font("Arial", Font.BOLD, 30));
                label.setHorizontalAlignment(JLabel.CENTER);
                add(label);
                t = new Thread(this);
                t.start();
                setTitle("Blinking Text");
                setSize(400, 200);
                setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                setVisible(true);
        }
        
        public void run() {
                try {
                        while (true) {
                                label.setVisible(false);
                                Thread.sleep(500);
                                label.setVisible(true);
                                Thread.sleep(500);
                        }
                } catch (InterruptedException e) {
                        System.out.println(e);
                }
        }
        public static void main(String[] args) {
                new BlinkText();
        }
}
