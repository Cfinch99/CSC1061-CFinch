
public class NonLendingBank extends FIAbstract{

	public NonLendingBank(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}

	@Override
	public double getInterestRate() throws UnsupportedOperationException{
		throw new UnsupportedOperationException("This bank does not lend money");
	}

}
