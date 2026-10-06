import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class StudentRegistration extends Frame implements ActionListener {

    private TextField nameField;
    private TextField rollField;
    private TextField courseField;
    private Button submitButton;

    public StudentRegistration() {
        setTitle("Student Registration Form");
        setSize(400, 250);
        setLayout(new FlowLayout());

        add(new Label("Name:"));
        nameField = new TextField(25);
        add(nameField);

        add(new Label("Roll No:"));
        rollField = new TextField(25);
        add(rollField);

        add(new Label("Course:"));
        courseField = new TextField(25);
        add(courseField);

        submitButton = new Button("Submit");
        submitButton.addActionListener(this);
        add(submitButton);

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                dispose();
            }
        });

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String name = nameField.getText();
        String rollNo = rollField.getText();
        String course = courseField.getText();

        String message = "Student Registration Successful!\n\n"
                + "Name: " + name + "\n"
                + "Roll No: " + rollNo + "\n"
                + "Course: " + course;

        java.awt.Dialog dialog = new java.awt.Dialog(this, "Registration Details", true);
        dialog.setLayout(new FlowLayout());
        dialog.setSize(350, 180);

        dialog.add(new Label(message));

        Button okButton = new Button("OK");
        okButton.addActionListener(event -> dialog.dispose());
        dialog.add(okButton);

        dialog.setLocationRelativeTo(this);
        dialog.setVisible(true);
    }

    public static void main(String[] args) {
        new StudentRegistration();
    }
}
