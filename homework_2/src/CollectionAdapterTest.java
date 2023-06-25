import org.junit.Test;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

/**
 * Test Class for CollectionAdapter
 * 
 * @safe.summary this class is in charge of testing the Collection class
 * @safe.testsuitedesign each individual method is tested, verifying that
 * intermediate states are created and all of them are verified, to verify
 * that the collection does not break during the editing
 */

public class CollectionAdapterTest<E> {
	
	/**
	 * test add method in Collection
	 * 
	 * @safe.precondition a Collection
	 * @safe.postcondition NullPointerException thrown
	 * @safe.testcases test the attempt to add a null element in a Collection
	 */
	@Test
	public void testAdd_1() {
		//Testing: boolean add(E e);
		HCollection<E> myAdapter = new CollectionAdapter<E>();
		assertThrows(NullPointerException.class, () -> myAdapter.add(null));
	}
	
	/**
	 * test add method in Collection
	 * 
	 * @safe.precondition an empty Collection
	 * @safe.postcondition Collection size = 3
	 * @safe.testcases test the addition of 3 elements (including 2 identical elements) in a Collection
	 */
	@Test
	public void testAdd_2() {
		//Testing: boolean add(E e);
		HCollection<E> myAdapter = new CollectionAdapter<E>();
		assertEquals(true, myAdapter.add((E)"str1"));
		assertEquals(true, myAdapter.add((E)"strEqual"));
		assertEquals(true, myAdapter.add((E)"strEqual"));
		assertEquals(3, myAdapter.size());
		String[] myArray = {"str1", "strEqual", "strEqual"};
		assertArrayEquals(myArray, myAdapter.toArray());
	}
	
	/**
	 * test add method in Collection
	 * 
	 * @safe.precondition an empty Collection
	 * @safe.postcondition Collection size = 3
	 * @safe.testcases test the addition of 3 elements (with different parameter types) in a Collection
	 */
	@Test
	public void testAdd_3() {
		//Testing: boolean add(E e);
		HCollection<E> myAdapter = new CollectionAdapter<E>();
		assertEquals(true, myAdapter.add((E)"str1"));
		assertEquals(true, myAdapter.add((E)(Double)2.2));
		assertEquals(true, myAdapter.add((E)(Integer)3));
		assertEquals(3, myAdapter.size());
		Object[] myArray = {"str1", 2.2, 3};
		assertArrayEquals(myArray, myAdapter.toArray());
	}
	
	
	/**
	 * test addAll method in Collection
	 * 
	 * @safe.precondition a Collection
	 * @safe.postcondition NullPointerException thrown
	 * @safe.testcases test the attempt to add, in a Collection, elements from a null Collection
	 */
	//Adds all of the elements in the specified collection to this collection (optional operation).
	@Test 
	public void testAddAll_1() {
		//Testing: boolean addAll(Collection<? extends E> c);
		HCollection<E> myAdapter = new CollectionAdapter<E>();
		assertThrows(NullPointerException.class, () -> myAdapter.addAll(null));
	}
	
	/**
	 * test addAll method in Collection
	 * 
	 * @safe.precondition two Collections with 2 elements each
	 * @safe.postcondition Collection size = 4
	 * @safe.testcases test the addition, in a Collection with 2 elements, of 2 other elements from another Collection
	 */
	@Test
	public void testAddAll_2() {
		//Testing: boolean addAll(Collection<? extends E> c);
		HCollection<E> myAdapter = new CollectionAdapter<E>();
		HCollection<E> helpAdapter = new CollectionAdapter<E>();
		myAdapter.add((E)"str1");
		myAdapter.add((E)"str2");
		helpAdapter.add((E)"add3");
		helpAdapter.add((E)"add4");
		assertEquals(true, myAdapter.addAll(helpAdapter));
		assertEquals(4, myAdapter.size());
		String[] myArray = {"str1", "str2", "add3", "add4"};
		assertArrayEquals(myArray, myAdapter.toArray());
	}	
	
	/**
	 * test addAll method in Collection
	 * 
	 * @safe.precondition an empty Collection
	 * @safe.postcondition the Collection remains empty
	 * @safe.testcases test the attempt to add, in a Collection, elements from an empty Collection
	 */
	@Test 
	public void testAddAll_3() {
		//Testing: boolean addAll(Collection<? extends E> c);
		HCollection<E> myAdapter = new CollectionAdapter<E>();
		assertEquals(false, myAdapter.addAll(new CollectionAdapter<E>()));
		assertEquals(true, myAdapter.isEmpty());
	}
	
	
	/**
	 * test clear method in Collection
	 * 
	 * @safe.precondition a not empty Collection
	 * @safe.postcondition the Collection becomes empty
	 * @safe.testcases test the elimination of all elements from a Collection
	 */
	//Removes all of the elements from this collection (optional operation).
	@Test
	public void testClear() {
		HCollection<E> myAdapter = new CollectionAdapter<E>();
		myAdapter.add((E)"str1");
		myAdapter.add((E)"str2");
		myAdapter.clear();
		assertEquals(true, myAdapter.isEmpty());
		assertEquals(0, myAdapter.size());
	}
	
	
	/**
	 * test contains method in Collection
	 * 
	 * @safe.precondition a not empty Collection
	 * @safe.postcondition none
	 * @safe.testcases test checking that a Collection contains determined elements that are in the Collection
	 */
	//Returns true if this collection contains the specified element.
	@Test
	public void testContains_1() {
		//Testing: boolean contains(Object o);
		HCollection<E> myAdapter = new CollectionAdapter<E>();
		myAdapter.add((E)"str1");
		myAdapter.add((E)"str2");
		assertEquals(true, myAdapter.contains((E)"str1"));
		assertEquals(true, myAdapter.contains((E)"str2"));
	}
	
	/**
	 * test contains method in Collection
	 * 
	 * @safe.precondition a Collection
	 * @safe.postcondition none
	 * @safe.testcases test checking that a Collection doesn't contain a determined element that isn't in the Collection
	 */
	@Test
	public void testContains_2() {
		//Testing: boolean contains(Object o);
		HCollection<E> myAdapter = new CollectionAdapter<E>();
		myAdapter.add((E)"str1");
		myAdapter.add((E)"str2");
		assertEquals(false, myAdapter.contains((E)"str3"));
	}
	
	
	/**
	 * test containsAll method in Collection
	 * 
	 * @safe.precondition a Collection
	 * @safe.postcondition NullPointerException thrown
	 * @safe.testcases test the attempt to check if a Collection contains determined elements using a null Collection
	 */
	//Returns true if this collection contains all of the elements in the specified collection.
	@Test
	public void testContainsAll_1() {
		//Testing: boolean containsAll(Collection<?> c);
		HCollection<E> myAdapter = new CollectionAdapter<E>();
		assertThrows(NullPointerException.class, () -> myAdapter.containsAll(null));
	}
	
	/**
	 * test containsAll method in Collection
	 * 
	 * @safe.precondition a Collection with 3 elements and a Collection with 2 elements that are equal to 2 of the elements of the first Collection
	 * @safe.postcondition none
	 * @safe.testcases test checking that a Collection contains all elements of another Collection
	 */
	@Test
	public void testContainsAll_2() {
		//Testing: boolean containsAll(Collection<?> c);
		HCollection<E> myAdapter = new CollectionAdapter<E>();
		HCollection<E> helpAdapter = new CollectionAdapter<E>();
		myAdapter.add((E)"str1");
		myAdapter.add((E)"str2");
		myAdapter.add((E)"str3");
		helpAdapter.add((E)"str1");
		helpAdapter.add((E)"str3");
		assertEquals(true, myAdapter.containsAll(helpAdapter));
	}
	
	/**
	 * test containsAll method in Collection
	 * 
	 * @safe.precondition two Collections with same elements
	 * @safe.postcondition none
	 * @safe.testcases test checking that a Collection doesn't contain all elements of another Collection
	 */
	@Test
	public void testContainsAll_3() {
		//Testing: boolean containsAll(Collection<?> c);
		HCollection<E> myAdapter = new CollectionAdapter<E>();
		HCollection<E> helpAdapter = new CollectionAdapter<E>();
		myAdapter.add((E)"str1");
		myAdapter.add((E)"str2");
		helpAdapter.add((E)"str1");
		helpAdapter.add((E)"str3");
		assertEquals(false, myAdapter.containsAll(helpAdapter));
	}
	
	
	/**
	 * test equals method in Collection
	 * 
	 * @safe.precondition two Collections with same elements
	 * @safe.postcondition none
	 * @safe.testcases test that two Collections with same elements are equal
	 */
	//Compares the specified object with this collection for equality.
	@Test
	public void testEquals_1() {
		//Testing: boolean equals(Object o);
		HCollection<E> myAdapter = new CollectionAdapter<E>();
		HCollection<E> helpAdapter = new CollectionAdapter<E>();
		myAdapter.add((E)"str1");
		myAdapter.add((E)"str2");
		helpAdapter.add((E)"str1");
		helpAdapter.add((E)"str2");
		assertEquals(true, myAdapter.equals(helpAdapter));
	}
	
	/**
	 * test equals method in Collection
	 * 
	 * @safe.precondition two Collections with at least one different element
	 * @safe.postcondition none
	 * @safe.testcases test that two Collections with at least one different element aren't equal
	 */
	@Test
	public void testEquals_2() {
		//Testing: boolean equals(Object o);
		HCollection<E> myAdapter = new CollectionAdapter<E>();
		HCollection<E> helpAdapter = new CollectionAdapter<E>();
		myAdapter.add((E)"str1");
		myAdapter.add((E)"str2");
		helpAdapter.add((E)"str1");
		assertEquals(false, myAdapter.equals(helpAdapter));
	}
	
	/**
	 * test equals method in Collection
	 * 
	 * @safe.precondition a Collection
	 * @safe.postcondition none
	 * @safe.testcases test that a Collection and another Object (that isn't a Collection instance) aren't equal
	 */
	@Test
	public void testEquals_3() { //false: not instance of
		//Testing: boolean equals(Object o);
		HCollection<E> myAdapter = new CollectionAdapter<E>();
		assertEquals(false, myAdapter.equals((Integer)1));
	}
	
	
	/**
	 * test hashCode method in Collection
	 * 
	 * @safe.precondition two Collections with same elements
	 * @safe.postcondition none
	 * @safe.testcases test that two Collections with same elements have same hashCode
	 */
	//Returns the hash code value for this collection.
	@Test
	public void testHashCode() {
		//Testing: int hashCode();
		HCollection<E> myAdapter = new CollectionAdapter<E>();
		myAdapter.add((E)"a");
		myAdapter.add((E)"b");
		HCollection<E> helpAdapter = new CollectionAdapter<E>();
		helpAdapter.add((E)"a");
		helpAdapter.add((E)"b");
		assertEquals(myAdapter.hashCode(), helpAdapter.hashCode());
		//assertEquals(4066, myAdapter.hashCode());
	}
	
	
	/**
	 * test isEmpty method in Collection
	 * 
	 * @safe.precondition an empty Collection
	 * @safe.postcondition none
	 * @safe.testcases test that a Collection without elements is empty
	 */
	//Returns true if this collection contains no elements.
	@Test
	public void testIsEmpty_1() {
		//Testing: boolean isEmpty();
		HCollection<E> myAdapter = new CollectionAdapter<E>();
		assertEquals(true, myAdapter.isEmpty());
	}
	
	/**
	 * test isEmpty method in Collection
	 * 
	 * @safe.precondition a not empty Collection
	 * @safe.postcondition none
	 * @safe.testcases test that a Collection with an element isn't empty
	 */
	@Test
	public void testIsEmpty_2() {
		//Testing: boolean isEmpty();
		HCollection<E> myAdapter = new CollectionAdapter<E>();
		myAdapter.add((E)"str1");
		assertEquals(false, myAdapter.isEmpty());
	}
	
	
	/**
	 * test iterator method in Collection
	 * 
	 * @safe.precondition a not empty Collection
	 * @safe.postcondition NoSuchElementException thrown
	 * @safe.testcases test the attempt to get the next element in an Iterator at the end of the Iterator
	 */
	@Test
	public void testIterator_1() {
		//Testing: Iterator<E> iterator();
		HCollection<E> myAdapter = new CollectionAdapter<E>();
		myAdapter.add((E)"str1");
		Iterator<E> myIterator = myAdapter.iterator();
		myIterator.next();
		assertThrows(java.util.NoSuchElementException.class, () -> myIterator.next());
	}
	
	/**
	 * test iterator method in Collection
	 * 
	 * @safe.precondition a Collection
	 * @safe.postcondition IllegalStateException thrown
	 * @safe.testcases test the attempt to remove an element in an Iterator when there is no element in that position
	 */
	@Test
	public void testIterator_2() {
		//Testing: Iterator<E> iterator();
		HCollection<E> myAdapter = new CollectionAdapter<E>();
		myAdapter.add((E)"str1");
		myAdapter.add((E)"str2");
		Iterator<E> myIterator = myAdapter.iterator();
		myIterator.next();
		myIterator.next();
		myIterator.remove();
		assertThrows(IllegalStateException.class, () -> myIterator.remove());
	}
	
	/**
	 * test iterator method in Collection
	 * 
	 * @safe.precondition a Collection with 5 elements
	 * @safe.postcondition Collection size = 3
	 * @safe.testcases test Collection Iterator features to remove 2 elements from a Collection of 5 elements
	 */
	@Test
	public void testIterator_3() {
		//Testing: Iterator<E> iterator();
		HCollection<E> myAdapter = new CollectionAdapter<E>();
		myAdapter.add((E)"str1");
		myAdapter.add((E)"remove1");
		myAdapter.add((E)"remove2");
		myAdapter.add((E)"str2");
		myAdapter.add((E)"str3");
		Iterator<E> myIterator = myAdapter.iterator();
		myIterator.next();
		myIterator.next();
		myIterator.remove();
		myIterator.next();
		myIterator.remove();
		assertEquals(3, myAdapter.size());
		String[] myArray = {"str1", "str2", "str3"};
		assertArrayEquals(myArray, myAdapter.toArray());
	}
	
	/**
	 * test iterator method in Collection
	 * 
	 * @safe.precondition a not empty Collection
	 * @safe.postcondition the Collection becomes empty
	 * @safe.testcases test Collection Iterator features to clear a Collection
	 */
	@Test
	public void testIterator_4() {
		//Testing: Iterator<E> iterator();
		HCollection<E> myAdapter = new CollectionAdapter<E>();
		myAdapter.add((E)"str1");
		myAdapter.add((E)"remove1");
		myAdapter.add((E)"str2");
		myAdapter.add((E)"remove2");
		myAdapter.add((E)"str3");
		Iterator<E> myIterator = myAdapter.iterator();
		while(myIterator.hasNext()) {
			myIterator.next();
			myIterator.remove();
		}
		assertEquals(true, myAdapter.isEmpty());
		assertEquals(0, myAdapter.size());
	}
	
	
	/**
	 * test remove method in Collection
	 * 
	 * @safe.precondition a Collection with 5 elements
	 * @safe.postcondition Collection size = 3
	 * @safe.testcases test the removal of 2 determined elements that are contained in a Collection
	 */
	//Removes a single instance of the specified element from this collection, if it is present (optional operation).
	@Test
	public void testRemove_1() {
		//Testing: boolean remove(Object o);
		HCollection<E> myAdapter = new CollectionAdapter<E>();
		myAdapter.add((E)"str1");
		myAdapter.add((E)"remove1");
		myAdapter.add((E)"removeEqual");
		myAdapter.add((E)"str2");
		myAdapter.add((E)"removeEqual");
		assertEquals(true, myAdapter.remove((E)"remove1"));
		assertEquals(true, myAdapter.remove((E)"removeEqual"));
		assertEquals(3, myAdapter.size());
		String[] myArray = {"str1", "str2", "removeEqual"};
		assertArrayEquals(myArray, myAdapter.toArray());
	}
	
	/**
	 * test remove method in Collection
	 * 
	 * @safe.precondition a Collection
	 * @safe.postcondition Collection size unchanged
	 * @safe.testcases test the attempt to remove an element that isn't contained in a Collection
	 */
	@Test
	public void testRemove_2() {
		//Testing: boolean remove(Object o);
		HCollection<E> myAdapter = new CollectionAdapter<E>();
		myAdapter.add((E)"str1");
		assertEquals(false, myAdapter.remove((E)"str2"));
		assertEquals(1, myAdapter.size());
	}
	
	
	/**
	 * test removeAll method in Collection
	 * 
	 * @safe.precondition a Collection
	 * @safe.postcondition NullPointerException thrown
	 * @safe.testcases test the attempt to remove elements in a Collection using a null Collection
	 */
	//Removes all of this collection's elements that are also contained in the specified collection (optional operation).
	@Test
	public void testRemoveAll_1() {
		//Testing: boolean removeAll(Collection<?> c);
		HCollection<E> myAdapter = new CollectionAdapter<E>();
		assertThrows(NullPointerException.class, () -> myAdapter.removeAll(null));
	}
	
	/**
	 * test removeAll method in Collection
	 * 
	 * @safe.precondition a Collection with 5 element and a Collection with 3 elements (including 2 common elements)
	 * @safe.postcondition Collection size = 3
	 * @safe.testcases test the removal, from a Collection with 5 elements, of 2 elements that are also contained in another Collection
	 */
	@Test
	public void testRemoveAll_2() {
		//Testing: boolean removeAll(Collection<?> c);
		HCollection<E> myAdapter = new CollectionAdapter<E>();
		HCollection<E> helpAdapter = new CollectionAdapter<E>();
		myAdapter.add((E)"str1");
		myAdapter.add((E)"remove1");
		myAdapter.add((E)"str2");
		myAdapter.add((E)"remove2");
		myAdapter.add((E)"str3");
		helpAdapter.add((E)"remove2");
		helpAdapter.add((E)"removeNothing");
		helpAdapter.add((E)"remove1");
		assertEquals(true, myAdapter.removeAll(helpAdapter));
		assertEquals(3, myAdapter.size());
		String[] myArray = {"str1", "str2", "str3"};
		assertArrayEquals(myArray, myAdapter.toArray());
	}
	
	/**
	 * test removeAll method in Collection
	 * 
	 * @safe.precondition two Collections with different elements
	 * @safe.postcondition Collections size unchanged
	 * @safe.testcases test the attempt to remove elements from a Collection using another Collection that has only different elements
	 */
	@Test
	public void testRemoveAll_3() {
		//Testing: boolean removeAll(Collection<?> c);
		HCollection<E> myAdapter = new CollectionAdapter<E>();
		HCollection<E> helpAdapter = new CollectionAdapter<E>();
		myAdapter.add((E)"str1");
		myAdapter.add((E)"str2");
		helpAdapter.add((E)"str3");
		assertEquals(false, myAdapter.removeAll(helpAdapter));
		assertEquals(2, myAdapter.size());
	}
	
	
	/**
	 * test retainAll method in Collection
	 * 
	 * @safe.precondition a Collection
	 * @safe.postcondition NullPointerException thrown
	 * @safe.testcases test the attempt to retain elements in a Collection using a null Collection
	 */
	//Retains only the elements in this collection that are contained in the specified collection (optional operation).
	@Test
	public void testRetainAll_1() {
		//Testing: boolean retainAll(Collection<?> c);
		HCollection<E> myAdapter = new CollectionAdapter<E>();
		assertThrows(NullPointerException.class, () -> myAdapter.retainAll(null));
	}
	
	/**
	 * test retainAll method in Collection
	 * 
	 * @safe.precondition a Collection with 5 element and a Collection with 4 elements (including 3 common elements)
	 * @safe.postcondition Collection size = 3
	 * @safe.testcases test the removal of 3 out of 5 elements from a Collection retaining only the 3 elements that are also contained in another Collection
	 */
	@Test
	public void testRetainAll_2() {
		//Testing: boolean retainAll(Collection<?> c);
		HCollection<E> myAdapter = new CollectionAdapter<E>();
		HCollection<E> helpAdapter = new CollectionAdapter<E>();
		myAdapter.add((E)"str1");
		myAdapter.add((E)"remove1");
		myAdapter.add((E)"str2");
		myAdapter.add((E)"remove2");
		myAdapter.add((E)"str3");
		helpAdapter.add((E)"str2");
		helpAdapter.add((E)"str3");
		helpAdapter.add((E)"retainNothing");
		helpAdapter.add((E)"str1");
		assertEquals(true, myAdapter.retainAll(helpAdapter));
		assertEquals(3, myAdapter.size());
		String[] myArray = {"str1", "str2", "str3"};
		assertArrayEquals(myArray, myAdapter.toArray());
	}
	
	/**
	 * test retainAll method in Collection
	 * 
	 * @safe.precondition two Collections with same elements
	 * @safe.postcondition Collections size unchanged
	 * @safe.testcases test the attempt to retain elements in a Collection using another Collection that has only different elements
	 */
	@Test
	public void testRetainAll_3() {
		//Testing: boolean retainAll(Collection<?> c);
		HCollection<E> myAdapter = new CollectionAdapter<E>();
		HCollection<E> helpAdapter = new CollectionAdapter<E>();
		myAdapter.add((E)"str1");
		myAdapter.add((E)"str2");
		helpAdapter.add((E)"str1");
		helpAdapter.add((E)"str2");
		assertEquals(false, myAdapter.retainAll(helpAdapter));
		assertEquals(2, myAdapter.size());
	}
	
	
	/**
	 * test size method in Collection
	 * 
	 * @safe.precondition a not empty Collection
	 * @safe.postcondition none
	 * @safe.testcases test that a Collection has the same size as the number of elements contained
	 */
	//Returns the number of elements in this collection.
	@Test
	public void testSize() {
		//Testing: int size();
		HCollection<E> myAdapter = new CollectionAdapter<E>();
		myAdapter.add((E)"str1");
		myAdapter.add((E)"str2");
		assertEquals(2, myAdapter.size());
	}
	
	
	/**
	 * test toArray method in Collection
	 * 
	 * @safe.precondition a not empty Collection
	 * @safe.postcondition none
	 * @safe.testcases test the creation of an array with elements of a Collection contains all the elements of the Collection and in the same order (using String type)
	 */
	@Test
	public void testToArray1_1() {
		//Testing: Object[] toArray();
		HCollection<E> myAdapter = new CollectionAdapter<E>();
		myAdapter.add((E)"str1");
		myAdapter.add((E)"str2");
		myAdapter.add((E)"str3");
		String[] myArray = {"str1", "str2", "str3"};
		assertArrayEquals(myArray, myAdapter.toArray());
	}
	
	/**
	 * test toArray method in Collection
	 * 
	 * @safe.precondition a not empty Collection
	 * @safe.postcondition none
	 * @safe.testcases test the creation of an array with elements of a Collection contains all the elements of the Collection and in the same order (using Integer type)
	 */
	@Test
	public void testToArray1_2() {
		//Testing: Object[] toArray();
		HCollection<E> myAdapter = new CollectionAdapter<E>();
		myAdapter.add((E)(Integer)1);
		myAdapter.add((E)(Integer)2);
		myAdapter.add((E)(Integer)3);
		Integer[] myArray = {1, 2, 3};
		assertArrayEquals(myArray, myAdapter.toArray());
	}
	
	
	/**
	 * test 2nd toArray method in Collection
	 * 
	 * @safe.precondition a not empty Collection
	 * @safe.postcondition NullPointerException thrown
	 * @safe.testcases test the attempt to create an array with elements of a Collection using a null array
	 */
	@Test
	public void testToArray2_1() {
		//Testing: <T> T[] toArray(T[] a);
		HCollection<E> myAdapter = new CollectionAdapter<E>();
		myAdapter.add((E)"str1");
		assertThrows(NullPointerException.class, () -> myAdapter.toArray(null));
	}
	
	/**
	 * test 2nd toArray method in Collection
	 * 
	 * @safe.precondition a not empty Collection
	 * @safe.postcondition ArrayStoreException thrown
	 * @safe.testcases test the attempt to create an array with elements of a determined type (String in this case) of a Collection using an array of another determined type (Integer in this case)
	 */
	@Test
	public void testToArray2_2() {
		//Testing: <T> T[] toArray(T[] a);
		HCollection<E> myAdapter = new CollectionAdapter<E>();
		myAdapter.add((E)"str1");
		Integer[] tmpArray = new Integer[1];
		assertThrows(ArrayStoreException.class, () -> myAdapter.toArray(tmpArray));
	}
	
	/**
	 * test 2nd toArray method in Collection
	 * 
	 * @safe.precondition a not empty Collection
	 * @safe.postcondition UnsupportedOperationException thrown
	 * @safe.testcases test the attempt to create an array with elements of a Collection using an array with less length than the number of elements contained in the Collection
	 */
	@Test
	public void testToArray2_3() {
		//Testing: <T> T[] toArray(T[] a);
		HCollection<E> myAdapter = new CollectionAdapter<E>();
		myAdapter.add((E)"str1");
		myAdapter.add((E)"str2");
		String[] tmpArray = new String[1];
		assertThrows(UnsupportedOperationException.class, () -> myAdapter.toArray(tmpArray));
	}
	
	/**
	 * test 2nd toArray method in Collection
	 * 
	 * @safe.precondition a not empty Collection
	 * @safe.postcondition ArrayStoreException thrown
	 * @safe.testcases test the attempt to create an array with elements of a Collection using an array with a different type of parameters
	 */
	@Test
	public void testToArray2_4() {
		//Testing: <T> T[] toArray(T[] a);
		HCollection<E> myAdapter = new CollectionAdapter<E>();
		myAdapter.add((E)"str1");
		myAdapter.add((E)"str2");
		String[] myArray = {"", "", "", ""};
		Integer[] tmpArray = {1, 2, 3, 4};
		assertThrows(ArrayStoreException.class, () -> myAdapter.toArray(tmpArray));
	}
	
	/**
	 * test 2nd toArray method in Collection
	 * 
	 * @safe.precondition a not empty Collection
	 * @safe.postcondition none
	 * @safe.testcases test the creation of an array with elements of a Collection using an array with same length as the number of elements contained in the Collection
	 */
	@Test
	public void testToArray2_5() {
		//Testing: <T> T[] toArray(T[] a);
		HCollection<E> myAdapter = new CollectionAdapter<E>();
		myAdapter.add((E)"str1");
		myAdapter.add((E)"str2");
		myAdapter.add((E)"str3");
		String[] myArray = {"str1", "str2", "str3"};
		String[] tmpArray = new String[myArray.length];
		assertArrayEquals(myArray, myAdapter.toArray(tmpArray));
	}
	
	/**
	 * test 2nd toArray method in Collection
	 * 
	 * @safe.precondition a not empty Collection
	 * @safe.postcondition none
	 * @safe.testcases test the creation of an array with elements of a Collection using an array with more length than the number of elements contained in the Collection
	 */
	@Test
	public void testToArray2_6() {
		//Testing: <T> T[] toArray(T[] a);
		HCollection<E> myAdapter = new CollectionAdapter<E>();
		myAdapter.add((E)"str1");
		myAdapter.add((E)"str2");
		String[] myArray = {"str1", "str2", null, ""};
		String[] tmpArray = {"", "", "", ""};
		assertArrayEquals(myArray, myAdapter.toArray(tmpArray));
	}	
}