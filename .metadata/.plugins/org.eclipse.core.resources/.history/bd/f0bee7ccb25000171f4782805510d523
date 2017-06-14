package Grafy;


import java.util.LinkedList;

public class NeighbourhoodListGraph implements Graph {
    private boolean[] visited;
    private LinkedList<Integer>[] map;

    public NeighbourhoodListGraph(int numberOfNodes) {
        map = new LinkedList[numberOfNodes];
        for (int i = 0; i < map.length; i++)
            map[i] = new LinkedList<>();
        visited = new boolean[numberOfNodes];
    }

    public void add (int a, int b) {
        if (!map[a].contains(b)) map[a].add(b);
        if (!map[b].contains(a)) map[b].add(a);
    }

    private void clearVisited() {
        for (int i = 0; i < visited.length; i++)
            visited[i] = false;
    }

    public void printConnections() {
        clearVisited();
        for (int i = 0; i < map.length; i++) {
            if (!visited[i])
                System.out.println(traverseAndAdd(i));
        }
    }

    private LinkedList<Integer> traverseAndAdd (int current) {
        LinkedList<Integer> connectionList = new LinkedList<>();
        connectionList.add(current);
        visited[current] = true;
        for (Integer el : map[current])
            if (!visited[el])
                connectionList.addAll(traverseAndAdd(el));
        return connectionList;
    }

    public void printInner () {
        for (int i = 0; i < map.length; i++)
            System.out.printf("%3d: %s\n", i, map[i]);
    }
}