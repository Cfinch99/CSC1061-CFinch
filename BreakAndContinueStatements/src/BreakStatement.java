// array list or linked list. different type of lists to use

import java.util.LinkedList;
import java.util.List;

public class BreakStatement {

	public static void main(String[] args) {
		
		List<Integer> numbers = new LinkedList<Integer>();
		
		
		numbers.add(5);
		//autoboxing, creates Integer object for you
		numbers.add(Integer.valueOf(4));
		
		int secondElem = numbers.get(1);
		//unboxing, creates int from Integer
		// same as Integer something .intValue();
		// works with wrapper classes
		
		numbers.add(1);
		numbers.add(2);
		numbers.add(3);
		
		int index = -1;
		for(int i = 0; i < numbers.size(); i++) {
			if(numbers.get(i) == 2) {
				index = i;
				break;
				//stop the for loop once we found it
			}
		}
		int[] nums = {23, 45, 56, 34, 59, 80};
		for(int num : nums) {
			if(num % 2 > 0) {
				continue;
				//skipping odd elements/ iterations with odd number
				// continue takes you to next iteration, breaks takes you out
			}
			//if(num % 2 == 0) not needed, 
			int answer = num/2;
			System.out.println("The answer is " + answer);
		}
		
		for (int i = 0; i < numbers.size(); i++) {
			if(i % 2 > 0) {
				continue;
			}
			System.out.println("Element at next even index is " + numbers.get(i));
			// only printing even index, 0, 2, 4, etc.
		}
		for (int i = 0; i < numbers.size(); i++) {
			for (int j = 0; j < numbers.size(); j++) {
				if(j == 2) {
					break;
					//breaks from here to line 60, bottom of outer loop
					//if it was continue, would go up to 54
				}
			}
			//here
		}

	}

}
