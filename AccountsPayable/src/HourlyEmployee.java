
public class HourlyEmployee extends Employee {
	private double hourlyWage;
	private double hoursWorked;
	
	public HourlyEmployee() {
		
	}
	
	public HourlyEmployee(String firstName, String lastName, int social, 
			double hourlyWage, double hoursWorked) {
		
		super(firstName, lastName, social);
		this.hourlyWage = hourlyWage;
		this.hoursWorked = hoursWorked;
	}


	public double getHourlyWage() {
		return hourlyWage;
	}


	public void setHourlyWage(double hourlyWage) {
		this.hourlyWage = hourlyWage;
	}


	public double getHoursWorked() {
		return hoursWorked;
	}


	public void setHoursWorked(double hoursWorked) {
		this.hoursWorked = hoursWorked;
	}
	
	
	
	@Override
	public double getPaymentAmount() {
		return hourlyWage * hoursWorked;
	}


	@Override
	public String toString() {
		return super.toString() + "Hourly Wage: " + hourlyWage + "\nHours Worked: " + hoursWorked 
				+ "\nPayment Amount: " + getPaymentAmount() + "\n";
	}
	
	

}
