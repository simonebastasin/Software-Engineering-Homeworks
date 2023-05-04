import org.junit.Test;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

/**
 * Test Class for MapAdapter
 * 
 * @safe.summary this class is in charge of testing the collection class
 * @safe.testsuitedesign each individual method is tested, verifying that
 * intermediate states are created and all of them are verified, to verify
 * that the collection does not break during the editing
 */

public class MapAdapterTest<K,V> {
	
	/**
	 * test clear method in Map
	 * 
	 * @safe.precondition a not empty Map
	 * @safe.postcondition the Map becomes empty
	 * @safe.testcases test the elimination of all couples of key-value from a Map
	 */
	@Test
	public void testClear() {
		//Testing: void clear();
		HMap<K,V> myAdapter = new MapAdapter<K,V>();
		myAdapter.put((K)(Integer)1, (V)"str1");
		myAdapter.put((K)(Integer)2, (V)"str2");
		myAdapter.clear();
		assertEquals(true, myAdapter.isEmpty());
		assertEquals(0, myAdapter.size());
	}
	
	
	/**
	 * test containsKey method in Map
	 * 
	 * @safe.precondition a not empty Map
	 * @safe.postcondition none
	 * @safe.testcases test checking that a Map contains determined keys that are in the Map
	 */
	@Test
	public void testContainsKey_1() {
		//Testing: boolean containsKey(Object key);
		HMap<K,V> myAdapter = new MapAdapter<K,V>();
		myAdapter.put((K)(Integer)1, (V)"str1");
		myAdapter.put((K)(Integer)2, (V)"str2");
		assertEquals(true, myAdapter.containsKey((Integer)1));
		assertEquals(true, myAdapter.containsKey((Integer)2));
	}
	
	/**
	 * test containsKey method in Map
	 * 
	 * @safe.precondition a Map
	 * @safe.postcondition none
	 * @safe.testcases test checking that a Map doesn't contain a determined key that isn't in the Map
	 */
	@Test
	public void testContainsKey_2() {
		//Testing: boolean containsKey(Object key);
		HMap<K,V> myAdapter = new MapAdapter<K,V>();
		myAdapter.put((K)(Integer)1, (V)"str1");
		myAdapter.put((K)(Integer)2, (V)"str2");
		assertEquals(false, myAdapter.containsKey((Integer)3));
	}
	
	
	/**
	 * test containsValue method in Map
	 * 
	 * @safe.precondition a not empty Map
	 * @safe.postcondition none
	 * @safe.testcases test checking that a Map contains determined values that are in the Map
	 */
	@Test
	public void testContainsValue_1() {
		//Testing: boolean containsValue(Object value);
		HMap<K,V> myAdapter = new MapAdapter<K,V>();
		myAdapter.put((K)(Integer)1, (V)"str1");
		myAdapter.put((K)(Integer)2, (V)"str2");
		assertEquals(true, myAdapter.containsValue("str1"));
		assertEquals(true, myAdapter.containsValue("str2"));
	}
	
	/**
	 * test containsValue method in Map
	 * 
	 * @safe.precondition a Map
	 * @safe.postcondition none
	 * @safe.testcases test checking that a Map doesn't contain a determined value that isn't in the Map
	 */
	@Test
	public void testContainsValue_2() {
		//Testing: boolean containsValue(Object value);
		HMap<K,V> myAdapter = new MapAdapter<K,V>();
		myAdapter.put((K)(Integer)1, (V)"str1");
		myAdapter.put((K)(Integer)2, (V)"str2");
		assertEquals(false , myAdapter.containsValue("str3"));
	}
	
	
	/**
	 * test equals method in Map
	 * 
	 * @safe.precondition two Maps with same couples of key-value
	 * @safe.postcondition none
	 * @safe.testcases test that two Maps with same couples of key-value are equal
	 */
	@Test
	public void testEquals_1() {
		//Testing: boolean equals(Object o);
		HMap<K,V> myAdapter = new MapAdapter<K,V>();
		HMap<K,V> helpAdapter = new MapAdapter<K,V>();
		myAdapter.put((K)(Integer)1, (V)"str1");
		myAdapter.put((K)(Integer)2, (V)"str2");
		helpAdapter.put((K)(Integer)1, (V)"str1");
		helpAdapter.put((K)(Integer)2, (V)"str2");
		assertEquals(true, myAdapter.equals(helpAdapter));
	}
	
	/**
	 * test equals method in Map
	 * 
	 * @safe.precondition two Maps with at least one different couple of key-value
	 * @safe.postcondition none
	 * @safe.testcases test that two Maps with at least one different couple of key-value
	 */
	@Test
	public void testEquals_2() {
		//Testing: boolean equals(Object o);
		HMap<K,V> myAdapter = new MapAdapter<K,V>();
		HMap<K,V> helpAdapter = new MapAdapter<K,V>();
		myAdapter.put((K)(Integer)1, (V)"str1");
		myAdapter.put((K)(Integer)2, (V)"str2");
		helpAdapter.put((K)(Integer)1, (V)"str1");
		assertEquals(false, myAdapter.equals(helpAdapter));
	}
	
	/**
	 * test equals method in Map
	 * 
	 * @safe.precondition two Maps with same number of couples of key-value, with same values but with at least one different key
	 * @safe.postcondition none
	 * @safe.testcases test that two Maps with same number of couples of key-value, with same values but with at least one different key aren't equal
	 */
	@Test
	public void testEquals_3() {
		//Testing: boolean equals(Object o);
		HMap<K,V> myAdapter = new MapAdapter<K,V>();
		HMap<K,V> helpAdapter = new MapAdapter<K,V>();
		myAdapter.put((K)(Integer)1, (V)"str1");
		helpAdapter.put((K)(Integer)2, (V)"str1");
		assertEquals(false, myAdapter.equals(helpAdapter));
	}
	
	/**
	 * test equals method in Map
	 * 
	 * @safe.precondition two Maps with same number of couples of key-value, with same keys but with at least one different value
	 * @safe.postcondition none
	 * @safe.testcases test that two Maps with same number of couples of key-value, with same keys but with at least one different value aren't equal
	 */
	@Test
	public void testEquals_4() {
		//Testing: boolean equals(Object o);
		HMap<K,V> myAdapter = new MapAdapter<K,V>();
		HMap<K,V> helpAdapter = new MapAdapter<K,V>();
		myAdapter.put((K)(Integer)1, (V)"str1");
		helpAdapter.put((K)(Integer)1, (V)"str2");
		assertEquals(false, myAdapter.equals(helpAdapter));
	}
	
	/**
	 * test equals method in Map
	 * 
	 * @safe.precondition a Map
	 * @safe.postcondition none
	 * @safe.testcases test that a Map and another Object (that isn't a Map instance) aren't equal
	 */
	@Test
	public void testEquals_5() {
		//Testing: boolean equals(Object o);
		HMap<K,V> myAdapter = new MapAdapter<K,V>();
		HSet<V> helpAdapter = new SetAdapter<V>();
		myAdapter.put((K)(Integer)1, (V)"str1");
		helpAdapter.add((V)"str1");
		assertEquals(false, myAdapter.equals(helpAdapter));
	}
	
	
	/**
	 * test get method in Map
	 * 
	 * @safe.precondition a Map
	 * @safe.postcondition none
	 * @safe.testcases test the attempt to get a value of a Map using an invalid key
	 */
	@Test
	public void testGet_1() {
		//Testing: V get(Object key);
		HMap<K,V> myAdapter = new MapAdapter<K,V>();
		myAdapter.put((K)(Integer)1, (V)"str1");
		assertEquals(null, myAdapter.get((Integer)2));
	}
	
	/**
	 * test get method in Map
	 * 
	 * @safe.precondition a not empty Map
	 * @safe.postcondition none
	 * @safe.testcases test the possibility to get a value in a Map using its key
	 */
	@Test
	public void testGet_2() {
		//Testing: V get(Object key);
		HMap<K,V> myAdapter = new MapAdapter<K,V>();
		myAdapter.put((K)(Integer)1, (V)"str1");
		myAdapter.put((K)(Integer)2, (V)"str2");
		assertEquals("str1", myAdapter.get((Integer)1));
		assertEquals("str2", myAdapter.get((Integer)2));
	}	
	
	
	/**
	 * test hashCode method in Map
	 * 
	 * @safe.precondition two Maps with same couples of key-value
	 * @safe.postcondition none
	 * @safe.testcases test that two Maps with same couples of key-value have same hashCode
	 */
	@Test
	public void testHashCode() {
		//Testing: int hashCode();
		HMap<K,V> myAdapter = new MapAdapter<K,V>();
		myAdapter.put((K)(Integer)1, (V)"a");
		myAdapter.put((K)(Integer)2, (V)"b");
		HMap<K,V> helpAdapter = new MapAdapter<K,V>();
		helpAdapter.put((K)(Integer)1, (V)"a");
		helpAdapter.put((K)(Integer)2, (V)"b");
		assertEquals(myAdapter.hashCode(), helpAdapter.hashCode());
		//assertEquals(192, myAdapter.hashCode());
	}
	
	
	/**
	 * test isEmpty method in Map
	 * 
	 * @safe.precondition an empty Map
	 * @safe.postcondition none
	 * @safe.testcases test that a Map without couples of key-value is empty
	 */
	@Test
	public void testIsEmpty_1() {
		//Testing: boolean isEmpty();
		HMap<K,V> myAdapter = new MapAdapter<K,V>();
		assertEquals(true, myAdapter.isEmpty());
	}
	
	/**
	 * test isEmpty method in Map
	 * 
	 * @safe.precondition a not empty Map
	 * @safe.postcondition none
	 * @safe.testcases test that a Map with a couple of key-value isn't empty
	 */
	@Test
	public void testIsEmpty_2() {
		//Testing: boolean isEmpty();
		HMap<K,V> myAdapter = new MapAdapter<K,V>();
		myAdapter.put((K)(Integer)1, (V)"str1");
		assertEquals(false, myAdapter.isEmpty());
	}	
	
	
	/**
	 * test put method in Map
	 * 
	 * @safe.precondition a Map
	 * @safe.postcondition NullPointerException thrown
	 * @safe.testcases test the attempt to put, in a Map, a couple of key-value with null value
	 */
	@Test
	public void testPut_1() {
		//Testing: V put(K key, V value);
		HMap<K,V> myAdapter = new MapAdapter<K,V>();
		assertThrows(NullPointerException.class, () -> myAdapter.put((K)(Integer)1, null));
	}
	
	/**
	 * test put method in Map
	 * 
	 * @safe.precondition a Map
	 * @safe.postcondition NullPointerException thrown
	 * @safe.testcases test the attempt to put, in a Map, a couple of key-value with null key
	 */
	@Test
	public void testPut_2() {
		//Testing: V put(K key, V value);
		HMap<K,V> myAdapter = new MapAdapter<K,V>();
		assertThrows(NullPointerException.class, () -> myAdapter.put(null, (V)"str1"));
	}
	
	/**
	 * test put method in Map
	 * 
	 * @safe.precondition an empty Map
	 * @safe.postcondition Map size = 3
	 * @safe.testcases test the addition of 3 couples of key-value (including 2 identical values and no identical keys) in a Collection
	 */
	@Test
	public void testPut_3() {
		//Testing: V put(K key, V value);
		HMap<K,V> myAdapter = new MapAdapter<K,V>();
		myAdapter.put((K)"K1", (V)"str1");
		myAdapter.put((K)"K2", (V)"strEqual");
		myAdapter.put((K)"K3", (V)"strEqual");
		assertEquals(3, myAdapter.size());
		assertEquals("str1", myAdapter.get("K1"));
		assertEquals("strEqual", myAdapter.get("K2"));
		assertEquals("strEqual", myAdapter.get("K3"));
	}
	
	/**
	 * test put method in Map
	 * 
	 * @safe.precondition an empty Map
	 * @safe.postcondition Map size = 4
	 * @safe.testcases test the addition of 4 couples of key-value (with different parameter types of key and value) in a Map
	 */
	@Test
	public void testPut_4() {
		//Testing: V put(K key, V value);
		HMap<K,V> myAdapter = new MapAdapter<K,V>();
		myAdapter.put((K)(Integer)1, (V)"str1");
		myAdapter.put((K)(Integer)2, (V)(Integer)10);
		myAdapter.put((K)"K3", (V)(Double)1.1);
		myAdapter.put((K)(Double)4.4, (V)(Double)5.8);
		assertEquals(4, myAdapter.size());
		assertEquals("str1", myAdapter.get((Integer)1));
		assertEquals(10, myAdapter.get((Integer)2));
		assertEquals(1.1, myAdapter.get("K3"));
		assertEquals(5.8, myAdapter.get((Double)4.4));
	}
	
	/**
	 * test put method in Map
	 * 
	 * @safe.precondition an empty Map
	 * @safe.postcondition Map size = 2
	 * @safe.testcases test, in a Map, the addition of 3 couples of key-value and the attempt to put a
	 * couple of key-value with the same key as another key already contained in the Map, the couple
	 * doesn't get added. The value of the couple already in the Map, with the same key as the couple
	 * the couple who was trying to get in, gets edited with the new value of the other couple
	 */
	@Test
	public void testPut_5() {
		//Testing: V put(K key, V value);
		HMap<K,V> myAdapter = new MapAdapter<K,V>();
		myAdapter.put((K)"K1", (V)"strToChange");
		myAdapter.put((K)"K2", (V)"str2");
		myAdapter.put((K)"K3", (V)"str3");
		myAdapter.put((K)"K1", (V)"str1");
		assertEquals(3, myAdapter.size());
		assertEquals("str1", myAdapter.get("K1"));
		assertEquals("str2", myAdapter.get("K2"));
		assertEquals("str3", myAdapter.get("K3"));
	}
	
	
	/**
	 * test putAll method in Map
	 * 
	 * @safe.precondition a Map
	 * @safe.postcondition NullPointerException thrown
	 * @safe.testcases test the attempt to add couples of key-value in a Map from a null Map
	 */
	@Test
	public void testPutAll_1() {
		//Testing: void putAll(Map<? extends K,? extends V> m);
		HMap<K,V> myAdapter = new MapAdapter<K,V>();
		assertThrows(NullPointerException.class, () -> myAdapter.putAll(null));
	}
	
	/**
	 * test putAll method in Map
	 * 
	 * @safe.precondition two Maps with 2 couples of key-value each 
	 * @safe.postcondition Map size = 4
	 * @safe.testcases test the addition, in a Map with 2 couples of key-value, of 2 other couples of key-value from another Map
	 */
	@Test
	public void testPutAll_2() {
		//Testing: void putAll(Map<? extends K,? extends V> m);
		HMap<K,V> myAdapter = new MapAdapter<K,V>();
		HMap<K,V> helpAdapter = new MapAdapter<K,V>();
		myAdapter.put((K)(Integer)1, (V)"str1");
		helpAdapter.put((K)(Integer)2, (V)"add2");
		helpAdapter.put((K)(Integer)3, (V)"add3");
		myAdapter.putAll(helpAdapter);
		assertEquals(3, myAdapter.size());
		assertEquals((V)"str1", myAdapter.get((Integer)1));
		assertEquals((V)"add2", myAdapter.get((Integer)2));
		assertEquals((V)"add3", myAdapter.get((Integer)3));
	}
	
	/**
	 * test putAll method in Map
	 * 
	 * @safe.precondition an empty Map
	 * @safe.postcondition the Map remains empty
	 * @safe.testcases test the attempt to add couples of key-value in a Map from an empty Map
	 */
	@Test
	public void testPutAll_3() {
		//Testing: void putAll(Map<? extends K,? extends V> m);
		HMap<K,V> myAdapter = new MapAdapter<K,V>();
		myAdapter.putAll(new MapAdapter<K,V>());
		assertEquals(true, myAdapter.isEmpty());
	}
	
	
	/**
	 * test remove method in Map
	 * 
	 * @safe.precondition a Map with 5 couples of key-value
	 * @safe.postcondition Map size = 3
	 * @safe.testcases test the removal of 2 couples of key-value that are contained in a Map
	 */
	@Test
	public void testRemove_1() {
		//Testing: V remove(Object key);
		HMap<K,V> myAdapter = new MapAdapter<K,V>();
		myAdapter.put((K)(Integer)1, (V)"str1");
		myAdapter.put((K)(Integer)4, (V)"remove2");
		myAdapter.put((K)(Integer)2, (V)"str2");
		myAdapter.put((K)(Integer)3, (V)"remove1");
		myAdapter.put((K)(Integer)5, (V)"str3");
		assertEquals("remove1", myAdapter.remove((Integer)3));
		assertEquals("remove2", myAdapter.remove((Integer)4));
		assertEquals(3, myAdapter.size());
		assertEquals(null, myAdapter.get((Integer)3));
		assertEquals(null, myAdapter.get((Integer)4));
	}
	
	/**
	 * test remove method in Map
	 * 
	 * @safe.precondition a Map
	 * @safe.postcondition Map size unchanged
	 * @safe.testcases test the attempt to remove a couple of key-value that isn't contained in a Map
	 */
	@Test
	public void testRemove_2() {
		//Testing: V remove(Object key);
		HMap<K,V> myAdapter = new MapAdapter<K,V>();
		myAdapter.put((K)(Integer)1, (V)"str1");
		assertEquals(null, myAdapter.remove((Integer)2));
		assertEquals(1, myAdapter.size());
	}
	
	
	/**
	 * test size method in Map
	 * 
	 * @safe.precondition a not empty Map
	 * @safe.postcondition none
	 * @safe.testcases test that a Map has the same size as the number of couples of key-value contained
	 */
	@Test
	public void testSize() {
		//Testing: int size();
		HMap<K,V> myAdapter = new MapAdapter<K,V>();
		myAdapter.put((K)(Integer)1, (V)"str1");
		myAdapter.put((K)(Integer)2, (V)"str2");
		assertEquals(2, myAdapter.size());
	}
	
	
	/**
	 * test entrySet method in Map
	 * 
	 * @safe.precondition two Entry instances
	 * @safe.postcondition none
	 * @safe.testcases test all features of Entry class to check their correctness to get implemented to use correctly a Set of Entry
	 */
	@Test
	public void testEntrySet_1() {
		//Testing: Set<HMap.Entry<K,V>> entrySet();
		Entry<K,V> myEntry = new Entry<K,V>((K)(Integer)1, (V)"str1");
		Entry<K,V> helpEntry = new Entry<K,V>((K)(Integer)1);
		assertEquals(true, helpEntry.equals(helpEntry));
		helpEntry.setValue((V)"str1");
		assertEquals(true, myEntry.equals(helpEntry));
		myEntry.setValue((V)"str2");
		assertEquals(false, myEntry.equals(helpEntry));
		helpEntry = new Entry<K,V>((K)(Integer)2, (V)"str1");
		assertEquals(false, myEntry.equals(helpEntry));
		assertEquals(true, helpEntry.equals(helpEntry));
	}
	
	/**
	 * test entrySet method in Map
	 * 
	 * @safe.precondition a Map and a KeySet created with entrySet() of the Map
	 * @safe.postcondition none
	 * @safe.testcases test all Exceptions of KeyEntry class to check their correctness
	 */
	@Test
	public void testEntrySet_2() {
		//Testing: Set<K> keySet();
		HMap<K,V> myAdapter = new MapAdapter<K,V>();
		myAdapter.put((K)(Integer)1, (V)"str1");
		HSet<HMap.HEntry<K,V>> myEntrySet = myAdapter.entrySet();
		assertThrows(UnsupportedOperationException.class, () -> myEntrySet.add(new Entry<K,V>((K)(Integer)1)));
		assertThrows(UnsupportedOperationException.class, () -> myEntrySet.addAll(new CollectionAdapter<HMap.HEntry<K,V>>()));
		assertThrows(UnsupportedOperationException.class, () -> myEntrySet.equals(new CollectionAdapter<HMap.HEntry<K,V>>()));
		assertThrows(UnsupportedOperationException.class, () -> myEntrySet.toArray(null));
		assertThrows(UnsupportedOperationException.class, () -> myEntrySet.toArray());
		assertThrows(NullPointerException.class, () -> myEntrySet.containsAll(null));
		assertThrows(NullPointerException.class, () -> myEntrySet.removeAll(null));
		assertThrows(NullPointerException.class, () -> myEntrySet.retainAll(null));
	}
	
	/**
	 * test entrySet method in Map
	 * 
	 * @safe.precondition a Map and a KeySet created with entrySet() of the Map
	 * @safe.postcondition none
	 * @safe.testcases test some features of KeyEntry class to check their correctness (KeySet and MapAdapter are backed each other)
	 */
	@Test
	public void testEntrySet_3() {
		//Testing: Set<HMap.Entry<K,V>> entrySet();
		HMap<K,V> myAdapter = new MapAdapter<K,V>();
		myAdapter.put((K)(Integer)1, (V)"str1");
		myAdapter.put((K)(Integer)2, (V)"str2");
		myAdapter.put((K)(Integer)3, (V)"str3");
		
		HSet<HMap.HEntry<K,V>> myEntrySet = myAdapter.entrySet();
		HSet<HMap.HEntry<K,V>> myEntrySet2 = myAdapter.entrySet();
		assertEquals(myEntrySet.hashCode(), myEntrySet2.hashCode());
		
		HCollection<Entry<K,V>> tmpColl = new CollectionAdapter<Entry<K,V>>();
		
		assertEquals(false, myEntrySet.contains(new Entry<K,V>((K)(Integer)4, (V)"str4")));
		assertEquals(true, myEntrySet.retainAll(tmpColl));
		assertEquals(false, myEntrySet.retainAll(tmpColl));
		assertEquals(false, myEntrySet.removeAll(tmpColl));
		assertEquals(true, myEntrySet.containsAll(tmpColl));
		assertEquals(true, myEntrySet.isEmpty());
		assertEquals(false, myEntrySet.remove(new Entry<K,V>((K)(Integer)9, (V)"str9")));
		
		tmpColl.add(new Entry<K,V>((K)(Integer)3, (V)"str3"));
		assertEquals(false, myEntrySet.containsAll(tmpColl));
		tmpColl.add(new Entry<K,V>((K)(Integer)1, (V)"str1"));
		tmpColl.add(new Entry<K,V>((K)(Integer)2, (V)"str2"));
		
		myAdapter.put((K)(Integer)1, (V)"str1");
		myAdapter.put((K)(Integer)2, (V)"str2");
		myAdapter.put((K)(Integer)3, (V)"str3");
		myEntrySet = myAdapter.entrySet();
		assertEquals(true, myEntrySet.remove(new Entry<K,V>((K)(Integer)1, (V)"str1")));
		assertEquals(true, myEntrySet.removeAll(tmpColl));
		myEntrySet.clear();
		assertEquals(true, myEntrySet.isEmpty());
		
	}
	
	/**
	 * test entrySet method in Map
	 * 
	 * @safe.precondition a Map and a KeySet created with entrySet() of the Map
	 * @safe.postcondition none
	 * @safe.testcases test some other features of KeyEntry class to check their correctness (KeySet and MapAdapter are backed each other)
	 */
	@Test
	public void testEntrySet_4() {
		//Testing: Set<HMap.Entry<K,V>> entrySet();
		HMap<K,V> myAdapter = new MapAdapter<K,V>();
		HSet<HMap.HEntry<K,V>> myEntrySet = myAdapter.entrySet();
		
		myAdapter.put((K)(Integer)1, (V)"str1");
		myAdapter.put((K)(Integer)2, (V)"str2");
		myAdapter.put((K)(Integer)3, (V)"str3");
		assertEquals(3, myEntrySet.size());
		assertEquals(myAdapter.size(), myEntrySet.size());
		
		Entry<K,V> myEntry = new Entry<K,V>((K)(Integer)1, (V)"str1");

		assertEquals(true, myEntrySet.contains(myEntry));
		assertEquals(true, myEntrySet.remove(myEntry));
		assertEquals(null, myAdapter.get((K)(Integer)1));

		assertEquals(2, myEntrySet.size());
		assertEquals(myAdapter.size(), myEntrySet.size());
	}
	
	
	/**
	 * test entrySet method in Map
	 * 
	 * @safe.precondition a Map and a KeySet created with entrySet() of the Map
	 * @safe.postcondition none
	 * @safe.testcases test all Exceptions of KeyEntry class to check their correctness
	 */
	@Test
	public void testKeySet_1() {
		//Testing: Set<K> keySet();
		HMap<K,V> myAdapter = new MapAdapter<K,V>();
		myAdapter.put((K)(Integer)1, (V)"str1");
		HSet<K> myKeySet = myAdapter.keySet();
		assertThrows(UnsupportedOperationException.class, () -> myKeySet.add((K)(Integer)2));
		assertThrows(UnsupportedOperationException.class, () -> myKeySet.addAll(new CollectionAdapter<K>()));
		assertThrows(UnsupportedOperationException.class, () -> myKeySet.equals(new CollectionAdapter<K>()));
		assertThrows(NullPointerException.class, () -> myKeySet.containsAll(null));
		assertThrows(NullPointerException.class, () -> myKeySet.removeAll(null));
		assertThrows(NullPointerException.class, () -> myKeySet.retainAll(null));
		assertThrows(NullPointerException.class, () -> myKeySet.toArray(null));
	}
	
	/**
	 * test entrySet method in Map
	 * 
	 * @safe.precondition a Map and a KeySet created with entrySet() of the Map
	 * @safe.postcondition none
	 * @safe.testcases test some features of KeyEntry class to check their correctness (KeySet and MapAdapter are backed each other)
	 */
	@Test
	public void testKeySet_2() {
		//Testing: Set<K> keySet();
		HMap<K,V> myAdapter = new MapAdapter<K,V>();
		myAdapter.put((K)(Integer)1, (V)"str1");
		myAdapter.put((K)(Integer)2, (V)"str2");
		myAdapter.put((K)(Integer)3, (V)"str3");
		
		HSet<K> myKeySet = myAdapter.keySet();
		HSet<K> myKeySet2 = myAdapter.keySet();
		assertEquals(myKeySet.hashCode(), myKeySet2.hashCode());
		
		HCollection<K> tmpColl = new CollectionAdapter<K>();
		tmpColl.add((K)(Integer)4);
		tmpColl.add((K)(Integer)5);
		tmpColl.add((K)(Integer)6);
		
		assertEquals(false, myKeySet.contains((Integer)4));
		assertEquals(false, myKeySet.containsAll(tmpColl));
		assertEquals(false, myKeySet.retainAll(myKeySet));
		assertEquals(false, myKeySet.removeAll(tmpColl));
		assertEquals(true, myKeySet.containsAll(myKeySet));
		assertEquals(true, myKeySet.retainAll(tmpColl));
		assertEquals(true, myKeySet.isEmpty());
		assertEquals(false, myKeySet.remove((Integer)4));
		
		myAdapter.put((K)(Integer)1, (V)"str1");
		myAdapter.put((K)(Integer)2, (V)"str2");
		myAdapter.put((K)(Integer)3, (V)"str3");
		myKeySet = myAdapter.keySet();
		assertEquals(true, myKeySet.remove((Integer)1));
		myKeySet.clear();
		assertEquals(true, myKeySet.isEmpty());
	}
	
	/**
	 * test entrySet method in Map
	 * 
	 * @safe.precondition a Map and a KeySet created with entrySet() of the Map
	 * @safe.postcondition none
	 * @safe.testcases test some other features of KeyEntry class to check their correctness (KeySet and MapAdapter are backed each other)
	 */
	@Test
	public void testKeySet_3() {
		//Testing: Set<K> keySet();
		HMap<K,V> myAdapter = new MapAdapter<K,V>();
		HSet<K> myKeySet = myAdapter.keySet();
		
		myAdapter.put((K)(Integer)1, (V)"str1");
		myAdapter.put((K)(Integer)10, (V)"str2");
		myAdapter.put((K)(Integer)2, (V)"str3");
		assertEquals(3, myKeySet.size());
		assertEquals(myAdapter.size(), myKeySet.size());
		
		assertEquals(true, myKeySet.contains(1));
		assertEquals(true, myKeySet.remove(10));
		assertEquals(null, myAdapter.get((K)(Integer)10));

		assertEquals(2, myKeySet.size());
		assertEquals(myKeySet.size(), myAdapter.size());
		Integer[] myArray2 = {2, 1};
		assertArrayEquals(myArray2, myKeySet.toArray());

		Integer[] myArray1 = new Integer[myKeySet.size()];
		myArray2 = myKeySet.toArray(myArray1);
		assertArrayEquals(myArray2, myArray1);
		
		Integer[] myArray3 = new Integer[myKeySet.size()+1];
		myArray3 = myKeySet.toArray(myArray3);
		
	}
	
	
	/**
	 * test values method in Map
	 * 
	 * @safe.precondition a Map and a Values created with values() of the Map
	 * @safe.postcondition none
	 * @safe.testcases test all Exceptions of Values class to check their correctness
	 */
	@Test
	public void testValues_1() {
		//Testing: Collection<V> values();
		HMap<K,V> myAdapter = new MapAdapter<K,V>();
		myAdapter.put((K)(Integer)1, (V)"str1");
		HCollection<V> myValues = myAdapter.values();
		assertThrows(UnsupportedOperationException.class, () -> myValues.add((V)"str2"));
		assertThrows(UnsupportedOperationException.class, () -> myValues.addAll(new CollectionAdapter<V>()));
		assertThrows(UnsupportedOperationException.class, () -> myValues.equals(new CollectionAdapter<V>()));
		assertThrows(NullPointerException.class, () -> myValues.containsAll(null));
		assertThrows(NullPointerException.class, () -> myValues.removeAll(null));
		assertThrows(NullPointerException.class, () -> myValues.retainAll(null));
		assertThrows(NullPointerException.class, () -> myValues.toArray(null));
	}
	
	/**
	 * test values method in Map
	 * 
	 * @safe.precondition a Map and a Values created with values() of the Map
	 * @safe.postcondition none
	 * @safe.testcases test some features of Values class to check their correctness (Values and MapAdapter are backed each other)
	 */
	@Test
	public void testValues_2() {
		//Testing: Collection<V> values();
		HMap<K,V> myAdapter = new MapAdapter<K,V>();
		myAdapter.put((K)(Integer)1, (V)"str1");
		myAdapter.put((K)(Integer)2, (V)"str2");
		myAdapter.put((K)(Integer)3, (V)"str3");
		
		HCollection<V> myValues = myAdapter.values();
		HCollection<V> myValues2 = myAdapter.values();
		assertEquals(myValues.hashCode(), myValues2.hashCode());
		
		HCollection<V> tmpColl = new CollectionAdapter<V>();
		tmpColl.add((V)"str4");
		tmpColl.add((V)"str5");
		tmpColl.add((V)"str6");
		
		assertEquals(false, myValues.contains((V)"str4"));
		assertEquals(false, myValues.containsAll(tmpColl));
		assertEquals(false, myValues.retainAll(myValues));
		assertEquals(false, myValues.removeAll(tmpColl));
		assertEquals(true, myValues.containsAll(myValues));
		assertEquals(true, myValues.retainAll(tmpColl));
		assertEquals(true, myValues.isEmpty());
		assertEquals(false, myValues.remove((V)"str1"));
		
		myAdapter.put((K)(Integer)1, (V)"str1");
		myAdapter.put((K)(Integer)2, (V)"str2");
		myAdapter.put((K)(Integer)3, (V)"str3");
		myValues = myAdapter.values();
		assertEquals(true, myValues.remove((V)"str1"));
		myValues.clear();
		assertEquals(true, myValues.isEmpty());
	}
	
	/**
	 * test values method in Map
	 * 
	 * @safe.precondition a Map and a Values created with values() of the Map
	 * @safe.postcondition none
	 * @safe.testcases test some other features of Values class to check their correctness (Values and MapAdapter are backed each other)
	 */
	@Test
	public void testValues_3() {
		//Testing: Collection<V> values();
		HMap<K,V> myAdapter = new MapAdapter<K,V>();
		HCollection<V> myValues = myAdapter.values();
		
		myAdapter.put((K)(Integer)1, (V)"str1");
		myAdapter.put((K)(Integer)2, (V)"str2");
		myAdapter.put((K)(Integer)3, (V)"str3");
		assertEquals(3, myValues.size());
		assertEquals(myAdapter.size(), myValues.size());
		
		assertEquals(true, myValues.contains("str1"));
		assertEquals(true, myValues.remove("str3"));
		assertEquals(null, myAdapter.get((K)(Integer)3));

		assertEquals(2, myValues.size());
		assertEquals(myValues.size(), myAdapter.size());
		String[] myArray2 = {"str2", "str1"};
		assertArrayEquals(myArray2, myValues.toArray());
		
		String[] myArray3 = new String[myValues.size()];
		myArray3 = myValues.toArray(myArray3);
		assertArrayEquals(myArray2, myArray3);
	}
}
