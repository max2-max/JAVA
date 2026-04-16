import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.table.DefaultTableModel;

public class ProjectTableSwing extends JFrame implements ActionListener {
	JLabel lblPid, lblPname, lblPdesc, lblStatus;
	JTextField txtPid, txtPname, txtPdesc, txtStatus;
	JButton btnSave, btnShowRecords;
	JTable projectTable;
	DefaultTableModel tableModel;

	public ProjectTableSwing () {
		setTitle("Project Table");
		setSize(600, 400);
		setLayout(new BorderLayout());

		JPanel inputPanel = new JPanel();
		inputPanel.setLayout(new GridLayout(5, 2, 10, 10));

		lblPid = new JLabel("Project id:");
		lblPname = new JLabel("Project Name:");
		lblPdesc = new JLabel("Description:");
		lblStatus = new JLabel("Status:");

		txtPid = new JTextField();
		txtPname = new JTextField();
		txtPdesc = new JTextField();
		txtStatus = new JTextField();

		btnSave = new JButton("Save");
		btnShowRecords = new JButton("Show Records");

		inputPanel.add(lblPid);
		inputPanel.add(txtPid);
		inputPanel.add(lblPname);
		inputPanel.add(txtPname);
		inputPanel.add(lblPdesc);
		inputPanel.add(txtPdesc);
		inputPanel.add(lblStatus);
		inputPanel.add(txtStatus);
		inputPanel.add(new JLabel());
		inputPanel.add(btnSave);

		add(inputPanel, BorderLayout.NORTH);

		String[] columnNames = {"Project Id", "Project Name", "Description", "Status"};
		tableModel = new DefaultTableModel(columnNames, 0);
		projectTable = new JTable(tableModel);
		JScrollPane tableScrollPane = new JScrollPane(projectTable);

		add(tableScrollPane, BorderLayout.CENTER);

		JPanel buttonPanel = new JPanel();
		buttonPanel.add(btnShowRecords);
		add(buttonPanel, BorderLayout.SOUTH);

		btnSave.addActionListener(this);
		btnShowRecords.addActionListener(e -> showProjectRecords());

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}

	public void actionPerformed(ActionEvent e) {
		int pid = Integer.parseInt(txtPid.getText());
		String pname = txtPname.getText();
		String pdesc = txtPdesc.getText();
		String status = txtStatus.getText();

		try {
			Connection con = DriverManager.getConnection("jdbc:postgresql:practice_db", "postgres", "postgres");

			PreparedStatement ps = con.prepareStatement("INSERT INTO project VALUES(?, ?, ?, ?)");

			ps.setInt(1, pid);
			ps.setString(2, pname);
			ps.setString(3, pdesc);
			ps.setString(4, status);
			ps.executeUpdate();

			JOptionPane.showMessageDialog(this, "Project Record Saved Successfully");

			txtPid.setText("");
			txtPname.setText("");
			txtPdesc.setText("");
			txtStatus.setText("");
		} catch (SQLException ex) {
			JOptionPane.showMessageDialog(this, "Database Error: " + ex.getMessage());
		} catch (Exception ex) {
			JOptionPane.showMessageDialog(this, "Unexpected Error: " + ex.getMessage());
		}
	}

	private void showProjectRecords() {
		try {
			Connection con = DriverManager.getConnection("jdbc:postgresql:practice_db", "postgres", "postgres");

			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("SELECT * FROM project");

			tableModel.setRowCount(0);

			while (rs.next()) {
				int pid = rs.getInt("project_id");
				String pname = rs.getString("project_name");
				String pdesc = rs.getString("project_description");
				String status = rs.getString("project_status");

				tableModel.addRow(new Object[] {pid, pname, pdesc, status});
			}
		} catch (SQLException ex) {
			JOptionPane.showMessageDialog(this, "Error fetching records: " + ex.getMessage());
		}
	}

	public static void main(String[] args) {
		new ProjectTableSwing();
	}
}
