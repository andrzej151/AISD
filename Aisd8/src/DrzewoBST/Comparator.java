package DrzewoBST;
public interface Comparator {
	public int compare(Object left, Object right) throws ClassCastException;
	public void wyczycscPorownania();
	public int getporownania();
}