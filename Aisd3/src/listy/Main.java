package listy;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LinkedList lista = new LinkedList();
		lista.add("ziemniaki");
		lista.add("mleko");
		lista.add("jajka");
		lista.wyswietl();
		System.out.println("\ninsert");
		lista.insert(2, "maslo");
		lista.wyswietl();
		System.out.println(lista+"\n"+lista.set(3, "chleb"));
		System.out.println("\nset");
		System.out.println(lista);
		System.out.println("iterator");
		Iterator it = lista.iterator();
		for(it.first();!it.isDone();it.next())
		{
			System.out.println(it.current());
		}
		System.out.println("");
		System.out.println("get 2 "+lista.get(2));
		System.out.println("contains jajka "+lista.contains("jajka"));
		System.out.println("contains chleb "+lista.contains("chleb"));
		System.out.println("ziemniaki index of "+lista.indexOf("ziemniaki"));
		System.out.println("jajka index of "+lista.indexOf("jajka"));
		System.out.println("maslo index of "+lista.indexOf("maslo"));
		System.out.println("size "+lista.size());
		System.out.println(lista.delete(1));
		System.out.println("size "+lista.size());
		System.out.println(lista);
		System.out.println(lista.delete("maslo"));
		System.out.println(lista.size());
		System.out.println(lista);
		

		
		
		
	}

}
