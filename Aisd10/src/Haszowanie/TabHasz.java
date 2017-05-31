package Haszowanie;

public class TabHasz {

	private Object [] tab;
	private int size;
	
	public  TabHasz() {
		// TODO Auto-generated constructor stub
		tab = new Object[13];
		size = 0;
	}
	

	public Object get(Object k) {
		// TODO Auto-generated method stub
		
		int kl=k.hashCode()%tab.length;
		int i =1;
		while(tab[kl]!=null)
		{
			if(k.equals(((Student)tab[kl]).getnazwisko()))
			{
				return tab[kl];
			}
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


	public void put(Object k, Object v) {
		// TODO Auto-generated method stub
		int kl=v.hashCode()%tab.length;
		int i =1;
		while(tab[kl]!=null)
		{
			kl=(kl+i*i)%tab.length;
			i++;
		}
		size++;
		tab[kl]=v;
		
	}

	public Boolean containsKey(Object k) {
		// TODO Auto-generated method stub
		int kl=k.hashCode()%tab.length;
		int i =1;
		while(tab[kl]!=null)
		{
			if(k.equals(((Student)tab[kl]).getnazwisko()))
			{
				return true;
			}
			kl=(kl+i*i)%tab.length;
			i++;
		}
		
		return false;
	}

	public int size() {
		// TODO Auto-generated method stub
		return size;
	}

	public Boolean isEmpty() {
		// TODO Auto-generated method stub
		return size==0;
	}

	public void resize() {
		// TODO Auto-generated method stub
		
		Object [] t = tab;
		tab = new Object[tab.length*2+3];
		for(int i = 0;i<t.length;i++)
		{
			if(t[i]!=null)
			{
				put(((Student)t[i]).getnazwisko(),t[i]);
				dump();
			}
		}
		System.out.println("przepisano");
		
		
	}

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
