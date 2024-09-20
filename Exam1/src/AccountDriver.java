
public class AccountDriver {

	public static void main(String[] args) {
//		Account ac1 = new Account(1122, 20000);
//		ac1.setAnnualInterestRate(4.5);
//		ac1.withdraw(2500);
//		ac1.deposit(3000);
//		System.out.println("Account ID: " + ac1.getId() + "\nDate Created: " + ac1.getDateCreated()
//		+ "\nBalance: " + ac1.getBalance() + "\nMonthly Interest: " + ac1.getMonthlyInterest());
//		
//		
//		CheckingAccount ca1 = new CheckingAccount(15,100,2);
//		ca1.withdraw(50);
//		
//		SavingsAccount sav1 = new SavingsAccount(3,200);
//		sav1.withdraw(201);
		
//		for(Transaction tr: ca1.traList) {
//			System.out.println(tr);
//		}
		
		CheckingAccount check1 = new CheckingAccount("George", 1122, 1000, 1.5);
		check1.deposit(30);
		check1.deposit(40);
		check1.deposit(50);
		check1.withdraw(5);
		check1.withdraw(4);
		check1.withdraw(2);
		
		System.out.println("Account ID: " + check1.getId());
		System.out.println("Account name: " + check1.getCustomerName());
		System.out.println("Annual Interest Rate: " + check1.getAnnualInterestRate() + "%");
		System.out.println("Balance: " + check1.getBalance());
		
		for(Transaction tr: check1.traList) {
			System.out.println(tr);
		}
		System.out.println(check1.getBalance());

	}

}
