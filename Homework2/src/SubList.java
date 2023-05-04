import java.util.Vector;

public class SubList<E> implements HList<E> {

	private Vector<E> subVector = new Vector<E>();
	private int fromIndex;
	private int toIndex;
	
	public SubList(Vector<E> v, int f, int t) {
		
		//IndexOutOfBoundsException - for an illegal endpoint index value (fromIndex < 0 || toIndex > size || fromIndex > toIndex)
		if(f < 0 || t > v.size() || f > t) throw new IndexOutOfBoundsException();
		
		subVector = v;
		fromIndex = f;
        toIndex = t;
	}
	
	//Inserts the specified element at the specified position in this list (optional operation).
	public void add(int index, E element) {
		
		//IndexOutOfBoundsException - if the index is out of range (index < 0 || index > size())
		if(index < 0 || index > size()) throw new IndexOutOfBoundsException();
		
		subVector.insertElementAt(element, index+fromIndex); //ArrayIndexOutOfBoundsException - if the index was invalid.
		toIndex++;
	}
	
	//Appends the specified element to the end of this list (optional operation).
	public boolean add(E e) {
		
		//NullPointerException - if the specified element is null and this list does not support null elements.
		if(e == null) throw new NullPointerException();
		
		subVector.insertElementAt(e, toIndex);
		toIndex++;
		return true;
	}
	
	//Inserts all of the elements in the specified collection into this list at the specified position (optional operation).
	public boolean addAll(int index, HCollection<? extends E> c) {

		//NullPointerException - if the specified collection is null
		if(c == null) throw new NullPointerException();
		
		//IndexOutOfBoundsException - if the index is out of range (index < 0 || index > size())
		if(index < 0 || index > size()) throw new IndexOutOfBoundsException();

		boolean check = false;
		Iterator<E> myIterator = (Iterator<E>)c.iterator();
		while(myIterator.hasNext())
		{
			add(index, myIterator.next());
			check = true;
		}
		return check;
		
	}
	
	//Appends all of the elements in the specified collection to the end of this list, in the order that they are returned by the specified collection's iterator (optional operation).
	public boolean addAll(HCollection<? extends E> c) {

		//NullPointerException - if the specified collection is null
		if(c == null) throw new NullPointerException();
				
		boolean check = false;
		Iterator<E> myIterator = (Iterator<E>)c.iterator();
		while(myIterator.hasNext())			
			check = check | add((E)myIterator.next()); 
		return check;
	}
	
	//Removes all of the elements from this list (optional operation).
	public void clear() {
		int pos = 0, maxPos = size();
		Iterator<E> myIterator = iterator();
		while(myIterator.hasNext() && pos < maxPos) {
			myIterator.next();
			myIterator.remove();
			pos++;
			toIndex--;
		}
	}
	
	//Returns true if this list contains the specified element.
	public boolean contains(Object o) {
		Vector<E> tmpVector = new Vector<E>();
		for(int i = fromIndex; i < toIndex; i++)
			tmpVector.add(subVector.elementAt(i));
		return tmpVector.contains(o);
	}
	
	//Returns true if this list contains all of the elements of the specified collection.
	public boolean containsAll(HCollection<?> c) {
		
		//NullPointerException - if the specified collection is null
		if(c == null) throw new NullPointerException();
		
		Vector<E> tmpVector = new Vector<E>();
		for(int i = fromIndex; i < toIndex; i++)
			tmpVector.add(subVector.elementAt(i));
		
		Iterator<E> myIterator = (Iterator<E>)c.iterator();
		while(myIterator.hasNext())
			if(!tmpVector.contains(myIterator.next()))
				return false;
		return true;
	}
	
	//Compares the specified object with this list for equality.
	public boolean equals(Object o) {
		if(!(o instanceof SubList))
			return false;
		SubList<E> mySubList = (SubList<E>)o;
		return subVector.equals(mySubList.subVector);
	}
	
	//Returns the element at the specified position in this list.
	public E get(int index) {
		
		//IndexOutOfBoundsException - if the index is out of range (index < 0 || index >= size())
		if(index < 0 || index >= size()) throw new IndexOutOfBoundsException();
		
		return subVector.elementAt(index+fromIndex);
	}
	
	//Returns the hash code value for this list.
	public int hashCode() {
		Vector<E> tmpVector = new Vector<E>();
		for(int i = fromIndex; i < toIndex; i++)
			tmpVector.add(subVector.elementAt(i));
		return tmpVector.hashCode();
	}
	
	//Returns the index of the first occurrence of the specified element in this list, or -1 if this list does not contain the element.
	public int indexOf(Object o) {
		int tmpIndex = subVector.indexOf(o);
		if(tmpIndex >= fromIndex && tmpIndex < toIndex)
			return tmpIndex-fromIndex;
		return -1;
	}
	
	//Returns true if this list contains no elements.
	public boolean isEmpty() {
		return (fromIndex == toIndex);
	}
	
	//Returns an iterator over the elements in this list in proper sequence.
	public Iterator<E> iterator() {
		return listIterator();
	}
	
	//Returns the index of the last occurrence of the specified element in this list, or -1 if this list does not contain the element.
	public int lastIndexOf(Object o) {
		int tmpIndex = subVector.lastIndexOf(o);
		if(tmpIndex >= fromIndex && tmpIndex < toIndex)
			return tmpIndex-fromIndex;
		return -1;
	}
	
	//Returns a list iterator over the elements in this list (in proper sequence).
	public ListIterator<E> listIterator() {
		return listIterator(0);
	}
	
	//Returns a list iterator over the elements in this list (in proper sequence), starting at the specified position in the list.
	public ListIterator<E> listIterator(int index) {
		
		//IndexOutOfBoundsException - if the index is out of range (index < 0 || index > size())
		if(index < 0 || index > size()) throw new IndexOutOfBoundsException();
		
		return new ListAdapterListIterator<E>(index+fromIndex, subVector);
	}
	
	//Removes the element at the specified position in this list (optional operation).
	public E remove(int index) {
		
		//IndexOutOfBoundsException - if the index is out of range (index < 0 || index >= size())
		if(index < 0 || index >= size()) throw new IndexOutOfBoundsException();
		
		E myObj = get(index);
		subVector.removeElementAt(index+fromIndex);
		toIndex--;
		return myObj;
	}
	
	//Removes the first occurrence of the specified element from this list, if it is present (optional operation).
	public boolean remove(Object o) {
		int tmpIndex = subVector.indexOf(o);
		if(tmpIndex >= fromIndex && tmpIndex < toIndex)
			if(subVector.removeElement(o)) {
				toIndex--;
				return true;
		}
		return false;
	}
	
	//Removes from this list all of its elements that are contained in the specified collection (optional operation).
	public boolean removeAll(HCollection<?> c) {
		
		//NullPointerException - if the specified collection is null
		if(c == null) throw new NullPointerException();
		
		boolean check = false;
		Iterator<E> myIterator = (Iterator<E>)c.iterator();
		while(myIterator.hasNext())
			check = check | remove(myIterator.next());
		return check;
	}
	
	//Retains only the elements in this list that are contained in the specified collection (optional operation).
	public boolean retainAll(HCollection<?> c) {
		
		//NullPointerException - if the specified collection is null
		if(c == null) throw new NullPointerException();

		int maxPos = size();
		boolean check = false;
		Iterator<E> myIterator = iterator();
		for(int i = 0; i < maxPos; i++)
			if(!c.contains(myIterator.next())) {
				myIterator.remove();
				toIndex--;
				check = true;
			}
		return check;
	}
	
	//Replaces the element at the specified position in this list with the specified element (optional operation).
	public E set(int index, E element) {
		
		//IndexOutOfBoundsException - if the index is out of range (index < 0 || index >= size())
		if(index < 0 || index >= size()) throw new IndexOutOfBoundsException();
		
		ListIterator<E> myListIterator = listIterator(index);
		E tmpObj = myListIterator.next();
		myListIterator.set(element);
		return tmpObj;
	}
	
	//Returns the number of elements in this list.
	public int size() {
		return toIndex-fromIndex;
	}
	
	//Returns a view of the portion of this list between the specified fromIndex, inclusive, and toIndex, exclusive.
	public HList<E> subList(int fromIndex, int toIndex){
		
		//IndexOutOfBoundsException - if (fromIndex < 0 || toIndex > size || fromIndex > toIndex)
		
		HList<E> newList = new SubList<E>(subVector, this.fromIndex+fromIndex, this.fromIndex+toIndex);
		return (HList<E>) newList;
	}
	
	//Returns an array containing all of the elements in this list in proper sequence (from first to last element).
	public Object[] toArray() {
		int pos = 0, maxPos = size();
		Object[] myObjArray = new Object[size()];
		Iterator<E> myIterator = iterator();
		for(pos = 0; pos < maxPos; pos++) {
			myObjArray[pos] = myIterator.next();
		}
		return myObjArray;
	}
	
	//Returns an array containing all of the elements in this list in proper sequence (from first to last element); the runtime type of the returned array is that of the specified array.
	public <T> T[] toArray(T[] a) {
		
		//ArrayStoreException - if the runtime type of the specified array is not a supertype of the runtime type of every element in this list
		
		//NullPointerException - if the specified array is null
		if(a == null) throw new NullPointerException();
		
		int maxPos = size();
		Iterator<E> myIterator = iterator();
		if(size() <= a.length) {
			for(int i = 0; i < maxPos; i++)
				a[i] = (T)myIterator.next(); //ArrayStoreException
			if(size() < a.length)
				a[size()] = null;
		}
		else throw new UnsupportedOperationException();
		return a;
	}
}