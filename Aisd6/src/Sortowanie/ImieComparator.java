package Sortowanie;

public final class ImieComparator implements Comparator {
	// wykorzystuje wzorzec singleton
	public static final ImieComparator INSTANCE = new ImieComparator();

	private ImieComparator() {
	}

	public int compare(Object left, Object right) throws ClassCastException {
		return ((Osoba) left).getImie().compareTo(((Osoba) right).getImie());
	}
}