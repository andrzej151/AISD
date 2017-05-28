package iterator;

public class ReverseIterator implements Iterator {
	private final Iterator _it;

	public ReverseIterator(Iterator it) {
		_it = it;
	}

	public void first() {
		_it.last();
	}

	public void last() {
		_it.first();
	}

	public void next() {
		_it.previous();
	}

	public void previous() {
		_it.next();
	}

	public boolean isDone() {
		return _it.isDone();
	}

	public Object current() {
		return _it.current();
	}
}