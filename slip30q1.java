import javax.swing.*;
import java.awt.*;

public class IndianFlagThread extends JPanel {
	private boolean saffronDone = false;
	private boolean whiteDone = false;
	private boolean greenDone = false;
	private boolean chakraDone = false;

	protected void paintComponent(Graphics g) {
		super.paintComponent(g);

		if (saffronDone) {
			g.setColor(Color.ORANGE);
			g.fillRect(100, 50, 300, 50);
		}

		if (whiteDone) {
			g.setColor(Color.WHITE);
			g.fillRect(100, 100, 300, 50);
		}

		if (greenDone) {
			g.setColor(Color.GREEN);
			g.fillRect(100, 150, 300, 50);
		}

		if (chakraDone) {
			g.setColor(Color.BLUE);
			g.fillOval(225, 105, 50, 50);

			for (int i = 0; i < 24; i ++) {
				double angle = Math.toRadians(i * 15);
				int x1 = 250;
				int y1 = 130;
				int x2 = (int) (x1 + 25 * Math.cos(angle));
				int y2 = (int) (y1 + 25 * Math.sin(angle));
				g.drawLine(x1, y1, x2, y2);
			}
		}
	}

	class SaffronThread extends Thread {
		public void run() {
			try {
				Thread.sleep(500);
				saffronDone = true;
				repaint();
			} catch (Exception e) {}
		}
	}

	class WhiteThread extends Thread {
		public void run() {
			try {
				Thread.sleep(1000);
				whiteDone = true;
				repaint();
			} catch (Exception e) {}
		}
	}

	class GreenThread extends Thread {
		public void run() {
			try {
				Thread.sleep(1500);
				greenDone = true;
				repaint();
			} catch (Exception e) {} 
		}
	}

	class ChakraThread extends Thread {
		public void run() {
			try {
				Thread.sleep(2000);
				chakraDone = true;
				repaint();
			} catch (Exception e) {}
		}
	}

	public static void main(String[] args) {
		JFrame frame = new JFrame("Indian Flag using Multithreading");
		IndianFlagThread panel = new IndianFlagThread();

		frame.add(panel);
		frame.setSize(500, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);

		panel.new SaffronThread().start();
		panel.new WhiteThread().start();
		panel.new GreenThread().start();
		panel.new ChakraThread().start();
	}
}
