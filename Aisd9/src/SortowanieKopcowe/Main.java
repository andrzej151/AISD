package SortowanieKopcowe;

import java.util.Random;



/*
 * author AndrzejD
 */
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println("");
		Random gen = new Random();
		int w = 10;

		int[] tabl = new int[w];

		for (int i = 0; i < w; i++) {
			tabl[i] = gen.nextInt(100);
		}

		for (int i = 0; i < tabl.length; i++) {
			System.out.print(tabl[i] + " ");
		}
		System.out.println("");
		System.out.println();
		HeapSort sortowanie = new HeapSort();
		tabl = sortowanie.sortmalejaco(tabl);

		for (int i = 0; i < tabl.length; i++) {
			System.out.println(tabl[i]);
		}

		Osoba[] tab = new Osoba[5];

		InsertSort insertsort;
		// komparatory proste
		// po nazwisku
		NameComparator nazwisko = NameComparator.INSTANCE;
		// po wieku
		WiekComparator wiek = WiekComparator.INSTANCE;
		// po imieniu
		ImieComparator imie = ImieComparator.INSTANCE;
		
		CompoundComparator zlozonyA = new CompoundComparator();
		zlozonyA.addComparator(nazwisko);
		zlozonyA.addComparator(imie);
		zlozonyA.addComparator(wiek);
		
		SortedPriorityQueue q = new SortedPriorityQueue(zlozonyA);
		UnsortedPriorityQueue ns = new UnsortedPriorityQueue(zlozonyA);
		// nowa tablica
				System.out.println("\n Dodajemy kolejka priorytetowa posortowana i nieposortowana");
				tab = new Osoba[10];
				tab[0] = new Osoba("Dandys", "Ilona", 21);
				tab[1] = new Osoba("Zlikaricz", "Zygmunt", 24);
				tab[2] = new Osoba("Abulabas", "Adam", 28);
				tab[3] = new Osoba("Wesolowska", "Anna", 23);
				tab[4] = new Osoba("Dolna", "Honorata", 23);
				tab[5] = new Osoba("Dandys", "Ilona", 22);
				tab[6] = new Osoba("Zlikaricz", "Zygmunt", 23);
				tab[7] = new Osoba("Abulabas", "Adam", 27);
				tab[8] = new Osoba("Wesolowska", "Anna", 26);
				tab[9] = new Osoba("Dolna", "Honorata", 26);
				for (int i = 0; i < tab.length; i++) {
					System.out.println(tab[i]);
					q.enqueue(tab[i]);
					ns.enqueue(tab[i]);
				}

				System.out.println();
				System.out.println("priorytetowa posortowana");
				for (int i = 0; i < tab.length; i++) {
					try {
						System.out.println(q.dequeue());
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				
				System.out.println();
				System.out.println("priorytetowa nieposortowana");
				for (int i = 0; i < tab.length; i++) {
					try {
						System.out.println(ns.dequeue());
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				

	}
}
