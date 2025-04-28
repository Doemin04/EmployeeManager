import java.util.ArrayList;
import java.util.List;

public class EmployeeManager {
    private List<FullTimeEmployee> employees;

    public EmployeeManager() {
        employees = new ArrayList<>();
    }

    public void addEmployee(FullTimeEmployee emp) {
        employees.add(emp);
    }

    public FullTimeEmployee searchEmployee(String keyword) {
        for (FullTimeEmployee emp : employees) {
            if (emp.name.equalsIgnoreCase(keyword) || emp.ssn.equals(keyword) || String.valueOf(emp.empId).equals(keyword)) {
                return emp;
            }
        }
        return null;
    }

    public void updateSalary(double lowerBound, double upperBound, double percentage) {
        for (FullTimeEmployee emp : employees) {
            double salary = emp.getSalary();
            if (salary >= lowerBound && salary < upperBound) {
                double newSalary = salary * (1 + percentage / 100);
                emp.setSalary(newSalary);
            }
        }
    }

    public void updateEmployee(int empId, String field, String newValue) {
        for (FullTimeEmployee emp : employees) {
            if (emp.empId == empId) {
                emp.updateData(field, newValue);
                break;
            }
        }
    }

    public List<FullTimeEmployee> getEmployees() {
        return employees;
    }
}