package Haszowanie;

public interface Hasz {
	public Object get(int k);
	public void put(int k, Object v);
	public Boolean containsKey(int k);
	public int size();
	public Boolean isEmpty();
	public void resize();
	public void dump();

}
