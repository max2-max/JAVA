import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.table.DefaultTableModel;

public class ProductTable extends JFrame implements ActionListener {
    JLabel lblPid, lblPname, lblPrice;
    JTextField txtPid, txtPname, txtPrice;
    JButton btnSave, btnShowRecords;
    JTable productTable;
    DefaultTableModel tableModel;

    public ProductTable() {
        setTitle("Product Details");
        setSize(600, 400);
        setLayout(new BorderLayout());

        JPanel inputPanel = new JPanel(new GridLayout(5, 2, 10, 10));

        lblPid = new JLabel("Product Id:");
        lblPname = new JLabel("Product Name:");
        lblPrice = new JLabel("Price:");

        txtPid = new JTextField();
        txtPname = new JTextField();
        txtPrice = new JTextField();

        btnSave = new JButton("Save");
        btnShowRecords = new JButton("Show Records");

        inputPanel.add(lblPid);
        inputPanel.add(txtPid);
        inputPanel.add(lblPname);
        inputPanel.add(txtPname);
        inputPanel.add(lblPrice);
        inputPanel.add(txtPrice);
        inputPanel.add(new JLabel());
        inputPanel.add(btnSave);

        add(inputPanel, BorderLayout.NORTH);

        String[] columnNames = {"Product id", "Product Name", "Price"};
        tableModel = new DefaultTableModel(columnNames, 0);
        productTable = new JTable(tableModel);

        add(new JScrollPane(productTable), BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(btnShowRecords);
        add(buttonPanel, BorderLayout.SOUTH);

        btnSave.addActionListener(this);
        btnShowRecords.addActionListener(e -> showProductRecords());

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        int pid = Integer.parseInt(txtPid.getText());
        String pname = txtPname.getText();
        double price = Double.parseDouble(txtPrice.getText());

        try {
            Connection conn = DriverManager.getConnection(
                "jdbc:postgresql:practice_db", "postgres", "postgres");

            PreparedStatement ps = conn.prepareStatement(
                "INSERT INTO product VALUES (?, ?, ?)");

            ps.setInt(1, pid);
            ps.setString(2, pname);
            ps.setDouble(3, price);
            ps.executeUpdate();

            JOptionPane.showMessageDialog(this, "Product Record Saved Successfully");

            txtPid.setText("");
            txtPname.setText("");
            txtPrice.setText("");

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Database Error: " + ex.getMessage());
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Unexpected Error: " + ex.getMessage());
        }
    }

    private void showProductRecords() {
        try {
            Connection con = DriverManager.getConnection(
                "jdbc:postgresql://localhost:5432/practice_db", "postgres", "postgres");

            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM product");

            tableModel.setRowCount(0);

            while (rs.next()) {
                int pid = rs.getInt("pid");
                String pname = rs.getString("pname");
                double price = rs.getDouble("price");

                tableModel.addRow(new Object[]{pid, pname, price});
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this,
                "Error fetching records: " + ex.getMessage());
        }
    }

    public static void main(String[] args) {
        new ProductTable();
    }
}
