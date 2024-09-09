
public class SalariedEmployee extends Employee {
	
	private double weeklySalary = 0;

	
	public SalariedEmployee() {
		
	}
	public SalariedEmployee(String firstName, String lastName, int social, double weeklySalary) {
		super(firstName, lastName, social);
		this.weeklySalary = weeklySalary;
	}

	public double getWeeklySalary() {
		return weeklySalary;
	}

	public void setWeeklySalary(double weeklySalary) {
		this.weeklySalary = weeklySalary;
	}
	
	@Override
	public double getPaymentAmount() {
		return weeklySalary;
	}

	@Override
	public String toString() {
		return super.toString() + "Weekly Salary: " + weeklySalary + "\n";
	}
	
	

}
