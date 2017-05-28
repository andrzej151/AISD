package SortowanieKopcowe;
public final class ZlozonyComparator implements Comparator {
	// wykorzystuje wzorzec singleton
	public static final ZlozonyComparator INSTANCE = new ZlozonyComparator();

	private ZlozonyComparator() {
	}

	public int compare(Object left, Object right) throws ClassCastException {
		if (((Osoba) left).getImie().compareTo(((Osoba) right).getImie()) == 0) {
			if (((Osoba) left).getNazwisko().compareTo(((Osoba) right).getNazwisko()) == 0) {

				if (((Osoba) left).getWiek() == (((Osoba) right).getWiek())) {
					return 0;
				} else {
					if (((Osoba) left).getWiek() < (((Osoba) right).getWiek())) {
						return -1;
					} else {
						return 1;

					}
				}

			} else {
				return ((Osoba) left).getNazwisko().compareTo(((Osoba) right).getNazwisko());
			}
		} else {
			return ((Osoba) left).getImie().compareTo(((Osoba) right).getImie());
		}
	}
}