package Sortowanie;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

public class PorownanieSortowan {

	private ArrayList<Sortowania> Asort;
	private ArrayList<String> nazwa;
	private int wielkosc;
	private Integer[] tablica, kopia;

	public PorownanieSortowan() {
		// TODO Auto-generated constructor stub
		Asort = new ArrayList<>();
		nazwa = new ArrayList<>();
		wielkosc = 0;
	}

	public void setWielkosc(int w) {
		wielkosc = w;
	}

	public void setSort(Sortowania sort, String naz) {
		Asort.add(sort);
		nazwa.add(naz);
	}

	private void copy() {
		kopia = new Integer[tablica.length];
		for (int i = 0; i < tablica.length; i++) {
			kopia[i] = tablica[i];
		}
	}

	private void generuj() {
		tablica = new Integer[wielkosc];
		Random gen = new Random();
		for (int i = 0; i < tablica.length; i++) {
			tablica[i] = gen.nextInt(1000);
		}

	}

	private void posortowana() {
		// TODO Auto-generated method stub
		for (int i = 0; i < tablica.length; i++) {
			tablica[i] = kopia[i];
		}

	}

	private void wyswietl() {
		// TODO Auto-generated method stub
		for (int i = 0; i < tablica.length; i++) {
			System.out.print(kopia[i] + " ");
		}
		System.out.println();

	}

	private void odwr() {
		// TODO Auto-generated method stub
		for (int i = 0; i < tablica.length; i++) {
			tablica[i] = kopia[tablica.length - i - 1];
		}

	}

	public String powrownaj(int w) {
		String raport = "";
		wielkosc = w;
		raport = "Wielkosc: " + wielkosc + "\n";
		generuj();
		int i = 0;
		for (Sortowania s : Asort) {
			copy();
			wyswietl();
			s.sort((Object[]) kopia);
			raport = raport + "Losowy " + nazwa.get(i) + "\nSwap: " + s.getswapy() + " Porownania: " + s.getporownania()
					+ "\n";
			wyswietl();
			i++;
		}
		posortowana();
		i = 0;
		for (Sortowania s : Asort) {
			copy();
			wyswietl();
			s.sort((Object[]) kopia);
			raport = raport + "Tablica posortowana " + nazwa.get(i) + "\nSwap: " + s.getswapy() + " Porownania: "
					+ s.getporownania() + "\n";
			wyswietl();
			i++;
		}
		odwr();
		i = 0;
		for (Sortowania s : Asort) {
			copy();
			wyswietl();
			s.sort((Object[]) kopia);
			raport = raport + "Tablica posortowana odwrotnie " + nazwa.get(i) + "\nSwap: " + s.getswapy()
					+ " Porownania: " + s.getporownania() + "\n";
			wyswietl();
			i++;
		}

		return raport;
	}

}
