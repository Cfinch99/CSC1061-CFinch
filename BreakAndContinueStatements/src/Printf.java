
public class Printf {

	public static void main(String[] args) {
		int num = 67;
		int num2 = 4595492;
		
		
		//%d for int
		//%f for floating point
		//%s for string
		
		System.out.printf("The first number is %70d, the second is %,d\n", num, num2);
		
		
		float fnum = 4.5f;
		double fnum2 = 4.567;
		System.out.printf("Number one is %.1f, the other one is %.80f\n", fnum, fnum2);
		
		String str = "Howdy";
		System.out.printf("%s" + " How are you %%", str);
		
	}

}
