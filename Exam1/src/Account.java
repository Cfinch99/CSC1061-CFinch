import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;

public class Account {
	private String customerName;
	protected int id = 0;
	protected double balance = 0;
	protected double annualInterestRate = 0;
	private LocalDate dateCreated = java.time.LocalDate.now();
	protected List<Transaction> traList = new LinkedList<>();
	
	
	// constructors
	public Account() {
		
	}
	
	public Account(int id, double balance) {
		this.id = id;
		this.balance = balance;
	}
	
	public Account(String customerName, int id, double balance, double annualInterestRate) {
		this.customerName = customerName;
		this.id = id;
		this.balance = balance;
		this.annualInterestRate = annualInterestRate;
	}
	public Account(String customerName) {
		this.customerName = customerName;
	}
	
	
// getters and setters
	
	
	public int getId() {
		return id;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public void setDateCreated(LocalDate dateCreated) {
		this.dateCreated = dateCreated;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public double getAnnualInterestRate() {
		return annualInterestRate;
	}

	public void setAnnualInterestRate(double annualInterestRate) {
		this.annualInterestRate = annualInterestRate;
	}

	public LocalDate getDateCreated() {
		return dateCreated;
	}
	
	// methods
	public double getMonthlyInterestRate() {
		return annualInterestRate / 12;
	}
	
	public double getMonthlyInterest() {
		return balance *(getMonthlyInterestRate() / 100);
	}
	public void withdraw(double amt) {
		this.balance = balance - amt;
		Transaction transactW = new Transaction("W",amt,this.balance);
		transactW.setNewBalance(this.balance);
		transactW.setTransactionAmount(amt);
		transactW.setTransactionType("W");
		traList.add(transactW);
	}
	public void deposit(double amt) {
		this.balance = balance + amt;
		Transaction transactD = new Transaction("D",amt,this.balance);
		transactD.setNewBalance(this.balance);
		transactD.setTransactionAmount(amt);
		transactD.setTransactionType("D");
		traList.add(transactD);
	}
	
	

}
