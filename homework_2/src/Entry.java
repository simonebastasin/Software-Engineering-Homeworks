
public class Entry<K,V> implements HMap.HEntry<K,V> {
	
	private K key;
	private V value;
	
	public Entry(K o) {
		key = o;
		value = null;
	}
	
	public Entry(K o, V v) {
		key = o;
		value = v;
	}
	
	public K getKey() {
		return key;
	}

	public V getValue() {
		return value;
	}

	public V setValue(V o) {
		V myValue = value;
		value = o;
		return myValue;
	}

	public boolean equals(Object o) {
		HMap.HEntry<K,V> helpEntry = (Entry<K,V>)o;
		if(!key.equals(helpEntry.getKey()))
			return false;
		if(value == null && helpEntry.getValue() == null)
			return true;
		if(value.equals(helpEntry.getValue()))
			return true;
		return false;
	}
}
