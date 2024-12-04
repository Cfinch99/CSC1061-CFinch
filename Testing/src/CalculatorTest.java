import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CalculatorTest {
	
	Calculator calc;
	
	@BeforeEach
	void setup() {
		calc = new Calculator();
	}
	@Test
	@DisplayName("Addition Test")
	@Disabled("not used currently")
	void testAdd() {
		assertEquals(9, calc.add(4, 5), "Addition of 4 and 5 does not work");
		assertTrue(calc.add(3, 0) == 3, "Addition of 3 and 0 does not work");
	}

}
