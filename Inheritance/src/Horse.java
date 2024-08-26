
public class Horse extends Animal{
	
	
	@Override
	public String makeSound() {
		return ("Neigh pbbtbtb");
	}
	
	@Override
	public String toString() {
		return "Horse [toString()=" + super.toString() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
				+ "]";
	}
	
	

}
