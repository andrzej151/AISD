package Grafy;

import java.util.LinkedList;

public class Macierz implements Graph {
	private boolean visited[];
	private boolean map[][];

	public Macierz(int ilosc) {
		map = new boolean[ilosc][ilosc];
		for (int i = 0; i < map.length; i++)
			map[i][i] = true;
		visited = new boolean[ilosc];
	}

	public void add(int a, int b) {
		map[a][b] = true;
		map[b][a] = true;
	}

	private void clearVisited() {
		for (int i = 0; i < visited.length; i++)
			visited[i] = false;
	}

	public void printConnections() {
		clearVisited();
		for (int i = 0; i < map.length; i++) {
			if (!visited[i])
				System.out.println(visited(i));
		}
	}

	private LinkedList<Integer> visited(int current) {
		LinkedList<Integer> result = new LinkedList<>();
		if (visited[current])
			return result;
		result.add(current);
		visited[current] = true;

		for (int i = 0; i < map[current].length; i++) {
			if (map[current][i])
				result.addAll(visited(i));
		}

		return result;
	}

	public void wyswietl() {
		System.out.printf("     ");
		for (int i = 0; i < map.length; i++)
			System.out.printf("%3d", i);

		System.out.printf("\n     ");
		for (int i = 0; i < map.length; i++) {
			System.out.printf("%3s", "_");
		}

		for (int i = 0; i < map.length; i++) {
			System.out.printf("\n%3d |", i);
			for (int j = 0; j < map[i].length; j++) {
				if(i==j)
				System.out.printf("%3d",  0);
				else
				System.out.printf("%3d", map[i][j] ? 1 : 0);
			}
		}
		System.out.println();
	}
}
