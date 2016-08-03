package lab_3;

import java.util.Calendar;

public class Employee implements Comparable<Employee> {

	public Employee(String firstLast, String YYYYMMDD) {
		setFullname(firstLast);
		setDateOfHire(
				Integer.valueOf(YYYYMMDD.substring(0, 4)), 
				Integer.valueOf(YYYYMMDD.substring(4, 6)),
						Integer.valueOf(YYYYMMDD.substring(6, 8))
				);
	}

	private String fullName = "";
	private Calendar dateOfHire = Calendar.getInstance();

	@Override
	public int compareTo(Employee otherEmployee) {
		// TODO Auto-generated method stub
		return dateOfHire.compareTo(otherEmployee.getDateOfHire())*-1;
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
