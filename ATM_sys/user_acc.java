package ATM_sys;

class user_acc {
    private double balance;

    public user_acc(double balance) {
        this.balance = balance;
    }

    public double getBalance() {
        return balance;
    }

    public String deposit(double amount) {
        balance += amount;
        return "Deposited $" + amount + ". New balance: $" + balance;
    }

    public String withdraw(double amount) {
        if (amount > balance) {
            return "Insufficient funds";
        }
        balance -= amount;
        return "Withdrew $" + amount + ". New balance: $" + balance;
    }
}