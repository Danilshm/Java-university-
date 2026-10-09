package main;
import java.util.ArrayList;

import lib.bankaccounts.BankAccount;
import lib.bankaccounts.InterestAccount;

public class BankAccountDemo {

	public static void main(String[] args) {
		/* Testing BankAccount */
		BankAccount acc = new BankAccount(100);
		System.out.println(acc.toString());
		acc.deposit(50);
		acc.withdraw(40);
		System.out.println(acc.getBalance()); //balance = 110
		acc.withdraw(150);
		System.out.println(acc.getBalance()); //balance = -40


		/* Testing InterestAccount */
		var intacc = new InterestAccount(3000, 5, 1000); //can use var if you wish variable to be same type as object
		System.out.println("\n" + intacc.toString());
		intacc.withdraw(1800);
		System.out.println(intacc.getBalance()); //balance = 1200
		intacc.addInterest();
		System.out.println(intacc.getBalance()); //balance = 1260
		intacc.withdraw(500);
		System.out.println(intacc.getBalance()); //balance = 1260 - no change


		/* Notice how an instance of a sub-class can be assigned
		 * to a variable of super-class type. Dynamic method lookup
		 * ensures the overridden InterestAccount withdraw(...) method
		 * is invoked. However, if you try to invoke the addInterest()
		 * method it will not work as BankAccount does not implement it. */
		BankAccount myacc = new InterestAccount(1500, 2, 1000);
		System.out.println("\n" + myacc.toString()); //displays InterestAccount even though stored in BankAccount variable
		System.out.println(myacc.getBalance()); //balance = 1500
		myacc.withdraw(600);
		System.out.println(myacc.getBalance()); //balance = 1500 - no change
		//myacc.addInterest(); // <--- try removing this comment, will give syntax error
		InterestAccount iacc = (InterestAccount) myacc;
		iacc.addInterest(); // now it's ok to call this method after downcast

		/* TEST StudentAccount here... */
		var stuAcc = new lib.bankaccounts.StudentAccount(500, 1000);
		System.out.println("\n" + stuAcc.toString());
		stuAcc.withdraw(1000);
		System.out.println(stuAcc.getBalance());
		stuAcc.withdraw(600);
		System.out.println(stuAcc.getBalance());


		/* TEST IsaAccount here... */
		var isaAcc = new lib.bankaccounts.IsaAccount(1000, 5, 100, 1000); // Remaining limit is 1000
		System.out.println("\n" + isaAcc.toString());
		isaAcc.deposit(600);
		System.out.println("Balance: " + isaAcc.getBalance() + " | Limit remaining: " + isaAcc.getDepositRemaining());
		isaAcc.deposit(401);
		System.out.println("Balance: " + isaAcc.getBalance() + " | Limit remaining: " + isaAcc.getDepositRemaining());
		isaAcc.resetDepositRemaining();
		System.out.println("Limit remaining after reset: " + isaAcc.getDepositRemaining());


		/* Create ArrayList to hold different types of bank account. */
		var banks = new ArrayList<BankAccount>();
		//Objects of type BankAccount or any of its subclasses can be added
		banks.add(new BankAccount(3000));  
		banks.add(new InterestAccount(2500, 3, 1000));
		banks.add(new InterestAccount(6000, 5, 5000));
		banks.add(new BankAccount(1200));
		/* ADD objects of type StudentAccount and IsaAccount once implemented */
		banks.add(new lib.bankaccounts.StudentAccount(200, 500));
		System.out.println("\nProcessing bank accounts in list...");
		banks.add(new lib.bankaccounts.IsaAccount(500, 4, 100, 2000)); // Add instance to ArrayList[cite: 4]
		//different type of object can be processed uniformly, this is known as polymorphism 
		for (BankAccount b : banks) {
			//subclass instances will either invoke inherited or overridden methods
			System.out.println("=====\n" + b.toString());
			System.out.println("Balance = " + b.getBalance());
			b.deposit(300);
			System.out.println("Balance = " + b.getBalance());
			b.withdraw(1500);
			System.out.println("Balance = " + b.getBalance());
		}


		System.out.println("\nOutputting specific account details...");
		for (BankAccount b : banks) {
			//pattern matching is used here to downcast object allowing subclass specific methods to be used
			if  (b instanceof InterestAccount ia) {
				System.out.println("InterestAccount, balance=" + ia.getBalance() + " and interest rate=" + ia.getInterestRate());
			} else if (b instanceof BankAccount ba) { //important to check for subclasses first
				System.out.println("BankAccount, balance=" + ba.getBalance());
			}
		}



	}
}

