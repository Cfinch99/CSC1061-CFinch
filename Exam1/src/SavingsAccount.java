//import java.time.LocalDate;

public class SavingsAccount extends Account {
	private double overdraftLimit = 0;
//	private double balance = 0;
//	private int id = 0;
//	private double annualInterestRate = 0;
//	private LocalDate dateCreated = java.time.LocalDate.now();
	
	public SavingsAccount(int id, double balance) {
		this.id = id;
		this.balance = balance;
	}
	
	@Override
	public void withdraw(double amt) {
		if(amt > this.balance) {
			System.out.print("Cannot withdraw more than current balance\n");
	
		}
		else {
			this.balance = balance - amt;
		}
		
	}

}
