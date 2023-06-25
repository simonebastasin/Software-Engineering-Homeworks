/**
 * A collection that contains no duplicate elements.  More formally, sets
 * contain no pair of elements <code>e1</code> and <code>e2</code> such that
 * <code>e1.equals(e2)</code>, and at most one null element.  As implied by
 * its name, this interface models the mathematical <i>set</i> abstraction.
 *
 * <p>The <tt>Set</tt> interface places additional stipulations, beyond those
 * inherited from the <tt>Collection</tt> interface, on the contracts of all
 * constructors and on the contracts of the <tt>add</tt>, <tt>equals</tt> and
 * <tt>hashCode</tt> methods.  Declarations for other inherited methods are
 * also included here for convenience.  (The specifications accompanying these
 * declarations have been tailored to the <tt>Set</tt> interface, but they do
 * not contain any additional stipulations.)
 *
 * <p>The additional stipulation on constructors is, not surprisingly,
 * that all constructors must create a set that contains no duplicate elements
 * (as defined above).
 *
 * <p>Note: Great care must be exercised if mutable objects are used as set
 * elements.  The behavior of a set is not specified if the value of an object
 * is changed in a manner that affects <tt>equals</tt> comparisons while the
 * object is an element in the set.  A special case of this prohibition is
 * that it is not permissible for a set to contain itself as an element.
 *
 * <p>Some set implementations have restrictions on the elements that
 * they may contain.  For example, some implementations prohibit null elements,
 * and some have restrictions on the types of their elements.  Attempting to
 * add an ineligible element throws an unchecked exception, typically
 * <tt>NullPointerException</tt> or <tt>ClassCastException</tt>.  Attempting
 * to query the presence of an ineligible element may throw an exception,
 * or it may simply return false; some implementations will exhibit the former
 * behavior and some will exhibit the latter.  More generally, attempting an
 * operation on an ineligible element whose completion would not result in
 * the insertion of an ineligible element into the set may throw an
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
 * @see     HList
 * @see     HMap
 * @see     Iterator
 * @see     ListIterator
 */

public interface HSet<E> extends HCollection<E> {
	
	/**
	 * Adds the specified element to this set if it is not already present
	 * (optional operation). More formally, adds the specified element, o, to
	 * this set if this set contains no element e such that
	 * (o==null ? e==null : o.equals(e)). If this set already contains the
	 * specified element, the call leaves this set unchanged and returns false.
	 * In combination with the restriction on constructors, this ensures that
	 * sets never contain duplicate elements.
	 * 
	 * <p>The stipulation above does not imply that sets must accept all
	 * elements; sets may refuse to add any particular element, including
	 * null, and throwing an exception, as described in the specification
	 * for Collection.add. Individual set implementations should clearly
	 * document any restrictions on the the elements that they may contain.
	 * 
	 * @param e element to be added to this set.
	 * @return true if this set did not already contain the specified element.
	 * @throws UnsupportedOperationException if the add method is not
	 * supported by this set.
	 * @throws ClassCastException if the class of the specified element
	 * prevents it from being added to this set.
	 * @throws NullPointerException if the specified element is null and
	 * this set does not support null elements.
	 * @throws IllegalArgumentException if some aspect of the specified
	 * element prevents it from being added to this set.
	 */
	boolean add(E e);
	
	
	/**
	 * Adds all of the elements in the specified collection to this set if
	 * they're not already present (optional operation). If the specified
	 * collection is also a set, the addAll operation effectively modifies
	 * this set so that its value is the union of the two sets. The behavior
	 * of this operation is unspecified if the specified collection is
	 * modified while the operation is in progress.
	 * 
	 * @param c collection whose elements are to be added to this set.
	 * @return true if this set changed as a result of the call.
	 * @throws UnsupportedOperationException if the addAll method is not
	 * supported by this set.
	 * @throws ClassCastException if the class of some element of the
	 * specified collection prevents it from being added to this set.
	 * @throws NullPointerException if the specified collection contains
	 * one or more null elements and this set does not support null elements,
	 * or if the specified collection is null.
	 * @throws IllegalArgumentException if some aspect of some element of
	 * the specified collection prevents it from being added to this set.
	 */
	boolean addAll(HCollection<? extends E> c);
	
	
	/**
	 * Removes all of the elements from this set (optional operation). This
	 * set will be empty after this call returns (unless it throws an
	 * exception).
	 * 
	 * @throws UnsupportedOperationException if the clear method is not
	 * supported by this set.
	 */
	void clear();
	
	
	/**
	 * Returns true if this set contains the specified element. More formally,
	 * returns true if and only if this set contains an element e such that
	 * (o==null ? e==null : o.equals(e)).
	 * 
	 * @param o element whose presence in this set is to be tested.
	 * @return true if this set contains the specified element.
	 * @throws ClassCastException if the type of the specified element is
	 * incompatible with this set (optional).
	 * @throws NullPointerException if the specified element is null and this
	 * set does not support null elements (optional).
	 */
	boolean contains(Object o);
	
	
	/**
	 * Returns true if this set contains all of the elements of the specified
	 * collection. If the specified collection is also a set, this method
	 * returns true if it is a subset of this set.
	 * 
	 * @param c collection to be checked for containment in this set.
	 * @return true if this set contains all of the elements of the specified
	 * collection.
	 * @throws ClassCastException if the types of one or more elements in the
	 * specified collection are incompatible with this set (optional).
	 * @throws NullPointerException if the specified collection contains one
	 * or more null elements and this set does not support null elements
	 * (optional).
	 * @throws NullPointerException if the specified collection is null.
	 */
	boolean containsAll(HCollection<?> c);
	
	
	/**
	 * Compares the specified object with this set for equality. Returns true
	 * if the specified object is also a set, the two sets have the same size,
	 * and every member of the specified set is contained in this set
	 * (or equivalently, every member of this set is contained in the
	 * specified set). This definition ensures that the equals method works
	 * properly across different implementations of the set interface.
	 * 
	 * @overrides equals in class Object
	 * @param o Object to be compared for equality with this set.
	 * @return true if the specified Object is equal to this set.
	 */
	boolean equals(Object o);
	
	
	/**
	 * Returns the hash code value for this set. The hash code of a set is
	 * defined to be the sum of the hash codes of the elements in the set,
	 * where the hashcode of a null element is defined to be zero. This
	 * ensures that s1.equals(s2) implies that s1.hashCode()==s2.hashCode()
	 * for any two sets s1 and s2, as required by the general contract of the
	 * Object.hashCode method.
	 * 
	 * @overrides hashCode in class Object
	 * @return the hash code value for this set.
	 */
	int hashCode();
	
	
	/**
	 * Returns true if this set contains no elements.
	 * 
	 * @return true if this set contains no elements.
	 */
	boolean isEmpty();
	
	
	/**
	 * Returns an iterator over the elements in this set. The elements are
	 * returned in no particular order (unless this set is an instance of
	 * some class that provides a guarantee).
	 * 
	 * @return an iterator over the elements in this set.
	 */
	Iterator<E> iterator();
	
	
	/**
	 * Removes the specified element from this set if it is present (optional
	 * operation). More formally, removes an element e such that
	 * (o==null ? e==null : o.equals(e)), if the set contains such an element.
	 * Returns true if the set contained the specified element
	 * (or equivalently, if the set changed as a result of the call). (The
	 * set will not contain the specified element once the call returns.)
	 * 
	 * @param o object to be removed from this set, if present.
	 * @return true if the set contained the specified element.
	 * @throws ClassCastException if the type of the specified element is
	 * incompatible with this set (optional).
	 * @throws NullPointerException if the specified element is null and this
	 * set does not support null elements (optional).
	 * @throws UnsupportedOperationException if the remove method is not
	 * supported by this set.
	 */
	boolean remove(Object o);
	
	
	/**
	 * Removes from this set all of its elements that are contained in the
	 * specified collection (optional operation). If the specified collection
	 * is also a set, this operation effectively modifies this set so that
	 * its value is the asymmetric set difference of the two sets.
	 * 
	 * @param c collection that defines which elements will be removed from
	 * this set.
	 * @return true if this set changed as a result of the call.
	 * @throws UnsupportedOperationException if the removeAll method is not
	 * supported by this Collection.
	 * @throws ClassCastException if the types of one or more elements in
	 * this set are incompatible with the specified collection (optional).
	 * @throws NullPointerException if this set contains a null element and
	 * the specified collection does not support null elements (optional).
	 * @throws NullPointerException if the specified collection is null.
	 */
	boolean removeAll(HCollection<?> c);
	
	
	/**
	 * Retains only the elements in this set that are contained in the
	 * specified collection (optional operation). In other words, removes
	 * from this set all of its elements that are not contained in the
	 * specified collection. If the specified collection is also a set, this
	 * operation effectively modifies this set so that its value is the
	 * intersection of the two sets.
	 * 
	 * @param c collection that defines which elements this set will retain.
	 * @return true if this collection changed as a result of the call.
	 * @throws UnsupportedOperationException if the retainAll method is not
	 * supported by this Collection.
	 * @throws ClassCastException if the types of one or more elements in
	 * this set are incompatible with the specified collection (optional).
	 * @throws NullPointerException if this set contains a null element and
	 * the specified collection does not support null elements (optional).
	 * @throws NullPointerException if the specified collection is null.
	 */
	boolean retainAll(HCollection<?> c);
	
	
	/**
	 * Returns the number of elements in this set (its cardinality). If this
	 * set contains more than Integer.MAX_VALUE elements, returns
	 * Integer.MAX_VALUE.
	 * 
	 * @return the number of elements in this set (its cardinality).
	 */
	int size();
	
	
	/**
	 * Returns an array containing all of the elements in this set. Obeys the
	 * general contract of the Collection.toArray method.
	 * 
	 * @return an array containing all of the elements in this set.
	 */
	Object[] toArray();
	
	
	/**
	 * Returns an array containing all of the elements in this set; the
	 * runtime type of the returned array is that of the specified array.
	 * Obeys the general contract of the Collection.toArray(Object[]) method.
	 * 
	 * @type T the runtime type of the array to contain the collection
	 * @param a the array into which the elements of this set are to be stored,
	 * if it is big enough; otherwise, a new array of the same runtime type is
	 * allocated for this purpose.
	 * @return an array containing the elements of this set.
	 * @throws ArrayStoreException - the runtime type of a is not a supertype
	 * of the runtime type of every element in this set.
	 * @throws NullPointerException - if the specified array is null.
	 */
	<T> T[] toArray(T[] a);
}
