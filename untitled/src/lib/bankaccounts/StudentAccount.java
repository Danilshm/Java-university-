package lib.bankaccounts;
public class StudentAccount extends BankAccount {
    private int overdraftLimit;
    public StudentAccount() {
        super();
        this.overdraftLimit = 500; // default overdraft limit
    }
    public StudentAccount(int balance, int overdraftLimit) {
        super(balance);
        this.overdraftLimit = overdraftLimit;
    }
    public int getOverdraftLimit() {
        return overdraftLimit;
    }
    public void setOverdraftLimit(int overdraftLimit) {
        this.overdraftLimit = overdraftLimit;
    }
    @Override
    public void withdraw(int amount) {
        if (super.getBalance() - amount >= -overdraftLimit) {
            super.withdraw(amount);
        } else {
            System.out.println("Withdrawal denied: Exceeds overdraft limit.");
        }
    }
    @Override
    public String toString() {
        return super.toString() + "[overdraftLimit=" + overdraftLimit + "]";
    }
}