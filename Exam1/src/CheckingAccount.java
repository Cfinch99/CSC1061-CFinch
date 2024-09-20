import java.time.LocalDate;

public class CheckingAccount extends Account {
	private double overdraftLimit = -200;
	//private int id = 0;
//	private double balance = 0;
//	private double annualInterestRate = 0;
//	private LocalDate dateCreated = java.time.LocalDate.now();
	private double overdraftFees;
	
	public CheckingAccount(int id, double balance, double annualInterestRate) {
		this.id = id;
		this.balance = balance;
		this.annualInterestRate = annualInterestRate;
	}
	public CheckingAccount(String customerName, int id, double balance, double annualInterestRate) {
		super(customerName, id, balance, annualInterestRate);
		this.id = id;
		this.balance = balance;
		this.annualInterestRate = annualInterestRate;
	}
	
	
	@Override
	public void withdraw(double amt) {
		if(balance - amt < overdraftLimit) {
			this.overdraftFees = Math.abs(balance - amt);
			System.out.println("Overdraft fees of " + overdraftFees + "$ incurred.");
			
		}
		this.balance = this.balance - amt;
		Transaction transactW = new Transaction("W",amt,this.balance);
		transactW.setNewBalance(this.balance);
		transactW.setTransactionAmount(amt);
		transactW.setTransactionType("W");
		traList.add(transactW);
		
	}

}
