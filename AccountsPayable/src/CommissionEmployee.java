
public class CommissionEmployee extends Employee{
	protected double grossSales;
	protected double commissionRate;
	
	public CommissionEmployee() {
		
	}
	
	public CommissionEmployee(String firstName, String lastName, int social, 
			double grossSales, double commissionRate) {
		
		super(firstName, lastName, social);
		this.grossSales = grossSales;
		this.commissionRate = commissionRate;
	}

	public double getGrossSales() {
		return grossSales;
	}

	public void setGrossSales(double grossSales) {
		this.grossSales = grossSales;
	}

	public double getCommissionRate() {
		return commissionRate;
	}

	public void setCommissionRate(double commissionRate) {
		this.commissionRate = commissionRate;
	}
	
	@Override
	public double getPaymentAmount() {
		return grossSales * commissionRate;
	}

	@Override
	public String toString() {
		return super.toString() + "Gross Sales: " + grossSales + "\nCommission Rate: "
				+ commissionRate + "\nPayment Amount: " + getPaymentAmount() + "\n";
	}
	

}
