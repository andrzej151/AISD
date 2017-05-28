package listy;

import java.io.PrintWriter;
import java.util.Scanner;

public class Student {
	private int _nrindexu;
	private String _imie;
	private String _nazwisko;
	private int _ocena;

	public Student() {
		_imie = "";
		_nrindexu = 0;
		_nazwisko = "";
		_ocena = 0;
	}

	public int getocena() {
		return _ocena;
	}

	public int getnrindexu() {
		return _nrindexu;
	}

	public void setocena(int ocena) {
		_ocena = ocena;
	}

	public Student(int nrindexu, String imie, String nazwisko, int ocena) {
		_imie = imie;
		_nazwisko = nazwisko;
		_nrindexu = nrindexu;
		_ocena = ocena;
	}

	public void wczytaj(int nrindexu, String imie, String nazwisko, int ocena) {
		_imie = imie;
		_nazwisko = nazwisko;
		_nrindexu = nrindexu;
		_ocena = ocena;
	}

	public Scanner wczytaj(Scanner odczyt) {
		_nrindexu = odczyt.nextInt();
		_imie = odczyt.next();
		_nazwisko = odczyt.next();
		_ocena = odczyt.nextInt();
		return odczyt;
	}

	public PrintWriter zapisz(PrintWriter zap) {
		zap.println(_nrindexu);
		zap.println(_imie);
		zap.println(_nazwisko);
		zap.println(_ocena);
		return zap;
	}

	public String toString() {
		return _nrindexu + " " + _imie + " " + _nazwisko + " " + _ocena;
	}

}
