package listy;

public class LinkedList extends AbstractList {
	private final Element _head = new Element(null); // glowa
	private int _size; // dlugoœæ listy

	public LinkedList() {
		clear();
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

	@Override
	public void insert(int index, Object value) throws IndexOutOfBoundsException {
		Element e = new Element(value);
		Element pop = _head;
		Element next = _head.getNext();
		int i = 0;
		if (index <= _size) {
			while (i < index) {
				pop = pop.getNext();
				next = next.getNext();
				i++;
			}
			_size++;
			pop.setNext(e);
			e.setNext(next);
		}

	}

	@Override
	public void add(Object value) {
		Element e = new Element(value);
		Element pod = _head;

		while (pod.getNext() != null) {
			pod = pod.getNext();
		}
		_size++;
		pod.setNext(e);

	}

	public void wyswietl() {
		Element pod = _head;
		int i = 0;
		while (pod.getNext() != null) {
			pod = pod.getNext();
			System.out.println(i + " " + pod.getValue());
			i++;
		}

	}

	@Override
	public Object delete(int index) throws IndexOutOfBoundsException {

		Element pop = _head;
		Element szuk;
		Element next;
		int i = 0;
		if (index <= _size) {

			while (i < index) {
				pop = pop.getNext();
				i++;
			}
			szuk = pop.getNext();
			if (szuk.getNext() != null) {
				next = szuk.getNext();
				pop.setNext(next);
			}
			_size--;
			return szuk.getValue();

		} else {
			throw new IndexOutOfBoundsException();
		}

	}

	@Override
	public boolean delete(Object value) {

		Element pop = _head;
		// pierwszy
		if (pop.getNext().getValue().equals(value)) {
			pop.setNext(pop.getNext().getNext());
			_size--;
			return true;
		}
		if (pop.getNext() != null) {
			Element next = pop.getNext();

			while (next.getNext() != null) {
				pop = pop.getNext();
				next = next.getNext();
				if (next.getValue().equals(value)) {
					pop.setNext(next.getNext());
					_size--;
					return true;
				}
			}
			return false;
		}
		return false;

	}

	@Override
	public void clear() {
		_head.setNext(null);
		_size = 0;

	}

	@Override
	public Object set(int index, Object value) throws IndexOutOfBoundsException {

		Element next = _head;
		Object ret;
		int i = 0;
		if (index < _size && index >= 0) {
			while (i <= index) {

				next = next.getNext();
				i++;
			}

			ret = next.getValue();
			next.setValue(value);
			return ret;
		} else {
			throw new IndexOutOfBoundsException();
		}
	}

	@Override
	public Object get(int index) throws IndexOutOfBoundsException {

		Element pop = _head;

		int i = 0;
		if (index < _size) {

			while (i <= index) {
				pop = pop.getNext();
				i++;
			}
			return pop.getValue();
		} else {
			throw new IndexOutOfBoundsException();
		}
	}

	@Override
	public int indexOf(Object value) {
		
		
		Element next = _head;
		int index = 0;
		next=next.getNext();
			while (next != null) {

				if (next.getValue().equals(value)) {
					return index;
				}
				next=next.getNext();
				index++;
			}
			return -1;
		

	}

	@Override
	public boolean contains(Object value) {
		Element next=_head.getNext();
		while(next!=null)
		{
			if(next.getValue().equals(value))
			{
				return true;
			}
			next=next.getNext();
		}
		return false;
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

	@Override
	public Iterator iterator() {
		{
			return new ValueIterator();
		}
	}

	private final class ValueIterator implements Iterator {
		private Element _current = _head;

		public void first() {
			_current = _head.getNext();
		}

		public boolean isDone() {
			return _current == null;
		}

		public void next() {
			_current = _current.getNext();
		}

		public Object current() throws IndexOutOfBoundsException {
			if (isDone())
				throw new IndexOutOfBoundsException();
			return _current.getValue();
		}
	}
}
