package Grafy;


	import java.util.LinkedList;

	public class MatrixGraph implements Graph {
	    private boolean visited[];
	    private boolean map[][];

	    public MatrixGraph(int numberOfNodes) {
	        map = new boolean[numberOfNodes][numberOfNodes];
	        for (int i = 0; i < map.length; i++) map[i][i] = true;
	        visited = new boolean[numberOfNodes];
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
	        for (int i = 0 ; i < map.length; i++) {
	            if (!visited[i])
	                System.out.println(traverseAndAdd(i));
	        }
	    }

	    private LinkedList<Integer> traverseAndAdd(int current) {
	        LinkedList<Integer> result = new LinkedList<>();
	        if (visited[current]) return result;
	        result.add(current);
	        visited[current] = true;

	        for (int i = 0; i < map[current].length; i++) {
	            if (map[current][i])
	                result.addAll(traverseAndAdd(i));
	        }

	        return result;
	    }

	    public void printInner () {
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
	                System.out.printf("%3d", map[i][j] ? 1 : 0);
	            }
	        }
	        System.out.println();
	    }
	}
