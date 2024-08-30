import java.util.Scanner;
public class CreditCardValidationProc {
	
	private static Scanner scn = new Scanner(System.in);

	public static void main(String[] args) {
		
		System.out.println("Enter a credit card number: ");
		long cardNum = scn.nextLong();
		
		String cardNumStr = Long.toString(cardNum);
		
		if(cardNumStr.length() < 13 || cardNumStr.length() > 16) {
			System.out.println("Card number is not valid.");
			System.exit(-1);
		}
		
		if(isValid(cardNum)) {
			System.out.println("The card is valid.");
		}
		else {
			System.out.println("The card is invalid.");
		}
		
		
		

	}

	private static boolean isValid(long number) {
		long prefix = getPrefix(number, 1);
		if(prefix != 4 && prefix != 5 && prefix != 6) {
			if(getPrefix(number, 2) != 37) {
				return false;
			}
		}
		
		int evenSum = sumOfDoubleEvenPlace(number);
		int oddSum = sumOfDoubleOddPlace(number);
		
		int total = evenSum + oddSum;
		if (total %10 > 0) {
			return false;
		}
		return true;
	}

	private static int sumOfDoubleEvenPlace(long number) {
		String str = Long.toString(number);
		int sum = 0;
		
		for(int i = str.length() -2; i >= 0; i -= 2) {
			int product = Character.getNumericValue(str.charAt(i)) * 2;
			int digit = getDigit(product);
			sum += digit;
		}
		return sum;
	}
	private static int sumOfDoubleOddPlace(long number) {
		String str = Long.toString(number);
		int sum = 0;
		
		for(int i = str.length() -1; i >= 0; i -= 2) {
			sum += Character.getNumericValue(str.charAt(i));
		}
		return sum;
	}

	private static int getDigit(int num) {
		int digit = num;
		
		switch(num) {
		case 10:
			digit = 1;
			break;
		case 12:
			digit = 3;
			break;
		case 14:
			digit = 5;
			break;
		case 16:
			digit = 7;
			break;
		case 18:
			digit = 9;
			break;
		default:
			break;
		}
		return digit;
	}

	private static long getPrefix(long number, int numDigits) {
		String str = Long.toString(number);
		if(str.length() < numDigits) {
			return number;
		}
		else {
			String newStr = str.substring(0,numDigits);
			long retNum = Long.parseLong(newStr);
			return retNum;
		}
	}

}
