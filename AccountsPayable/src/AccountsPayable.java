import java.util.Scanner;

public class AccountsPayable {
	static Scanner in = new Scanner(System.in);

	public static void main(String[] args) {
		String firstName;
		String lastName;
		int social;
		double weeklySalary;
		double grossSales;
		double commissionRate;
		double hourlyWage;
		double hoursWorked;
		double basePay;

		Employee[] payableEmployees = new Employee[6];

		for (int i = 0; i < 6; i++) {
			System.out
					.println("Enter Employee Type:\n1 for Salary\n2 for Commission\n3 for Hourly" + "\n4 for BasePlus");
			int emp = in.nextInt();

			switch (emp) {
			// Salary
			case 1:
				int empNum = i;

				payableEmployees[i] = new SalariedEmployee();
				System.out.println("Enter first name: ");
				firstName = in.next();
				payableEmployees[i].setFirstName(firstName);
				System.out.println("Enter last name: ");
				lastName = in.next();
				payableEmployees[i].setLastName(lastName);
				System.out.println("Enter social: ");
				social = in.nextInt();
				payableEmployees[i].setSocial(social);
				System.out.println("Enter weekly salary: ");
				weeklySalary = in.nextDouble();
				((SalariedEmployee) payableEmployees[i]).setWeeklySalary(weeklySalary);
				break;
			// Commission
			case 2:
				payableEmployees[i] = new CommissionEmployee();
				System.out.println("Enter first name: ");
				firstName = in.next();
				payableEmployees[i].setFirstName(firstName);
				System.out.println("Enter last name: ");
				lastName = in.next();
				payableEmployees[i].setLastName(lastName);
				System.out.println("Enter social: ");
				social = in.nextInt();
				payableEmployees[i].setSocial(social);
				System.out.println("Enter gross sales: ");
				grossSales = in.nextDouble();
				((CommissionEmployee) payableEmployees[i]).setGrossSales(grossSales);
				System.out.println("Enter commission rate: ");
				commissionRate = in.nextDouble();
				((CommissionEmployee) payableEmployees[i]).setCommissionRate(commissionRate);
				break;
			// Hourly
			case 3:
				payableEmployees[i] = new HourlyEmployee();
				System.out.println("Enter first name: ");
				firstName = in.next();
				payableEmployees[i].setFirstName(firstName);
				System.out.println("Enter last name: ");
				lastName = in.next();
				payableEmployees[i].setLastName(lastName);
				System.out.println("Enter social: ");
				social = in.nextInt();
				payableEmployees[i].setSocial(social);
				System.out.println("Enter hourly wage: ");
				hourlyWage = in.nextDouble();
				((HourlyEmployee) payableEmployees[i]).setHourlyWage(hourlyWage);
				System.out.println("Enter hours worked: ");
				hoursWorked = in.nextDouble();
				((HourlyEmployee) payableEmployees[i]).setHoursWorked(hoursWorked);
				break;
			// BasePlus
			case 4:
				payableEmployees[i] = new BasePlusCommissionEmployee();
				System.out.println("Enter first name: ");
				firstName = in.next();
				payableEmployees[i].setFirstName(firstName);
				System.out.println("Enter last name: ");
				lastName = in.next();
				payableEmployees[i].setLastName(lastName);
				System.out.println("Enter social: ");
				social = in.nextInt();
				payableEmployees[i].setSocial(social);
				System.out.println("Enter base pay: ");
				basePay = in.nextDouble();
				((BasePlusCommissionEmployee) payableEmployees[i]).setBasePay(basePay);
				System.out.println("Enter gross sales: ");
				grossSales = in.nextDouble();
				((BasePlusCommissionEmployee) payableEmployees[i]).setGrossSales(grossSales);
				System.out.println("Enter commission rate: ");
				commissionRate = in.nextDouble();
				((BasePlusCommissionEmployee) payableEmployees[i]).setCommissionRate(commissionRate);
				break;

			}
		}
		// traverse and print array
		for (int i = 0; i < 6; i++) {
			System.out.println(EmployeePrintToString(payableEmployees[i]));
		}
		//traverse and increase base plus employee's base pay by %10
		for (int i = 0; i < 6; i++) {
			if (payableEmployees[i] instanceof BasePlusCommissionEmployee) {
				double temp = ((BasePlusCommissionEmployee) payableEmployees[i]).getBasePay();
				double raise = temp + (temp / 10);
				((BasePlusCommissionEmployee) payableEmployees[i]).setBasePay(raise);
			}
		}
		// traverse again
		for (int i = 0; i < 6; i++) {
			System.out.println(EmployeePrintToString(payableEmployees[i]));
		}
	}

	public static String EmployeePrintToString(Employee emp) {
		return emp.toString();
	}
	public static String EmployeePrint(Employee emp) {
		return null;
		}
	}


