public abstract class Employee {
    protected String name;
    protected String phoneNumber;
    protected String emailAddress;
    protected int empId;
    protected String ssn;
    protected double salary;
    protected String jobTitle;
    protected String division;

    public abstract void updateData(String field, String newValue);
    public abstract double getSalary();
    public abstract void setSalary(double salary);
}