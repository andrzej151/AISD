package Haszowanie;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		TabHasz h = new TabHasz();
		Student []tab = new Student[10];
		tab[0] = new Student(23444,"Adam","Wojak",5);
		tab[1] = new Student(23467,"Michal","Masek",5);
		tab[2] = new Student(23454,"Wojtek","Wojak",5);
		tab[3] = new Student(23445,"Janina","Masek",5);
		tab[4] = new Student(23744,"Ola","Wojak",5);
		tab[5] = new Student(23444,"Jola","Wojak",5);
		tab[6] = new Student(23844,"Tomek","Wojak",5);
		tab[7] =  new Student(28444,"Damian","Wojak",5);
		tab[8] =  new Student(23494,"Olek","Wojak",5);
		tab[9] =  new Student(23944,"Ewa","Abulabas",5);
		
		h.dump();
		for(int i = 0;i<tab.length-1; i++)
		{
			h.put(tab[i].getnazwisko(), tab[i]);
			h.dump();
		}
		System.out.println(h.get(tab[1].getnazwisko()));
		System.out.println(h.get(tab[4].getnazwisko()));
		System.out.println(h.get(tab[9].getnazwisko()));
		h.resize();
		System.out.println("hassz list");
		ListHash lh=new ListHash();
		lh.dump();
		for(int i = 0;i<tab.length-1; i++)
		{
			h.put(tab[i].getnrindexu(), tab[i]);
			h.dump();
		}


		
		

	}

}
