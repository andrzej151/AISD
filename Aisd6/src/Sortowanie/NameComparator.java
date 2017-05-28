package Sortowanie;

public final class NameComparator implements Comparator {
	// wykorzystuje wzorzec singleton
	public static final NameComparator INSTANCE = new NameComparator();

	private NameComparator() {
	}

	public int compare(Object left, Object right) throws ClassCastException {
		return ((Osoba) left).getNazwisko().compareTo(((Osoba) right).getNazwisko());
	}
}

