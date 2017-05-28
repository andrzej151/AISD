package Sortowanie;
public final class WiekComparator implements Comparator {
	// wykorzystuje wzorzec singleton
	public static final WiekComparator INSTANCE = new WiekComparator();

	private WiekComparator() {
	}

	public int compare(Object left, Object right) throws ClassCastException {
		if (((Osoba) left).getWiek() == ((Osoba) right).getWiek()) {
			return 0;
		} else {
			if (((Osoba) left).getWiek() < ((Osoba) right).getWiek()) {
				return -1;
			} else {
				return 1;

			}
		}
	}
}