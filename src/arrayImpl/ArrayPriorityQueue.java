/**
 *
 */
package arrayImpl;

import java.lang.reflect.Array;

import com.sun.xml.internal.bind.v2.runtime.RuntimeUtil.ToStringAdapter;

import lab_3.Employee;
import lab_3.PriorityQueueInterface;

/**
 * @author Peter Socha
 *
 *
 */


public class ArrayPriorityQueue<T extends Comparable<? super T>> implements PriorityQueueInterface <T> {
	private T[] theArray;
	private static final int DEFAULT_SIZE = 10;
	private int capacity;
	private int numberOfEntries = 0;



	public ArrayPriorityQueue(int newCapacity) {

		@SuppressWarnings("unchecked")
		T[] anArray = (T[])(new Comparable[newCapacity]);
		theArray  = anArray;
	}

	public ArrayPriorityQueue() {
		// TODO Auto-generated constructor stub
		this(DEFAULT_SIZE);
	}
	@Override
	public void add(T newEntry) {
	//public void add(T newEntry) {

		System.out.println("Attempting to add employee" + newEntry.toString());
		// TODO Auto-generated method stub


		int addIndex = numberOfEntries - 1;
		while ( addIndex>= 0 && newEntry.compareTo(theArray[addIndex])<0){
		//while ( addIndex>= 0 && isLowerPriorityThan(newEntry,theArray[addIndex])){
			theArray[addIndex+1] = theArray[addIndex];
			addIndex--;
		}
		theArray[addIndex +1] = newEntry;
		numberOfEntries++;
	}

	@Override
	public T remove() {
		// TODO Auto-generated method stub
		T removedObject = theArray[getLastIndex()];
		theArray[getLastIndex()] = null;
		numberOfEntries--;
		return removedObject;


	}

	public int getLastIndex(){
		return numberOfEntries-1;
	}
	@Override
	public T peek() {
		// TODO Auto-generated method stub
		return theArray[getLastIndex()];
	}

	@Override
	public int getCurrentSize() {
		// TODO Auto-generated method stub
		int copyNumberOfEntries = numberOfEntries;
		return copyNumberOfEntries;
	}

	public T[] toArray(){
		@SuppressWarnings("unchecked")
		T[] populatedArrayCopy = (T[]) new Object[numberOfEntries];
		for(int i = 0; i<numberOfEntries;i++){
			populatedArrayCopy[i] = theArray[i];
		}
		return populatedArrayCopy;
	}

	public ArrayPriorityQueue<T> joinArrayPriorityQueues(ArrayPriorityQueue<T> apq1,ArrayPriorityQueue<T> apq2){
		int mergedCapacity = apq1.getCurrentSize() + apq2.getCurrentSize();
		ArrayPriorityQueue<T> mergedArrayPriorityQueue = new ArrayPriorityQueue<T>(mergedCapacity);

		for (int i =0; i< apq1.getCurrentSize();i++){
			mergedArrayPriorityQueue.add(apq1.remove());
		}
		for (int i =0; i< apq2.getCurrentSize();i++){
			mergedArrayPriorityQueue.add(apq2.remove());
		}
		return mergedArrayPriorityQueue;
	}


	public String toString(){
		String theString = "";
		for (int i = 0; i<numberOfEntries;i++){
			theString = theString + "\n" + theArray[i].toString();
		}
		return theString;
	}


}
