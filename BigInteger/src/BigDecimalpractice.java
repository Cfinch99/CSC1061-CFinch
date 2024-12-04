import java.math.BigDecimal;

public class BigDecimalpractice {

	public static void main(String[] args) {
		
		double val = 0.1;
		BigDecimal val2 = new BigDecimal("0.1");
		
		System.out.println(val * val);
		System.out.println(val2.multiply(val2));

	}

}
