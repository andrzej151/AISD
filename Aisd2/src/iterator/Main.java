package iterator;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Zadanie zad1=new Zadanie();
		zad1.wczytaj("plik2.txt");
		zad1.wyswietlanie();
		zad1.niezal();
		zad1.srednia();
		zad1.zmien(543883,2);
		zad1.srednia();
		zad1.niezal();
	}

}
