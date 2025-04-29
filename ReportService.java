import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class ReportService {
    private EmployeeManager manager;

    public ReportService(EmployeeManager manager) {
        this.manager = manager;
    }

    public void viewPayHistory(FullTimeEmployee emp) {
        List<PayStatement> history = manager.getPayHistory(emp.empId);
        if (history.isEmpty()) {
            System.out.println("No pay statements found.");
        } else {
            for (PayStatement pay : history) {
                System.out.println("Date: " + pay.getDate() + " | Amount: $" + pay.getAmount());
            }
        }
    }

    public void payByDivision() {
        try (Connection conn = DBConnection.getConnection()) {
            String sql = "SELECT division, SUM(salary) AS total FROM employeeData GROUP BY division";
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            System.out.println("Total Pay by Division:");
            while (rs.next()) {
                System.out.println(rs.getString("division") + ": $" + rs.getDouble("total"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void payByJobTitle() {
        try (Connection conn = DBConnection.getConnection()) {
            String sql = "SELECT jobTitle, SUM(salary) AS total FROM employeeData GROUP BY jobTitle";
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            System.out.println("Total Pay by Job Title:");
            while (rs.next()) {
                System.out.println(rs.getString("jobTitle") + ": $" + rs.getDouble("total"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}