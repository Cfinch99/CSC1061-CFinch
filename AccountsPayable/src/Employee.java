
public class Employee {
	private String firstName = "No first name given";
	private String lastName = "No last name given";
	private int social = 000000000;
	
	
	public Employee() {
		super();
	}


	public Employee(String firstName, String lastName, int social) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.social = social;
	}


	public String getFirstName() {
		return firstName;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public String getLastName() {
		return lastName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	public int getSocial() {
		return social;
	}

	
	public void setSocial(int social) {
		this.social = social;
	}


	
	
	public double getPaymentAmount(){
		return 0;
		
	}
	
	@Override
	public String toString() {
		return "Employee:\n" + "First Name: " + firstName + "\nLast Name: " + lastName + 
				"\nSocial: " + social + "\n";
	}
	
	

}
