import java.time.LocalDate;

public class Transaction {
	private LocalDate transactionDate = java.time.LocalDate.now();
	private String transactionType;
	private double transactionAmount;
	private double newBalance;
	
	public Transaction() {
		
	}
	public Transaction(String transactionType, double transactionAmount, double newBalance) {
		this.transactionDate = java.time.LocalDate.now();
		
	}




	public String getTransactionType() {
		return transactionType;
	}


	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}


	public double getTransactionAmount() {
		return transactionAmount;
	}


	public void setTransactionAmount(double transactionAmount) {
		this.transactionAmount = transactionAmount;
	}


	public double getNewBalance() {
		return newBalance;
	}


	public void setNewBalance(double newBalance) {
		this.newBalance = newBalance;
	}
	
	@Override
	public String toString() {
		return "Transaction [transactionDate=" + transactionDate + ", transactionType=" + transactionType
				+ ", transactionAmount=" + transactionAmount + ", newBalance=" + newBalance + "]";
	}

}
