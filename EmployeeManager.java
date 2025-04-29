import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeManager {
    public void addEmployee(FullTimeEmployee emp) {
        try (Connection conn = DBConnection.getConnection()) {
            String sql = "INSERT INTO employeeData (empId, name, phoneNumber, emailAddress, ssn, salary, jobTitle, division) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, emp.empId);
            stmt.setString(2, emp.name);
            stmt.setString(3, emp.phoneNumber);
            stmt.setString(4, emp.emailAddress);
            stmt.setString(5, emp.ssn);
            stmt.setDouble(6, emp.salary);
            stmt.setString(7, emp.jobTitle);
            stmt.setString(8, emp.division);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void addPayStatement(int empId, double amount) {
        try (Connection conn = DBConnection.getConnection()) {
            String sql = "INSERT INTO pay_statement (empId, date, amount) VALUES (?, CURRENT_DATE(), ?)";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, empId);
            stmt.setDouble(2, amount);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<PayStatement> getPayHistory(int empId) {
        List<PayStatement> history = new ArrayList<>();
        try (Connection conn = DBConnection.getConnection()) {
            String sql = "SELECT date, amount FROM pay_statement WHERE empId = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, empId);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                history.add(new PayStatement(rs.getDate("date"), rs.getDouble("amount")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return history;
    }

    public FullTimeEmployee searchEmployee(String keyword) {
        try (Connection conn = DBConnection.getConnection()) {
            String sql = "SELECT * FROM employeeData WHERE name = ? OR ssn = ? OR empId = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, keyword);
            stmt.setString(2, keyword);
            stmt.setString(3, keyword);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new FullTimeEmployee(
                        rs.getString("name"),
                        rs.getString("phoneNumber"),
                        rs.getString("emailAddress"),
                        rs.getInt("empId"),
                        rs.getString("ssn"),
                        rs.getDouble("salary"),
                        rs.getString("jobTitle"),
                        rs.getString("division")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void updateEmployee(int empId, String field, String newValue) {
        try (Connection conn = DBConnection.getConnection()) {
            String sql = "UPDATE employeeData SET " + field + " = ? WHERE empId = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, newValue);
            stmt.setInt(2, empId);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateSalary(double lowerBound, double upperBound, double percentage) {
        try (Connection conn = DBConnection.getConnection()) {
            String sql = "UPDATE employeeData SET salary = salary * (1 + ? / 100) WHERE salary >= ? AND salary < ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setDouble(1, percentage);
            stmt.setDouble(2, lowerBound);
            stmt.setDouble(3, upperBound);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<FullTimeEmployee> getEmployees() {
        List<FullTimeEmployee> employees = new ArrayList<>();
        try (Connection conn = DBConnection.getConnection()) {
            String sql = "SELECT * FROM employeeData";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                employees.add(new FullTimeEmployee(
                        rs.getString("name"),
                        rs.getString("phoneNumber"),
                        rs.getString("emailAddress"),
                        rs.getInt("empId"),
                        rs.getString("ssn"),
                        rs.getDouble("salary"),
                        rs.getString("jobTitle"),
                        rs.getString("division")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return employees;
    }
}