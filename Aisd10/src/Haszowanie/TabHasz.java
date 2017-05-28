package Haszowanie;

public class TabHasz implements Hasz{

	private Object [] tab;
	private int size;
	
	public  TabHasz() {
		// TODO Auto-generated constructor stub
		tab = new Object[13];
		size = 0;
	}
	
	@Override
	public Object get(int k) {
		// TODO Auto-generated method stub
		int kl=k%tab.length;
		int i =1;
		while(tab[kl]!=null&&kl!=((Student)tab[kl]).getnrindexu())
		{
			kl=(kl+i*i)%tab.length;
			i++;
		}
		
		return tab[kl];
	}
	
	public int getpoz(int k) {
		// TODO Auto-generated method stub
		int kl=k%tab.length;
		
		return kl;
	}

	@Override
	public void put(int k, Object v) {
		// TODO Auto-generated method stub
		int kl=k%tab.length;
		int i =1;
		while(tab[kl]!=null)
		{
			kl=(kl+i*i)%tab.length;
			i++;
		}
		size++;
		tab[kl]=v;
		
	}

	@Override
	public Boolean containsKey(int k) {
		// TODO Auto-generated method stub
		return tab[k]!=null;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return size;
	}

	@Override
	public Boolean isEmpty() {
		// TODO Auto-generated method stub
		return size==0;
	}

	@Override
	public void resize() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void dump() {
		// TODO Auto-generated method stub
		for(int i = 0;i<tab.length;i++)
		{
			if(tab[i]==null)
			{
				System.out.print("* ");
			}
			else
			{
				System.out.print(i+" ");
			}
		}
		System.out.println("");
	}
	
	

}