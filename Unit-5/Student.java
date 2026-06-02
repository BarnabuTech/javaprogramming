import java.util.ArrayList;
import java.util.HashMap;

public class Student {
    private String name;
    private String studentId;
    private ArrayList<Course> enrolledCourses;
    private HashMap<String, Double> grades;

    public Student(String name, String studentId) {
        this.name = name;
        this.studentId = studentId;
        enrolledCourses = new ArrayList<>();
        grades = new HashMap<>();
    }

    // Getter methods
    public String getName() {
        return name;
    }

    public String getStudentId() {
        return studentId;
    }

    public ArrayList<Course> getEnrolledCourses() {
        return enrolledCourses;
    }

    // Setter methods
    public void setName(String name) {
        this.name = name;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    // Enroll student in course
    public void enrollCourse(Course course) {
        enrolledCourses.add(course);
    }

    // Assign grade to student
    public void assignGrade(Course course, double grade) {
        grades.put(course.getCourseCode(), grade);
    }

    // Retrieve grades
    public HashMap<String, Double> getGrades() {
        return grades;
    }
}