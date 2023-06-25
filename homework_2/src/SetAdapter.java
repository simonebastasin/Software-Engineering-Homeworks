
public class SetAdapter<E> extends CollectionAdapter<E> implements HSet<E> {
	
	private MapAdapter<Object,E> myMapAdapter = new MapAdapter<Object,E>();
	
	//Adds the specified element to this set if it is not already present (optional operation).
	public boolean add(E e) {
		
		//NullPointerException - if the specified element is null and this set does not support null elements.
		if(e == null) throw new NullPointerException();
		
		if(contains(e)) return false;
		myMapAdapter.put(e, e);
		return true;
	}
	
	//Adds all of the elements in the specified collection to this set if they're not already present (optional operation).
	public boolean addAll(HCollection<? extends E> c) {
		
		//NullPointerException - if the specified collection is null
		if(c == null) throw new NullPointerException();
		
		boolean check = false;
		Iterator<E> myIterator = (Iterator<E>)c.iterator();
		while(myIterator.hasNext())
			check = check | add((E)myIterator.next());
		return check;
	}
	
	//Removes all of the elements from this set (optional operation).
	public void clear() {
		myMapAdapter.clear();
	}
	
	//Returns true if this set contains the specified element.
	public boolean contains(Object o) {
		return myMapAdapter.containsKey(o);
	}
	
	//Returns true if this set contains all of the elements of the specified collection.
	public boolean containsAll(HCollection<?> c) {
		
		//NullPointerException - if the specified collection is null
		if(c == null) throw new NullPointerException();
		
		Iterator<E> myIterator = (Iterator<E>)c.iterator();
		while(myIterator.hasNext())
			if(!contains(myIterator.next()))
				return false;
		return true;
	}
	
	//Compares the specified object with this set for equality.
	public boolean equals(Object o) {
		if(!(o instanceof SetAdapter))
			return false;
		SetAdapter<E> mySetAdapter = (SetAdapter<E>)o;
		return myMapAdapter.equals(mySetAdapter.myMapAdapter);
	}
	
	//Returns the hash code value for this set.
	public int hashCode() {
		return myMapAdapter.hashCode();
	}
	
	//Returns true if this set contains no elements.
	public boolean isEmpty() {
		return myMapAdapter.isEmpty();
	}
	
	//Returns an iterator over the elements in this set.
	public Iterator<E> iterator() {
		return new SetAdapterIterator<E>((MapAdapter<E, Object>) myMapAdapter);
	}
	
	//Removes the specified element from this set if it is present (optional operation).
	public boolean remove(Object o) {
		E tmpObj = (E)myMapAdapter.remove(o);
		if(tmpObj == null)
			return false;
		return true;
	}
	
	//Removes from this set all of its elements that are contained in the specified collection (optional operation).
	public boolean removeAll(HCollection<?> c) {

		//NullPointerException - if the specified collection is null
		if(c == null) throw new NullPointerException();
		
		boolean check = false;
		Iterator<E> myIterator = (Iterator<E>)c.iterator();
		while(myIterator.hasNext())
			check = check | remove(myIterator.next());
		return check;		
	}
	
	//Retains only the elements in this set that are contained in the specified collection (optional operation).
	public boolean retainAll(HCollection<?> c) {

		//NullPointerException - if the specified collection is null
		if(c == null) throw new NullPointerException();
		
		boolean check = false;
		Iterator<E> myIterator = iterator();
		while(myIterator.hasNext())
		{
			if(!c.contains(myIterator.next()))
			{
				myIterator.remove();
				check = true;
			}
		}
		return check;
	}
	
	//Returns the number of elements in this set (its cardinality).
	public int size() {
		return myMapAdapter.size();
	}
	
	
	//Returns an array containing all of the elements in this set.
	public Object[] toArray() {
		HCollection<E> tmpColl = myMapAdapter.values();
		Object[] tmpArray = new Object[tmpColl.size()];
		return tmpColl.toArray(tmpArray);
	}
	
	//Returns an array containing all of the elements in this set; the runtime type of the returned array is that of the specified array.
	public <T> T[] toArray(T[] a) {
		
		//ArrayStoreException - if the runtime type of the specified array is not a supertype of the runtime type of every element in this list
		//NullPointerException - if the specified array is null
		
		HCollection<E> tmpColl = myMapAdapter.values();
		a = tmpColl.toArray(a);
		return a;
	}
}
