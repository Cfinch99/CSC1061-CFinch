
public abstract class FIAbstract implements Comparable<FIAbstract>, Cloneable {	
	private String fiName;
	private long financialInstitutionID;
	private long routingNumber;
	private Address address;
	
	public FIAbstract(String name) {
		fiName=name;
	}
	
	public String getFiName() {
		return fiName;
	}

	public void setFiName(String fiName) {
		this.fiName = fiName;
	}

	public long getFinancialInstitutionID() {
		return financialInstitutionID;
	}

	public void setFinancialInstitutionID(long financialInstitutionID) {
		this.financialInstitutionID = financialInstitutionID;
	}

	public long getRoutingNumber() {
		return routingNumber;
	}

	public void setRoutingNumber(long routingNumber) {
		this.routingNumber = routingNumber;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public abstract double getInterestRate();

	@Override
	public int compareTo(FIAbstract other) {
		if (financialInstitutionID < other.financialInstitutionID) {
			return -1;
		}
		if (financialInstitutionID > other.financialInstitutionID) {
			return 1;
		}
		return 0;
	}
	@Override
	public FIAbstract clone() throws CloneNotSupportedException{
		FIAbstract clone = (FIAbstract) super.clone();
		clone.address = address.clone();
		return clone;
	}
	
	@Override
	public String toString() {
		return "FIAbstract [fiName=" + fiName + ", financialInstitutionID=" + financialInstitutionID
				+ ", routingNumber=" + routingNumber + ", address=" + address + "]";
	}

}
