import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        EmployeeManager manager = new EmployeeManager();
        ReportService reportService = new ReportService(manager);
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n=== Employee Management System ===");
            System.out.println("1. Add Employee");
            System.out.println("2. Search Employee");
            System.out.println("3. Update Employee");
            System.out.println("4. Update Salary by Range");
            System.out.println("5. View Pay History");
            System.out.println("6. Total Pay by Division");
            System.out.println("7. Total Pay by Job Title");
            System.out.println("8. View All Employees");
            System.out.println("0. Exit");
            System.out.print("Select: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            if (choice == 1) {
                System.out.print("Name: ");
                String name = scanner.nextLine();
                System.out.print("Phone Number: ");
                String phone = scanner.nextLine();
                System.out.print("Email Address: ");
                String email = scanner.nextLine();
                System.out.print("Employee ID: ");
                int empId = scanner.nextInt();
                scanner.nextLine();
                System.out.print("SSN: ");
                String ssn = scanner.nextLine();
                System.out.print("Salary: ");
                double salary = scanner.nextDouble();
                scanner.nextLine();
                System.out.print("Job Title: ");
                String jobTitle = scanner.nextLine();
                System.out.print("Division: ");
                String division = scanner.nextLine();

                FullTimeEmployee emp = new FullTimeEmployee(name, phone, email, empId, ssn, salary, jobTitle, division);
                manager.addEmployee(emp);
                manager.addPayStatement(empId, salary);
                System.out.println("Employee added successfully!");

            } else if (choice == 2) {
                System.out.print("Enter Name, SSN or Employee ID to search: ");
                String keyword = scanner.nextLine();
                FullTimeEmployee emp = manager.searchEmployee(keyword);
                if (emp != null) {
                    System.out.println("Found: " + emp.name + ", Salary: $" + emp.salary);
                } else {
                    System.out.println("Employee not found.");
                }

            } else if (choice == 3) {
                System.out.print("Employee ID to update: ");
                int id = scanner.nextInt();
                scanner.nextLine();
                System.out.print("Field to update (name, phonenumber, emailaddress, jobtitle, division, ssn): ");
                String field = scanner.nextLine();
                System.out.print("New Value: ");
                String newValue = scanner.nextLine();
                manager.updateEmployee(id, field, newValue);
                System.out.println("Employee updated!");

            } else if (choice == 4) {
                System.out.print("Lower salary bound: ");
                double low = scanner.nextDouble();
                System.out.print("Upper salary bound: ");
                double high = scanner.nextDouble();
                System.out.print("Percentage increase: ");
                double percent = scanner.nextDouble();
                manager.updateSalary(low, high, percent);
                System.out.println("Salaries updated!");

            } else if (choice == 5) {
                System.out.print("Enter Name, SSN or Employee ID to view pay history: ");
                String keyword = scanner.nextLine();
                FullTimeEmployee emp = manager.searchEmployee(keyword);
                if (emp != null) {
                    reportService.viewPayHistory(emp);
                } else {
                    System.out.println("Employee not found.");
                }

            } else if (choice == 6) {
                reportService.payByDivision();

            } else if (choice == 7) {
                reportService.payByJobTitle();

            } else if (choice == 8) {
                System.out.println("Employee List:");
                System.out.println("ID | Name | Pay | Division | Job Title");
                for (FullTimeEmployee emp : manager.getEmployees()) {
                    System.out.println(emp.empId + " | " + emp.name + " | $" + emp.salary + " | " + emp.division + " | " + emp.jobTitle);
                }

            } else if (choice == 0) {
                System.out.println("Goodbye!");
                break;
            }
        }
        scanner.close();
    }
}