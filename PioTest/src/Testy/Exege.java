package Testy;

public class Exege 
{
	public Integer[] exchange(Integer []tab, Integer i, Integer j) 
	{
	
		
		Integer pom = tab[i];
		tab[i]=tab[j];
		tab[j]=pom;
		
		return tab;
	}

}