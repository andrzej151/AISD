package DrzewoRB;

import java.util.Random;

public class DrzewoRB {
	static final boolean RED = true;
	static final boolean BLACK = false;

	private Node _root;
	private int[][] tab;
	int wysokosc;

	public DrzewoRB() {
		_root = null;
	}

	private boolean isRed(Node x) {
		return x != null && x.color == RED;
	}

	public int find(int x) {
		Node t = search(x);
		return t != null ? t.value : null;
	}

	private Node search(int value) {
		Node node = _root;
		int cmp = 0;
		while (node != null && (value != node.value))
			node = cmp < 0 ? node.left : node.right;
		return node;
	}

	private Node rotateL(Node t) {
		Node x = t.right;
		t.right = x.left;
		x.left = t;
		x.color = t.color;
		t.color = RED;
		return x;
	}

	private Node rotateR(Node t) {
		Node x = t.left;
		t.left = x.right;
		x.right = t;
		x.color = t.color;
		t.color = RED;
		return x;
	}

	private void colorZm(Node t) {
		t.color = !t.color;
		t.left.color = !t.left.color;
		t.right.color = !t.right.color;
	}

	public void insert(int x) {
		System.out.println("Wstawiam " + x);
		_root = insert(x, _root);
		_root.color = BLACK;

		System.out.println();
	}

	protected Node insert(int x, Node t) {
		if (t == null)
			t = new Node(x);
		else {
			if (isRed(t.left) && isRed(t.right))
				colorZm(t);
			if (t.value > x)
				t.left = insert(x, t.left);
			else if (t.value < x)
				t.right = insert(x, t.right);
			else
				throw new RuntimeException("Duplikat");
			t = fixUp(t);
		}
		return t;
	}

	private Node fixUp(Node t) {
		if (isRed(t.left) && isRed(t.left.right)) {
			t.left=rotateL(t.left);
			t = rotateR(t);
		}
		if (isRed(t.right) && isRed(t.right.left)) {
			t.right=rotateR(t.right);
			t = rotateL(t);
		}
		if (isRed(t.left) && isRed(t.left.left))
			t = rotateR(t);
		if (isRed(t.right) && isRed(t.right.right))
			t = rotateL(t);
		return t;
	}

	private Node moveRedR(Node t) {
		colorZm(t);
		if (isRed(t.left.left)) {
			t = rotateR(t);
			colorZm(t);
		}
		return t;
	}

	private Node moveRedL(Node t) {
		colorZm(t);
		if (isRed(t.right.left)) {
			t.right = rotateR(t.right);
			t = rotateL(t);
			colorZm(t);
		}
		return t;
	}

	public void delete(int x) {
		_root = delete(x, _root);
		if (_root != null)
			_root.color = BLACK;
	}

	protected Node delete(int x, Node t) {
		if (t == null)
			throw new RuntimeException("Not found  ");
		else {
			if (t.value < x) {
				if (!isRed(t.left) && !isRed(t.left.left))
					t = moveRedL(t);
				t.left = delete(x, t.left);
			} else {
				if (isRed(t.left))
					t = rotateR(t);
				if (x == t.value && t.right == null)
					return null;
				else {
					if (!isRed(t.right) && !isRed(t.right.left))
						t = moveRedR(t);
					if (t.value > x)
						t.right = delete(x, t.right);
					else
						t.right = detachMin(t.right, t);
				}
			}
		}
		return fixUp(t);
	}

	protected Node detachMin(Node t, Node del) {
		if (t.left == null) {
			del.value = t.value;
			t = null;
		} else {
			if (!isRed(t.left) && !isRed(t.left.left))
				t = moveRedL(t);
			t.left = detachMin(t.left, del);
			t = fixUp(t);
		}
		return t;
	}

	public String toString() {
		return toString(_root, 0);
	}

	private String toString(Node t, int pos) {
		String result = "";
		String spaces = "                                                                                                                                                                                                     ";
		if (t != null)
			result = result + toString(t.right, pos + 4) + spaces.substring(0, pos)
					+ String.format("%s%s", t.value, (t.color ? "/R" : "/B")) + toString(t.left, pos + 4);
		else
			result = result + String.format("%n");
		return result;
	}

	public int wysokosc() {
		// TODO Auto-generated method stub
		return wysokoscp(_root);
	}

	private int wysokoscp(Node n) {
		// TODO Auto-generated method stub
		if (n == null)
			return 0;
		int l = wysokoscp(n.left);
		int p = wysokoscp(n.right);
		return (l > p) ? l + 1 : p + 1;
	}

	public void wyswietlpoziom() {
		// TODO Auto-generated method stub
		int wys = wysokosc();
		System.out.println("klucze poziomami");

		for (int i = 0; i < wysokosc(); i++) {
			System.out.println("poziom " + (i + 1));
			wyswietlpoziomp(i, _root);
			System.out.println("");
		}

	}

	private void wyswietlpoziomp(int p, Node n) {
		if (n != null) {
			if (p == 0) {
				System.out.print(n);
			} else {
				wyswietlpoziomp(p - 1, n.left);
				wyswietlpoziomp(p - 1, n.right);
			}
		} else {
			System.out.print("  *  ");
		}

	}

	public int lwezlow() {
		// TODO Auto-generated method stub
		return lwezlowp(_root);
	}

	private int lwezlowp(Node n) {
		// TODO Auto-generated method stub
		if (n == null)
			return 0;
		return lwezlowp(n.left) + lwezlowp(n.right) + 1;
	}

	public void metody() {
		// TODO Auto-generated method stub
		System.out.println("1 *- Wstaw wezel o podanym kluczy");
		System.out.println("2 - Wyswietl inOrder");
		System.out.println("3 - Wyswietl preOrder");
		System.out.println("4 - Wyswietl postOrder");
		System.out.println("5 - wyszukiwanie wezla o podanym kluczu");
		System.out.println("6 - klucz max");
		System.out.println("7 - klucz min");
		System.out.println("8 *- wstaw przykladowe");
		System.out.println("9 - wyszukaj nastepnika drzewa");
		System.out.println("10 - wyszukaj poprzednika drzewa");
		System.out.println("11 *- liczba wezlow");
		System.out.println("12 *- wysokosc");
		System.out.println("13 - liczba wezlow zewnetrznych");
		System.out.println("14 - liczba lisci");
		System.out.println("15 *- wyswietlanie kluczy poziomami");
		System.out.println("16 - wyszukaj nastepnika wezla");
		System.out.println("17 - wyszukaj poprzednika wezla");
		System.out.println("18 *- usuwanie wezla o podanym kluczu");
		System.out.println("0 - koniec");
	}

	class Node {
		int value;
		Node left;
		Node right;
		boolean color;

		Node(int x) {
			value = x;
			left = right = null;
			color = RED;
		}

		@Override
		public String toString() {
			// TODO Auto-generated method stub
			return " " + value + " (" + (color ? "R)" : "B)");
		}
	}

}