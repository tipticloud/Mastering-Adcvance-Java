import java.util.*;
import java.util.stream.Collectors;

public class EPDISMain {

    public static void main(String[] args) {
        List<Employee> employees = Arrays.asList(
                new Employee(1, "Alice", "Female", "Delhi", "Sales", "Executive", 85.5, 29),
                new Employee(2, "Bob", "Male", "Mumbai", "Engineering", "Software Engineer", 90.2, 32),
                new Employee(3, "Charlie", "Male", "Delhi", "Sales", "Manager", 78.0, 40),
                new Employee(4, "Daisy", "Female", "Bangalore", "Engineering", "Software Engineer", 88.1, 27),
                new Employee(5, "Eva", "Female", "Mumbai", "HR", "HR Manager", 92.0, 35),
                new Employee(6, "Frank", "Male", "Delhi", "Engineering", "Software Engineer", 60.5, 30)
        );

        // 1. Filter all Software Engineers in Delhi
        List<Employee> softwareEngineersInDelhi = employees.stream()
                .filter(e -> e.getRole().equalsIgnoreCase("Software Engineer") && e.getCity().equalsIgnoreCase("Delhi"))
                .collect(Collectors.toList());

        System.out.println("Software Engineers in Delhi:");
        softwareEngineersInDelhi.forEach(e -> System.out.println(e.getName()));

        // 2. Average Performance Score by Department
        Map<String, Double> avgPerformanceByDept = employees.stream()
                .collect(Collectors.groupingBy(
                        Employee::getDepartment,
                        Collectors.averagingDouble(Employee::getPerformanceScore)
                ));

        System.out.println("\nAverage Performance Score by Department:");
        avgPerformanceByDept.forEach((dept, avg) -> System.out.println(dept + ": " + avg));

        // 3. Gender Distribution
        Map<String, Long> genderCount = employees.stream()
                .collect(Collectors.groupingBy(Employee::getGender, Collectors.counting()));

        System.out.println("\nGender Distribution:");
        genderCount.forEach((gender, count) -> System.out.println(gender + ": " + count));

        // 4. Employees above age 30
        List<Employee> ageAbove30 = employees.stream()
                .filter(e -> e.getAge() > 30)
                .collect(Collectors.toList());

        System.out.println("\nEmployees above age 30:");
        ageAbove30.forEach(e -> System.out.println(e.getName() + " (" + e.getAge() + ")"));

        // 5. Top Performers (Score > 85)
        List<Employee> topPerformers = employees.stream()
                .filter(e -> e.getPerformanceScore() > 85)
                .sorted((e1, e2) -> Double.compare(e2.getPerformanceScore(), e1.getPerformanceScore()))
                .collect(Collectors.toList());

        System.out.println("\nTop Performers:");
        topPerformers.forEach(e -> System.out.println(e.getName() + " - " + e.getPerformanceScore()));
    }
}
