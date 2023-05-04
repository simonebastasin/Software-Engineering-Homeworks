import java.util.Enumeration;
import java.util.Vector;

public class CollectionAdapterIterator<E> implements Iterator<E> {
	
	private Vector<E> helpVector = new Vector<E>();
	private int index;
	private boolean next = false;
	
	public CollectionAdapterIterator(Vector<E> v) {
		index = 0;
		helpVector = v;
	}
	
	public CollectionAdapterIterator(MapAdapter<Object,E> ma) {
		index = 0;
		
		//HCollection<E> tmpC = ma.values();
		HCollection<E> tmpC = new CollectionAdapter<E>();
		Enumeration<E> myEnumeration = ma.myHashTable.elements();
		while(myEnumeration.hasMoreElements())
		{
			E tmpValue = myEnumeration.nextElement();
			tmpC.add(tmpValue);
		}		
		
		Object[] tmpArray = new Object[ma.size()];
		tmpArray = tmpC.toArray(tmpArray);			
		
		for(int i = 0; i < tmpC.size(); i++)
			helpVector.add((E)tmpArray[i]);
			//helpVector.setElementAt((E)tmpArray[i], i);
	}
	
	public boolean hasNext() {
		return (index < helpVector.size());
	}
	
	public E next() {
		if(index >= helpVector.size())
			throw new java.util.NoSuchElementException();
		next = true;
		return helpVector.elementAt(index++);
	}
	
	public void remove() {
		if(!next)
			throw new IllegalStateException();
		next = false;
		helpVector.removeElementAt(--index);
	}
}