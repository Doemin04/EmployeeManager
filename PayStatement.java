import java.time.LocalDate;

public class PayStatement {
    private LocalDate date;
    private double amount;

    public PayStatement(LocalDate date, double amount) {
        this.date = date;
        this.amount = amount;
    }

    public LocalDate getDate() { return date; }
    public double getAmount() { return amount; }
}