package iterator;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class Zadanie {
	Student[] tab;
	int rozm;

	public Zadanie()
	{
		tab=null;
		rozm=0;
	}
	public void wczytaj(String nazwa )
	{
		try {
			Scanner odczyt = new Scanner(new FileReader(nazwa));
			rozm = odczyt.nextInt();
			tab = new Student[rozm];
			for (int i = 0; i < rozm; i++) {
				tab[i] = new Student();
				tab[i].wczytaj(odczyt);
			}
			odczyt.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void wyswietlanie()
	{
		Iterator it = new ArrayIterator(tab, 0, rozm);
		
		System.out.println("Lista studentow");
		
		it.first();
		while (!it.isDone()) {
			System.out.println(it.current());
			it.next();
		}
		
		System.out.println();
	}
	
	public void srednia()
	{
		Iterator it = new ArrayIterator(tab, 0, rozm);	
		Iterator itzal = new FilterIterator(it, new PredZal()); 
		int sr=0;
		int ilo=0;
		System.out.println("srednia");
		
		itzal.first();
		while (!itzal.isDone()) {
			sr+=((Student)itzal.current()).getocena();
			ilo++;
			itzal.next();
		}
		System.out.println(sr/ilo);
		
	}
	public void niezal() {
		System.out.println("Nie zaliczyli");
		Iterator it = new ArrayIterator(tab, 0, rozm);	
		Iterator itNzal = new FilterIterator(it, new PredNzal()); 
		
		itNzal.first();
		while (!itNzal.isDone()) {
			System.out.println(itNzal.current());
			itNzal.next();
		}
		
		
	}
	public void zmien(int index, int ocena) {
		
Iterator it = new ArrayIterator(tab, 0, rozm);
		
		System.out.println("Zmieniam ");
		
		it.first();
		while (!it.isDone()) {
			Student s=(Student)it.current();
			if((s.getnrindexu()==index))
			{
				System.out.println(s+" na "+ocena); 
				s.setocena(ocena);
			}
			it.next();
		}
		System.out.println();
		
	}
	
}
