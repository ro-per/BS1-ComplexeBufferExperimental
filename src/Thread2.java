import java.util.concurrent.Semaphore;

public class Thread2 extends Thread {
	private Semaphore sem;
	private int M;
	private Scheme scheme;

	public Thread2(Scheme scheme, Semaphore sem, int M) {
		this.scheme = scheme;
		this.sem = sem;
		this.M = M;
	}

	public void run() {
		for (int i = 0; i < M; i++) {
			//UNLINKING
			Block x = scheme.unlink1();// -> synchronized
			Block y = scheme.unlinkFree();// -> synchronized
			// BEWERKING
			y.setNumber(x.getNumber() / 2); // y=x:2
			//LINKING
			scheme.linkFree(x);
			scheme.link2(y);
			//RELEASE SEMAPHORE
			sem.release(); // mag enkel hier, niet in Thread 3 !!!

		}
	}
}
