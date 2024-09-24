
public class Faculty extends Employee{
	private String officeHours;
	private String rank;//junior senior
	
	public Faculty(String name, String address, long phone, String email, 
			String office, double salary, String dateHired, 
				String officeHours, String rank) {
		super(name, address, phone, email, office, salary, dateHired);
		this.officeHours = officeHours;
		this.rank = rank;
	}

	public String getOfficeHours() {
		return officeHours;
	}

	public void setOfficeHours(String officeHours) {
		this.officeHours = officeHours;
	}

	public String getRank() {
		return rank;
	}

	public void setRank(String rank) {
		this.rank = rank;
	}

	@Override
	public String toString() {
		return "Faculty [officeHours=" + officeHours + ", rank=" + rank + ", " + super.toString() + "]";
	}
	
	
	
	

}
