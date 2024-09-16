
public abstract class Animal {
	
	private String name;
	private double weight;
	private double height;
	
	
	
	
	
	
	public abstract String makeSound();
		
	
	
//	public String makeSound() {
//		return ("Blah Blah");
//	}
	
	@Override
	public boolean equals(Object anim) {
		return true;
	}
	
	@Override
	public String toString() {
		return "Animal [name=" + name + ", weight=" + weight + ", height=" + height + "]";
	}
	
	

}
