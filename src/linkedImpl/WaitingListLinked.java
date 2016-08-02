/**
 *
 */
package linkedImpl;

import lab_3.Employee;

/**
 * @author Peter Socha
 *
 */
public class WaitingListLinked {

	private LinkedPriorityQueue<Employee> waitingList;

	public WaitingListLinked(){
		waitingList = new LinkedPriorityQueue<>();
	}	// end constructor

	public void addEmployee(Employee newEmployee){
		waitingList.add(newEmployee);
	}	// end addEmployee

	public void addEmployee(String fullName, String dateOfHire){
		Employee newEmployee  = new Employee(fullName, dateOfHire);
		addEmployee(newEmployee);
	}//end addEmployee

	public Employee getNextEmployee(){
		return waitingList.peek();
	} // end getNextEmployee
}
