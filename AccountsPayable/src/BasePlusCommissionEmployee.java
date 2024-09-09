
public class BasePlusCommissionEmployee extends CommissionEmployee {
	private double basePay;

	public BasePlusCommissionEmployee() {
		
	}
	
	public BasePlusCommissionEmployee(String firstName, String lastName, int social, double grossSales,
			double commissionRate, double basePay) {
		super(firstName, lastName, social, grossSales, commissionRate);
		this.basePay = basePay;
	}

	public double getBasePay() {
		return basePay;
	}

	public void setBasePay(double basePay) {
		this.basePay = basePay;
	}
	
	@Override
	public double getPaymentAmount() {
		return basePay + (commissionRate * grossSales);
	}
	
	@Override
	public String toString() {
		return super.toString() + "Base Pay: " + basePay + "\n";
	}
	

}
