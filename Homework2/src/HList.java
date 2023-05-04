/**
 * An ordered collection (also known as a <i>sequence</i>).  The user of this
 * interface has precise control over where in the list each element is
 * inserted.  The user can access elements by their integer index (position in
 * the list), and search for elements in the list.
 *
 * <p>Unlike sets, lists typically allow duplicate elements.  More formally,
 * lists typically allow pairs of elements <tt>e1</tt> and <tt>e2</tt>
 * such that <tt>e1.equals(e2)</tt>, and they typically allow multiple
 * null elements if they allow null elements at all.  It is not inconceivable
 * that someone might wish to implement a list that prohibits duplicates, by
 * throwing runtime exceptions when the user attempts to insert them, but we
 * expect this usage to be rare.
 *
 * <p>The <tt>List</tt> interface places additional stipulations, beyond those
 * specified in the <tt>Collection</tt> interface, on the contracts of the
 * <tt>iterator</tt>, <tt>add</tt>, <tt>remove</tt>, <tt>equals</tt>, and
 * <tt>hashCode</tt> methods.  Declarations for other inherited methods are
 * also included here for convenience.
 *
 * <p>The <tt>List</tt> interface provides four methods for positional (indexed)
 * access to list elements.  Lists (like Java arrays) are zero based.  Note
 * that these operations may execute in time proportional to the index value
 * for some implementations (the <tt>LinkedList</tt> class, for
 * example). Thus, iterating over the elements in a list is typically
 * preferable to indexing through it if the caller does not know the
 * implementation.
 *
 * <p>The <tt>List</tt> interface provides a special iterator, called a
 * <tt>ListIterator</tt>, that allows element insertion and replacement, and
 * bidirectional access in addition to the normal operations that the
 * <tt>Iterator</tt> interface provides.  A method is provided to obtain a
 * list iterator that starts at a specified position in the list.
 *
 * <p>The <tt>List</tt> interface provides two methods to search for a specified
 * object.  From a performance standpoint, these methods should be used with
 * caution.  In many implementations they will perform costly linear
 * searches.
 *
 * <p>The <tt>List</tt> interface provides two methods to efficiently insert and
 * remove multiple elements at an arbitrary point in the list.
 *
 * <p>Note: While it is permissible for lists to contain themselves as elements,
 * extreme caution is advised: the <tt>equals</tt> and <tt>hashCode</tt>
 * methods are no longer well defined on such a list.
 *
 * <p>Some list implementations have restrictions on the elements that
 * they may contain.  For example, some implementations prohibit null elements,
 * and some have restrictions on the types of their elements.  Attempting to
 * add an ineligible element throws an unchecked exception, typically
 * <tt>NullPointerException</tt> or <tt>ClassCastException</tt>.  Attempting
 * to query the presence of an ineligible element may throw an exception,
 * or it may simply return false; some implementations will exhibit the former
 * behavior and some will exhibit the latter.  More generally, attempting an
 * operation on an ineligible element whose completion would not result in
 * the insertion of an ineligible element into the list may throw an
 * exception or it may succeed, at the option of the implementation.
 * Such exceptions are marked as "optional" in the specification for this
 * interface.
 * 
 * <p>This interface is a member of the Java Collections Framework.
 * 
 * @param <E> the type of elements maintained by this set
 * @super HCollection<E>
 * 
 * @author  Simone Bastasin
 * @see     HCollection
 * @see     HSet
 * @see     HMap
 * @see     Iterator
 * @see     ListIterator
 */

public interface HList<E> extends HCollection<E> {
	
	/**
	 * Inserts the specified element at the specified position in this list
	 * (optional operation). Shifts the element currently at that position (if
	 * any) and any subsequent elements to the right (adds one to their indices).
	 * 
	 * @param index index at which the specified element is to be inserted.
	 * @param element element to be inserted.
	 * @throws UnsupportedOperationException if the add method is not supported
	 * by this list.
	 * @throws ClassCastException if the class of the specified element prevents
	 * it from being added to this list.
	 * @throws NullPointerException if the specified element is null and this
	 * list does not support null elements.
	 * @throws IllegalArgumentException if some aspect of the specified element
	 * prevents it from being added to this list.
	 * @throws IndexOutOfBoundsException if the index is out of range
	 * (index < 0 || index > size()).
	 */
	void add(int index, E element);
	
	
	/**
	 * Appends the specified element to the end of this list (optional operation).
	 * 
	 * <p>Lists that support this operation may place limitations on what
	 * elements may be added to this list. In particular, some lists will refuse
	 * to add null elements, and others will impose restrictions on the type of
	 * elements that may be added. List classes should clearly specify in their
	 * documentation any restrictions on what elements may be added.
	 * 
	 * @param e element to be appended to this list.
	 * @return true (as per the general contract of the Collection.add method).
	 * @throws UnsupportedOperationException if the add method is not supported
	 * by this list.
	 * @throws ClassCastException if the class of the specified element prevents
	 * it from being added to this list.
	 * @throws NullPointerException if the specified element is null and this
	 * list does not support null elements.
	 * @throws IllegalArgumentException if some aspect of this element prevents
	 * it from being added to this list.
	 */
	boolean add(E e);
	

	/**
	 * Inserts all of the elements in the specified collection into this list at
	 * the specified position (optional operation). Shifts the element currently
	 * at that position (if any) and any subsequent elements to the right
	 * (increases their indices). The new elements will appear in this list in
	 * the order that they are returned by the specified collection's iterator.
	 * The behavior of this operation is unspecified if the specified collection
	 * is modified while the operation is in progress. (Note that this will occur
	 * if the specified collection is this list, and it's nonempty.)
	 * 
	 * @param index index at which to insert first element from the specified
	 * collection.
	 * @param c elements to be inserted into this list.
	 * @return true if this list changed as a result of the call.
	 * @throws UnsupportedOperationException - if the addAll method is not
	 * supported by this list.
	 * @throws ClassCastException if the class of one of elements of the
	 * specified collection prevents it from being added to this list.
	 * @throws NullPointerException if the specified collection contains one or
	 * more null elements and this list does not support null elements, or if
	 * the specified collection is null.
	 * @throws IllegalArgumentException if some aspect of one of elements of
	 * the specified collection prevents it from being added to this list.
	 * @throws IndexOutOfBoundsException if the index is out of range
	 * (index < 0 || index > size()).
	 */
	boolean addAll(int index, HCollection<? extends E> c);
	

	/**
	 * Appends all of the elements in the specified collection to the end of
	 * this list, in the order that they are returned by the specified
	 * collection's iterator (optional operation). The behavior of this
	 * operation is unspecified if the specified collection is modified while
	 * the operation is in progress. (Note that this will occur if the specified
	 * collection is this list, and it's nonempty.)
	 * 
	 * @param c collection whose elements are to be added to this list.
	 * @return true if this list changed as a result of the call.
	 * @throws UnsupportedOperationException if the addAll method is not
	 * supported by this list.
	 * @throws ClassCastException if the class of an element in the specified
	 * collection prevents it from being added to this list.
	 * @throws NullPointerException if the specified collection contains one or
	 * more null elements and this list does not support null elements, or if
	 * the specified collection is null.
	 * @throws IllegalArgumentException if some aspect of an element in the
	 * specified collection prevents it from being added to this list.
	 */
	boolean addAll(HCollection<? extends E> c);
	

	/**
	 * Removes all of the elements from this list (optional operation). This list
	 * will be empty after this call returns (unless it throws an exception).
	 * 
	 * @throws UnsupportedOperationException if the clear method is not supported
	 * by this list.
	 */
	void clear();
	
	
	/**
	 * Returns true if this list contains the specified element. More formally,
	 * returns true if and only if this list contains at least one element e
	 * such that (o==null ? e==null : o.equals(e)).
	 * 
	 * @param o element whose presence in this list is to be tested.
	 * @return true if this list contains the specified element.
	 * @throws ClassCastException - if the type of the specified element is
	 * incompatible with this list (optional).
	 * @throws NullPointerException - if the specified element is null and this
	 * list does not support null elements (optional).
	 */
	boolean contains(Object o);
	

	/**
	 * Returns true if this list contains all of the elements of the specified
	 * collection.
	 * 
	 * @param c collection to be checked for containment in this list.
	 * @return true if this list contains all of the elements of the specified
	 * collection.
	 * @throws ClassCastException - if the types of one or more elements in the
	 * specified collection are incompatible with this list (optional).
	 * @throws NullPointerException - if the specified collection contains one
	 * or more null elements and this list does not support null elements
	 * (optional).
	 * @throws NullPointerException - if the specified collection is null.
	 */
	boolean containsAll(HCollection<?> c);
	

	/**
	 * Compares the specified object with this list for equality. Returns true
	 * if and only if the specified object is also a list, both lists have the
	 * same size, and all corresponding pairs of elements in the two lists are
	 * equal. (Two elements e1 and e2 are equal if
	 * (e1==null ? e2==null : e1.equals(e2)).) In other words, two lists are
	 * defined to be equal if they contain the same elements in the same order.
	 * This definition ensures that the equals method works properly across
	 * different implementations of the List interface.
	 * 
	 * @overrides equals in class Object
	 * @param o the object to be compared for equality with this list.
	 * @return true if the specified object is equal to this list.
	 */
	boolean equals(Object o);
	

	/**
	 * Returns the element at the specified position in this list.
	 * 
	 * @param index index of element to return.
	 * @return the element at the specified position in this list.
	 * @throws IndexOutOfBoundsException - if the index is out of range
	 * (index < 0 || index >= size()).
	 */
	E get(int index);
	

	/**
	 * Returns the hash code value for this list. The hash code of a list is
	 * defined to be the result of the following calculation:
	 * <pre>{@code
     *     int hashCode = 1;
     *     for (E e : list)
     *         hashCode = 31*hashCode + (e==null ? 0 : e.hashCode());
     * }</pre>
     * 
     * <p>This ensures that list1.equals(list2) implies that
     * list1.hashCode()==list2.hashCode() for any two lists, list1 and list2,
     * as required by the general contract of Object.hashCode.
     * 
	 * @overrides hashCode in class Object
	 * @return the hash code value for this list.
	 */
	int hashCode();
	

	/**
	 * Returns the index in this list of the first occurrence of the specified
	 * element, or -1 if this list does not contain this element. More formally,
	 * returns the lowest index i such that
	 * (o==null ? get(i)==null : o.equals(get(i))), or -1 if there is no such
	 * index.
	 * 
	 * @param o element to search for.
	 * @return the index in this list of the first occurrence of the specified
	 * element, or -1 if this list does not contain this element.
	 * @throws ClassCastException if the type of the specified element is
	 * incompatible with this list (optional).
	 * @throws NullPointerException if the specified element is null and this
	 * list does not support null elements (optional).
	 */
	int indexOf(Object o);
	

	/**
	 * Returns true if this list contains no elements.
	 * 
	 * @return true if this list contains no elements.
	 */
	boolean isEmpty();
	

	/**
	 * Returns an iterator over the elements in this list in proper sequence.
	 * 
	 * @return an iterator over the elements in this list in proper sequence.
	 */
	Iterator<E> iterator();
	

	/**
	 * Returns the index in this list of the last occurrence of the specified
	 * element, or -1 if this list does not contain this element. More formally,
	 * returns the highest index i such that
	 * (o==null ? get(i)==null : o.equals(get(i))), or -1 if there is no such
	 * index.
	 * 
	 * @param o element to search for.
	 * @return the index in this list of the last occurrence of the specified
	 * element, or -1 if this list does not contain this element.
	 * @throws ClassCastException if the type of the specified element is 
	 *incompatible with this list (optional).
	 * @throws NullPointerException if the specified element is null and this
	 * list does not support null elements (optional).
	 */
	int lastIndexOf(Object o);
	

	/**
	 * Returns a list iterator of the elements in this list (in proper sequence).
	 * 
	 * @return a list iterator of the elements in this list (in proper sequence).
	 */
	ListIterator<E> listIterator();
	

	/**
	 * Returns a list iterator of the elements in this list (in proper sequence), starting at the specified position in this list. The specified index indicates the first element that would be returned by an initial call to the next method. An initial call to the previous method would return the element with the specified index minus one.
	 * 
	 * @param index index of first element to be returned from the list iterator
	 * (by a call to the next method).
	 * @return a list iterator of the elements in this list (in proper sequence),
	 * starting at the specified position in this list.
	 * @throws IndexOutOfBoundsException if the index is out of range
	 * (index < 0 || index > size()).
	 */
	ListIterator<E> listIterator(int index);
	

	/**
	 * Removes the element at the specified position in this list
	 * (optional operation). Shifts any subsequent elements to the left
	 * (subtracts one from their indices). Returns the element that was removed
	 * from the list.
	 * 
	 * @param index the index of the element to removed.
	 * @return the element previously at the specified position.
	 * @throws UnsupportedOperationException if the remove method is not
	 * supported by this list.
	 * @throws IndexOutOfBoundsException if the index is out of range
	 * (index < 0 || index >= size()).
	 */
	E remove(int index);
	

	/**
	 * Removes the first occurrence in this list of the specified element
	 * (optional operation). If this list does not contain the element, it is
	 * unchanged. More formally, removes the element with the lowest index i
	 * such that (o==null ? get(i)==null : o.equals(get(i))) (if such an
	 * element exists).
	 * 
	 * @param o element to be removed from this list, if present.
	 * @return true if this list contained the specified element.
	 * @throws ClassCastException if the type of the specified element is
	 * incompatible with this list (optional).
	 * @throws NullPointerException if the specified element is null and this
	 * list does not support null elements (optional).
	 * @throws UnsupportedOperationException if the remove method is not
	 * supported by this list.
	 */
	boolean remove(Object o);
	

	/**
	 * Removes from this list all the elements that are contained in the
	 * specified collection (optional operation).
	 * 
	 * @param c collection that defines which elements will be removed from this
	 * list.
	 * @return true if this list changed as a result of the call.
	 * @throws UnsupportedOperationException if the removeAll method is not
	 * supported by this list.
	 * @throws ClassCastException if the types of one or more elements in this
	 * list are incompatible with the specified collection (optional).
	 * @throws NullPointerException if this list contains one or more null
	 * elements and the specified collection does not support null elements
	 * (optional).
	 * @throws NullPointerException if the specified collection is null.
	 */
	boolean removeAll(HCollection<?> c);
	

	/**
	 * Retains only the elements in this list that are contained in the specified
	 * collection (optional operation). In other words, removes from this list
	 * all the elements that are not contained in the specified collection.
	 * 
	 * @param c collection that defines which elements this set will retain.
	 * @return true if this list changed as a result of the call.
	 * @throws UnsupportedOperationException if the retainAll method is not
	 * supported by this list.
	 * @throws ClassCastException if the types of one or more elements in this
	 * list are incompatible with the specified collection (optional).
	 * @throws NullPointerException if this list contains one or more null
	 * elements and the specified collection does not support null elements
	 * (optional).
	 * @throws NullPointerException if the specified collection is null.
	 */
	boolean retainAll(HCollection<?> c);
	

	/**
	 * Replaces the element at the specified position in this list with the
	 * specified element (optional operation).
	 * 
	 * @param index index of element to replace.
	 * @param element element to be stored at the specified position.
	 * @return the element previously at the specified position.
	 * @throws UnsupportedOperationException if the set method is not supported
	 * by this list.
	 * @throws ClassCastException if the class of the specified element prevents
	 * it from being added to this list.
	 * @throws NullPointerException if the specified element is null and this
	 * list does not support null elements.
	 * @throws IllegalArgumentException if some aspect of the specified element
	 * prevents it from being added to this list.
	 * @throws IndexOutOfBoundsException if the index is out of range
	 * (index < 0 || index >= size()).
	 */
	E set(int index, E element);
	

	/**
	 * Returns the number of elements in this list. If this list contains more
	 * than Integer.MAX_VALUE elements, returns Integer.MAX_VALUE.
	 * 
	 * @return the number of elements in this list.
	 */
	int size();
	

	/**
	 * Returns a view of the portion of this list between the specified
	 * fromIndex, inclusive, and toIndex, exclusive. (If fromIndex and toIndex
	 * are equal, the returned list is empty.) The returned list is backed by
	 * this list, so non-structural changes in the returned list are reflected
	 * in this list, and vice-versa. The returned list supports all of the
	 * optional list operations supported by this list.
	 * 
	 * <p>This method eliminates the need for explicit range operations (of
	 * the sort that commonly exist for arrays). Any operation that expects a
	 * list can be used as a range operation by passing a subList view instead
	 * of a whole list. For example, the following idiom removes a range of
	 * elements from a list:
	 * <pre>
	 * list.subList(from, to).clear();</pre>
	 * 
	 * <p>Similar idioms may be constructed for indexOf and lastIndexOf, and all
	 * of the algorithms in the Collections class can be applied to a subList.
	 * 
	 * <p>The semantics of the list returned by this method become undefined if
	 * the backing list (i.e., this list) is structurally modified in any way
	 * other than via the returned list. (Structural modifications are those
	 * that change the size of this list, or otherwise perturb it in such a
	 * fashion that iterations in progress may yield incorrect results.)
	 * 
	 * @param fromIndex low endpoint (inclusive) of the subList.
	 * @param toIndex high endpoint (exclusive) of the subList.
	 * @return a view of the specified range within this list.
	 * @throws IndexOutOfBoundsException for an illegal endpoint index value
	 * (fromIndex < 0 || toIndex > size || fromIndex > toIndex).
	 */
	HList<E> subList(int fromIndex, int toIndex);
	

	/**
	 * Returns an array containing all of the elements in this list in proper
	 * sequence. Obeys the general contract of the Collection.toArray method.
	 * 
	 * @return an array containing all of the elements in this list in proper
	 * sequence.
	 */
	Object[] toArray();
	

	/**
	 * Returns an array containing all of the elements in this list in proper
	 * sequence; the runtime type of the returned array is that of the specified
	 * array. Obeys the general contract of the Collection.toArray(Object[])
	 * method.
	 * 
	 * @type T the runtime type of the array to contain the collection
	 * @param a the array into which the elements of this list are to be stored,
	 * if it is big enough; otherwise, a new array of the same runtime type is
	 * allocated for this purpose.
	 * @return an array containing the elements of this list.
	 * @throws ArrayStoreException if the runtime type of the specified array
	 * is not a supertype of the runtime type of every element in this list.
	 * @throws NullPointerException if the specified array is null.
	 */
	<T> T[] toArray(T[] a);
	
}
