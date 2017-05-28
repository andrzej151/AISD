package WysukiwanieBinarne;

import java.util.Random;
import java.util.Scanner;

/*
 * author AndrzejD
 */

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner odczyt = new Scanner(System.in);
		int decyzja = 0;
		int pom;
		Wyszukiwanie w = new Wyszukiwanie();
		do {
			w.metody();
			decyzja = odczyt.nextInt();
			switch (decyzja) {
			case 1: {
				w.generuj();
				w.wyswietl();
			}
				break;
				
			case 2: {
				System.out.println("Podaj ilosc prub");
				pom = odczyt.nextInt();
				w.setLiczba_prub(pom);
			}
				break;
				
			case 3: {
				System.out.println("Podaj wielkosc tab");
				pom = odczyt.nextInt();
				w.setWielkosc_tab(pom);
				System.out.println("Podaj zakres tab");
				pom = odczyt.nextInt();
				w.setZakres_wartosci(pom);
			
			}
				break;
			case 4: {
				System.out.println("Podaj wielkosc tab");
				pom = odczyt.nextInt();
				w.setWielkosc_tab(pom);
				System.out.println("Podaj zakres tab");
				pom = odczyt.nextInt();
				w.setZakres_wartosci(pom);
				System.out.println("Podaj ilosc prub");
				pom = odczyt.nextInt();
				w.setLiczba_prub(pom);
				
				w.generuj();
				w.wyswietl();
				w.test();
			
			}
				break;
			case 5: {
				System.out.println("Wyszukiwanie liniowe \nPodaj co znalesc");
				pom = odczyt.nextInt();
				if (w.wyszukiwanieliniowe(pom)) {
					System.out.println("Znaleziono");
				} else {
					System.out.println("NIE Znaleziono");
				}

			}
				break;

			case 6: {
				System.out.println("Wyszukiwanie binarne \nPodaj co znalesc");
				pom = odczyt.nextInt();

				if (w.wyszukiwaniebinarne(pom)) {
					System.out.println("Znaleziono");
				} else {
					System.out.println("NIE Znaleziono");
				}

			}
				break;

			case 7:{
				w.test();
			}
				break;
			default:
				break;
			}

		} while (decyzja != 0);
	}

}
