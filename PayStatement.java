import java.sql.Date;

public class PayStatement {
    private Date date;
    private double amount;

    public PayStatement(Date date, double amount) {
        this.date = date;
        this.amount = amount;
    }

    public Date getDate() { return date; }
    public double getAmount() { return amount; }
}