/**
 *
 */
package arrayImpl;

import lab_3.PriorityQueueInterface;

/**
 * @author Peter Socha
 * 
 * 
 */


public class ArrayPriorityQueue<T extends Comparable<? super T>> implements PriorityQueueInterface <T> {
	private T[] theArray;
	private static final int DEFAULT_SIZE = 10;
	private int lastIndex;


	public ArrayPriorityQueue(int Capacity) {
		@SuppressWarnings("unchecked")
		T[] anArray = (T[]) new Object[Capacity];
		theArray = anArray;
	}

	public ArrayPriorityQueue() {
		// TODO Auto-generated constructor stub
		this(DEFAULT_SIZE);
	}
	@Override
	public void add(T newEntry) {
		// TODO Auto-generated method stub
		for (T genObj:theArray){
			if (newEntry.compareTo(genObj)>0){

			}
		}
	}

	@Override
	public T remove() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public T peek() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getCurrentSize() {
		// TODO Auto-generated method stub
		return 0;
	}


}
