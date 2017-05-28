package arraylista;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class Array {

	private ArrayList<Student> ar;

	public Array() {
		ar = new ArrayList<Student>();
	}

	public void add(Student s) {
		ar.add(s);
	}

	public void zapisz(String nazwa) {
		try {
			PrintWriter zap = new PrintWriter(new File(nazwa));
			zap.println(ar.size());
			for (Student student : ar) {
				zap.println(student);
			}
			zap.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void wczytaj(String nazwa) {
		try {
			Scanner odczyt = new Scanner(new FileReader(nazwa));
			int rozm = odczyt.nextInt();

			for (int i = 0; i < rozm; i++) {
				Student s = new Student();
				s.wczytaj(odczyt);
				ar.add(s);
			}
			odczyt.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void srednia() {
		double srednia = 0;
		for (Student student : ar) {
			srednia += student.getocena();
		}
		System.out.println();
		System.out.println("srednia " + srednia / ar.size());
	}

	public void niezal() {
		System.out.println();
		System.out.println("nie zaliczyli");
		for (Student student : ar) {
			if (student.getocena() < 3) {
				System.out.println(student);
			}
		}

	}
	
	public void zmien(int nrindexu , int ocena) {
		System.out.println();
		Iterator<Student> it = ar.iterator();
		boolean znaleziono=false;
		while (it.hasNext()) {
			Student akt=it.next();
			if (akt.getnrindexu()==nrindexu)
			{
				System.out.print("zmieniam ocene studenta "+akt+" z "+akt.getocena()+" na ");
				akt.setocena(ocena);
				znaleziono=true;
				System.out.println(akt.getocena());
			}
		}
		if(!znaleziono)
		{
			System.out.println("nie znaleziono indexu "+nrindexu);
		}

	}

	public void wyswietl() {
		Iterator<Student> it = ar.iterator();
		System.out.println();
		while (it.hasNext()) {
			System.out.println(it.next());
		}
		System.out.println();
	}
}
