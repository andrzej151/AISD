package Sortowanie;

import java.util.Random;

/*
 * author AndrzejD
 */

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] wielkosci = { 8, 64};//, 128, 512, 1024 };
		Comparator licz = IntComparator.INSTANCE;
		QuickSort quick = new QuickSort(licz);
		QuickSort2 quick2 = new QuickSort2(licz);
		SelectSort select = new SelectSort(licz);
		BubbleSort buble = new BubbleSort(licz);
		BubbleSort1 buble2 = new BubbleSort1(licz);
		
		PorownanieSortowan porownaj = new PorownanieSortowan();
		porownaj.setSort(quick, "QuickSort");
		porownaj.setSort(quick2, "QuickSort2");
		porownaj.setSort(select, "SelectSort");
		porownaj.setSort(buble, "BubleSort");
		porownaj.setSort(buble2, "BubleSort2");

		for (int i = 0; i < wielkosci.length; i++)
		{
			System.out.println(porownaj.powrownaj(wielkosci[i])+"\n");
		}
	}

}
