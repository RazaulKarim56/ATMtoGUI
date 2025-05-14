public abstract class Account {
    protected String accountNumber;
    protected String pin;
    protected double balance;

    public Account(String accountNumber, String pin, double balance) {
        this.accountNumber = accountNumber;
        this.pin = pin;
        this.balance = balance;
    }

    public boolean authenticate(String enteredPin) {
        return this.pin.equals(enteredPin);
    }

    public double getBalance() {
        return balance;
    }

    public abstract void deposit(double amount);
    public abstract void withdraw(double amount);
}
