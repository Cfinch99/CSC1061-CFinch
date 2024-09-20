import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class TestFIAbstract {

	public static void main(String[] args) throws CloneNotSupportedException{
	//	FIAbstract fi = new FIAbstract("The Bank");
	//	cannot be instantiated
		
		FIAbstract fi1 = new Bank("Bank1");
		fi1.setFinancialInstitutionID(34);
		FIAbstract fi2 = new CreditUnion("Credit1");
		fi2.setFinancialInstitutionID(67);
		FIAbstract fi3 = new NonLendingBank("NoLoan1");
		fi3.setFinancialInstitutionID(90);
		
		List<FIAbstract> fiList = new LinkedList<>();
		fiList.add(fi2);
		fiList.add(fi3);
		fiList.add(fi1);
		
		for(FIAbstract fi: fiList) {
			System.out.println(fi);
		}
		// sorting based off our compareTo in FIAbstract
		
		Collections.sort(fiList);
		System.out.println();
		for(FIAbstract fi: fiList) {
			System.out.println(fi);
		}
		System.out.println();
		
		fi1.setAddress(new Address());
		fi1.getAddress().line1 = "6969 something st";
		
		System.out.println(fi1.getAddress().line1);
		FIAbstract fi4 = fi1.clone();
		fi4.setAddress(new Address());
		fi4.getAddress().line1 = "89 something else st";
		System.out.println(fi4.getAddress().line1);
		System.out.println(fi1.getAddress().line1);
		
		
		
		
	}

}
