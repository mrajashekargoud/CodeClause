import java.util.ArrayList;
import java.util.Scanner;

class Student {
    private String name;
    private int id;
    private double feePaid;

    // Constructor
    public Student(String name, int id, double feePaid) {
        this.name = name;
        this.id = id;
        this.feePaid = feePaid;
    }

    // Getters and Setters
    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public double getFeePaid() {
        return feePaid;
    }

    public void setFeePaid(double feePaid) {
        this.feePaid = feePaid;
    }
}

class FeeReport {
    private ArrayList<Student> students;

    // Constructor
    public FeeReport() {
        students = new ArrayList<>();
    }

    // Add a student to the fee report
    public void addStudent(Student student) {
        students.add(student);
    }

    // Generate the fee report
    public void generateReport() {
        System.out.println("Fee Report\n");

        System.out.println("---------------------------------------------------------");
        System.out.printf("%-10s%-20s%-10s%-10s\n", "ID", "Name", "Fee Paid", "Status");
        System.out.println("---------------------------------------------------------");

        for (Student student : students) {
            String status = (student.getFeePaid() >= 1000) ? "Paid" : "Not Paid";

            System.out.printf("%-10d%-20s%-10.2f%-10s\n", student.getId(), student.getName(), student.getFeePaid(),
                    status);
        }

        System.out.println("---------------------------------------------------------");
    }
}

public class Main {
    public static void main(String[] args) {
        // Create a FeeReport object
        FeeReport feeReport = new FeeReport();
        Scanner s = new Scanner(System.in);
        // Add students to the fee report
        System.out.println("Enter number of students");
        int n = s.nextInt();
        while (n > 0) {
            System.out.println("enter student name");
            String sname = s.next();
            System.out.println("enter student id");
            int sid = s.nextInt();
            System.out.println("enter fee paid amount");
            double feePaid = s.nextDouble();
            feeReport.addStudent(new Student(sname, sid, feePaid));
            n--;
        }
        s.close();
        // Generate the fee report
        feeReport.generateReport();
    }
}
