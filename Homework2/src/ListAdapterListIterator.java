import java.util.Vector;

public class ListAdapterListIterator<E> implements ListIterator<E> {
	
	private int index;
	private Vector<E> helpVector = new Vector<E>();
	private boolean next = false;
	private boolean previous = false;
	
	public ListAdapterListIterator(int i, Vector<E> v) {
		if(i < 0 || i > v.size())
			throw new IndexOutOfBoundsException();
		index = i;
		helpVector = v;
	}
	
	// Query Operations
	
	public boolean hasNext() {
		return (index < helpVector.size());
	}
	
	public E next() {
		if(index >= helpVector.size())
			throw new java.util.NoSuchElementException();
		next = true;
		previous = false;
		return helpVector.elementAt(index++);
	}

	public boolean hasPrevious() {
		return (index > 0);
	}

	public E previous() {
		if(!hasPrevious())
			throw new java.util.NoSuchElementException();
		next = false;
		previous = true;
		return helpVector.elementAt(--index);
	}

	public int nextIndex() {
		return index;
	}

	public int previousIndex() {
		return index-1;
	}
	
	// Modification Operations

	public void remove() {
		if(previous) {
			next = false;
			previous = false;
			helpVector.removeElementAt(index);
		}
		else {
			if(!next)
				throw new IllegalStateException();
			next = false;
			helpVector.removeElementAt(--index);
		}
	}

	public void set(E o) {
		if(next) {
			next = false;
			helpVector.setElementAt(o, index-1);
		}
		else if(previous) {
			previous = false;
			helpVector.setElementAt(o, index);
		}
		else
			throw new IllegalStateException();
	}

	public void add(E o) {
		next = false;
		previous = false;
		helpVector.insertElementAt(o, index++);
	}
}
