package MinDrzewoRozp;

import java.util.LinkedList;

public class Lista implements Graph {
	private boolean[] visited;
	private LinkedList<Integer>[] map;

	public Lista(int numberOfNodes) {
		map = new LinkedList[numberOfNodes];
		for (int i = 0; i < map.length; i++)
			map[i] = new LinkedList<>();
		visited = new boolean[numberOfNodes];
	}

	public void add(int a, int b) {
		if (!map[a].contains(b))
			map[a].add(b);
		if (!map[b].contains(a))
			map[b].add(a);
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
		LinkedList<Integer> connectionList = new LinkedList<>();
		connectionList.add(current);
		visited[current] = true;
		for (Integer el : map[current])
			if (!visited[el])
				connectionList.addAll(visited(el));
		return connectionList;
	}

	public void wyswietl() {
		for (int i = 0; i < map.length; i++)
			System.out.printf("%3d: %s\n", i, map[i]);
	}
}