import java.util.Hashtable;

public class MapAdapter<K,V> implements HMap<K,V> {
	
	public Hashtable<K,V> myHashTable = new Hashtable<K,V>();
	
	//Removes all of the mappings from this map (optional operation).
	public void clear() {
		myHashTable.clear();
	}
	
	//Returns true if this map contains a mapping for the specified key.
	public boolean containsKey(Object key) {
		return myHashTable.containsKey(key);
	}
	
	//Returns true if this map maps one or more keys to the specified value.
	public boolean containsValue(Object value) {
		return myHashTable.contains(value);
	}
	
	//Returns a Set view of the mappings contained in this map.
	public HSet<HMap.HEntry<K,V>> entrySet() {
		HSet<V> myEntrySet = (HSet<V>)new EntrySet<K,V>(this);
		return (HSet<HEntry<K,V>>)myEntrySet;
	}
	
	//Compares the specified object with this map for equality.
	public boolean equals(Object o) {
		if(!(o instanceof MapAdapter))
			return false;
		MapAdapter<K,V> myMapAdapter = (MapAdapter<K,V>)o;
		return myHashTable.equals(myMapAdapter.myHashTable);
	}	
	
	//Returns the value to which the specified key is mapped, or null if this map contains no mapping for the key.
	public V get(Object key) {
		return myHashTable.get(key);
	}
	
	//Returns the hash code value for this map.
	public int hashCode() {
		return myHashTable.hashCode();
	}
	
	//Returns true if this map contains no key-value mappings.
	public boolean isEmpty() {
		return myHashTable.isEmpty();
	}
	
	//Returns a Set view of the keys contained in this map.
	public HSet<K> keySet() {
		KeySet<K,V> myKeySet = new KeySet<K,V>(this);
		return myKeySet;
	}
	
	//Associates the specified value with the specified key in this map (optional operation).
	public V put(K key, V value) {
		
		//NullPointerException - if this map does not permit null keys or values, and the specified map contains null keys or values.
		if(key == null || value == null) throw new NullPointerException();
		
		return myHashTable.put(key, value);
	}
	
	//Copies all of the mappings from the specified map to this map (optional operation).
	public void putAll(HMap<? extends K,? extends V> m) {
		
		//NullPointerException - if the specified map is null
		if(m == null) throw new NullPointerException();
		
		HSet<K> myKeySet = (HSet<K>) m.keySet();
		Iterator<K> myIterator = myKeySet.iterator();
		while(myIterator.hasNext())
		{
			K tmpKey = myIterator.next();
			myHashTable.put(tmpKey, m.get(tmpKey));
		}
	}
	
	//Removes the mapping for a key from this map if it is present (optional operation).
	public V remove(Object key) {
		return myHashTable.remove(key);
	}
	
	//Returns the number of key-value mappings in this map.
	public int size() {
		return myHashTable.size();
	}
	
	//Returns a Collection view of the values contained in this map.
	public HCollection<V> values() {
		Values<K,V> myValue = new Values<K,V>(this);
		return myValue;
	}
}
