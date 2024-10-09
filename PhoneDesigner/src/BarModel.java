
public class BarModel implements Repairable{
	private final String PROCESSOR = "DragonSlayer 600";
	private final int CACHE = 8;
	private final int STORAGE = 32; //mb not gb
	
	
	
	
	
	
	
	
	
	
	
	
	
	@Override
	public String howToRepair() {
		return "Turn it off and back on again";
	}
	@Override
	public String costToRepair() {
		return "$5.00";
	}
	@Override
	public String toString() {
		return "BarModel [PROCESSOR=" + PROCESSOR + ", CACHE=" + CACHE + "MB, STORAGE=" + 
					STORAGE + "MB]";

}
}
