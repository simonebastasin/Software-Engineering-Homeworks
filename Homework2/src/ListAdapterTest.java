 import org.junit.Test;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

/**
 * Test Class for ListAdapter
 * 
 * @safe.summary this class is in charge of testing the List class
 * @safe.testsuitedesign each individual method is tested, verifying that
 * intermediate states are created and all of them are verified, to verify
 * that the List does not break during the editing
 */

public class ListAdapterTest<E> {
	
	/**
	 * test add method in List
	 * 
	 * @safe.precondition a List
	 * @safe.postcondition NullPointerException thrown
	 * @safe.testcases test the attempt to add a null element (in a valid index) in a List
	 */
	@Test
	public void testAdd1_1() {
		//Testing: void add(int index, E element);
		HList<E> myAdapter = new ListAdapter<E>();
		assertThrows(NullPointerException.class, () -> myAdapter.add(0, null));
	}
	
	/**
	 * test add method in List
	 * 
	 * @safe.precondition a List
	 * @safe.postcondition IndexOutOfBoundsException thrown
	 * @safe.testcases test the attempt to add an element in an invalid index in a List (negative index or out of bounds index)
	 */
	@Test
	public void testAdd1_2() {
		//Testing: void add(int index, E element);
		HList<E> myAdapter = new ListAdapter<E>();
		assertThrows(IndexOutOfBoundsException.class, () -> myAdapter.add(-1, (E)"str1"));
		assertThrows(IndexOutOfBoundsException.class, () -> myAdapter.add(1, (E)"str1"));
	}
	
	/**
	 * test add method in List
	 * 
	 * @safe.precondition an empty List
	 * @safe.postcondition List size = 5
	 * @safe.testcases test the addition of 5 elements (including 2 identical elements) in determined indexes in a List
	 */
	@Test
	public void testAdd1_3() {
		//Testing: void add(int index, E element);
		HList<E> myAdapter = new ListAdapter<E>();
		myAdapter.add(0, (E)"strEqual");
		myAdapter.add(1, (E)"strEqual");
		myAdapter.add(2, (E)"str4");
		myAdapter.add(3, (E)"str5");
		myAdapter.add(2, (E)"str3");
		assertEquals(5, myAdapter.size());
		String[] myArray = {"strEqual", "strEqual", "str3", "str4", "str5"};
		assertArrayEquals(myArray, myAdapter.toArray());
	}
	
	/**
	 * test add method in List
	 * 
	 * @safe.precondition an empty List
	 * @safe.postcondition List size = 3
	 * @safe.testcases test the addition of 3 elements (with different parameter types) in determined indexes in a List
	 */
	@Test
	public void testAdd1_4() {
		//Testing: void add(int index, E element);
		HList<E> myAdapter = new ListAdapter<E>();
		myAdapter.add(0, (E)(Double)2.2);
		myAdapter.add(0, (E)"str1");
		myAdapter.add(2, (E)(Integer)3);
		assertEquals(3, myAdapter.size());
		Object[] myArray = {"str1", 2.2, 3};
		assertArrayEquals(myArray, myAdapter.toArray());
	}
	
	
	/**
	 * test 2nd add method in List
	 * 
	 * @safe.precondition a List
	 * @safe.postcondition NullPointerException thrown
	 * @safe.testcases test the attempt to add a null element in a List
	 */
	@Test
	public void testAdd2_1() {
		//Testing: boolean add(E e);
		HList<E> myAdapter = new ListAdapter<E>();
		assertThrows(NullPointerException.class, () -> myAdapter.add(null));
	}
	
	/**
	 * test 2nd add method in List
	 * 
	 * @safe.precondition an empty List
	 * @safe.postcondition List size = 3
	 * @safe.testcases test the addition of 3 elements (including 2 identical elements) in a List
	 */
	@Test
	public void testAdd2_2() {
		//Testing: boolean add(E e);
		HList<E> myAdapter = new ListAdapter<E>();
		assertEquals(true, myAdapter.add((E)"str1"));
		assertEquals(true, myAdapter.add((E)"strEqual"));
		assertEquals(true, myAdapter.add((E)"strEqual"));
		assertEquals(3, myAdapter.size());
		String[] myArray = {"str1", "strEqual", "strEqual"};
		assertArrayEquals(myArray, myAdapter.toArray());
	}
	
	/**
	 * test 2nd add method in List
	 * 
	 * @safe.precondition an empty List
	 * @safe.postcondition List size = 3
	 * @safe.testcases test the addition of 3 elements (with different parameter types) in a List
	 */
	@Test
	public void testAdd2_3() {
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
	 * test addAll method in List
	 * 
	 * @safe.precondition a List
	 * @safe.postcondition NullPointerException thrown
	 * @safe.testcases test the attempt to add, in a List, elements (with valid index) from a null List
	 */
	@Test
	public void testAddAll1_1() {
		//Testing: boolean addAll(int index, Collection<? extends E> c);
		HList<E> myAdapter = new ListAdapter<E>();
		assertThrows(NullPointerException.class, () -> myAdapter.addAll(0, null));
	}
	
	/**
	 * test addAll method in List
	 * 
	 * @safe.precondition a List
	 * @safe.postcondition IndexOutOfBoundsException thrown
	 * @safe.testcases test the attempt to add, in a List, elements with invalid index from another List (negative index or out of bounds index)
	 */
	@Test
	public void testAddAll1_2() {
		//Testing: boolean addAll(int index, Collection<? extends E> c);
		HList<E> myAdapter = new ListAdapter<E>();
		assertThrows(IndexOutOfBoundsException.class, () -> myAdapter.addAll(1, new ListAdapter<E>()));
		assertThrows(IndexOutOfBoundsException.class, () -> myAdapter.addAll(-1, new ListAdapter<E>()));
	}
	
	/**
	 * test addAll method in List
	 * 
	 * @safe.precondition two Lists with 2 elements each
	 * @safe.postcondition List size = 4
	 * @safe.testcases test the addition, in a List with 2 elements, of 2 other elements with valid index from another List
	 */
	@Test
	public void testAddAll1_3() {
		//Testing: boolean addAll(int index, Collection<? extends E> c);
		HList<E> myAdapter = new ListAdapter<E>();
		HList<E> helpAdapter = new ListAdapter<E>();
		myAdapter.add((E)"str1");
		myAdapter.add((E)"str4");
		helpAdapter.add((E)"add2");
		helpAdapter.add((E)"add3");
		assertEquals(true, myAdapter.addAll(1, helpAdapter));
		assertEquals(4, myAdapter.size());
		String[] myArray = {"str1", "add2", "add3", "str4"};
		assertArrayEquals(myArray, myAdapter.toArray());
	}
	
	/**
	 * test addAll method in List
	 * 
	 * @safe.precondition a List
	 * @safe.postcondition the List remains empty
	 * @safe.testcases test the attempt to add, in a List, elements with valid index from an empty List
	 */
	@Test
	public void testAddAll1_4() {
		//Testing: boolean addAll(int index, Collection<? extends E> c);
		HList<E> myAdapter = new ListAdapter<E>();
		assertEquals(false, myAdapter.addAll(0, new ListAdapter<E>()));
		assertEquals(true, myAdapter.isEmpty());
	}
	
	
	/**
	 * test 2nd addAll method in List
	 * 
	 * @safe.precondition a List
	 * @safe.postcondition NullPointerException thrown
	 * @safe.testcases test the attempt to add, in a List, elements from a null List
	 */
	@Test
	public void testAddAll2_1() {
		//Testing: boolean addAll(Collection<? extends E> c);
		HList<E> myAdapter = new ListAdapter<E>();
		assertThrows(NullPointerException.class, () -> myAdapter.addAll(null));
	}
	
	/**
	 * test 2nd addAll method in List
	 * 
	 * @safe.precondition two Lists with 2 elements each
	 * @safe.postcondition List size = 4
	 * @safe.testcases test the addition, in a List with 2 elements, of 2 other elements from another List
	 */
	@Test
	public void testAddAll2_2() {
		//Testing: boolean addAll(Collection<? extends E> c);
		HList<E> myAdapter = new ListAdapter<E>();
		HList<E> helpAdapter = new ListAdapter<E>();
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
	 * test 2nd addAll method in List
	 * 
	 * @safe.precondition an empty List
	 * @safe.postcondition the List remains empty
	 * @safe.testcases test the attempt to add, in a List, elements from an empty List
	 */
	@Test
	public void testAddAll2_3() {
		//Testing: boolean addAll(Collection<? extends E> c);
		HList<E> myAdapter = new ListAdapter<E>();
		assertEquals(false, myAdapter.addAll(new CollectionAdapter<E>()));
		assertEquals(true, myAdapter.isEmpty());
	}
	
	
	
	/**
	 * test clear method in List
	 * 
	 * @safe.precondition a not empty List
	 * @safe.postcondition the List becomes empty
	 * @safe.testcases test the elimination of all elements from a List
	 */
	@Test
	public void testClear() {
		//Testing: void clear();
		HList<E> myAdapter = new ListAdapter<E>();
		myAdapter.add((E)"str1");
		myAdapter.add((E)"str2");
		myAdapter.clear();
		assertEquals(true, myAdapter.isEmpty());
		assertEquals(0, myAdapter.size());
	}
	
	
	/**
	 * test contains method in List
	 * 
	 * @safe.precondition a not empty List
	 * @safe.postcondition none
	 * @safe.testcases test checking that a List contains determined elements that are in the List
	 */
	@Test
	public void testContains_1() {
		//Testing: boolean contains(Object o);
		HList<E> myAdapter = new ListAdapter<E>();
		myAdapter.add((E)"str1");
		myAdapter.add((E)"str2");
		assertEquals(true, myAdapter.contains((E)"str1"));
		assertEquals(true, myAdapter.contains((E)"str2"));
	}
	
	/**
	 * test contains method in List
	 * 
	 * @safe.precondition a List
	 * @safe.postcondition none
	 * @safe.testcases test checking that a List doesn't contain a determined element that isn't in the List
	 */
	@Test
	public void testContains_2() {
		//Testing: boolean contains(Object o);
		HList<E> myAdapter = new ListAdapter<E>();
		myAdapter.add((E)"str1");
		myAdapter.add((E)"str2");
		assertEquals(false, myAdapter.contains((E)"str3"));
	}
	
	
	/**
	 * test containsAll method in List
	 * 
	 * @safe.precondition a List
	 * @safe.postcondition NullPointerException thrown
	 * @safe.testcases test the attempt to check if a List contains determined elements using a null List
	 */
	@Test
	public void testContainsAll_1() {
		//Testing: boolean containsAll(Collection<?> c);
		HList<E> myAdapter = new ListAdapter<E>();
		assertThrows(NullPointerException.class, () -> myAdapter.containsAll(null));
	}
	
	/**
	 * test containsAll method in List
	 * 
	 * @safe.precondition a List with 3 elements and a List with 2 elements that are equal to 2 of the elements of the first List
	 * @safe.postcondition none
	 * @safe.testcases test checking that a List contains all elements of another List
	 */
	@Test
	public void testContainsAll_2() {
		//Testing: boolean containsAll(Collection<?> c);
		HList<E> myAdapter = new ListAdapter<E>();
		HList<E> helpAdapter = new ListAdapter<E>();
		myAdapter.add((E)"str1");
		myAdapter.add((E)"str2");
		myAdapter.add((E)"str3");
		helpAdapter.add((E)"str1");
		helpAdapter.add((E)"str3");
		assertEquals(true, myAdapter.containsAll(helpAdapter));
	}
	
	/**
	 * test containsAll method in List
	 * 
	 * @safe.precondition two Lists with same elements
	 * @safe.postcondition none
	 * @safe.testcases test checking that a List doesn't contain all elements of another List
	 */
	@Test
	public void testContainsAll_3() {
		//Testing: boolean containsAll(Collection<?> c);
		HList<E> myAdapter = new ListAdapter<E>();
		HList<E> helpAdapter = new ListAdapter<E>();
		myAdapter.add((E)"str1");
		myAdapter.add((E)"str2");
		helpAdapter.add((E)"str1");
		helpAdapter.add((E)"str3");
		assertEquals(false, myAdapter.containsAll(helpAdapter));
	}
	
	
	/**
	 * test equals method in List
	 * 
	 * @safe.precondition two Lists with same elements
	 * @safe.postcondition none
	 * @safe.testcases test that two Lists with same elements are equal
	 */
	@Test
	public void testEquals_1() {
		//Testing: boolean equals(Object o);
		HList<E> myAdapter = new ListAdapter<E>();
		HList<E> helpAdapter = new ListAdapter<E>();
		myAdapter.add((E)"str1");
		myAdapter.add((E)"str2");
		helpAdapter.add((E)"str1");
		helpAdapter.add((E)"str2");
		assertEquals(true, myAdapter.equals(helpAdapter));
	}
	
	/**
	 * test equals method in List
	 * 
	 * @safe.precondition two Lists with at least one different element
	 * @safe.postcondition none
	 * @safe.testcases test that two Lists with at least one different element aren't equal
	 */
	@Test
	public void testEquals_2() {
		//Testing: boolean equals(Object o);
		HList<E> myAdapter = new ListAdapter<E>();
		HList<E> helpAdapter = new ListAdapter<E>();
		myAdapter.add((E)"str1");
		myAdapter.add((E)"str2");
		helpAdapter.add((E)"str1");
		assertEquals(false, myAdapter.equals(helpAdapter));
	}
	
	/**
	 * test equals method in List
	 * 
	 * @safe.precondition a List
	 * @safe.postcondition none
	 * @safe.testcases test that a List and another Object (that isn't a List instance) aren't equal
	 */
	@Test
	public void testEquals_3() {
		//Testing: boolean equals(Object o);
		HList<E> myAdapter = new ListAdapter<E>();
		assertEquals(false, myAdapter.equals((Integer)1));
	}
	
	
	/**
	 * test get method in List
	 * 
	 * @safe.precondition a List
	 * @safe.postcondition IndexOutOfBoundsException thrown
	 * @safe.testcases test the attempt to get an element of a List using an invalid index (negative index or out of bounds index)
	 */
	@Test
	public void testGet_1() {
		//Testing: E get(int index);
		HList<E> myAdapter = new ListAdapter<E>();
		assertThrows(IndexOutOfBoundsException.class, () -> myAdapter.get(-1));
		assertThrows(IndexOutOfBoundsException.class, () -> myAdapter.get(1));
	}
	
	/**
	 * test get method in List
	 * 
	 * @safe.precondition a not empty List
	 * @safe.postcondition none
	 * @safe.testcases test the possibility to get an element in a List using a its index
	 */
	@Test
	public void testGet_2() {
		//Testing: E get(int index);
		HList<E> myAdapter = new ListAdapter<E>();
		myAdapter.add((E)"str1");
		myAdapter.add((E)"str2");
		assertEquals((E)"str1", myAdapter.get(0));
		assertEquals((E)"str2", myAdapter.get(1));
	}
		
	
	
	/**
	 * test hashCode method in List
	 * 
	 * @safe.precondition two Lists with same elements
	 * @safe.postcondition none
	 * @safe.testcases test that two Lists with same elements have same hashCode
	 */
	@Test
	public void testHashCode() {
		//Testing: int hashCode();
		HList<E> myAdapter = new ListAdapter<E>();
		myAdapter.add((E)"a");
		myAdapter.add((E)"b");
		HList<E> helpAdapter = new ListAdapter<E>();
		helpAdapter.add((E)"a");
		helpAdapter.add((E)"b");
		assertEquals(myAdapter.hashCode(), helpAdapter.hashCode());
	}
		
	
	/**
	 * test indexOf method in List
	 * 
	 * @safe.precondition a not empty List
	 * @safe.postcondition none
	 * @safe.testcases test the possibility to get the first index of a determined element contained in a List
	 */
	@Test
	public void testIndexOf_1() {
		//Testing: int indexOf(Object o);
		HList<E> myAdapter = new ListAdapter<E>();
		myAdapter.add((E)"str1");
		myAdapter.add((E)"str2");
		myAdapter.add((E)"str1");
		assertEquals(0, myAdapter.indexOf((E)"str1"));
		assertEquals(1, myAdapter.indexOf((E)"str2"));
	}
	
	/**
	 * test indexOf method in List
	 * 
	 * @safe.precondition a List
	 * @safe.postcondition none
	 * @safe.testcases test the attempt to get the first index of an element that isn't contained in a List
	 */
	@Test
	public void testIndexOf_2() {
		//Testing: int indexOf(Object o);
		HList<E> myAdapter = new ListAdapter<E>();
		myAdapter.add((E)"str1");
		myAdapter.add((E)"str2");
		assertEquals(-1, myAdapter.indexOf((E)"str3"));
	}
		
	
	/**
	 * test isEmpty method in List
	 * 
	 * @safe.precondition an empty List
	 * @safe.postcondition none
	 * @safe.testcases test that a List without elements is empty
	 */
	@Test
	public void testIsEmpty_1() {
		//Testing: boolean isEmpty();
		HList<E> myAdapter = new ListAdapter<E>();
		assertEquals(true, myAdapter.isEmpty());
	}
	
	/**
	 * test isEmpty method in List
	 * 
	 * @safe.precondition a not empty List
	 * @safe.postcondition none
	 * @safe.testcases test that a List with an element isn't empty
	 */
	@Test
	public void testIsEmpty_2() {
		//Testing: boolean isEmpty();
		HList<E> myAdapter = new ListAdapter<E>();
		myAdapter.add((E)"str1");
		assertEquals(false, myAdapter.isEmpty());
	}
		
	
	/**
	 * test iterator method in List
	 * 
	 * @safe.precondition a not empty List
	 * @safe.postcondition NoSuchElementException thrown
	 * @safe.testcases test the attempt to get the next element in an Iterator at the end of the Iterator
	 */
	@Test
	public void testIterator_1() {
		//Testing: Iterator<E> iterator();
		HList<E> myAdapter = new ListAdapter<E>();
		myAdapter.add((E)"str1");
		Iterator<E> myIterator = myAdapter.iterator();
		myIterator.next();
		assertThrows(java.util.NoSuchElementException.class, () -> myIterator.next());
	}
	
	/**
	 * test iterator method in List
	 * 
	 * @safe.precondition a List
	 * @safe.postcondition IllegalStateException thrown
	 * @safe.testcases test the attempt to remove an element in an Iterator when there is no element in that position
	 */
	@Test
	public void testIterator_2() {
		//Testing: Iterator<E> iterator();
		HList<E> myAdapter = new ListAdapter<E>();
		myAdapter.add((E)"str1");
		myAdapter.add((E)"str2");
		Iterator<E> myIterator = myAdapter.iterator();
		myIterator.next();
		myIterator.next();
		myIterator.remove();
		assertThrows(IllegalStateException.class, () -> myIterator.remove());
	}
	
	/**
	 * test iterator method in List
	 * 
	 * @safe.precondition a List with 5 elements
	 * @safe.postcondition List size = 3
	 * @safe.testcases test (List) Iterator features to remove 2 elements from a List of 5 elements
	 */
	@Test
	public void testIterator_3() {
		//Testing: Iterator<E> iterator();
		HList<E> myAdapter = new ListAdapter<E>();
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
	 * test iterator method in List
	 * 
	 * @safe.precondition a not empty List
	 * @safe.postcondition the List becomes empty
	 * @safe.testcases test (List) Iterator features to clear a List
	 */
	@Test
	public void testIterator_4() {
		//Testing: Iterator<E> iterator();
		HList<E> myAdapter = new ListAdapter<E>();
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
	 * test lastIndexOf method in List
	 * 
	 * @safe.precondition a not empty List
	 * @safe.postcondition none
	 * @safe.testcases test the possibility to get the last index of a determined element contained in a List
	 */
	@Test
	public void testLastIndexOf_1() {
		//Testing: int lastIndexOf(Object o);
		HList<E> myAdapter = new ListAdapter<E>();
		myAdapter.add((E)"str1");
		myAdapter.add((E)"str2");
		myAdapter.add((E)"str1");
		assertEquals(2, myAdapter.lastIndexOf((E)"str1"));
		assertEquals(1, myAdapter.lastIndexOf((E)"str2"));
	}
	
	/**
	 * test lastIndexOf method in List
	 * 
	 * @safe.precondition a List
	 * @safe.postcondition none
	 * @safe.testcases test the attempt to get the last index of an element that isn't contained in a List
	 */
	@Test
	public void testLastIndexOf_2() {
		//Testing: int lastIndexOf(Object o);
		HList<E> myAdapter = new ListAdapter<E>();
		myAdapter.add((E)"str1");
		myAdapter.add((E)"str2");
		assertEquals(-1, myAdapter.lastIndexOf((E)"str3"));
	}
		
	
	/**
	 * test listIterator method in List
	 * 
	 * @safe.precondition a not empty List
	 * @safe.postcondition NoSuchElementException thrown
	 * @safe.testcases test the attempt to get the next element in an ListIterator at the end of the ListIterator
	 */
	@Test
	public void testListIterator1_1() {
		//Testing: ListIterator<E> listIterator();
		HList<E> myAdapter = new ListAdapter<E>();
		myAdapter.add((E)"str1");
		ListIterator<E> myListIterator = myAdapter.listIterator();
		myListIterator.next();
		assertThrows(java.util.NoSuchElementException.class, () -> myListIterator.next());
	}
	
	/**
	 * test listIterator method in List
	 * 
	 * @safe.precondition a List
	 * @safe.postcondition IllegalStateException thrown
	 * @safe.testcases test the attempt to remove an element in an ListIterator when there is no element in that position
	 */
	@Test
	public void testListIterator1_2() {
		//Testing: ListIterator<E> listIterator();
		HList<E> myAdapter = new ListAdapter<E>();
		myAdapter.add((E)"str1");
		myAdapter.add((E)"str2");
		ListIterator<E> myListIterator = myAdapter.listIterator();
		myListIterator.next();
		myListIterator.next();
		myListIterator.remove();
		assertThrows(IllegalStateException.class, () -> myListIterator.remove());
	}
	
	/**
	 * test listIterator method in List
	 * 
	 * @safe.precondition a List
	 * @safe.postcondition NoSuchElementException thrown
	 * @safe.testcases test the attempt to get the previous element in an ListIterator at the start of the ListIterator
	 */
	@Test
	public void testListIterator1_3() {
		//Testing: ListIterator<E> listIterator();
		HList<E> myAdapter = new ListAdapter<E>();
		myAdapter.add((E)"str1");
		ListIterator<E> myListIterator = myAdapter.listIterator();
		assertThrows(java.util.NoSuchElementException.class, () -> myListIterator.previous());
	}
	
	/**
	 * test listIterator method in List
	 * 
	 * @safe.precondition a List
	 * @safe.postcondition IllegalStateException thrown
	 * @safe.testcases test the attempt to set an element in an ListIterator when there is no element in that position
	 */
	@Test
	public void testListIterator1_4() {
		//Testing: ListIterator<E> listIterator();
		HList<E> myAdapter = new ListAdapter<E>();
		myAdapter.add((E)"str1");
		myAdapter.add((E)"str2");
		ListIterator<E> myListIterator = myAdapter.listIterator();
		myListIterator.next();
		myListIterator.next();
		myListIterator.set((E)"str3");
		assertThrows(IllegalStateException.class, () -> myListIterator.set((E)"str4"));
	}
	
	/**
	 * test listIterator method in List
	 * 
	 * @safe.precondition a List with 5 elements
	 * @safe.postcondition List size = 3
	 * @safe.testcases test ListIterator features to remove 2 elements from a List of 5 elements (next, remove)
	 */
	@Test
	public void testListIterator1_5() {
		//Testing: ListIterator<E> listIterator();
		HList<E> myAdapter = new ListAdapter<E>();
		myAdapter.add((E)"str1");
		myAdapter.add((E)"remove1");
		myAdapter.add((E)"remove2");
		myAdapter.add((E)"str2");
		myAdapter.add((E)"str3");
		ListIterator<E> myListIterator = myAdapter.listIterator();
		myListIterator.next();
		myListIterator.next();
		myListIterator.remove();
		myListIterator.next();
		myListIterator.remove();
		assertEquals(3, myAdapter.size());
		String[] myArray = {"str1", "str2", "str3"};
		assertArrayEquals(myArray, myAdapter.toArray());
	}
	
	/**
	 * test listIterator method in List
	 * 
	 * @safe.precondition a not empty List
	 * @safe.postcondition the List becomes empty
	 * @safe.testcases test ListIterator features to clear a List (hasNext, next, remove)
	 */
	@Test
	public void testListIterator1_6() {
		//Testing: ListIterator<E> listIterator();
		HList<E> myAdapter = new ListAdapter<E>();
		myAdapter.add((E)"str1");
		myAdapter.add((E)"str2");
		myAdapter.add((E)"str3");
		myAdapter.add((E)"str4");
		myAdapter.add((E)"str5");
		ListIterator<E> myListIterator = myAdapter.listIterator();
		while(myListIterator.hasNext()) {
			myListIterator.next();
			myListIterator.remove();
		}
		assertEquals(true, myAdapter.isEmpty());
		assertEquals(0, myAdapter.size());
	}
	
	
	/**
	 * test 2nd listIterator method in List
	 * 
	 * @safe.precondition a List
	 * @safe.postcondition IndexOutOfBoundsException thrown
	 * @safe.testcases test the attempt to create a ListIterator with invalid index
	 */
	@Test
	public void testListIterator2_1() {
		//Testing: ListIterator<E> listIterator(int index);
		HList<E> myAdapter = new ListAdapter<E>();
		myAdapter.add((E)"str1");
		assertThrows(IndexOutOfBoundsException.class, () -> new ListAdapterListIterator(-1, new java.util.Vector<E>()));
		assertThrows(IndexOutOfBoundsException.class, () -> new ListAdapterListIterator(2, new java.util.Vector<E>()));
	}
	
	/**
	 * test listIterator method in List
	 * 
	 * @safe.precondition a List with 5 elements
	 * @safe.postcondition List size = 3
	 * @safe.testcases test ListIterator features to remove 2 elements from a List of 5 elements (previous, remove)
	 */
	@Test
	public void testListIterator2_2() {
		//Testing: ListIterator<E> listIterator();
		HList<E> myAdapter = new ListAdapter<E>();
		myAdapter.add((E)"str1");
		myAdapter.add((E)"str2");
		myAdapter.add((E)"remove1");
		myAdapter.add((E)"remove2");
		myAdapter.add((E)"str3");
		ListIterator<E> myListIterator = myAdapter.listIterator(5);
		myListIterator.previous();
		myListIterator.previous();
		myListIterator.remove();
		myListIterator.previous();
		myListIterator.remove();
		assertEquals(3, myAdapter.size());
		String[] myArray = {"str1", "str2", "str3"};
		assertArrayEquals(myArray, myAdapter.toArray());
		assertEquals(2, myListIterator.nextIndex());
		assertEquals(1, myListIterator.previousIndex());
		myListIterator.add(myListIterator.next());
		assertEquals(4, myAdapter.size());
		myListIterator.previous();
		myListIterator.set((E)"add4");
		String[] myArray2 = {"str1", "str2", "str3", "add4"};
		assertArrayEquals(myArray2, myAdapter.toArray());
	}
	
	/**
	 * test 2nd listIterator method in List
	 * 
	 * @safe.precondition a not empty List
	 * @safe.postcondition the List becomes empty
	 * @safe.testcases test ListIterator features to clear a List (hasPrevious, previous, remove)
	 */
	@Test
	public void testListIterator2_3() {
		//Testing: ListIterator<E> listIterator(int index);
		HList<E> myAdapter = new ListAdapter<E>();
		myAdapter.add((E)"str1");
		myAdapter.add((E)"str2");
		myAdapter.add((E)"str3");
		myAdapter.add((E)"str4");
		myAdapter.add((E)"str5");
		ListIterator<E> myListIterator = myAdapter.listIterator(5);
		while(myListIterator.hasPrevious()) {
			myListIterator.previous();
			myListIterator.remove();
		}
		assertEquals(true, myAdapter.isEmpty());
		assertEquals(0, myAdapter.size());
	}
	
	
	/**
	 * test remove method in List
	 * 
	 * @safe.precondition a List
	 * @safe.postcondition IndexOutOfBoundsException thrown
	 * @safe.testcases test the attempt to remove an element from an invalid index in a List (negative index or out of bounds index)
	 */
	@Test
	public void testRemove1_1() {
		//Testing: E remove(int index);
		HList<E> myAdapter = new ListAdapter<E>();
		myAdapter.add((E)"str1");
		assertThrows(IndexOutOfBoundsException.class, () -> myAdapter.remove(-1));
		assertThrows(IndexOutOfBoundsException.class, () -> myAdapter.remove(1));
	}
	
	/**
	 * test remove method in List
	 * 
	 * @safe.precondition a List with 5 elements
	 * @safe.postcondition List size = 3
	 * @safe.testcases test the removal of 2 elements that are contained in a List using their index
	 */
	@Test
	public void testRemove1_2() {
		//Testing: E remove(int index);
		HList<E> myAdapter = new ListAdapter<E>();
		myAdapter.add((E)"str1");
		myAdapter.add((E)"remove1");
		myAdapter.add((E)"str2");
		myAdapter.add((E)"remove2");
		myAdapter.add((E)"str3");
		assertEquals((E)"remove1", myAdapter.remove(1));
		assertEquals((E)"remove2", myAdapter.remove(2));
		assertEquals(3, myAdapter.size());
		String[] myArray = {"str1", "str2", "str3"};
		assertArrayEquals(myArray, myAdapter.toArray());
	}
		
	
	/**
	 * test 2nd remove method in List
	 * 
	 * @safe.precondition a List with 5 elements
	 * @safe.postcondition List size = 3
	 * @safe.testcases test the removal of 2 determined elements that are contained in a List
	 */
	@Test
	public void testRemove2_1() {
		//Testing: boolean remove(Object o);
		HList<E> myAdapter = new ListAdapter<E>();
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
	 * test 2nd remove method in List
	 * 
	 * @safe.precondition a List
	 * @safe.postcondition List size unchanged
	 * @safe.testcases test the attempt to remove an element that isn't contained in a List
	 */
	@Test
	public void testRemove2_2() {
		//Testing: boolean remove(Object o);
		HList<E> myAdapter = new ListAdapter<E>();
		myAdapter.add((E)"str1");
		assertEquals(false, myAdapter.remove((E)"str2"));
		assertEquals(1, myAdapter.size());
	}
		
	
	/**
	 * test removeAll method in List
	 * 
	 * @safe.precondition a List
	 * @safe.postcondition NullPointerException thrown
	 * @safe.testcases test the attempt to remove elements in a List using a null List
	 */
	@Test
	public void testRemoveAll_1() {
		//Testing: boolean removeAll(Collection<?> c);
		HList<E> myAdapter = new ListAdapter<E>();
		assertThrows(NullPointerException.class, () -> myAdapter.removeAll(null));
	}
	
	/**
	 * test removeAll method in List
	 * 
	 * @safe.precondition a List with 5 element and a List with 3 elements (including 2 common elements)
	 * @safe.postcondition List size = 3
	 * @safe.testcases test the removal, from a List with 5 elements, of 2 elements that are also contained in another List
	 */
	@Test
	public void testRemoveAll_2() {
		//Testing: boolean removeAll(Collection<?> c);
		HList<E> myAdapter = new ListAdapter<E>();
		HList<E> helpAdapter = new ListAdapter<E>();
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
	 * test removeAll method in List
	 * 
	 * @safe.precondition two Lists with different elements
	 * @safe.postcondition Lists size unchanged
	 * @safe.testcases test the attempt to remove elements from a List using another List that has only different elements
	 */
	@Test
	public void testRemoveAll_3() {
		//Testing: boolean removeAll(Collection<?> c);
		HList<E> myAdapter = new ListAdapter<E>();
		HList<E> helpAdapter = new ListAdapter<E>();
		myAdapter.add((E)"str1");
		helpAdapter.add((E)"str2");
		assertEquals(false, myAdapter.removeAll(helpAdapter));
		assertEquals(1, myAdapter.size());
	}
		
	
	/**
	 * test retainAll method in List
	 * 
	 * @safe.precondition a List
	 * @safe.postcondition NullPointerException thrown
	 * @safe.testcases test the attempt to retain elements in a List using a null List
	 */
	@Test
	public void testRetainAll_1() {
		//Testing: boolean retainAll(Collection<?> c);
		HList<E> myAdapter = new ListAdapter<E>();
		assertThrows(NullPointerException.class, () -> myAdapter.retainAll(null));
	}
	
	/**
	 * test retainAll method in List
	 * 
	 * @safe.precondition a List with 5 element and a List with 4 elements (including 3 common elements)
	 * @safe.postcondition List size = 3
	 * @safe.testcases test the removal of 3 out of 5 elements from a List retaining only the 3 elements that are also contained in another List
	 */
	@Test
	public void testRetainAll_2() {
		//Testing: boolean retainAll(Collection<?> c);
		HList<E> myAdapter = new ListAdapter<E>();
		HList<E> helpAdapter = new ListAdapter<E>();
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
	 * test retainAll method in List
	 * 
	 * @safe.precondition two Lists with same elements
	 * @safe.postcondition Lists size unchanged
	 * @safe.testcases test the attempt to retain elements in a List using another List that has only different elements
	 */
	@Test
	public void testRetainAll_3() {
		//Testing: boolean retainAll(Collection<?> c);
		HList<E> myAdapter = new ListAdapter<E>();
		HList<E> helpAdapter = new ListAdapter<E>();
		myAdapter.add((E)"str1");
		myAdapter.add((E)"str2");
		helpAdapter.add((E)"str1");
		helpAdapter.add((E)"str2");
		assertEquals(false, myAdapter.retainAll(helpAdapter));
		assertEquals(2, myAdapter.size());
	}
		
	
	/**
	 * test set method in List
	 * 
	 * @safe.precondition a List
	 * @safe.postcondition  IndexOutOfBoundsException thrown
	 * @safe.testcases test the attempt to change an element of a List using an invalid index (negative index or out of bounds index)
	 */
	@Test
	public void testSet_1() {
		//Testing: E set(int index, E element);
		HList<E> myAdapter = new ListAdapter<E>();
		myAdapter.add((E)"str1");
		assertThrows(IndexOutOfBoundsException.class, () -> myAdapter.set(-1, (E)"str1"));
		assertThrows(IndexOutOfBoundsException.class, () -> myAdapter.set(1, (E)"str1"));
	}
	
	/**
	 * test set method in List
	 * 
	 * @safe.precondition a not empty List
	 * @safe.postcondition elements have changed
	 * @safe.testcases test the possibility to change, in a List, elements to another determined elements using a their indexes
	 */
	@Test
	public void testSet_2() {
		//Testing: E set(int index, E element);
		HList<E> myAdapter = new ListAdapter<E>();
		myAdapter.add((E)"str1");
		myAdapter.add((E)"strToChange1");
		myAdapter.add((E)"strToChange2");
		assertEquals((E)"strToChange1", myAdapter.set(1, (E)"str2"));
		assertEquals((E)"strToChange2", myAdapter.set(2, (E)(Integer)3));
		assertEquals(3, myAdapter.size());
		Object[] myArray = {"str1", "str2", 3};
		assertArrayEquals(myArray, myAdapter.toArray());
	}
	
		
	/**
	 * test size method in List
	 * 
	 * @safe.precondition a not empty List
	 * @safe.postcondition none
	 * @safe.testcases test that a List has the same size as the number of elements contained
	 */

	@Test
	public void testSize() {
		//Testing: int size();
		HList<E> myAdapter = new ListAdapter<E>();
		myAdapter.add((E)"str1");
		myAdapter.add((E)"str2");
		assertEquals(2, myAdapter.size());
	}
		
	
	/**
	 * test subList method in List
	 * 
	 * @safe.precondition a List and a SubList created with subList() of the map
	 * @safe.postcondition none
	 * @safe.testcases test the attempt to create a SubList of a List using invalid indexes
	 */
	@Test
	public void testSubList_1() {
		//Testing: List<E> subList(int fromIndex, int toIndex);
		HList<E> myAdapter = new ListAdapter<E>();
		myAdapter.add((E)"str1");
		assertThrows(IndexOutOfBoundsException.class, () -> myAdapter.subList(-1, 0));
		assertThrows(IndexOutOfBoundsException.class, () -> myAdapter.subList(0, 2));
		assertThrows(IndexOutOfBoundsException.class, () -> myAdapter.subList(1, 0));
	}
	
	/**
	 * test subList method in List
	 * 
	 * @safe.precondition a List and a SubList created with subList() of the map
	 * @safe.postcondition none
	 * @safe.testcases test all Exceptions of SubList class to check their correctness
	 */
	@Test
	public void testSubList_2() {
		//Testing: Collection<V> values();
		HList<E> myAdapter = new ListAdapter<E>();
		myAdapter.add((E)"str1");
		HList<E> mySubList = myAdapter.subList(0, 1);
		assertThrows(IndexOutOfBoundsException.class, () -> mySubList.add(-1, (E)"str2"));
		assertThrows(IndexOutOfBoundsException.class, () -> mySubList.add(2, (E)"str2"));
		assertThrows(IndexOutOfBoundsException.class, () -> mySubList.get(-1));
		assertThrows(IndexOutOfBoundsException.class, () -> mySubList.get(2));
		assertThrows(IndexOutOfBoundsException.class, () -> mySubList.addAll(-1, new ListAdapter<E>()));
		assertThrows(IndexOutOfBoundsException.class, () -> mySubList.addAll(2, new ListAdapter<E>()));
		assertThrows(NullPointerException.class, () -> mySubList.add(null));
		assertThrows(NullPointerException.class, () -> mySubList.addAll(null));
		assertThrows(NullPointerException.class, () -> mySubList.containsAll(null));
	}
	
	/**
	 * test subList method in List
	 * 
	 * @safe.precondition a List and a SubList created with subList() of the List
	 * @safe.postcondition none
	 * @safe.testcases test all features of SubList class to check their correctness (SubList and ListAdapter are backed each other)
	 */
	@Test
	public void testSubList_3() {
		//Testing: List<E> subList(int fromIndex, int toIndex);
		HList<E> myAdapter = new ListAdapter<E>();
		myAdapter.add((E)"str1");
		myAdapter.add((E)"str2");
		myAdapter.add((E)"remove1");
		myAdapter.add((E)"remove2");
		myAdapter.add((E)"str4");
		myAdapter.add((E)"str6");
		
		HList<E> mySubList = myAdapter.subList(1, 5);
		assertEquals(4, mySubList.size());
		
		assertEquals(true, mySubList.add((E)"add5")); //add_1
		assertEquals(5, mySubList.size());
		
		mySubList.add(1, (E)"addToChange"); //add_2
		assertEquals(6, mySubList.size());
		assertEquals(8, myAdapter.size());
		
		assertEquals((E)"remove1", mySubList.remove(2)); //remove_1
		assertEquals(5, mySubList.size());
		
		assertEquals(true, mySubList.remove((E)"remove2")); //remove_2
		assertEquals(false, mySubList.remove((E)"remove2"));
		assertEquals(4, mySubList.size());
		assertEquals(6, myAdapter.size());
		
		myAdapter.add((E)"add7");
		assertEquals(true, mySubList.contains((E)"str2")); //contains
		assertEquals(myAdapter.get(3), mySubList.get(2)); //get
		
		HList<E> tmpSubList = myAdapter.subList(1, 5);
		mySubList.equals(tmpSubList); //equals
		assertEquals(mySubList.hashCode(), tmpSubList.hashCode()); //hashCode
		
		mySubList.set(1, (E)"add3"); //set
		
		String[] myArray1 = {"str2", "add3", "str4", "add5"};
		assertArrayEquals(myArray1, mySubList.toArray()); //toarray_1
		String[] myArray2 = {"str1", "str2", "add3", "str4", "add5", "str6", "add7"};
		assertArrayEquals(myArray2, myAdapter.toArray());
		
		mySubList.clear(); //clear
		assertEquals(true, mySubList.isEmpty()); //isempty
		assertEquals(3, myAdapter.size());
		String[] myArray3 = {"str1", "str6", "add7"};
		assertArrayEquals(myArray3, myAdapter.toArray());
		
		mySubList.add((E)"strTemp");
		mySubList.add((E)"strTemp");
		String[] myArray6 = {"strTemp", "strTemp"};
		assertArrayEquals(myArray6, mySubList.toArray());
		String[] myArray7 = {"str1", "strTemp", "strTemp", "str6", "add7"};
		assertArrayEquals(myArray7, myAdapter.toArray());
		assertEquals(5, myAdapter.size());
		assertEquals(2, mySubList.size());
		
		assertEquals(0, mySubList.indexOf("strTemp")); //indexof
		assertEquals(-1, mySubList.indexOf("strNotInside"));
		assertEquals(1, mySubList.lastIndexOf("strTemp")); //lastindexof
		assertEquals(-1, mySubList.lastIndexOf("strNotInside"));
		
		HCollection<E> tmpColl = new CollectionAdapter<E>();
		tmpColl.add((E)"str2");
		tmpColl.add((E)"str3");
		tmpColl.add((E)"str4");
		tmpColl.add((E)"str5");

		assertEquals(5, myAdapter.size());
		assertEquals(2, mySubList.size());
		assertEquals(true, mySubList.addAll(tmpColl)); //addall_1
		assertEquals(9, myAdapter.size());
		assertEquals(6, mySubList.size());

		assertEquals(true, mySubList.containsAll(tmpColl)); //containsall
		tmpColl.add((E)"str10");
		assertEquals(false, mySubList.containsAll(tmpColl)); //containsall
		tmpColl.remove((E)"str10");
		
		String[] myArray8 = {"strTemp", "strTemp", "str2", "str3", "str4", "str5"};
		assertArrayEquals(myArray8, mySubList.toArray());
		String[] myArray9 = {"str1", "strTemp", "strTemp", "str2", "str3", "str4", "str5", "str6", "add7"};
		assertArrayEquals(myArray9, myAdapter.toArray());
		
		assertEquals(true, mySubList.removeAll(tmpColl)); //removeall
		assertEquals(5, myAdapter.size());
		assertEquals(2, mySubList.size());
		
		String[] myArray10 = {"strTemp", "strTemp"};
		assertArrayEquals(myArray10, mySubList.toArray());
		String[] myArray11 = {"str1", "strTemp", "strTemp", "str6", "add7"};
		assertArrayEquals(myArray11, myAdapter.toArray());
		
		mySubList.add((E)"a");
		assertEquals(6, myAdapter.size());
		assertEquals(3, mySubList.size());
		tmpColl.clear();
		tmpColl.add((E)"a");
		assertEquals(true, mySubList.retainAll(tmpColl)); //retainall
		assertEquals(4, myAdapter.size());
		assertEquals(1, mySubList.size());

		String[] myArray12 = {"a"};
		assertArrayEquals(myArray12, mySubList.toArray());
		String[] myArray13 = {"str1", "a", "str6", "add7"};
		assertArrayEquals(myArray13, myAdapter.toArray());
		
		Iterator<E> myIterator = mySubList.iterator();
		assertEquals(false, mySubList.equals((Integer)1));
		
		String[] tmpArray = new String[mySubList.size()+1];
		tmpArray = mySubList.toArray(tmpArray);
		
		tmpArray = new String[mySubList.size()];
		assertArrayEquals(myArray12, mySubList.toArray(tmpArray));
		
		tmpArray = new String[mySubList.size()+1];
		tmpArray = mySubList.toArray(tmpArray);
		
		assertEquals(true, mySubList.addAll(0, tmpColl)); //addall_2
	}
	
	/**
	 * test subList method in List
	 * 
	 * @safe.precondition a List and a SubList created with subList() of the List
	 * @safe.postcondition none
	 * @safe.testcases test some features of SubList class to check their correctness (SubList and ListAdapter are backed each other)
	 */
	@Test
	public void testSubList_4() {
		//Testing: List<E> subList(int fromIndex, int toIndex);
		HList<E> myAdapter = new ListAdapter<E>();
		myAdapter.add((E)"a"); //0
		myAdapter.add((E)"b"); //1 - 0
		myAdapter.add((E)"c"); //2 - 1
		myAdapter.add((E)"d"); //3 - 2
		myAdapter.add((E)"e"); //4 - 3
		myAdapter.add((E)"f"); //5
		
		HList<E> mySubList = myAdapter.subList(1, 5);
		HList<E> mySubListOfSubList = mySubList.subList(1, 3);

		assertEquals(6, myAdapter.size());
		assertEquals(4, mySubList.size());
		assertEquals(2, mySubListOfSubList.size());
		assertEquals(true, mySubListOfSubList.add((E)"added")); //add_1
		assertEquals(7, myAdapter.size());
		assertEquals(4, mySubList.size());
		assertEquals(3, mySubListOfSubList.size());

		String[] myArray1 = {"a", "b", "c", "d", "added", "e", "f"};
		assertArrayEquals(myArray1, myAdapter.toArray());
		String[] myArray2 = {"b", "c", "d", "added"};
		assertArrayEquals(myArray2, mySubList.toArray());
		String[] myArray3 = {"c", "d", "added"};
		assertArrayEquals(myArray3, mySubListOfSubList.toArray());
		
	}
	
	
	/**
	 * test toArray method in List
	 * 
	 * @safe.precondition a not empty List
	 * @safe.postcondition none
	 * @safe.testcases test the creation of an array with elements of a List contains all the elements of the List and in the same order (using String type)
	 */
	@Test
	public void testToArray1_1() {
		//Testing: Object[] toArray();
		HList<E> myAdapter = new ListAdapter<E>();
		myAdapter.add((E)"str1");
		myAdapter.add((E)"str2");
		myAdapter.add((E)"str3");
		String[] myArray = {"str1", "str2", "str3"};
		assertArrayEquals(myArray, myAdapter.toArray());
	}
	
	/**
	 * test toArray method in List
	 * 
	 * @safe.precondition a not empty List
	 * @safe.postcondition none
	 * @safe.testcases test the creation of an array with elements of a List contains all the elements of the List and in the same order (using Integer type)
	 */
	@Test
	public void testToArray1_2() {
		//Testing: Object[] toArray();
		HList<E> myAdapter = new ListAdapter<E>();
		myAdapter.add((E)(Integer)1);
		myAdapter.add((E)(Integer)2);
		myAdapter.add((E)(Integer)3);
		Integer[] myArray = {1, 2, 3};
		assertArrayEquals(myArray, myAdapter.toArray());
	}
	
		
	/**
	 * test 2nd toArray method in List
	 * 
	 * @safe.precondition a not empty List
	 * @safe.postcondition NullPointerException thrown
	 * @safe.testcases test the attempt to create an array with elements of a List using a null array
	 */
	@Test
	public void testToArray2_1() {
		//Testing: <T> T[] toArray(T[] a);
		HList<E> myAdapter = new ListAdapter<E>();
		myAdapter.add((E)"str1");
		assertThrows(NullPointerException.class, () -> myAdapter.toArray(null));
	}
	
	/**
	 * test 2nd toArray method in List
	 * 
	 * @safe.precondition a not empty List
	 * @safe.postcondition ArrayStoreException thrown
	 * @safe.testcases test the attempt to create an array with elements of a determined type (String in this case) of a List using an array of another determined type (Integer in this case)
	 */
	@Test
	public void testToArray2_2() {
		//Testing: <T> T[] toArray(T[] a);
		HList<E> myAdapter = new ListAdapter<E>();
		myAdapter.add((E)"str1");
		Integer[] tmpArray = new Integer[1];
		assertThrows(ArrayStoreException.class, () -> myAdapter.toArray(tmpArray));
	}
	
	/**
	 * test 2nd toArray method in List
	 * 
	 * @safe.precondition a not empty List
	 * @safe.postcondition UnsupportedOperationException thrown
	 * @safe.testcases test the attempt to create an array with elements of a List using an array with less length than the number of elements contained in the List
	 */
	@Test
	public void testToArray2_3() {
		//Testing: <T> T[] toArray(T[] a);
		HList<E> myAdapter = new ListAdapter<E>();
		myAdapter.add((E)"str1");
		myAdapter.add((E)"str2");
		String[] tmpArray = new String[1];
		assertThrows(UnsupportedOperationException.class, () -> myAdapter.toArray(tmpArray));
	}
	
	/**
	 * test 2nd toArray method in List
	 * 
	 * @safe.precondition a not empty List
	 * @safe.postcondition ArrayStoreException thrown
	 * @safe.testcases test the attempt to create an array with elements of a List using an array with a different type of parameters
	 */
	@Test
	public void testToArray2_4() {
		//Testing: <T> T[] toArray(T[] a);
		HList<E> myAdapter = new ListAdapter<E>();
		myAdapter.add((E)"str1");
		myAdapter.add((E)"str2");
		String[] myArray = {"", "", "", ""};
		Integer[] tmpArray = {1, 2, 3, 4};
		assertThrows(ArrayStoreException.class, () -> myAdapter.toArray(tmpArray));
	}
	
	/**
	 * test 2nd toArray method in List
	 * 
	 * @safe.precondition a not empty List
	 * @safe.postcondition none
	 * @safe.testcases test the creation of an array with elements of a List using an array with same length as the number of elements contained in the List
	 */
	@Test
	public void testToArray2_5() {
		//Testing: <T> T[] toArray(T[] a);
		HList<E> myAdapter = new ListAdapter<E>();
		myAdapter.add((E)"str1");
		myAdapter.add((E)"str2");
		myAdapter.add((E)"str3");
		String[] myArray = {"str1", "str2", "str3"};
		String[] tmpArray = new String[myArray.length];
		assertArrayEquals(myArray, myAdapter.toArray(tmpArray));
	}
	
	/**
	 * test 2nd toArray method in List
	 * 
	 * @safe.precondition a not empty List
	 * @safe.postcondition none
	 * @safe.testcases test the creation of an array with elements of a List using an array with more length than the number of elements contained in the List
	 */
	@Test
	public void testToArray2_6() {
		//Testing: <T> T[] toArray(T[] a);
		HList<E> myAdapter = new ListAdapter<E>();
		myAdapter.add((E)"str1");
		myAdapter.add((E)"str2");
		String[] myArray = {"str1", "str2", null, ""};
		String[] tmpArray = {"", "", "", ""};
		assertArrayEquals(myArray, myAdapter.toArray(tmpArray));
	}
}