package Sortowanie;

public class BubbleSort1 extends Testy implements Sortowania {
	private final Comparator _comparator;

	public BubbleSort1(Comparator comparator) {
		_comparator = comparator;
	}

	// wynikiem jest posortowana lista pierwotna
	// wersja ulepszona wykorywaj�ca wcze�niejsze uporz�dkowanie
	public Object[] sort(Object[] list) {
		clear();
		_comparator.wyczycscPorownania();
		int lastSwap = list.length - 1; // pozycja ostatniej zamiany
		while (lastSwap > 0) {
			int end = lastSwap;
			lastSwap = 0;
			for (int left = 0; left < end; ++left) {
				if (_comparator.compare(list[left], list[left + 1]) > 0) { // ci�g
																					// zamian
																					// jest
																					// zast�piony
																					// ci�giem
																					// przepisa�
					Object temp = list[left];
					while (left < end && _comparator.compare(temp, list[left + 1]) > 0) {
						list[left]= list[left + 1];
						left++;
					}
					
					lastSwap = left;
					list[left] = temp;
					swapy++;
				}
			}

		}
		porownana=_comparator.getporownania();
		return list;
	}
}