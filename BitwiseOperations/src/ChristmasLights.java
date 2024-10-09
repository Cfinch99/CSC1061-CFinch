
public class ChristmasLights {
	private static final int NUM_LIGHTS = 32;
	public static void main(String[] args) {
		
		boolean[] xmasLts = new boolean[NUM_LIGHTS];
		
		for(int i = 0; i < NUM_LIGHTS; i++) {
			xmasLts[i] = true;
		}
		
		for(int i = 0; i < NUM_LIGHTS; i++) {
			System.out.printf("%-6b",xmasLts[i]);
		}
		System.out.println();
		//////////////////////////////////////////////////////////////
		
		int xmasBts = 0x0; // initializes all to 0.
		xmasBts = 0xFFFFFFFF; // turns them all on F = 1111, *8 = 32, 32 1's. constant time 
		// hex code is same as binary, just easier to read
		
		int mask = 1;
		for(int i = 0; i < NUM_LIGHTS; i++) {
			System.out.printf("%-6b", (xmasBts & mask) > 0);
			mask = mask << 1;	//left shift by one, all bits shift left by one, empty space become 0
		}
		System.out.println();
		

	}

}
