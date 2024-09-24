import java.io.IOException;

public class TestSchoolRecords {

	public static void main(String[] args) throws IOException {
		Student stu = new Student("greg", "45 highway rd", 9708657869l, "Email@email.com", "Sophomore");
		Student stu2 = new Student("greg", "45 highway rd", 9708657869l, "Email@email.com", "Sophomore");
		System.out.println(stu.toString());
		Database dat = new Database();
		dat.writePerson(stu);
		dat.writePerson(stu2);
	}

}
