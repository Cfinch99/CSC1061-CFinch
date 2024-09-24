
public class Staff extends Employee{
	private String title;

	
	public Staff(String name, String address, long phone, String email, String office, 
				double salary, String dateHired, String title) {
		super(name, address, phone, email, office, salary, dateHired);
		this.title = title;
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	@Override
	public String toString() {
		return "Staff [title=" + title + ", " + super.toString() + "]";
	}


	
	
	
	
	

}
