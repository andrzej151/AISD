package kolejki;

import java.util.EmptyStackException;



public class Kolejka implements Queue {
	private final Element _head = new Element(null);
	private int _size;

	public Kolejka() {
		clear();
	}

	@Override
	public void enqueue(Object value) {
		Element e = new Element(value);
		Element next = _head;
		while (next.getNext() != null) {
			next = next.getNext();
		}
		next.setNext(e);
		_size++;

	}

	@Override
	public Object dequeue() throws EmptyStackException {
		// TODO Auto-generated method stub
		Element next = _head;
		if (next.getNext() == null) {
			throw new EmptyStackException();
		} else {
			Element e = next.getNext();
			next.setNext( e.getNext());
			_size--;
			return e.getValue();
		}
	}

	public void wyswietl()
	{
		Element next = _head;
		while(next.getNext()!=null)
		{
			next=next.getNext();
			System.out.println(next.getValue());
		}
	}
	
	public String toString() {
		StringBuffer buffer = new StringBuffer();
		Element next = _head;
		buffer.append('[');
		while(next.getNext()!=null)
		{
			next=next.getNext();
			buffer.append(next.getValue()).append(", ");
		}
		if(!isEmpty()){
			buffer.setLength(buffer.length() - 2);
		}
		buffer.append(']');
		return buffer.toString();
	}

	@Override
	public void clear() {
		_head.setNext(null);
		_size = 0;

	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return _size;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return _size == 0;
	}

	private static final class Element {
		private Object _value;
		private Element _next;

		public Element(Object value) {
			setValue(value);
		}

		public void setValue(Object value) {
			_value = value;
		}

		public Object getValue() {
			return _value;
		}

		public Element getNext() {
			return _next;
		}

		public void setNext(Element next) {
			_next = next;
		}

	}

}
