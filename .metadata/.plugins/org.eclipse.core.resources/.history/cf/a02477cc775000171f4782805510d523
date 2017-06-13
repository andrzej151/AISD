package Grafy;

import java.util.Scanner;



public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner odczyt = new Scanner(System.in);
		int decyzja = 0;
		int pom, pom2;
		Zbior z= new Zbior();

		do {
			z.metody();
			decyzja = odczyt.nextInt();
			switch (decyzja) {
			case 1: {
				System.out.println("co wpisac");
				pom = odczyt.nextInt();
				z.MAKE_SET(pom);
			

			}
				break;

			case 2: {
				z.wyswietl();
			}
				break;

			case 3: {
				z.wyswietl();
				System.out.println("Co po³aczyc (nr pozycji)");
				pom = odczyt.nextInt();
				System.out.println("z czym nr pozycji");
				pom2 = odczyt.nextInt();
				z.UNION(pom,pom2);
				z.wyswietl();

			}
				break;
			case 4: {
			
				z.wyswietl();
				System.out.println("Co po³aczyc (wartosc)");
				pom = odczyt.nextInt();
				System.out.println("z czym (wartosc");
				pom2 = odczyt.nextInt();
				z.UNION(z.FIND(pom),z.FIND(pom2));
				z.wyswietl();

			}
				break;
			case 5: {

			}
				break;

			case 6: {
				
				System.out.println("Co znalesæ");
				pom = odczyt.nextInt();
				System.out.println(z.FIND(pom));

			}
				break;

			case 7: {
				for(int i = 0 ;i<4;i++ )
				z.MAKE_SET(i);
				z.UNION(0, 1);
				z.UNION(0, 2);
				z.UNION(1, 2);
				z.UNION(2, 3);
				
				
		
			}
				break;

			case 8: {
				

			}
				break;

//
			default:
				break;
			}

		} while (decyzja != 0);
		
		

	}

}
