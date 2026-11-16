package com.employeemanagement;

import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;

public class EmployeeManagementApp extends JFrame {
    private final JTextField idField = new JTextField(18);
    private final JTextField nameField = new JTextField(18);
    private final JTextField departmentField = new JTextField(18);
    private final JTextField salaryField = new JTextField(18);

    private final DefaultTableModel tableModel = new DefaultTableModel(
            new String[]{"Employee ID", "Name", "Department", "Salary"}, 0) {
        @Override
        public boolean isCellEditable(int row, int column) {
            return false;
        }
    };

    private final JTable employeeTable = new JTable(tableModel);

    public EmployeeManagementApp() {
        super("Employee Management System");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(850, 550);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout(12, 12));

        add(createFormPanel(), BorderLayout.NORTH);
        employeeTable.setRowHeight(25);
        add(new JScrollPane(employeeTable), BorderLayout.CENTER);

        JButton viewButton = new JButton("View All Employees");
        viewButton.addActionListener(event -> loadEmployees());

        JPanel bottomPanel = new JPanel();
        bottomPanel.add(viewButton);
        add(bottomPanel, BorderLayout.SOUTH);
    }

    private JPanel createFormPanel() {
        JPanel panel = new JPanel(new GridBagLayout());
        panel.setBorder(BorderFactory.createTitledBorder("Add a New Employee"));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(6, 8, 6, 8);
        gbc.anchor = GridBagConstraints.WEST;

        addFormRow(panel, gbc, 0, "Employee ID:", idField);
        addFormRow(panel, gbc, 1, "Name:", nameField);
        addFormRow(panel, gbc, 2, "Department:", departmentField);
        addFormRow(panel, gbc, 3, "Salary:", salaryField);

        JButton submitButton = new JButton("Submit");
        submitButton.addActionListener(event -> saveEmployee());

        gbc.gridx = 1;
        gbc.gridy = 4;
        gbc.anchor = GridBagConstraints.EAST;
        panel.add(submitButton, gbc);

        return panel;
    }

    private void addFormRow(JPanel panel, GridBagConstraints gbc,
                            int row, String label, JTextField field) {
        gbc.gridx = 0;
        gbc.gridy = row;
        panel.add(new JLabel(label), gbc);

        gbc.gridx = 1;
        panel.add(field, gbc);
    }

    private void saveEmployee() {
        final int employeeId;
        final BigDecimal salary;

        String name = nameField.getText().trim();
        String department = departmentField.getText().trim();

        try {
            employeeId = Integer.parseInt(idField.getText().trim());
            salary = new BigDecimal(salaryField.getText().trim());

            if (employeeId <= 0) {
                throw new IllegalArgumentException("Employee ID must be a positive integer.");
            }
            if (salary.signum() < 0 || salary.precision() > 10
                    || salary.scale() > 2) {
                throw new IllegalArgumentException(
                        "Salary must be non-negative and fit DECIMAL(10,2).");
            }
            if (name.isEmpty() || name.length() > 100) {
                throw new IllegalArgumentException("Enter a name (up to 100 characters).");
            }
            if (department.isEmpty() || department.length() > 50) {
                throw new IllegalArgumentException("Enter a department (up to 50 characters).");
            }
        } catch (NumberFormatException ex) {
            showError("Employee ID must be an integer and salary must be a valid decimal.");
            return;
        } catch (IllegalArgumentException ex) {
            showError(ex.getMessage());
            return;
        }

        String sql = "INSERT INTO employees (emp_id, name, department, salary) VALUES (?, ?, ?, ?)";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setInt(1, employeeId);
            statement.setString(2, name);
            statement.setString(3, department);
            statement.setBigDecimal(4, salary);

            statement.executeUpdate();
            JOptionPane.showMessageDialog(this, "Employee added successfully!",
                    "Success", JOptionPane.INFORMATION_MESSAGE);
            clearFields();
            loadEmployees();

        } catch (SQLException ex) {
            showError("Could not save employee. " + ex.getMessage()
                    + "\nCheck your database connection and ensure the Employee ID is unique.");
        }
    }

    private void loadEmployees() {
        String sql = "SELECT emp_id, name, department, salary FROM employees ORDER BY emp_id";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery()) {

            tableModel.setRowCount(0);
            while (resultSet.next()) {
                tableModel.addRow(new Object[]{
                    resultSet.getInt("emp_id"),
                    resultSet.getString("name"),
                    resultSet.getString("department"),
                    resultSet.getBigDecimal("salary")
                });
            }

        } catch (SQLException ex) {
            showError("Could not retrieve employees. " + ex.getMessage()
                    + "\nMake sure MySQL is running and company_db is configured.");
        }
    }

    private void clearFields() {
        idField.setText("");
        nameField.setText("");
        departmentField.setText("");
        salaryField.setText("");
        idField.requestFocusInWindow();
    }

    private void showError(String message) {
        JOptionPane.showMessageDialog(this, message, "Error", JOptionPane.ERROR_MESSAGE);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new EmployeeManagementApp().setVisible(true));
    }
}
