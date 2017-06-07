package Grafy;

import java.util.LinkedList;

public class Zbior {
	
	private LinkedList<Node> lista;
	
	public Zbior()
	{
		lista= new LinkedList<>();
	}
	
	
	public void MAKE_SET(int x) {
		Node n = new Node(x);
		lista.add(n);
	}
	

	
	public void MAKE_SET(Node x) {
		x.parent = x;
		x.height = 0;
	}
	
	void UNION(int x, int y) {
		LINK(lista.get(x), lista.get(y));
	}


	void UNION(Node x, Node y) {
		LINK(FIND(x), FIND(y));
	}

	void LINK(Node x, Node y) {
		if (x.height > y.height)
			y.parent = x;

		else {
			x.parent = y;

			if (x.height == y.height)
				y.height++;
		}
	}
	Node FIND(int y) {
		Node x= new Node(y);
		return x == x.parent ? x : FIND(x.parent);

	}

	Node FIND(Node x) {
		return x == x.parent ? x : FIND(x.parent);

	}
	

	public void wyswietl() {
		int i=0;
		System.out.println();
		for(Node n:lista)
		{
			System.out.println("["+i+"] "+n);
			i++;
		}
	}
	
	
	class Node {
		public Node parent;
		public int value;
		public int height;

		public Node() {
			parent = this;
			height = 0;
		}

		public Node(int _value) {
			parent = this;
			height = 0;
			value = _value;
		}

		@Override
		public String toString() {
			// TODO Auto-generated method stub
			String s = "";
			
			if(parent == this)
			{
				return s=s+"("+value+")";
			}
			else
			{
				return s=s+value+"=>"+parent;
			}
		}
	}


	public void metody() {
		// TODO Auto-generated method stub
		System.out.println("1 - Utworz wezel" );
		System.out.println("2 - wyswiet liste sasiedztwa" );
		System.out.println("3 - polacz pozycja" );
		System.out.println("4 - polacz wartosc" );
		System.out.println("5 - macierz sasiedztwa" );
		System.out.println("6 - find" );
		System.out.println("7 - 10 wezlow" );
		
	}
}
