package Sortowanie;

/*
 * author AndrzejD
 */
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Osoba[] tab = new Osoba[5];

		InsertSort insertsort;
		// komparatory proste
		// po nazwisku
		NameComparator nazwisko = NameComparator.INSTANCE;
		// po wieku
		WiekComparator wiek = WiekComparator.INSTANCE;
		// po imieniu
		ImieComparator imie = ImieComparator.INSTANCE;
		// zlorzony funkcja
		ZlozonyComparator zlozonyf = ZlozonyComparator.INSTANCE;
		// z³orzony z podstawowych na ArrayList
		CompoundComparator zlozonyA = new CompoundComparator();
		zlozonyA.addComparator(nazwisko);
		zlozonyA.addComparator(imie);
		zlozonyA.addComparator(wiek);

		System.out.println("\n Nieposotrowana");
		tab[0] = new Osoba("Dandys", "Ilona", 21);
		tab[1] = new Osoba("Zlikaricz", "Zygmunt", 24);
		tab[2] = new Osoba("Abulabas", "Adam", 28);
		tab[3] = new Osoba("Wesolowska", "Anna", 23);
		tab[4] = new Osoba("Dolna", "Honorata", 23);
		for (int i = 0; i < tab.length; i++) {
			System.out.println(tab[i]);
		}
		System.out.println("\n posotrowana po nazwisku prosty");

		InsertSort sortowanie = new InsertSort(nazwisko);
		tab = (Osoba[]) sortowanie.sort(tab);
		for (int i = 0; i < tab.length; i++) {
			System.out.println(tab[i]);
		}

		// nowa tablica
		System.out.println("\n Nieposotrowana");
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
		}

		System.out.println("\nComparator zlozony z prostych na ArrayList");
		sortowanie = new InsertSort(zlozonyA);
		tab = (Osoba[]) sortowanie.sort(tab);
		for (int i = 0; i < tab.length; i++) {
			System.out.println(tab[i]);
		}

		// nowa tablica
		System.out.println("\n Nieposotrowana");
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
		}

		System.out.println("\nComparator zlozony z prostych na funkcji");
		sortowanie = new InsertSort(zlozonyf);
		tab = (Osoba[]) sortowanie.sort(tab);
		for (int i = 0; i < tab.length; i++) {
			System.out.println(tab[i]);
		}

	}
}
