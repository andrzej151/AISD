package DrzewoBST;

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

		DrzewoBST drzewo = new DrzewoBST();
		do {
			drzewo.metody();
			decyzja = odczyt.nextInt();
			switch (decyzja) {
			case 1: {
				pom = odczyt.nextInt();
				try {
					drzewo.insert(pom);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
				break;

			case 2: {
				drzewo.inOrder();

			}
				break;

			case 3: {
				drzewo.preOrder();

			}
				break;
			case 4: {
				drzewo.postOrder();

			}
				break;
			case 5: {
				System.out.println("co znalesc");
				pom = odczyt.nextInt();
				System.out.println(drzewo.find(pom) != null ? "znaleziono" : "nie znaleziono");

			}
				break;

			case 6: {
				System.out.println("Max: " + drzewo.max());
			}
				break;

			case 7: {
				System.out.println("Min: " + drzewo.min());
			}
				break;

			case 8: {
				try {
					drzewo.insert(35);
					drzewo.insert(60);
					drzewo.insert(15);
					drzewo.insert(20);
					drzewo.insert(43);
					drzewo.insert(8);
					drzewo.insert(50);
					drzewo.insert(82);
					drzewo.insert(70);
					drzewo.insert(30);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
				break;

			case 9: {
				System.out.println("czyjego nastepnika znalesc");
				pom = odczyt.nextInt();
				System.out.println("nastepnik: " + pom +" to ");
			}
				break;
			case 10: {
				System.out.println("czyjego poprzednika znalesc");
				pom = odczyt.nextInt();
				System.out.println("poprzednik: " + pom +" to ");
			}
				break;
			case 11: {
				System.out.println("Liczba wezlow: " + drzewo.lwezlow());
			}
				break;
			case 12: {
				System.out.println("Liczba wezlow wew: " + drzewo.lwezlowwew());
			}
				break;
			case 13: {
				System.out.println("Liczba wezlow: zew" + drzewo.lwezlowzew());
			}
				break;
			case 14: {
				System.out.println("Liczba lisci: " + drzewo.llisci());
			}
				break;
			case 15: {
				System.out.println("Wyswietlanie kluczy poziomami ");
				 drzewo.wyswietlpoziom();
			}
				break;
			case 16: {
				System.out.println("czyjego nastepnika znalesc");
				pom = odczyt.nextInt();
				drzewo.findnext(pom);
			}
				break;
			case 17: {
				System.out.println("czyjego poprzednika znalesc");
				pom = odczyt.nextInt();
				drzewo.findpop(pom);
			}
				break;
			case 18: {
				System.out.println("jaki klucz usunac");
				pom = odczyt.nextInt();
				drzewo.delete(pom);
			}
			case 19: {
				System.out.println("wysokosc "+drzewo.wysokosc());
				
			}
				break;
			default:
				break;
			}

		} while (decyzja != 0);
	}

}
