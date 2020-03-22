import java.util.LinkedList;
import java.util.concurrent.Semaphore;

public class Main {
	public static void main(String[] args) {
		final int N = 10; // initieel aantal blokken
		final int M = 1000; // aantal transacties

		// MAAK EEN SCHEMA VAN DE SITUATIE
		Scheme scheme = new Scheme(N);

		// Maak semafoor aan
		Semaphore sem = new Semaphore(N - 1);

		// Maak threads aan
		Thread1 t1 = new Thread1(scheme, sem, M);
		Thread2 t2 = new Thread2(scheme, sem, M);
		Thread3 t3 = new Thread3(scheme, sem, M);

		// Strat threads op
		t1.start();
		t2.start();
		t3.start();
	}
}