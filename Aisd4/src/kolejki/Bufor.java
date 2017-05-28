package kolejki;

public class Bufor implements Queue {
	Object[] tab;
	final int _size;
	int first;
	int last;
	int sizeA;

	public Bufor(int size) {
		_size = size;
		tab = new Object[_size];
		clear();
	}

	@Override
	public void enqueue(Object value) {
		// TODO Auto-generated method stub
		if (_size == sizeA) {
			System.out.println("pelna");
		} else {
			tab[last] = value;
			if (last < _size - 1) {
				last++;
			} else {
				last = 0;
			}
			sizeA++;
			// System.out.println(first+" "+last);
		}
	}

	@Override
	public Object dequeue() throws EmptyQueueException {
		if (size() == 0) {
			System.out.println("pusta");
			throw new EmptyQueueException();
		} else {
			Object e = tab[first];
			if (first < _size - 1) {
				first++;
			} else {
				first = 0;
			}
			sizeA--;
			// System.out.println(first+" "+last);
			return e;
		}
	}

	@Override
	public void clear() {
		first = 0;
		last = 0;
		sizeA = 0;

	}

	public void wyswietl() {
		for (int i = 0; i < sizeA; i++) {
			if (i + first < _size) {
				System.out.println("nr " + i + " poz w tb " + (i + first) + " " + tab[i + first]);
			} else {
				System.out.println("nr " + i + " poz w tb " + (i + first - _size) + " " + tab[i + first - _size]);
			}

		}
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return sizeA;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return sizeA == 0;
	}

}
