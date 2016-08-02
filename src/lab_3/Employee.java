package lab_3;

import java.util.Calendar;

public class Employee implements Comparable<Employee> {

	Employee(String firstLast, String YYYYMMDD) {
		setFullname(firstLast);
		setDateOfHire(Integer.getInteger(YYYYMMDD.substring(0, 3)), Integer.getInteger(YYYYMMDD.substring(4, 5)),
				Integer.getInteger(YYYYMMDD.substring(6, 7)));
	}

	private String fullName = "";
	private Calendar dateOfHire = Calendar.getInstance();

	@Override
	public int compareTo(Employee o) {
		// TODO Auto-generated method stub
		return dateOfHire.compareTo(o.getDateOfHire());

	}

	public void setFullname(String firstLast) {
		fullName = firstLast;
	}

	public void setDateOfHire(int year, int month, int date) {
		dateOfHire.set(year, month, date);
	}

	public Calendar getDateOfHire() {
		return dateOfHire;
	}

	public String getFullName() {
		return fullName;
	}
}
