package Sortowanie;

public class BubbleSort extends Testy implements Sortowania{
	private final Comparator _comparator;

	public BubbleSort(Comparator comparator) {
		_comparator = comparator;
	}

	// wynikiem jest posortowana lista pierwotna
	// najbardziej prymitywna wersja
	public Object[] sort(Object[] list) {
		clear();
		_comparator.wyczycscPorownania();
		int size = list.length;
		for (int pass = 1; pass < size; ++pass) {
			for (int left = 0; left < (size - pass); ++left) {
				int right = left + 1;
				if (_comparator.compare(list[left], list[right]) > 0)
					swap(list, left, right);
			}
		}
		porownana = _comparator.getporownania(); 
		return list;
	}

	private void swap(Object[] list, int left, int right) {
		swapy++;
		Object temp = list[left];
		list[left] = list[right];
		list[right] = temp;
	}
}