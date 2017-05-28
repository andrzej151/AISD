package DrzewoBST;

public class MergeSort implements Sortowania {

	@Override
	public Object[] sort(Object[] Lists) {
		// TODO Auto-generated method stub
		return null;
	}
//	private final Comparator _comparator;
//
//	public MergeSort(Comparator comparator) {
//		_comparator = comparator;
//	}
//
//	// wynikiem jest nowa lista
//	@Override
//	public Object[] sort(Object[] Lists){ 
//		return mergesort(Lists, 0, Lists.length - 1);
//	}
//
//	private Object[] mergesort(Object[] list, int startIndex, int endIndex) {
//		if (startIndex == endIndex) {
//			Object[] result = new Object[startIndex];
//			result.add(list.get(startIndex));
//			return result;
//		}
//		int splitIndex = startIndex + (endIndex - startIndex) / 2;
//		return merge(mergesort(list, startIndex, splitIndex), mergesort(list, splitIndex + 1, endIndex));
//	}
//
//	private List merge(List left, List right) {
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