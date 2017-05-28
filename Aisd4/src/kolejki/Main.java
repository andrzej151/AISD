package kolejki;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Bufor b = new Bufor(5);
		try {
		b.enqueue("chleb1");
		b.enqueue("chleb2");
		
		b.enqueue("chleb3");
		b.enqueue("chleb4");
		b.enqueue("chleb5");
		b.wyswietl();
		b.enqueue("chleb6");
		
			System.out.println(b.dequeue());
			System.out.println(b.dequeue());
			b.wyswietl();
			System.out.println(b.dequeue());
			b.enqueue("chleb6");
			b.wyswietl();
			System.out.println(b.dequeue());
			System.out.println(b.dequeue());
			System.out.println(b.dequeue());
			System.out.println(b.dequeue());
			
			
		} catch (EmptyQueueException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println();
		
		Kolejka k = new Kolejka();
		k.enqueue("ser");
		k.enqueue("jajka");
		k.wyswietl();
		System.out.println("");
		k.enqueue("maslo");
		k.wyswietl();
		System.out.println(k);
		System.out.println("ret "+k.dequeue());
		System.out.println(k);
		System.out.println("ret "+k.dequeue());
		System.out.println(k);
		System.out.println("ret "+k.dequeue());
		System.out.println(k);
		System.out.println("");
		k.wyswietl();

	}

}
