import java.util.Enumeration;
import java.util.Vector;

public class SetAdapterIterator<E> implements Iterator<E> {
	
	private int index;
	private MapAdapter<E,Object> helpMapAdapter = new MapAdapter<E,Object>();
	private Vector<E> helpVector = new Vector<E>();
	private boolean next = false;
	
	
	public SetAdapterIterator(MapAdapter<E,Object> ma) {
		index = 0;
		helpMapAdapter = ma;
		
		index = 0;
		
		//HCollection<E> tmpC = helpMapAdapter.keySet();
		HCollection<E> tmpC = new CollectionAdapter<E>();
		Enumeration<E> myEnumeration = helpMapAdapter.myHashTable.keys();
		while(myEnumeration.hasMoreElements())
		{
			E tmpKey = myEnumeration.nextElement();
			tmpC.add(tmpKey);
		}
		
		Object[] tmpArray = new Object[helpMapAdapter.size()];
		tmpArray = tmpC.toArray(tmpArray);	
		
		for(int i = 0; i < tmpC.size(); i++)
			helpVector.add((E)tmpArray[i]);
			//helpVector.setElementAt((E)tmpArray[i], i);		
	}
	
	
	public boolean hasNext() {
		return (index < helpMapAdapter.size());
	}
	
	public E next() {
		if(index >= helpMapAdapter.size())
			throw new java.util.NoSuchElementException();
		next = true;
		return helpVector.elementAt(index++);
	}
	
	public void remove() {
		if(!next)
			throw new IllegalStateException();
		next = false;
		index--;
		helpMapAdapter.remove(helpVector.elementAt(index));
		helpVector.removeElementAt(index);
	}
}
