package WysukiwanieBinarne;

public class MergeSort {
	private final Comparator _comparator;

	public MergeSort(Comparator comparator) {
		_comparator = comparator;
	}

	// wynikiem jest nowa lista
	public Object[] sort(Object[] list) {
		return mergesort(list, 0, list.length - 1);
	}

	private Object[] mergesort(Object[] list, int startIndex, int endIndex) {
		return list;
	}
//		if (startIndex == endIndex) {
//			Object[] result = new ArrayList();
//			result[]list[startIndex]);
//			return result;
//		}
//		int splitIndex = startIndex + (endIndex - startIndex) / 2;
//		return merge(mergesort(list, startIndex, splitIndex), mergesort(list, splitIndex + 1, endIndex));
//	}
//
//	private Aisd7 merge(List left, List right) {
//		List result = new ArrayList();
//		Iterator l = left.iterator();
//		Iterator r = right.iterator();
//		l.first();
//		r.first();
//		while (!l.isDone() && !r.isDone()) {
//			if (_comparator.compare(l.current(), r.current()) <= 0) {
//				result.add(l.current());
//				l.next();
//			} else {
//				result.add(r.current());
//				r.next();
//			}
//		}
//		while (!l.isDone()) {
//			result.add(l.current());
//			l.next();
//		}
//		while (!r.isDone()) {
//			result.add(r.current());
//			r.next();
//		}
//		return result;
//	}
}
