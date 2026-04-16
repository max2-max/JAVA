import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class EmployeeForm extends JFrame implements ActionListener {
	JLabel lblEno, lblEname, lblDesignation, lblSalary;
	JTextField txtEno, txtEname, txtDesignation, txtSalary;
	JButton btnSave;

	public EmployeeForm() {
		setTitle("Employee Details");
		setSize(400, 300);
		setLayout(new GridLayout(5, 2, 10, 10));

		lblEno = new JLabel("Employee No: ");
		lblEname = new JLabel("Employee Name: ");
		lblDesignation = new JLabel("Designation: ");
		lblSalary = new JLabel("Salary: ");

		txtEno = new JTextField();
		txtEname = new JTextField();
		txtDesignation = new JTextField();
		txtSalary = new JTextField();

		btnSave = new JButton("Save");
		
		add(lblEno); add(txtEno);
		add(lblEname); add(txtEname);
		add(lblDesignation); add(txtDesignation);
		add(lblSalary); add(txtSalary);
		add(btnSave);

		btnSave.addActionListener(this);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}

	public void actionPerformed(ActionEvent e) {
		int eno = Integer.parseInt(txtEno.getText());
		String ename = txtEname.getText();
		String designation = txtDesignation.getText();
		double salary = Double.parseDouble(txtSalary.getText());

		try {
			Class.forName("org.postgresql.Driver");

			Connection con = DriverManager.getConnection("jdbc:postgresql:practice_db", "postgres", "postgres");

			String sql = "insert into employee values(?, ?, ?, ?)";
			PreparedStatement ps = con.prepareStatement(sql);

			ps.setInt(1, eno);
			ps.setString(2, ename);
			ps.setString(3, designation);
			ps.setDouble(4, salary);

			ps.executeUpdate();

			JOptionPane.showMessageDialog(this, "Employee record saved successfully");

			ps.close();
			con.close();
		} catch (Exception ex) {
			JOptionPane.showMessageDialog(this, ex.getMessage());
		}
	}

	public static void main(String[] args) {
		new EmployeeForm();
	}
}
