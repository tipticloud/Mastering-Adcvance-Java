public class Employee {
    private int id;
    private String name;
    private String gender;
    private String city;
    private String department;
    private String role;
    private double performanceScore;
    private int age;

    public Employee(int id, String name, String gender, String city, String department, String role, double performanceScore, int age) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.city = city;
        this.department = department;
        this.role = role;
        this.performanceScore = performanceScore;
        this.age = age;
    }

    // Getters
    public int getId() { return id; }
    public String getName() { return name; }
    public String getGender() { return gender; }
    public String getCity() { return city; }
    public String getDepartment() { return department; }
    public String getRole() { return role; }
    public double getPerformanceScore() { return performanceScore; }
    public int getAge() { return age; }
}
