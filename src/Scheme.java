import java.util.LinkedList;

public class Scheme {
	LinkedList<Block> freeList;
	LinkedList<Block> list1;
	LinkedList<Block> list2;

	public Scheme(int N) {
		// Maak gelinkte lijst (gelinkte lijst van freeList is private)
		freeList = new LinkedList<Block>();
		list1 = new LinkedList<Block>();
		list2 = new LinkedList<Block>();

		for (int i = 0; i < N; i++) {
			freeList.add(new Block());
		}

	}

	// LINKING TO FREELIST________________________________________________________
	public synchronized void linkFree(Block b) {
		freeList.add(b);
		print();
		this.notifyAll();
	}

	// UNLINKING TO FREELIST
	public synchronized Block unlinkFree() {
		// verwijder het eerste block uit de lijst
		while (freeList.isEmpty()) { // anders runtime error
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		Block temp = freeList.remove();
		print();
		return temp;
	}

	// LINKING TO LIST1________________________________________________________
	public synchronized void link1(Block b) {
		list1.add(b);
		print();
		this.notifyAll();
	}

	// UNLINKING TO LIST1
	public synchronized Block unlink1() {
		// verwijder het eerste block uit de lijst
		while (list1.isEmpty()) { // anders runtime error
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		Block temp = list1.remove();
		print();
		return temp;
	}

	// LINKING TO LIST2________________________________________________________
	public synchronized void link2(Block b) {
		list2.add(b);
		print();
		this.notifyAll();
	}

	// UNLINKING TO LIST2
	public synchronized Block unlink2() {
		// verwijder het eerste block uit de lijst
		while (list2.isEmpty()) { // anders runtime error
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		Block temp = list2.remove();
		print();
		return temp;
	}

	public void print() {
		System.out.println("-----------------------------------------");
		System.out.println(freeList);
		System.out.println(list1);
		System.out.println(list2);

		/*
		 * System.out.println("freelist: " + freeList.size());
		 * System.out.println("list1: " + list1.size()); System.out.println("list2: " +
		 * list2.size());
		 */

	}
}