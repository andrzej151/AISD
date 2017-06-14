package MinDrzewoRozp;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("lista sasiedztwa:\n");
		test(new Lista(4));

		System.out.println("Macierz sasiedztwa:\n");
		test(new Macierz(4));
	}

	private static void test(Graph graph) {
		graph.add(0, 1);
		graph.add(1, 2);
		graph.add(0, 2);
		graph.add(2, 3);

		graph.wyswietl();

		System.out.println("----------------------------------------------");
	}
}