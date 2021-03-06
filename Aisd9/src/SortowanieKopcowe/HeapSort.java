package SortowanieKopcowe;

import java.util.ArrayList;

public class HeapSort {

	public HeapSort() {
		
	}

	private int[] a;
	private int n;
	private int left;
	private int right;
	private int largest;
	private int smolest;

	public void buildmax(int[] a) {
		n = a.length - 1;
		for (int i = n / 2; i >= 0; i--) {
			maxheap(a, i);
		}
	}

	public void buildmin(int[] a) {
		n = a.length - 1;
		for (int i = n / 2; i >= 0; i--) {
			minheap(a, i);
		}
	}

	public void maxheap(int[] a, int i) {
		left = 2 * i;
		right = 2 * i + 1;

		if (left <= n && a[left] > a[i]) {
			largest = left;
		} else {
			largest = i;
		}

		if (right <= n && a[right] > a[largest]) {
			largest = right;
		}
		if (largest != i) {
			change(i, largest);
			maxheap(a, largest);
		}
	}

	public void minheap(int[] a, int i) {
		left = 2 * i;
		right = 2 * i + 1;

		if (left <= n && a[left] < a[i]) {
			largest = left;
		} else {
			largest = i;
		}

		if (right <= n && a[right] < a[largest]) {
			largest = right;
		}
		if (largest != i) {
			change(i, largest);
			minheap(a, largest);
		}
	}

	public void change(int i, int j) {
		int t = a[i];
		a[i] = a[j];
		a[j] = t;
	}

	public int[] sortrosnaco(int[] a0) {
		a = a0;
		buildmax(a);

		for (int i = n; i > 0; i--) {
			change(0, i);
			n = n - 1;
			maxheap(a, 0);
		}
		return a;
	}

	public int[] sortmalejaco(int[] a0) {
		a = a0;
		buildmin(a);

		for (int i = n; i > 0; i--) {
			change(0, i);
			n = n - 1;
			minheap(a, 0);
		}
		return a;
	}

	public void swap(int[] list, int x, int y) {
		int i = list[x];
		list[x] = list[y];
		list[y] = i;
	}

}