import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

class Employee {
    private String name;
    private int age;
    private String department;
    private double salary;

    // Constructor
    public Employee(String name, int age, String department, double salary) {
        this.name = name;
        this.age = age;
        this.department = department;
        this.salary = salary;
    }

    // Getter methods
    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getDepartment() {
        return department;
    }

    public double getSalary() {
        return salary;
    }

    @Override
    public String toString() {
        return name + " | Age: " + age +
                " | Department: " + department +
                " | Salary: Ksh." + salary;
    }
}

public class EmployeeManagementSystem {

    public static void main(String[] args) {

        // Step 1: Store employee dataset in a collection
        List<Employee> employees = new ArrayList<>();

        employees.add(new Employee("Abubakar Bakari", 25, "IT", 65000));
        employees.add(new Employee("Mary Kinoti", 28, "HR", 55000));
        employees.add(new Employee("James Brown", 40, "Finance", 72000));
        employees.add(new Employee("Fatma Ali", 32, "Marketing", 60000));
        employees.add(new Employee("David Kamau", 25, "IT", 50000));

        // Step 2: Function interface to concatenate name and department
        Function<Employee, String> employeeInfo =
                emp -> emp.getName() + " - " + emp.getDepartment();

        // Step 3: Generate new collection using streams
        List<String> employeeDetails = employees.stream()
                .map(employeeInfo)
                .collect(Collectors.toList());

        System.out.println("Employee Name and Department:");
        employeeDetails.forEach(System.out::println);

        // Step 4: Calculate average salary using streams
        double averageSalary = employees.stream()
                .mapToDouble(Employee::getSalary)
                .average()
                .orElse(0.0);

        System.out.println("\nAverage Salary: Ksh." + averageSalary);

        // Step 5: Filter employees above age threshold
        int ageThreshold = 30;

        List<Employee> filteredEmployees = employees.stream()
                .filter(emp -> emp.getAge() > ageThreshold)
                .collect(Collectors.toList());

        System.out.println("\nEmployees Above Age " + ageThreshold + ":");
        filteredEmployees.forEach(System.out::println);
    }
}
