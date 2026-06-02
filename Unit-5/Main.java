import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        Student student1 = new Student("Abubakar", "CS101");

        while (true) {
            System.out.println("\n===== Course Enrollment System =====");
            System.out.println("1. Add Course");
            System.out.println("2. Enroll Student");
            System.out.println("3. Assign Grade");
            System.out.println("4. Calculate Overall Grade");
            System.out.println("5. View Total Enrolled Students");
            System.out.println("6. Exit");

            System.out.print("Enter choice: ");
            int choice = input.nextInt();
            input.nextLine();

            switch (choice) {

                case 1:
                    System.out.print("Enter course code: ");
                    String code = input.nextLine();

                    System.out.print("Enter course name: ");
                    String name = input.nextLine();

                    System.out.print("Enter maximum capacity: ");
                    int capacity = input.nextInt();

                    CourseManagement.addCourse(code, name, capacity);
                    break;

                case 2:
                    if (CourseManagement.getCourses().size() == 0) {
                        System.out.println("No courses available.");
                        break;
                    }

                    Course course = CourseManagement.getCourses().get(0);
                    CourseManagement.enrollStudent(student1, course);
                    break;

                case 3:
                    if (student1.getEnrolledCourses().size() == 0) {
                        System.out.println("Student not enrolled in any course.");
                        break;
                    }

                    Course enrolledCourse = student1.getEnrolledCourses().get(0);

                    System.out.print("Enter grade: ");
                    double grade = input.nextDouble();

                    CourseManagement.assignGrade(student1, enrolledCourse, grade);
                    break;

                case 4:
                    double average = CourseManagement.calculateOverallGrade(student1);
                    System.out.println("Overall Grade: " + average);
                    break;

                case 5:
                    System.out.println("Total Enrolled Students: " + Course.getTotalEnrolledStudents());
                    break;

                case 6:
                    System.out.println("Exiting system...");
                    System.exit(0);

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
