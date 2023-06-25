import org.junit.Test;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

/**
 * Test Class for SetAdapter
 * 
 * @safe.summary this class is in charge of testing the collection class
 * @safe.testsuitedesign each individual method is tested, verifying that
 * intermediate states are created and all of them are verified, to verify
 * that the collection does not break during the editing
 */

public class SetAdapterTest<E> {
	
	/**
	 * test add method in List
	 * 
	 * @safe.precondition a List
	 * @safe.postcondition NullPointerException thrown
	 * @safe.testcases test the attempt to add a null element in a List
	 */
	@Test
	public void testAdd_1() {
		//Testing: boolean add(E e);
		HSet<E> myAdapter = new SetAdapter<E>();
		assertThrows(NullPointerException.class, () -> myAdapter.add(null));
	}
	
	/**
	 * test add method in Set
	 * 
	 * @safe.precondition an empty Set
	 * @safe.postcondition Set size = 3
	 * @safe.testcases test the addition of 3 distinct elements in a Set
	 */
	@Test
	public void testAdd_2() {
		//Testing: boolean add(E e);
		HSet<E> myAdapter = new SetAdapter<E>();
		assertEquals(true, myAdapter.add((E)"str1"));
		assertEquals(true, myAdapter.add((E)"str3"));
		assertEquals(true, myAdapter.add((E)"str2"));
		assertEquals(3, myAdapter.size());
		String[] myArray = {"str3", "str2", "str1"};
		assertArrayEquals(myArray, myAdapter.toArray());
	}
	
	/**
	 * test add method in Set
	 * 
	 * @safe.precondition an empty Set
	 * @safe.postcondition Set size = 3
	 * @safe.testcases test the addition of 3 distinct elements (with different parameter types) in a Set
	 */
	@Test
	public void testAdd_3() {
		//Testing: boolean add(E e);
		HSet<E> myAdapter = new SetAdapter<E>();
		assertEquals(true, myAdapter.add((E)"str1"));
		assertEquals(true, myAdapter.add((E)(Double)2.2));
		assertEquals(true, myAdapter.add((E)(Integer)3));
		assertEquals(3, myAdapter.size());
		Object[] myArray = {3, "str1", 2.2};
		assertArrayEquals(myArray, myAdapter.toArray());
	}
	
	/**
	 * test add method in Set
	 * 
	 * @safe.precondition a not empty Set
	 * @safe.postcondition Set size unchanged
	 * @safe.testcases test that in Set doesn't allow the addition of duplicate elements
	 */
	@Test
	public void testAdd_4() {
		//Testing: boolean add(E e);
		HSet<E> myAdapter = new SetAdapter<E>();
		myAdapter.add((E)"str1");
		assertEquals(false, myAdapter.add((E)"str1"));
		assertEquals(1, myAdapter.size());
	}
	
	
	/**
	 * test addAll method in Set
	 * 
	 * @safe.precondition a Set
	 * @safe.postcondition NullPointerException thrown
	 * @safe.testcases test the attempt to add, in a Set, elements from a null Set
	 */
	@Test
	public void testAddAll_1() {
		//Testing: boolean addAll(Collection<? extends E> c);
		HSet<E> myAdapter = new SetAdapter<E>();
		assertThrows(NullPointerException.class, () -> myAdapter.addAll(null));
	}
	
	/**
	 * test addAll method in Set
	 * 
	 * @safe.precondition two Sets with 2 elements each
	 * @safe.postcondition Set size = 4
	 * @safe.testcases test the addition, in a Set with 2 elements, of 2 other elements from another Set
	 */
	@Test
	public void testAddAll_2() {
		//Testing: boolean addAll(Collection<? extends E> c);
		HSet<E> myAdapter = new SetAdapter<E>();
		HSet<E> helpAdapter = new SetAdapter<E>();
		myAdapter.add((E)"str1");
		myAdapter.add((E)"str2");
		helpAdapter.add((E)"add3");
		helpAdapter.add((E)"add4");
		assertEquals(true, myAdapter.addAll(helpAdapter));
		assertEquals(4, myAdapter.size());
		String[] myArray = {"add4", "str2", "add3", "str1"};
		assertArrayEquals(myArray, myAdapter.toArray());
	}
	
	/**
	 * test addAll method in Set
	 * 
	 * @safe.precondition an empty Set
	 * @safe.postcondition the Set remains empty
	 * @safe.testcases test the attempt to add, in a Set, elements from an empty Set
	 */
	@Test
	public void testAddAll_3() {
		//Testing: boolean addAll(Collection<? extends E> c);
		HSet<E> myAdapter = new SetAdapter<E>();
		assertEquals(false, myAdapter.addAll(new SetAdapter<E>()));
		assertEquals(true, myAdapter.isEmpty());
	}
	
		
	/**
	 * test clear method in Set
	 * 
	 * @safe.precondition a not empty Set
	 * @safe.postcondition the Set becomes empty
	 * @safe.testcases test the elimination of all elements from a Set
	 */
	@Test
	public void testClear() {
		//Testing: void clear();
		HSet<E> myAdapter = new SetAdapter<E>();
		myAdapter.add((E)"str1");
		myAdapter.add((E)"str2");
		myAdapter.clear();
		assertEquals(true, myAdapter.isEmpty());
		assertEquals(0, myAdapter.size());
	}
	
	
	/**
	 * test contains method in Set
	 * 
	 * @safe.precondition a not empty Set
	 * @safe.postcondition none
	 * @safe.testcases test checking that a Set contains determined elements that are in the Set
	 */
	@Test
	public void testContains_1() {
		//Testing: boolean contains(Object o);
		HSet<E> myAdapter = new SetAdapter<E>();
		myAdapter.add((E)"str1");
		myAdapter.add((E)"str2");
		assertEquals(true, myAdapter.contains((E)"str1"));
		assertEquals(true, myAdapter.contains((E)"str2"));
	}
	
	/**
	 * test contains method in Set
	 * 
	 * @safe.precondition a Set
	 * @safe.postcondition none
	 * @safe.testcases test checking that a Set doesn't contain a determined element that isn't in the Set
	 */
	@Test
	public void testContains_2() {
		//Testing: boolean contains(Object o);
		HSet<E> myAdapter = new SetAdapter<E>();
		myAdapter.add((E)"str1");
		myAdapter.add((E)"str2");
		assertEquals(false, myAdapter.contains((E)"str3"));
	}
	
	
	/**
	 * test containsAll method in Set
	 * 
	 * @safe.precondition a Set
	 * @safe.postcondition NullPointerException thrown
	 * @safe.testcases test the attempt to check if a Set contains determined elements using a null Set
	 */
	@Test
	public void testContainsAll_1() {
		//Testing: boolean containsAll(Collection<?> c);
		HSet<E> myAdapter = new SetAdapter<E>();
		assertThrows(NullPointerException.class, () -> myAdapter.containsAll(null));
	}
	
	/**
	 * test containsAll method in Set
	 * 
	 * @safe.precondition a Set with 3 elements and a Set with 2 elements that are equal to 2 of the elements of the first Set
	 * @safe.postcondition none
	 * @safe.testcases test checking that a Set contains all elements of another Set
	 */
	@Test
	public void testContainsAll_2() {
		//Testing: boolean containsAll(Collection<?> c);
		HSet<E> myAdapter = new SetAdapter<E>();
		HSet<E> helpAdapter = new SetAdapter<E>();
		myAdapter.add((E)"str1");
		myAdapter.add((E)"str2");
		myAdapter.add((E)"str3");
		helpAdapter.add((E)"str1");
		helpAdapter.add((E)"str3");
		assertEquals(true, myAdapter.containsAll(helpAdapter));
	}
	
	/**
	 * test containsAll method in Set
	 * 
	 * @safe.precondition two Sets with same elements
	 * @safe.postcondition none
	 * @safe.testcases test checking that a Set doesn't contain all elements of another Set
	 */
	@Test
	public void testContainsAll_3() {
		//Testing: boolean containsAll(Collection<?> c);
		HSet<E> myAdapter = new SetAdapter<E>();
		HSet<E> helpAdapter = new SetAdapter<E>();
		myAdapter.add((E)"str1");
		myAdapter.add((E)"str2");
		helpAdapter.add((E)"str1");
		helpAdapter.add((E)"str3");
		assertEquals(false, myAdapter.containsAll(helpAdapter));
	}
	
	
	/**
	 * test equals method in Set
	 * 
	 * @safe.precondition two Sets with same elements
	 * @safe.postcondition none
	 * @safe.testcases test that two Sets with same elements are equal
	 */
	@Test
	public void testEquals_1() {
		//Testing: boolean equals(Object o);
		HSet<E> myAdapter = new SetAdapter<E>();
		HSet<E> helpAdapter = new SetAdapter<E>();
		myAdapter.add((E)"str1");
		myAdapter.add((E)"str2");
		helpAdapter.add((E)"str1");
		helpAdapter.add((E)"str2");
		assertEquals(true, myAdapter.equals(helpAdapter));
	}
	
	/**
	 * test equals method in Set
	 * 
	 * @safe.precondition two Sets with at least one different element
	 * @safe.postcondition none
	 * @safe.testcases test that two Sets with at least one different element aren't equal
	 */
	@Test
	public void testEquals_2() {
		//Testing: boolean equals(Object o);
		HSet<E> myAdapter = new SetAdapter<E>();
		HSet<E> helpAdapter = new SetAdapter<E>();
		myAdapter.add((E)"str1");
		myAdapter.add((E)"str2");
		helpAdapter.add((E)"str1");
		assertEquals(false, myAdapter.equals(helpAdapter));
	}
	
	/**
	 * test equals method in Set
	 * 
	 * @safe.precondition a Set
	 * @safe.postcondition none
	 * @safe.testcases test that a Set and another Object (that isn't a Set instance) aren't equal
	 */
	@Test
	public void testEquals_3() {
		//Testing: boolean equals(Object o);
		HSet<E> myAdapter = new SetAdapter<E>();
		myAdapter.add((E)"str1");
		assertEquals(false, myAdapter.equals((Integer)1));
	}
	
	
	/**
	 * test hashCode method in Set
	 * 
	 * @safe.precondition two Sets with same elements
	 * @safe.postcondition none
	 * @safe.testcases test that two Sets with same elements have same hashCode
	 */
	@Test
	public void testHashCode() {
		//Testing: int hashCode();
		HSet<E> myAdapter = new SetAdapter<E>();
		myAdapter.add((E)"a");
		myAdapter.add((E)"b");
		HSet<E> helpAdapter = new SetAdapter<E>();
		helpAdapter.add((E)"a");
		helpAdapter.add((E)"b");
		assertEquals(myAdapter.hashCode(), helpAdapter.hashCode());
		//assertEquals(0, myAdapter.hashCode());
	}
	
	
	/**
	 * test isEmpty method in Set
	 * 
	 * @safe.precondition an empty Set
	 * @safe.postcondition none
	 * @safe.testcases test that a Set without elements is empty
	 */
	@Test
	public void testIsEmpty_1() {
		//Testing: boolean isEmpty();
		HSet<E> myAdapter = new SetAdapter<E>();
		assertEquals(true, myAdapter.isEmpty());
	}
	
	/**
	 * test isEmpty method in Set
	 * 
	 * @safe.precondition a not empty Set
	 * @safe.postcondition none
	 * @safe.testcases test that a Set with an element isn't empty
	 */
	@Test
	public void testIsEmpty_2() {
		//Testing: boolean isEmpty();
		HSet<E> myAdapter = new SetAdapter<E>();
		myAdapter.add((E)"str1");
		assertEquals(false, myAdapter.isEmpty());
	}
	
	
	/**
	 * test iterator method in Set
	 * 
	 * @safe.precondition a not empty Set
	 * @safe.postcondition NoSuchElementException thrown
	 * @safe.testcases test the attempt to get the next element in an Iterator at the end of the Iterator
	 */
	@Test
	public void testIterator_1() {
		//Testing: Iterator<E> iterator();
		HSet<E> myAdapter = new SetAdapter<E>();
		myAdapter.add((E)"str1");
		Iterator<E> myIterator = myAdapter.iterator();
		myIterator.next();
		assertThrows(java.util.NoSuchElementException.class, () -> myIterator.next());
	}
	
	/**
	 * test iterator method in Set
	 * 
	 * @safe.precondition a Set
	 * @safe.postcondition IllegalStateException thrown
	 * @safe.testcases test the attempt to remove an element in an Iterator when there is no element in that position
	 */
	@Test
	public void testIterator_2() {
		//Testing: Iterator<E> iterator();
		HSet<E> myAdapter = new SetAdapter<E>();
		myAdapter.add((E)"str1");
		myAdapter.add((E)"str2");
		Iterator<E> myIterator = myAdapter.iterator();
		myIterator.next();
		myIterator.next();
		myIterator.remove();
		assertThrows(IllegalStateException.class, () -> myIterator.remove());
	}
	
	/**
	 * test iterator method in Set
	 * 
	 * @safe.precondition a Set with 5 elements
	 * @safe.postcondition Set size = 3
	 * @safe.testcases test Set Iterator features to remove 2 elements from a Set of 5 elements
	 */
	@Test
	public void testIterator_3() {
		//Testing: Iterator<E> iterator();
		HSet<E> myAdapter = new SetAdapter<E>();
		myAdapter.add((E)"str1");
		myAdapter.add((E)"str2");
		myAdapter.add((E)"str3");
		myAdapter.add((E)"str4");
		myAdapter.add((E)"str5");
		Iterator<E> myIterator = myAdapter.iterator();
		myIterator.next();
		myIterator.next();
		myIterator.remove();
		myIterator.next();
		myIterator.remove();
		assertEquals(3, myAdapter.size());
	}
	
	/**
	 * test iterator method in Set
	 * 
	 * @safe.precondition a not empty Set
	 * @safe.postcondition the Set becomes empty
	 * @safe.testcases test Set Iterator features to clear a Set
	 */
	@Test
	public void testIterator_4() {
		//Testing: Iterator<E> iterator();
		HSet<E> myAdapter = new SetAdapter<E>();
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
	 * test remove method in Set
	 * 
	 * @safe.precondition a Set with 5 elements
	 * @safe.postcondition Set size = 3
	 * @safe.testcases test the removal of 2 determined elements that are contained in a Set
	 */
	@Test
	public void testRemove_1() {
		//Testing: boolean remove(Object o);
		HSet<E> myAdapter = new SetAdapter<E>();
		myAdapter.add((E)"str1");
		myAdapter.add((E)"remove1");
		myAdapter.add((E)"str2");
		myAdapter.add((E)"str3");
		myAdapter.add((E)"remove2");
		assertEquals(true, myAdapter.remove((E)"remove1"));
		assertEquals(true, myAdapter.remove((E)"remove2"));
		assertEquals(3, myAdapter.size());
		String[] myArray = {"str3", "str2", "str1"};
		assertArrayEquals(myArray, myAdapter.toArray());
	}
	
	/**
	 * test remove method in Set
	 * 
	 * @safe.precondition a Set
	 * @safe.postcondition Set size unchanged
	 * @safe.testcases test the attempt to remove an element that isn't contained in a Set
	 */
	@Test
	public void testRemove_2() {
		//Testing: boolean remove(Object o);
		HSet<E> myAdapter = new SetAdapter<E>();
		myAdapter.add((E)"str1");
		assertEquals(false, myAdapter.remove((E)"str2"));
		assertEquals(1, myAdapter.size());
	}
	
	
	/**
	 * test removeAll method in Set
	 * 
	 * @safe.precondition a Set
	 * @safe.postcondition NullPointerException thrown
	 * @safe.testcases test the attempt to remove elements in a Set using a null Set
	 */
	@Test
	public void testRemoveAll_1() {
		//Testing: boolean removeAll(Collection<?> c);
		HSet<E> myAdapter = new SetAdapter<E>();
		assertThrows(NullPointerException.class, () -> myAdapter.removeAll(null));
	}
	
	/**
	 * test removeAll method in Set
	 * 
	 * @safe.precondition a Set with 5 element and a Set with 3 elements (including 2 common elements)
	 * @safe.postcondition Set size = 3
	 * @safe.testcases test the removal, from a Set with 5 elements, of 2 elements that are also contained in another Set
	 */
	@Test
	public void testRemoveAll_2() {
		//Testing: boolean removeAll(Collection<?> c);
		HSet<E> myAdapter = new SetAdapter<E>();
		HSet<E> helpAdapter = new SetAdapter<E>();
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
		String[] myArray = {"str3", "str2", "str1"};
		assertArrayEquals(myArray, myAdapter.toArray());
	}
	
	/**
	 * test removeAll method in Set
	 * 
	 * @safe.precondition two Sets with different elements
	 * @safe.postcondition Sets size unchanged
	 * @safe.testcases test the attempt to remove elements from a Set using another Set that has only different elements
	 */
	@Test
	public void testRemoveAll_3() {
		//Testing: boolean removeAll(Collection<?> c);
		HSet<E> myAdapter = new SetAdapter<E>();
		HSet<E> helpAdapter = new SetAdapter<E>();
		myAdapter.add((E)"str1");
		helpAdapter.add((E)"str2");
		assertEquals(false, myAdapter.removeAll(helpAdapter));
		assertEquals(1, myAdapter.size());
	}
	
	
	/**
	 * test retainAll method in Set
	 * 
	 * @safe.precondition a Set
	 * @safe.postcondition NullPointerException thrown
	 * @safe.testcases test the attempt to retain elements in a Set using a null Set
	 */
	@Test
	public void testRetainAll_1() {
		//Testing: boolean retainAll(Collection<?> c);
		HSet<E> myAdapter = new SetAdapter<E>();
		assertThrows(NullPointerException.class, () -> myAdapter.retainAll(null));
	}
	
	/**
	 * test retainAll method in Set
	 * 
	 * @safe.precondition a Set with 5 element and a Set with 4 elements (including 3 common elements)
	 * @safe.postcondition Set size = 3
	 * @safe.testcases test the removal of 3 out of 5 elements from a Set retaining only the 3 elements that are also contained in another Set
	 */
	@Test
	public void testRetainAll_2() {
		//Testing: boolean retainAll(Collection<?> c);
		HSet<E> myAdapter = new SetAdapter<E>();
		HSet<E> helpAdapter = new SetAdapter<E>();
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
		String[] myArray = {"str3", "str2", "str1"};
		assertArrayEquals(myArray, myAdapter.toArray());
	}
	
	/**
	 * test retainAll method in Set
	 * 
	 * @safe.precondition two Sets with same elements
	 * @safe.postcondition Sets size unchanged
	 * @safe.testcases test the attempt to retain elements in a Set using another Set that has only different elements
	 */
	@Test
	public void testRetainAll_3() {
		//Testing: boolean retainAll(Collection<?> c);
		HSet<E> myAdapter = new SetAdapter<E>();
		HSet<E> helpAdapter = new SetAdapter<E>();
		myAdapter.add((E)"str1");
		myAdapter.add((E)"str2");
		helpAdapter.add((E)"str1");
		helpAdapter.add((E)"str2");
		assertEquals(false, myAdapter.retainAll(helpAdapter));
		assertEquals(2, myAdapter.size());
	}
	
	
	/**
	 * test size method in Set
	 * 
	 * @safe.precondition a not empty Set
	 * @safe.postcondition none
	 * @safe.testcases test that a Set has the same size as the number of elements contained
	 */
	@Test
	public void testSize() {
		//Testing: int size();
		HSet<E> myAdapter = new SetAdapter<E>();
		myAdapter.add((E)"str1");
		myAdapter.add((E)"str2");
		assertEquals(2, myAdapter.size());	
	}
	
	
	/**
	 * test toArray method in Set
	 * 
	 * @safe.precondition a not empty Set
	 * @safe.postcondition none
	 * @safe.testcases test the creation of an array with elements of a Set contains all the elements of the Set and in the same order (using String type)
	 */
	@Test
	public void testToArray1_1() {
		//Testing: Object[] toArray();
		HSet<E> myAdapter = new SetAdapter<E>();
		myAdapter.add((E)"str1");
		myAdapter.add((E)"str3");
		myAdapter.add((E)"str2");
		String[] myArray = {"str3", "str2", "str1"};
		assertArrayEquals(myArray, myAdapter.toArray());
	}
	
	/**
	 * test toArray method in Set
	 * 
	 * @safe.precondition a not empty Set
	 * @safe.postcondition none
	 * @safe.testcases test the creation of an array with elements of a Set contains all the elements of the Set and in the same order (using Integer type)
	 */
	@Test
	public void testToArray1_2() {
		//Testing: Object[] toArray();
		HSet<E> myAdapter = new SetAdapter<E>();
		myAdapter.add((E)(Integer)1);
		myAdapter.add((E)(Integer)3);
		myAdapter.add((E)(Integer)4);
		myAdapter.add((E)(Integer)2);
		Integer[] myArray = {4, 3, 2, 1};
		assertArrayEquals(myArray, myAdapter.toArray());
	}
	
	
	/**
	 * test 2nd toArray method in Set
	 * 
	 * @safe.precondition a not empty Set
	 * @safe.postcondition NullPointerException thrown
	 * @safe.testcases test the attempt to create an array with elements of a Set using a null array
	 */
	@Test
	public void testToArray2_1() {
		//Testing: <T> T[] toArray(T[] a);
		HSet<E> myAdapter = new SetAdapter<E>();
		myAdapter.add((E)"str1");
		assertThrows(NullPointerException.class, () -> myAdapter.toArray(null));
	
	}
	
	/**
	 * test 2nd toArray method in Set
	 * 
	 * @safe.precondition a not empty Set
	 * @safe.postcondition ArrayStoreException thrown
	 * @safe.testcases test the attempt to create an array with elements of a determined type (String in this case) of a Set using an array of another determined type (Integer in this case)
	 */
	@Test
	public void testToArray2_2() {
		//Testing: <T> T[] toArray(T[] a);
		HSet<E> myAdapter = new SetAdapter<E>();
		myAdapter.add((E)"str1");
		Integer[] tmpArray = new Integer[1];
		assertThrows(ArrayStoreException.class, () -> myAdapter.toArray(tmpArray));
	
	}
	
	/**
	 * test 2nd toArray method in Set
	 * 
	 * @safe.precondition a not empty Set
	 * @safe.postcondition UnsupportedOperationException thrown
	 * @safe.testcases test the attempt to create an array with elements of a Set using an array with less length than the number of elements contained in the Set
	 */
	@Test
	public void testToArray2_3() {
		//Testing: <T> T[] toArray(T[] a);
		HSet<E> myAdapter = new SetAdapter<E>();
		myAdapter.add((E)"str1");
		myAdapter.add((E)"str2");
		String[] tmpArray = new String[1];
		assertThrows(UnsupportedOperationException.class, () -> myAdapter.toArray(tmpArray));
	
	}
	
	/**
	 * test 2nd toArray method in Set
	 * 
	 * @safe.precondition a not empty Set
	 * @safe.postcondition ArrayStoreException thrown
	 * @safe.testcases test the attempt to create an array with elements of a Set using an array with a different type of parameters
	 */
	@Test
	public void testToArray2_4() {
		//Testing: <T> T[] toArray(T[] a);
		HSet<E> myAdapter = new SetAdapter<E>();
		myAdapter.add((E)"str1");
		myAdapter.add((E)"str2");
		String[] myArray = {"", "", "", ""};
		Integer[] tmpArray = {1, 2, 3, 4};
		assertThrows(ArrayStoreException.class, () -> myAdapter.toArray(tmpArray));
	}
	
	/**
	 * test 2nd toArray method in Set
	 * 
	 * @safe.precondition a not empty Set
	 * @safe.postcondition none
	 * @safe.testcases test the creation of an array with elements of a Set using an array with same length as the number of elements contained in the Set
	 */
	@Test
	public void testToArray2_5() {
		//Testing: <T> T[] toArray(T[] a);
		HSet<E> myAdapter = new SetAdapter<E>();
		myAdapter.add((E)"str1");
		myAdapter.add((E)"str2");
		myAdapter.add((E)"str3");
		String[] myArray = {"str3", "str2", "str1"};
		String[] tmpArray = new String[myArray.length];
		assertArrayEquals(myArray, myAdapter.toArray(tmpArray));
	
	}
	
	/**
	 * test 2nd toArray method in Set
	 * 
	 * @safe.precondition a not empty Set
	 * @safe.postcondition none
	 * @safe.testcases test the creation of an array with elements of a Set using an array with more length than the number of elements contained in the Set
	 */
	@Test
	public void testToArray2_6() {
		//Testing: <T> T[] toArray(T[] a);
		HSet<E> myAdapter = new SetAdapter<E>();
		myAdapter.add((E)"str1");
		myAdapter.add((E)"str2");
		String[] myArray = {"str2", "str1", null, ""};
		String[] tmpArray = {"", "", "", ""};
		assertArrayEquals(myArray, myAdapter.toArray(tmpArray));
	}
}