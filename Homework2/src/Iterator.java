/**
 * An iterator over a collection. Iterator takes the place of Enumeration in the
 * Java collections framework. Iterators differ from enumerations in two ways:
 * 
 * <p>- Iterators allow the caller to remove elements from the underlying collection
 * during the iteration with well-defined semantics.
 * 
 * <p>- Method names have been improved.
 * 
 * <p>This interface is a member of the Java Collections Framework.
 * 
 * @param <E> the type of elements in this collection
 * 
 * @author  Simone Bastasin
 * @see     ListIterator
 * @see     HCollection
 * @see     HList
 * @see     HSet
 * @see     HMap
 */

public interface Iterator<E> {
	
	/**
	 * Returns true if the iteration has more elements. (In other words, returns true if next would return an element rather than throwing an exception.)
	 * 
	 * @return true if the iterator has more elements.
	 */
	boolean hasNext();
	
	/**
	 * Returns the next element in the iteration.
	 * 
	 * @return the next element in the iteration.
	 * @throws NoSuchElementException iteration has no more elements.
	 */
	E next();
	
	/**
	 * Removes from the underlying collection the last element returned by the iterator (optional operation). This method can be called only once per call to next. The behavior of an iterator is unspecified if the underlying collection is modified while the iteration is in progress in any way other than by calling this method.
	 * 
	 * @throws UnsupportedOperationException - if the remove operation is not supported by this Iterator.
	 * @throws IllegalStateException - if the next method has not yet been called, or the remove method has already been called after the last call to the next method.
	 */
	void remove();
	
}