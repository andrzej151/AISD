package DrzewoRB;

public final class IntComparator implements Comparator {
	// wykorzystuje wzorzec singleton
	public static final IntComparator INSTANCE = new IntComparator();
	private int porownania;

	private IntComparator() {

	}

	public int compare(Object left, Object right) throws ClassCastException {
		porownania++;
		return (Integer) left - (Integer) right;
	}

	public int getporownania() {
		return porownania;
	}

	public void wyczycscPorownania() {
		porownania = 0;
	}

}