import java.util.ArrayList;
import java.util.HashMap;

public class Student {

    private String studentId;
    private String studentName;
    private ArrayList<Course> enrolledCourses;
    private HashMap<String, String> grades;

    public Student(String studentId, String studentName) {
        this.studentId = studentId;
        this.studentName = studentName;
        this.enrolledCourses = new ArrayList<>();
        this.grades = new HashMap<>();
    }

    // Getters
    public String getStudentId() {
        return studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public ArrayList<Course> getEnrolledCourses() {
        return enrolledCourses;
    }

    public HashMap<String, String> getGrades() {
        return grades;
    }

    // Setters
    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    // Enroll student
    public void enrollCourse(Course course) {
        if (!enrolledCourses.contains(course)) {
            enrolledCourses.add(course);
        }
    }

    // Assign grade
    public void assignGrade(Course course, String grade) {
        if (course == null || grade == null) return;
        grades.put(course.getCourseCode(), grade);
    }

    @Override
    public String toString() {
        return studentName;
    }
}