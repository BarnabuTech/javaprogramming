import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;

public class StudentManagementGUI extends JFrame {

    private JTextField studentIdField;
    private JTextField studentNameField;

    private JComboBox<Student> studentComboBox;
    private JComboBox<Course> courseComboBox;

    private JTable studentTable;
    private DefaultTableModel tableModel;

    private ArrayList<Student> students;
    private ArrayList<Course> courses;

    public StudentManagementGUI() {

        students = new ArrayList<>();
        courses = new ArrayList<>();

        // Sample courses
        courses.add(new Course("CS101", "Programming 1"));
        courses.add(new Course("CS102", "Database Systems"));
        courses.add(new Course("CS103", "Computer Networks"));

        setTitle("Student Management System");
        setSize(900, 550);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel(new BorderLayout());

        // Top Form Panel
        JPanel formPanel = new JPanel(new GridLayout(3, 2, 10, 10));

        formPanel.setBorder(
                BorderFactory.createTitledBorder("Student Information"));

        formPanel.add(new JLabel("Student ID:"));
        studentIdField = new JTextField();
        formPanel.add(studentIdField);

        formPanel.add(new JLabel("Student Name:"));
        studentNameField = new JTextField();
        formPanel.add(studentNameField);

        JButton addButton = new JButton("Add Student");
        JButton updateButton = new JButton("Update Student");

        formPanel.add(addButton);
        formPanel.add(updateButton);

        panel.add(formPanel, BorderLayout.NORTH);

        // Table
        tableModel = new DefaultTableModel();
        tableModel.setColumnIdentifiers(new String[]{
                "Student ID",
                "Student Name",
                "Courses",
                "Grades"
        });

        studentTable = new JTable(tableModel);

        JScrollPane scrollPane =
                new JScrollPane(studentTable);

        panel.add(scrollPane, BorderLayout.CENTER);

        // Bottom Panel
        JPanel bottomPanel =
                new JPanel(new GridLayout(2, 3, 10, 10));

        bottomPanel.setBorder(
                BorderFactory.createTitledBorder(
                        "Course Enrollment & Grades"));

        studentComboBox = new JComboBox<>();
        courseComboBox = new JComboBox<>();

        for (Course course : courses) {
            courseComboBox.addItem(course);
        }

        JButton enrollButton =
                new JButton("Enroll Student");

        JButton gradeButton =
                new JButton("Assign Grade");

        bottomPanel.add(new JLabel("Select Student"));
        bottomPanel.add(new JLabel("Select Course"));
        bottomPanel.add(new JLabel("Action"));

        bottomPanel.add(studentComboBox);
        bottomPanel.add(courseComboBox);
        bottomPanel.add(enrollButton);

        panel.add(bottomPanel, BorderLayout.SOUTH);

        add(panel);

        // Add Student Event
        addButton.addActionListener(e -> addStudent());

        // Update Student Event
        updateButton.addActionListener(e -> updateStudent());

        // Enroll Student Event
        enrollButton.addActionListener(e -> enrollStudent());

        // Assign Grade Event
        gradeButton.addActionListener(e -> assignGrade());

        setVisible(true);
    }

    private void addStudent() {

        String id = studentIdField.getText().trim();
        String name = studentNameField.getText().trim();

        if (id.isEmpty() || name.isEmpty()) {

            JOptionPane.showMessageDialog(
                    this,
                    "Please fill all fields!",
                    "Input Error",
                    JOptionPane.ERROR_MESSAGE);

            return;
        }

        Student student = new Student(id, name);

        students.add(student);
        studentComboBox.addItem(student);

        updateTable();

        studentIdField.setText("");
        studentNameField.setText("");

        JOptionPane.showMessageDialog(
                this,
                "Student Added Successfully!");
    }

    private void updateStudent() {

        int selectedRow =
                studentTable.getSelectedRow();

        if (selectedRow == -1) {

            JOptionPane.showMessageDialog(
                    this,
                    "Please select a student row.");
            return;
        }

        String newId =
                studentIdField.getText().trim();

        String newName =
                studentNameField.getText().trim();

        Student student =
                students.get(selectedRow);

        student.setStudentId(newId);
        student.setStudentName(newName);

        updateTable();

        JOptionPane.showMessageDialog(
                this,
                "Student Updated Successfully!");
    }

    private void enrollStudent() {

        Student student =
                (Student) studentComboBox.getSelectedItem();

        Course course =
                (Course) courseComboBox.getSelectedItem();

        if (student == null || course == null) {

            JOptionPane.showMessageDialog(
                    this,
                    "Invalid selection.");
            return;
        }

        student.enrollCourse(course);

        updateTable();

        JOptionPane.showMessageDialog(
                this,
                "Student Enrolled Successfully!");
    }

    private void assignGrade() {

        Student student =
                (Student) studentComboBox.getSelectedItem();

        Course course =
                (Course) courseComboBox.getSelectedItem();

        String grade = JOptionPane.showInputDialog(
                this,
                "Enter Grade:");

        if (grade == null || grade.isEmpty()) {

            JOptionPane.showMessageDialog(
                    this,
                    "Grade cannot be empty.");
            return;
        }

        student.assignGrade(course, grade);

        updateTable();

        JOptionPane.showMessageDialog(
                this,
                "Grade Assigned Successfully!");
    }

    private void updateTable() {

        tableModel.setRowCount(0);

        for (Student student : students) {

            StringBuilder courseNames =
                    new StringBuilder();

            for (Course course :
                    student.getEnrolledCourses()) {

                courseNames.append(
                        course.getCourseName())
                        .append(", ");
            }

            tableModel.addRow(new Object[]{
                    student.getStudentId(),
                    student.getStudentName(),
                    courseNames.toString(),
                    student.getGrades().toString()
            });
        }
    }

    public static void main(String[] args) {

        SwingUtilities.invokeLater(
                StudentManagementGUI::new);
    }
}