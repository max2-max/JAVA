import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class NumberRunnable implements Runnable {
	JTextField textField;

	NumberRunnable(JTextField tf) {
		this.textField = tf;
	}

	public void run() {
		try {
			for (int i = 1; i <= 100; i ++) {
				textField.setText(String.valueOf(i));
				Thread.sleep(100);
			}
		} catch (InterruptedException e)   {
			System.out.println(e);
		}
	}
}

public class NumberThread extends JFrame implements ActionListener {
	JTextField tf;
	JButton btn;

	public NumberThread() {
		tf = new JTextField(10);
		btn  = new JButton("Start");

		setLayout(new FlowLayout());
		add(tf);
		add(btn);

		btn.addActionListener(this);

		setTitle("Mutithreading Demo");
		setSize(250, 150);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public void actionPerformed(ActionEvent e) {
		NumberRunnable nr = new NumberRunnable(tf);
		Thread t = new Thread(nr);
		t.start();
	}

	public static void main(String[] args) {
		new NumberThread();
	}
}
