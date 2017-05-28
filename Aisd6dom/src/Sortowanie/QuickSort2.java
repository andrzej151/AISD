package Sortowanie;

public class QuickSort2 extends Testy implements Sortowania {
	private final Comparator _comparator;

	public QuickSort2(Comparator comparator) {
		_comparator = comparator;
	}

	// wynikiem jest posortowana oryginalna lista
	public Object[] sort(Object[] list) {
		clear();
		_comparator.wyczycscPorownania();
		quicksort(list, 0, list.length - 1);
		porownana = _comparator.getporownania();
		return list;
	}

	private void quicksort(Object[] list, int startIndex, int endIndex) {
		if (endIndex > startIndex) {
			// jako element dziel¹cy bierzemy ostatni
			Object value = list[endIndex];
			int partition = partition(list, value, startIndex, endIndex - 1);
			if (_comparator.compare(list[partition], value) < 0)
				++partition;
			swap(list, partition, endIndex);
			quicksort(list, startIndex, partition - 1);
			quicksort(list, partition + 1, endIndex);
		}
	}

	// styl!!
	private int partition(Object[] list, Object value, int left, int right) {
		while (left < right) {
			if (_comparator.compare(list[left], value) < 0) {
				++left;
				continue;
			}
			if (_comparator.compare(list[right], value) >= 0) {
				--right;
				continue;
			}
			swap(list, left, right);
			++left;
		}
		return left;
	}

	private void swap(Object[] list, int left, int right) {
		if (left != right) {
			Object temp = list[left];
			list[left] = list[right];
			list[right] = temp;
		}
		swapy++;
	}
}