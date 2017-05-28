package SortowanieKopcowe;
/**
 * 
 */

/**
 * @author andrz
 *
 */
public class InsertSort {
	
	private final Comparator _comparator;

	public InsertSort(Comparator comparator) {
		_comparator = comparator;
	}

	public Object[] sort(Object[] list) {
		for (int i = 1; i < list.length; ++i) {
			Object value = list[i], temp;
			int j;
			for (j = i; j > 0 && _comparator.compare(value, temp = list[j - 1]) < 0; --j)
				list[j]= temp;
			list[j] = value;
		}
		return list;
	}
}