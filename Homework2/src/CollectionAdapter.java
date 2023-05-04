import java.util.Vector;

public class CollectionAdapter<E> implements HCollection<E> {
	
	private Vector<E> myVector = new Vector<E>();
	
	//Ensures that this collection contains the specified element (optional operation).
	public boolean add(E e) {
		
		//NullPointerException - if the specified element is null and this collection does not support null elements.
		if(e == null) throw new NullPointerException();
		
		myVector.addElement(e);
		return true;
	}
	
	//Adds all of the elements in the specified collection to this collection (optional operation).
	public boolean addAll(HCollection<? extends E> c) {
		
		//NullPointerException - if the specified collection is null
		if(c == null) throw new NullPointerException();
		
		boolean check = false;
		Iterator<E> myIterator = (Iterator<E>)c.iterator();
		while(myIterator.hasNext())
			check = check | add((E)myIterator.next());
		return check;
	}
	
	//Removes all of the elements from this collection (optional operation).
	public void clear() {
		myVector.removeAllElements();
	}
	
	//Returns true if this collection contains the specified element.
	public boolean contains(Object o) {
		return myVector.contains(o);
	}
	
	//Returns true if this collection contains all of the elements in the specified collection.
	public boolean containsAll(HCollection<?> c) {
		
		//NullPointerException - if the specified collection is null
		if(c == null) throw new NullPointerException();
		
		Iterator<E> myIterator = (Iterator<E>)c.iterator();
		while(myIterator.hasNext())
			if(!contains(myIterator.next()))
				return false;
		return true;
	}
	
	//Compares the specified object with this collection for equality.
	public boolean equals(Object o) {
		if(!(o instanceof CollectionAdapter))
			return false;
		CollectionAdapter<E> myCollectionAdapter = (CollectionAdapter<E>)o;
		return myVector.equals(myCollectionAdapter.myVector);
	}
	
	//Returns the hash code value for this collection.
	public int hashCode() {
		return myVector.hashCode();
	}
	
	//Returns true if this collection contains no elements.
	public boolean isEmpty() {
		return myVector.isEmpty();
	}
	
	//Returns an iterator over the elements in this collection.
	public Iterator<E> iterator() {
		return new CollectionAdapterIterator<E>(myVector);
	}
	
	//Removes a single instance of the specified element from this collection, if it is present (optional operation).
	public boolean remove(Object o) {
		return myVector.removeElement(o);
	}
	
	//Removes all of this collection's elements that are also contained in the specified collection (optional operation).
	public boolean removeAll(HCollection<?> c) {
		
		//NullPointerException - if the specified collection is null
		if(c == null) throw new NullPointerException();
		
		boolean check = false;
		Iterator<E> myIterator = (Iterator<E>)c.iterator();
		while(myIterator.hasNext())
			check = check | remove(myIterator.next());
		return check;
	}
	
	//Retains only the elements in this collection that are contained in the specified collection (optional operation).
	public boolean retainAll(HCollection<?> c) {
		
		//NullPointerException - if the specified collection is null
		if(c == null) throw new NullPointerException();
		
		boolean check = false;
		Iterator<E> myIterator = iterator();
		while(myIterator.hasNext())
			if(!c.contains(myIterator.next()))
			{
				myIterator.remove();
				check = true;
			}
		return check;
	}
	
	//Returns the number of elements in this collection.
	public int size() {
		return myVector.size();
	}
	
	//Returns an array containing all of the elements in this collection.
	public Object[] toArray() {		
		Object[] myObjArray = new Object[size()];
		Iterator<E> myIterator = iterator();
		for(int i = 0; myIterator.hasNext(); i++) //for(int i = 0; myIterator.hasNext() && i<size(); i++)
			myObjArray[i] = myIterator.next();
		return myObjArray;

		/* oppure:
		Object[] myObjArray = new Object[size()];
		for(int i = 0; i < myObjArray.length; i++)
			myObjArray[i] = myVector.elementAt(i);
		return myObjArray; */
	}
	
	//Returns an array containing all of the elements in this collection; the runtime type of the returned array is that of the specified array.
	public <T> T[] toArray(T[] a) {
		
		//ArrayStoreException - if the runtime type of the specified array is not a supertype of the runtime type of every element in this list
		
		//NullPointerException - if the specified array is null
		if(a == null) throw new NullPointerException();
		
		Iterator<E> myIterator = iterator();
		if(size() <= a.length) {
			for(int i = 0; myIterator.hasNext(); i++)
				a[i] = (T)myIterator.next(); //ArrayStoreException
			if(size() < a.length)
				a[size()] = null;
		}
		else throw new UnsupportedOperationException();
		return a;
		
		/* oppure:
		if(size() <= a.length) {
			for(int i = 0; i < size(); i++) {
				a[i] = (T)myVector.elementAt(i); //with try { } catch { }
			}
			if(size() < a.length)
				a[size()] = null;
		}
		else throw new UnsupportedOperationException();
		return a; */
	}
}
