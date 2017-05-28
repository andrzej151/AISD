package SortowanieKopcowe;

import java.util.EmptyStackException;
import java.util.LinkedList;
import java.util.List;

public class UnsortedPriorityQueue implements Queue {
	private final List _list;
	private final Comparator _comparator; // do ustalenia priorytetu

	public UnsortedPriorityQueue(Comparator comparator) {
		_comparator = comparator;
		_list = new LinkedList();
	}

	public void enqueue(Object value) {
		_list.add(value);
	}

	public Object dequeue() throws Exception {
		if (isEmpty())
			throw new Exception();
		return _list.remove(getIndexOfLargestElement());
	}

	private int getIndexOfLargestElement() {
		int result = 0;
		for (int i = 1; i < _list.size(); ++i)
			if (_comparator.compare(_list.get(i), _list.get(result)) > 0)
				result = i;
		return result;
	}

	public void clear() {
		_list.clear();
	}

	public int size() {
		return _list.size();
	}

	public boolean isEmpty() {
		return _list.isEmpty();
	}

	@Override
	public void insert(int index, Object value) throws IndexOutOfBoundsException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void add(Object value) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Object delete(int index) throws IndexOutOfBoundsException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean delete(Object value) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Object set(int index, Object value) throws IndexOutOfBoundsException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object get(int index) throws IndexOutOfBoundsException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int indexOf(Object value) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean contains(Object value) {
		// TODO Auto-generated method stub
		return false;
	}
}