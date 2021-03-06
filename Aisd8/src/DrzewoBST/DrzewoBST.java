package DrzewoBST;

import java.util.Random;

public class DrzewoBST {

	private Node _root;

	public DrzewoBST() {
		// TODO Auto-generated constructor stub

	}

	public void insert(int x) {
		System.out.println(x);
		_root = insert(x, _root);
	}

	protected Node insert(int x, Node t) {
		if (t == null)
			t = new Node(x);
		else {

			if (x < t.value)
				t.left = insert(x, t.left);
			else if (x > t.value)
				t.right = insert(x, t.right);
			else
				try {
					throw new Exception("jest juz taki klucz");
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
		return t;
	}

	/////////////////////////
	public Object find(int x) {
		Node t = search(x);
		return t != null ? t.value : null;
	}

	private Node search(int value) {
		Node node = _root;
		int cmp = 0;
		while (node != null && (cmp = value - node.value) != 0)
			node = cmp < 0 ? node.left : node.right;
		return node;
	}

	public void findnext(int klucz) {
		Node t = search(klucz);
		System.out.println("po kluczu " + (t != null ? t.value : null) + 
				(searchnext(t.right)==null?"nie ma nastepnika ":"jest nastepnik"+searchnext(t.right).value));
	}
	
	private Node searchnext(Node n) {
		if(n==null) return null;
		if(n.left==null) return n;
		return searchnext(n.left);
	}

	public void findpop(int klucz) {
		Node t = search(klucz);
		System.out.println("po kluczu " + (t != null ? t.value : null) + 
				(searchpop(t.left)==null?"nie ma poprzednika ":"jest poprzednik"+searchpop(t.left).value));
	}

	private Node searchpop(Node n) {
		if(n==null) return null;
		if(n.right==null) return n;
		return searchpop(n.right);
	}


	public void metody() {
		// TODO Auto-generated method stub
		System.out.println("1 - Wstaw wezel o podanym kluczy");
		System.out.println("2 - Wyswietl inOrder");
		System.out.println("3 - Wyswietl preOrder");
		System.out.println("4 - Wyswietl postOrder");
		System.out.println("5 - wyszukiwanie wezla o podanym kluczu");
		System.out.println("6 - klucz max");
		System.out.println("7 - klucz min");
		System.out.println("8 - wstaw przykladowe");
		System.out.println("9 - wyszukaj nastepnika drzewa");
		System.out.println("10 - wyszukaj poprzednika drzewa");
		System.out.println("11 - liczba wezlow");
		System.out.println("12 - liczba wezlow wewnetrznych");
		System.out.println("13 - liczba wezlow zewnetrznych");
		System.out.println("14 - liczba lisci");
		System.out.println("15 - wyswietlanie kluczy poziomami");
		System.out.println("16 - wyszukaj nastepnika wezla");
		System.out.println("17 - wyszukaj poprzednika wezla");
		System.out.println("18 - usuwanie wezla o podanym kluczu");
		System.out.println("0 - koniec");
	}

	public void inOrder() {
		System.out.println("In Order");
		_inOrder(_root);
		System.out.println("");
	}

	private void _inOrder(Node n) {
		if (n.left != null)
			_inOrder(n.left);
		System.out.print(n.value + " ");
		if (n.right != null)
			_inOrder(n.right);
	}

	public void preOrder() {
		System.out.println("pre Order");
		_preOrder(_root);
		System.out.println("");

	}

	private void _preOrder(Node n) {
		if (n != null)
			System.out.print(n.value + " ");
		if (n.left != null)
			_preOrder(n.left);
		if (n.right != null)
			_preOrder(n.right);
	}

	public void postOrder() {
		System.out.println("post Order");
		_postOrder(_root);
		System.out.println("");
	}

	private void _postOrder(Node n) {
		if (n.left != null)
			_postOrder(n.left);
		if (n.right != null)
			_postOrder(n.right);
		if (n != null)
			System.out.print(n.value + " ");
	}

	public int min() {
		Node n = _root;

		while (n.left != null) {
			n = n.left;
		}
		return n.value;
	}

	public int max() {
		Node n = _root;

		while (n.right != null) {
			n = n.right;
		}
		return n.value;
	}

	class Node {
		private int value;
		private Node left;
		private Node right;

		public Node(int x) {
			value = x;
			left = right = null;
		}

		public Node() {
			value = 0;
			left = right = null;
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

	public int lwezlowwew() {
		// TODO Auto-generated method stub
		return lwezlowwewp(_root);
	}

	private int lwezlowwewp(Node n) {
		// TODO Auto-generated method stub
		if (n == null)
			return 0;

		return lwezlowwewp(n.left) + lwezlowwewp(n.right) + ((n.left == null && n.right == null) ? 0 : 1);
	}

	public int lwezlowzew() {
		// TODO Auto-generated method stub
		return lwezlowzewp(_root);
	}

	private int lwezlowzewp(Node n) {
		// TODO Auto-generated method stub
		if (n == null)
			return 1;

		return lwezlowzewp(n.left) + lwezlowzewp(n.right);
	}

	public int llisci() {
		// TODO Auto-generated method stub
		return lliscip(_root);
	}

	private int lliscip(Node n) {
		// TODO Auto-generated method stub
		if (n == null)
			return 0;

		return lliscip(n.left) + lliscip(n.right) + ((n.left == null && n.right == null) ? 1 : 0);
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
		System.out.println(wys);
		for (int i = 0; i < wysokosc(); i++) {
			System.out.println("poziom " + (i + 1));
			wyswietlpoziomp(i, _root);
			System.out.println("");
		}

	}

	private void wyswietlpoziomp(int p, Node n) {
		if (n != null) {
			if (p == 0) {
				System.out.print(n.value + " ");
			} else {
				wyswietlpoziomp(p - 1, n.left);
				wyswietlpoziomp(p - 1, n.right);
			}
		}

	}

	public void delete(int x) {
		try {
			_root = delete(x, _root);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	protected Node delete(int x, Node t) throws Exception {
		if (t == null)
			throw new Exception(x + "");
		else {

			if (x < t.value)
				t.left = delete(x, t.left);
			else if (x > t.value)
				t.right = delete(x, t.right);
			else if (t.left != null && t.right != null)
				t.right = detachMin(t.right, t);
			else
				t = (t.left != null) ? t.left : t.right;
		}
		return t;
	}

	// zast�p usuwany element jego nast�pnikiem i usu� nast�pnik
	protected Node detachMin(Node t, Node del) {
		if (t.left != null)
			t.left = detachMin(t.left, del);
		else {
			del.value = t.value;
			t = t.right;
		}
		return t;
	}

}