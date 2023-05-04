import java.util.Enumeration;

public class Values<K,V> implements HCollection<V> {
	
	private MapAdapter<K,V> myMapAdapter = new MapAdapter<K,V>();
	
	public Values(MapAdapter<K,V> ma) {
		myMapAdapter = ma;
	}
	
	//Ensures that this collection contains the specified element (optional operation).
	public boolean add(V e) {
		throw new UnsupportedOperationException();
	}
	
	//Adds all of the elements in the specified collection to this collection (optional operation).
	public boolean addAll(HCollection<? extends V> c) {
		throw new UnsupportedOperationException();
	}
	
	//Removes all of the elements from this collection (optional operation).
	public void clear() {
		myMapAdapter.clear();
	}
	
	//Returns true if this collection contains the specified element.
	public boolean contains(Object o) {
		return myMapAdapter.containsValue(o);
	}
	
	//Returns true if this collection contains all of the elements in the specified collection.
	public boolean containsAll(HCollection<?> c) {
		
		//NullPointerException - if the specified collection is null
		if(c == null) throw new NullPointerException();
		
		Iterator<V> myIterator = (Iterator<V>)c.iterator();
		while(myIterator.hasNext())
			if(!contains(myIterator.next()))
				return false;
		return true;
	}
	
	//Compares the specified object with this collection for equality.
	public boolean equals(Object o) {
		throw new UnsupportedOperationException();
	}
	
	//Returns the hash code value for this collection.
	public int hashCode() {
		return myMapAdapter.hashCode();
	}
	
	//Returns true if this collection contains no elements.
	public boolean isEmpty() {
		return myMapAdapter.isEmpty();
	}
	
	//Returns an iterator over the elements in this collection.
	public Iterator<V> iterator() {
		return new CollectionAdapterIterator<V>((MapAdapter<Object, V>) myMapAdapter);
	}
	
	//Removes a single instance of the specified element from this collection, if it is present (optional operation).
	public boolean remove(Object o) {
		
		Enumeration<K> myEnumeration = myMapAdapter.myHashTable.keys();
		while(myEnumeration.hasMoreElements())
		{
			K tmpKey = myEnumeration.nextElement();
			if(myMapAdapter.get(tmpKey) == o) {
				V tmpValue = myMapAdapter.remove(tmpKey);
				if(tmpValue != null) return true;
			}
		}
		return false;
	}
	
	//Removes all of this collection's elements that are also contained in the specified collection (optional operation).
	public boolean removeAll(HCollection<?> c) {
		
		//NullPointerException - if the specified collection is null
		if(c == null) throw new NullPointerException();
		
		boolean check = false;
		Iterator<V> myIterator = (Iterator<V>)c.iterator();
		while(myIterator.hasNext())
			check = check | remove(myIterator.next());
		return check;
	}
	
	//Retains only the elements in this collection that are contained in the specified collection (optional operation).
	public boolean retainAll(HCollection<?> c) {
		
		//NullPointerException - if the specified collection is null
		if(c == null) throw new NullPointerException();
		
		boolean check = false;
		Iterator<V> myIterator = iterator();
		while(myIterator.hasNext()) {
			V tmpValue = myIterator.next();
			if(!c.contains(tmpValue))
			{
				remove(tmpValue);
				check = true;
			}
		}
		return check;		
	}
	
	//Returns the number of elements in this collection.
	public int size() {
		return myMapAdapter.size();
	}
	
	//Returns an array containing all of the elements in this collection.
	public Object[] toArray() {
		Object[] myObjArray = new Object[size()];
		Iterator<V> myIterator = iterator();
		for(int i = 0; myIterator.hasNext(); i++)
			myObjArray[i] = myIterator.next();
		return myObjArray;
	}
	
	//Returns an array containing all of the elements in this collection; the runtime type of the returned array is that of the specified array.
	public <T> T[] toArray(T[] a) {
		
		//ArrayStoreException - if the runtime type of the specified array is not a supertype of the runtime type of every element in this list
		
		//NullPointerException - if the specified array is null
		if(a == null) throw new NullPointerException();
		
		Iterator<V> myIterator = iterator();
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
