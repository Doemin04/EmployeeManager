import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ReportService {
    private EmployeeManager manager;

    public ReportService(EmployeeManager manager) {
        this.manager = manager;
    }

    public void payByDivision() {
        Map<String, Double> divisionPay = new HashMap<>();
        for (FullTimeEmployee emp : manager.getEmployees()) {
            divisionPay.put(emp.division, divisionPay.getOrDefault(emp.division, 0.0) + emp.getSalary());
        }
        for (String division : divisionPay.keySet()) {
            System.out.println("Division: " + division + " | Total Pay: $" + divisionPay.get(division));
        }
    }

    public void payByJobTitle() {
        Map<String, Double> titlePay = new HashMap<>();
        for (FullTimeEmployee emp : manager.getEmployees()) {
            titlePay.put(emp.jobTitle, titlePay.getOrDefault(emp.jobTitle, 0.0) + emp.getSalary());
        }
        for (String title : titlePay.keySet()) {
            System.out.println("Job Title: " + title + " | Total Pay: $" + titlePay.get(title));
        }
    }

    public void viewPayHistory(FullTimeEmployee emp) {
        for (PayStatement pay : emp.getPayStatementHistory()) {
            System.out.println("Date: " + pay.getDate() + " | Amount: $" + pay.getAmount());
        }
    }
}