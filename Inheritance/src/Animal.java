
public class Animal {
	
	private String name;
	private double weight;
	private double height;
	
	
	
	
	
	
	public String makeSound() {
		return ("Blah Blah");
	}
	
	@Override
	public boolean equals(Object anim) {
		return true;
	}
	
	@Override
	public String toString() {
		return "Animal [name=" + name + ", weight=" + weight + ", height=" + height + "]";
	}
	
	

}
