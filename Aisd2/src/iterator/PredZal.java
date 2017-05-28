package iterator;

public class PredZal implements Predicate{

	@Override
	public boolean accept(Object ob) {
		return ((Student)ob).getocena()>2;
		
	}

}
