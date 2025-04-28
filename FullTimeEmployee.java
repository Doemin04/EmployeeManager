import java.util.ArrayList;
import java.util.List;

public class FullTimeEmployee extends Employee {
    private List<PayStatement> payHistory;

    public FullTimeEmployee(String name, String phoneNumber, String emailAddress, int empId, String ssn, double salary, String jobTitle, String division) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.emailAddress = emailAddress;
        this.empId = empId;
        this.ssn = ssn;
        this.salary = salary;
        this.jobTitle = jobTitle;
        this.division = division;
        this.payHistory = new ArrayList<>();
    }

    @Override
    public void updateData(String field, String newValue) {
        switch (field.toLowerCase()) {
            case "name": name = newValue; break;
            case "phonenumber": phoneNumber = newValue; break;
            case "emailaddress": emailAddress = newValue; break;
            case "jobtitle": jobTitle = newValue; break;
            case "division": division = newValue; break;
            case "ssn": ssn = newValue; break;
        }
    }

    @Override
    public double getSalary() {
        return salary;
    }

    @Override
    public void setSalary(double salary) {
        this.salary = salary;
    }

    public List<PayStatement> getPayStatementHistory() {
        return payHistory;
    }

    public void addPayStatement(PayStatement pay) {
        payHistory.add(pay);
    }
}