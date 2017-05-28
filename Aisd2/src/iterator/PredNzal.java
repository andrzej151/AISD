package iterator;


	public class PredNzal implements Predicate
	{

		@Override
		public boolean accept(Object ob) {
			
			return ((Student)ob).getocena()==2;
		}
		
	}

