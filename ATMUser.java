import javax.swing.JOptionPane;

public class ATMUser extends Account {

    public ATMUser(String accountNumber, String pin, double balance) {
        super(accountNumber, pin, balance);
    }

    @Override
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            JOptionPane.showMessageDialog(null, "Deposited: " + amount);
        } else {
            JOptionPane.showMessageDialog(null, "Invalid amount!");
        }
    }

    @Override
    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            JOptionPane.showMessageDialog(null, "Withdrawn: " + amount);
        } else {
            JOptionPane.showMessageDialog(null, "Insufficient balance or invalid amount!");
        }
    }
}
