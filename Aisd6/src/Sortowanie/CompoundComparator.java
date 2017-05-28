package Sortowanie;
import java.util.ArrayList;

public class CompoundComparator implements Comparator {
	// tablica komparatorów ; od najwa¿niejszego
	private ArrayList<Comparator> _comparators = new ArrayList();
	
	public CompoundComparator() {
		_comparators = new ArrayList<Comparator>();
	}

	public void addComparator(Comparator comparator) {
		_comparators.add(comparator);
	}

	public int compare(Object left, Object right) throws ClassCastException {
		int result = 0;
		for (Comparator comparator : _comparators) {
			if(result!=comparator.compare(left, right))
			{
				result = comparator.compare(left, right);
				return result;
			}
		}
	
		return result;
	}
}