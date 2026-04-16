import javax.swing.*;
import java.awt.*;
class BlinkImage extends JFrame implements Runnable {
        JLabel label;
        ImageIcon icon;
        public BlinkImage() {
                setTitle("Blinking Image Demo");
                setSize(400, 400);
                setLayout(new FlowLayout());
                setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                
                icon = new ImageIcon("image.png");
                label = new JLabel(icon);
                add(label);
                setVisible(true);
                
                Thread t = new Thread(this);
                t.start();
        }
       
        public void run() {
                try {
                        while (true) {
                                label.setVisible(true);
                                Thread.sleep(500);
                                label.setVisible(false);
                                Thread.sleep(500); 
                        }
                } catch (InterruptedException e) {
                        System.out.println(e);
                }
        }
        public static void main(String[] args) {
                new BlinkImage();
        }
}
