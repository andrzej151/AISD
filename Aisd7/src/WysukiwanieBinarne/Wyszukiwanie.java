package WysukiwanieBinarne;

import java.util.Random;

public class Wyszukiwanie {
	private Integer[] tab;
	private Comparator licz;
	private InsertSort insert;
	private int wielkosc_tab, zakres_wartosci, liczba_prub;
	private int porBinNZnal, porBinZnal, porLinZnal, porLinNZnal;
	private int bznalezione, bnie_znalezione,lznalezione, lnie_znalezione;

	public int getWielkosc_tab() {
		return wielkosc_tab;
	}

	public void setWielkosc_tab(int wielkosc_tab) {
		this.wielkosc_tab = wielkosc_tab;
	}

	public int getZakres_wartosci() {
		return zakres_wartosci;
	}

	public void setZakres_wartosci(int zakres_wartosci) {
		this.zakres_wartosci = zakres_wartosci;
	}

	public int getLiczba_prub() {
		return liczba_prub;
	}

	public void setLiczba_prub(int liczba_prub) {
		this.liczba_prub = liczba_prub;
	}

	public Wyszukiwanie() {
		// TODO Auto-generated constructor stub

		licz = IntComparator.INSTANCE;
		insert = new InsertSort(licz);
		reset();
		liczba_prub=20;

	}

	public void reset() {
		porBinNZnal = 0;
		porBinZnal = 0;
		porLinZnal = 0;
		porLinNZnal = 0;
		bznalezione = 0;
		bnie_znalezione = 0;
		lznalezione = 0;
		lnie_znalezione = 0;
	}

	public void generuj() {
		Random gen = new Random();
		tab = new Integer[wielkosc_tab];
		for (int i = 0; i < wielkosc_tab; i++) {
			tab[i] = gen.nextInt(zakres_wartosci);
		}

	}

	public void metody() {
		// TODO Auto-generated method stub
		System.out.println("1 - generuj");
		System.out.println("2 - ilosc prub");
		System.out.println("3 - wielkosc i zakres tablicy");
		System.out.println("4 - Automat");
		System.out.println("5 - wyszukiwanie liniowe");
		System.out.println("6 - wyszukiwanie binarne");
		System.out.println("7 - testy");
		System.out.println("0 - koniec");
	}

	public void wyswietl() {
		// TODO Auto-generated method stub
		System.out.println();
		for (int i = 0; i < wielkosc_tab; i++) {
			System.out.print(tab[i] + " ");
		}
		System.out.println();

	}

	public boolean wyszukiwanieliniowe(int szuk) {
		// TODO Auto-generated method stub
		int i = 0;
		while (i < tab.length && tab[i] != szuk) {
			i++;
		}
		if (i < tab.length) {
			System.out.println("Znaleziono na poz " + i);
			porLinZnal+=i;
			lznalezione++;
		}
		else
		{
			porLinNZnal+=i;
			lnie_znalezione++;
		}
		return i < tab.length;

	}

	public boolean wyszukiwaniebinarne(int szuk) {
		// TODO Auto-generated method stub
		int porownania=0;

		insert.sort(tab);
	
		int left = 0, right = tab.length - 1, sr = tab.length / 2;
		
		while ((((right - left) / 2 + 1) > 1) && (tab[sr] != szuk)) {
			if (tab[sr] < szuk) {
				left = sr;
				sr = (right - left) / 2 + left;
			} else {
				right = sr;
				sr = (right - left) / 2 + left;
			}
			porownania++;
			System.out.println(left + " " + sr + " " + right);
		}
		System.out.println(left + " " + sr + " " + right);
		
		if(tab[left] == szuk || tab[sr] == szuk || tab[right] == szuk)
		{
			porBinZnal=porBinZnal+porownania;
			bznalezione++;
		}
		else
		{
			porBinNZnal=porBinNZnal+porownania;
			bnie_znalezione++;
		}
		return tab[left] == szuk || tab[sr] == szuk || tab[right] == szuk;

	}
	
	public void test()
	{
		Random gen = new Random();
		int szukane;
		for(int i=0;i<liczba_prub;i++)
		{
			szukane=gen.nextInt(zakres_wartosci);
			wyszukiwanieliniowe(szukane);
			wyszukiwaniebinarne(szukane);
		}
		raport();
	}
	
	public void raport()
	{
		System.out.println("Znaleziono wyszukiwaniem liniowym "+lznalezione);
		System.out.println("Œrednia liczba porownan "+porLinZnal+"/"+lznalezione+"="+((double)porLinZnal/(double)lznalezione));
		System.out.println("Nie Znaleziono wyszukiwaniem liniowym "+lnie_znalezione);
		System.out.println("Œrednia liczba porownan "+porLinNZnal+"/"+lnie_znalezione+"="+((double)porLinNZnal/(double)lnie_znalezione));
		System.out.println("Znaleziono wyszukiwaniem binarnym "+bznalezione);
		System.out.println("Œrednia liczba porownan "+porBinZnal+"/"+bznalezione+"="+((double)porBinZnal/(double)bznalezione));
		System.out.println("Nie Znaleziono wyszukiwaniem binarnym "+bnie_znalezione);
		System.out.println("Œrednia liczba porownan "+porBinNZnal+"/"+bnie_znalezione+"="+((double)porBinNZnal/(double)bnie_znalezione));
	}

}
