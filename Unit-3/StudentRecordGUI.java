import java.awt.*;
import javax.swing.*;

public class StudentRecordGUI {

    // Static storage (as required)
    static final int MAX = 100;
    static String[] names = new String[MAX];
    static int[] ids = new int[MAX];
    static int[] ages = new int[MAX];
    static String[] grades = new String[MAX];
    static int totalStudents = 0;

    // 🔍 Find student index
    static int findStudent(int id) {
        for (int i = 0; i < totalStudents; i++) {
            if (ids[i] == id) return i;
        }
        return -1;
    }

    public static void main(String[] args) {

        JFrame frame = new JFrame("Student Record System");
        frame.setSize(400, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new GridLayout(6, 2));

        // Input fields
        JTextField idField = new JTextField();
        JTextField nameField = new JTextField();
        JTextField ageField = new JTextField();
        JTextField gradeField = new JTextField();

        JTextArea output = new JTextArea();
        output.setEditable(false);

        // Labels
        frame.add(new JLabel("Student ID:"));
        frame.add(idField);

        frame.add(new JLabel("Name:"));
        frame.add(nameField);

        frame.add(new JLabel("Age:"));
        frame.add(ageField);

        frame.add(new JLabel("Grade:"));
        frame.add(gradeField);

        // Buttons
        JButton addBtn = new JButton("Add");
        JButton updateBtn = new JButton("Update");
        JButton viewBtn = new JButton("View");

        frame.add(addBtn);
        frame.add(updateBtn);
        frame.add(viewBtn);

        frame.add(new JScrollPane(output));

        // 🔹 Add Student
        addBtn.addActionListener(e -> {
            try {
                int id = Integer.parseInt(idField.getText());
                String name = nameField.getText();
                int age = Integer.parseInt(ageField.getText());
                String grade = gradeField.getText();

                if (findStudent(id) != -1) {
                    output.setText("❌ Student ID already exists!");
                    return;
                }

                ids[totalStudents] = id;
                names[totalStudents] = name;
                ages[totalStudents] = age;
                grades[totalStudents] = grade;
                totalStudents++;

                output.setText("✅ Student added successfully!");

            } catch (NumberFormatException ex) {
                output.setText("❌ Invalid input!");
            }
        });

        // 🔹 Update Student
        updateBtn.addActionListener(e -> {
            try {
                int id = Integer.parseInt(idField.getText());
                int index = findStudent(id);

                if (index == -1) {
                    output.setText("❌ Student not found!");
                    return;
                }

                names[index] = nameField.getText();
                ages[index] = Integer.parseInt(ageField.getText());
                grades[index] = gradeField.getText();

                output.setText("✅ Student updated successfully!");

            } catch (NumberFormatException ex) {
                output.setText("❌ Invalid input!");
            }
        });

        // 🔹 View Student
        viewBtn.addActionListener(e -> {
            try {
                int id = Integer.parseInt(idField.getText());
                int index = findStudent(id);

                if (index == -1) {
                    output.setText("❌ Student not found!");
                    return;
                }

                output.setText(
                        "ID: " + ids[index] +
                        "\nName: " + names[index] +
                        "\nAge: " + ages[index] +
                        "\nGrade: " + grades[index]
                );

            } catch (NumberFormatException ex) {
                output.setText("❌ Invalid input!");
            }
        });

        frame.setVisible(true);
    }
}
