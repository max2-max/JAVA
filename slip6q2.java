import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class TrafficSignal extends JFrame implements ItemListener {
	JRadioButton red, yellow, green;
	ButtonGroup bg;
	String msg = "";
	int light = 0;

	public TrafficSignal() {
		setLayout(new FlowLayout());
		red = new JRadioButton("Red");
		yellow = new JRadioButton("Yellow");
		green = new JRadioButton("Green");

		bg = new ButtonGroup();
		bg.add(red);
		bg.add(yellow);
		bg.add(green);

		add(red);
		add(yellow);
		add(green);

		red.addItemListener(this);
		yellow.addItemListener(this);
		green.addItemListener(this);

		setSize(400, 400);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public void itemStateChanged(ItemEvent e) {
		if (red.isSelected()) {
			msg = "STOP";
			light = 1;
		} else if (yellow.isSelected()) {
			msg = "READY";
			light = 2;
		} else if (green.isSelected()) {
			msg = "GO";
			light = 3;
		}

		repaint();
	}

	public void paint(Graphics g) {
		super.paint(g);
		g.drawRect(150, 100, 80, 200);
		g.drawOval(160, 120, 60, 60);
		g.drawOval(160, 180, 60, 60);
		g.drawOval(160, 240, 60, 60);

		if (light == 1) {
			g.setColor(Color.RED);
			g.fillOval(160, 120, 60, 60);
		} else if (light == 2) {
			g.setColor(Color.YELLOW);
			g.fillOval(160, 180, 60, 60);
		} else if (light == 3) {
			g.setColor(Color.GREEN);
			g.fillOval(160, 240, 60, 60);
		}

		g.setColor(Color.BLACK);
		g.drawString(msg, 170, 330);
	}

	public static void main(String[] args) {
		new TrafficSignal();
	}
}
