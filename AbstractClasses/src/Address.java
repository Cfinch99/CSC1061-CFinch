
public class Address implements Cloneable {
	
	public String line1;
	public String line2;
	public String city;
	public String state;
	public long zip;

	public Address clone() throws CloneNotSupportedException{
		Address clone = (Address) super.clone();
		return clone;
	}
}
