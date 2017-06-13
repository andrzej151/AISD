package Grafy;

import java.util.Scanner;



public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 System.out.println("Tablica linked list:\n");
	        test(new NeighbourhoodListGraph(10));

	        System.out.println("Macierz sasiedztwa:\n");
	        test(new MatrixGraph(10));
	    }

	    private static void test (Graph graph) {
	        graph.add(1, 2);
	        graph.add(1, 3);
	        graph.add(3, 4);
	        graph.add(5, 6);
	        graph.add(6, 7);
	        graph.add(9, 0);
	        graph.printInner();
	        System.out.println();
	        graph.printConnections();
	        System.out.println("----------------------------------------------");
	    }
}