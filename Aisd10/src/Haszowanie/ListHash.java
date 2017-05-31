package Haszowanie;

import java.util.LinkedList;

public class ListHash {

	private LinkedList<Student>[] tab;
	
	public ListHash()
	{
		tab=new LinkedList[13];
		
	}
	
	public Object get(int k) {
		// TODO Auto-generated method stub
		return null;
	}

	
	public void put(int k, Student v) {
		// TODO Auto-generated method stub
		if(tab[k%tab.length]==null)
		{
			tab[k%tab.length]= new LinkedList<Student>();
			tab[k%tab.length].add(v);
		}
		
	}

	
	public Boolean containsKey(int k) {
		// TODO Auto-generated method stub
		return null;
	}

	
	public int size() {
		// TODO Auto-generated method stub
		return 0;
	}

	
	public Boolean isEmpty() {
		// TODO Auto-generated method stub
		return null;
	}


	public void dump() {
		// TODO Auto-generated method stub
		for(int i = 0;i<tab.length;i++)
		{
			if(tab[i]==null)
			{
				System.out.print("*\n");
			}
			else
			{
				for(Student s:tab[i])
				System.out.print(s+" ");
			}
		}
		System.out.println("");
	}
	

}
