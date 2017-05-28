package Stos;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			Stosnieogr stosn = new Stosnieogr();
			stosn.wyswietl();
			stosn.push("chleb1");
			stosn.push("chleb2");
			stosn.push("chleb3");
			stosn.wyswietl();
			System.out.println(stosn.pop());
			stosn.wyswietl();
			System.out.println("perk " + stosn.peek());
			stosn.wyswietl();
			System.out.println(stosn.pop());
			System.out.println("ost " + stosn.pop());
			stosn.wyswietl();

			System.out.println("Ograniczony");
			Stostab st = new Stostab(5);
			st.push("chleb1");
			st.push("chleb2");
			st.push("chleb3");
			st.push("chleb4");
			st.push("chleb5");
			st.push("chleb6");
			System.out.println(st.pop());
			System.out.println(st.pop());
			System.out.println(st.pop());
			System.out.println(st.pop());

			Scanner odczyt = new Scanner(System.in);
			String elem = "0";
			Stosnieogr odw = new Stosnieogr();
			do {
				System.out.println("Podaj zdanie do odwrotu 0-konczy program");
				elem = odczyt.nextLine();
				if (!elem.equals("0")) {
					odw.clear();
					for (String el : elem.split(" ")) {
						odw.push(el);
					}

				}
				while (!odw.isEmpty()) {
					System.out.print(odw.pop()+" ");
				}
				System.out.println();

			} while (!elem.equals("0"));

		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}
