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
	private int lastIndex = 0;
	private int capacity;


	
	public ArrayPriorityQueue(int newCapacity) {
		capacity = newCapacity;
		/*
		//T [] anArray = (T[]) new Object[capacity];
	    private Key[] pq;          // elements
	    private int n;             // number of elements
	    // set inititial size of heap to hold size elements
	    public OrderedArrayMaxPQ(int capacity) {
	        pq = (Key[]) (new Comparable[capacity]);
	        n = 0;
	    }
	*/	
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
		

		int addIndex = lastIndex - 1;
		while ( addIndex>= 0 && newEntry.compareTo(theArray[addIndex])<0){
		//while ( addIndex>= 0 && isLowerPriorityThan(newEntry,theArray[addIndex])){
			theArray[addIndex+1] = theArray[addIndex];
			addIndex--;
		}
		theArray[addIndex +1] = newEntry;
		lastIndex++;
	}

	@Override
	public T remove() {
		// TODO Auto-generated method stub
		T removedObject = theArray[lastIndex];
		theArray[lastIndex] = null;
		lastIndex++;
		return removedObject;
		
		
	}
	
	@Override
	public T peek() {
		// TODO Auto-generated method stub
		return theArray[lastIndex];
	}

	@Override
	public int getCurrentSize() {
		// TODO Auto-generated method stub
		int lastIndexCopy = lastIndex;
		return lastIndexCopy;
	}
	
	public T[] toArray(){
		@SuppressWarnings("unchecked")
		T[] populatedArrayCopy = (T[]) new Object[lastIndex];
		for(int i = 0; i<lastIndex;i++){
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
		for (int i = 0; i<lastIndex;i++){
			theString = theString + "\n" + theArray[i].toString();
		}
		return theString;
	}

}
