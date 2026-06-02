public class Course {
    private String courseCode;
    private String courseName;
    private int maximumCapacity;

    private static int totalEnrolledStudents = 0;

    public Course(String courseCode, String courseName, int maximumCapacity) {
        this.courseCode = courseCode;
        this.courseName = courseName;
        this.maximumCapacity = maximumCapacity;
    }

    // Getter methods
    public String getCourseCode() {
        return courseCode;
    }

    public String getCourseName() {
        return courseName;
    }

    public int getMaximumCapacity() {
        return maximumCapacity;
    }

    // Static methods
    public static void incrementEnrollment() {
        totalEnrolledStudents++;
    }

    public static int getTotalEnrolledStudents() {
        return totalEnrolledStudents;
    }
}