import java.util.ArrayList;

public class CourseManagement {

    private static ArrayList<Course> courses = new ArrayList<>();

    // Add course
    public static void addCourse(String code, String name, int capacity) {
        Course course = new Course(code, name, capacity);
        courses.add(course);
        System.out.println("Course added successfully.");
    }

    // Enroll student
    public static void enrollStudent(Student student, Course course) {
        student.enrollCourse(course);
        Course.incrementEnrollment();
        System.out.println(student.getName() + " enrolled in " + course.getCourseName());
    }

    // Assign grades
    public static void assignGrade(Student student, Course course, double grade) {
        student.assignGrade(course, grade);
        System.out.println("Grade assigned successfully.");
    }

    // Calculate overall grade
    public static double calculateOverallGrade(Student student) {
        double total = 0;
        int count = 0;

        for (double grade : student.getGrades().values()) {
            total += grade;
            count++;
        }

        if (count == 0) {
            return 0;
        }

        return total / count;
    }

    public static ArrayList<Course> getCourses() {
        return courses;
    }
}
