
public class KeySet<K,V> implements HSet<K> {
	
	private MapAdapter<K,V> myMapAdapter = new MapAdapter<K,V>();
	
	public KeySet(MapAdapter<K,V> ma) {
		myMapAdapter = ma;
	}
	
	//Adds the specified element to this set if it is not already present (optional operation).
	public boolean add(K e) {
		throw new UnsupportedOperationException();
	}
	
	//Adds all of the elements in the specified collection to this set if they're not already present (optional operation).
	public boolean addAll(HCollection<? extends K> c) {
		throw new UnsupportedOperationException();
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
		
		Iterator<K> myIterator = (Iterator<K>)c.iterator();
		while(myIterator.hasNext())
			if(!contains(myIterator.next()))
				return false;
		return true;
	}
	
	//Compares the specified object with this set for equality.
	public boolean equals(Object o) {
		throw new UnsupportedOperationException();
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
	public Iterator<K> iterator() {
		//return map.keySet().iterator();
		return new SetAdapterIterator<K>((MapAdapter<K, Object>)myMapAdapter);
	}
	
	//Removes the specified element from this set if it is present (optional operation).
	public boolean remove(Object o) {
		K tmpObj = (K)myMapAdapter.remove(o);
		if(tmpObj == null)
			return false;
		return true;
	}
	
	//Removes from this set all of its elements that are contained in the specified collection (optional operation).
	public boolean removeAll(HCollection<?> c) {

		//NullPointerException - if the specified collection is null
		if(c == null) throw new NullPointerException();
		
		boolean check = false;
		Iterator<V> myIterator = (Iterator<V>)c.iterator();
		while(myIterator.hasNext())
			check = check | remove(myIterator.next());
		return check;		
	}
	
	//Retains only the elements in this set that are contained in the specified collection (optional operation).
	public boolean retainAll(HCollection<?> c) {

		//NullPointerException - if the specified collection is null
		if(c == null) throw new NullPointerException();
		
		boolean check = false;
		Iterator<K> myIterator = iterator();
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
		Object[] myObjArray = new Object[size()];
		Iterator<K> myIterator = iterator();
		for(int i = 0; myIterator.hasNext(); i++)
			myObjArray[i] = myIterator.next();
		return myObjArray;
	}
	
	//Returns an array containing all of the elements in this set; the runtime type of the returned array is that of the specified array.
	public <T> T[] toArray(T[] a) {
		
		//ArrayStoreException - if the runtime type of the specified array is not a supertype of the runtime type of every element in this list
		
		//NullPointerException - if the specified array is null
		if(a == null) throw new NullPointerException();
		
		Iterator<K> myIterator = iterator();
		if(size() <= a.length) {
			for(int i = 0; myIterator.hasNext(); i++)
				a[i] = (T)myIterator.next(); //ArrayStoreException
			if(size() < a.length)
				a[size()] = null;
		}
		else throw new UnsupportedOperationException();
		return a;
	}

}
