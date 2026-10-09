package lib.bankaccounts;
public class IsaAccount extends InterestAccount {
    private int depositRemaining;
    public IsaAccount() {
        super();
        this.depositRemaining = 5000; // default allowance
    }
    public IsaAccount(int balance, int interestRate, int minimumBalance, int depositRemaining) {
        super(balance, interestRate, minimumBalance);
        this.depositRemaining = depositRemaining;
    }
    @Override
    public void deposit(int amount) {
        if (this.depositRemaining - amount >= 0) {
            this.depositRemaining -= amount;
            super.deposit(amount);
        } else {
            System.out.println("Deposit denied: Exceeds the deposit remaining limit.");
        }
    }
    public int getDepositRemaining() {
        return depositRemaining;
    }
    public void resetDepositRemaining() {
        this.depositRemaining = 5000;
    }
    @Override
    public String toString() {
        return super.toString() + "[depositRemaining=" + depositRemaining + "]";
    }
}