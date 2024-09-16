
public abstract class FIAbstract {	
	private String fiName;
	private long financialInstitutionID;
	private long routingNumber;
	private String address;
	
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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public abstract double getInterestRate();

}
