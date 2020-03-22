import java.util.concurrent.Semaphore;

public class Thread1 extends Thread {
	private Semaphore sem;
	private int M;
	private Scheme scheme;

	public Thread1(Scheme scheme, Semaphore sem, int M) {
		this.scheme = scheme;
		this.sem = sem;
		this.M = M;
	}

	public void run() {
		for (int i = 0; i < M; i++) {
			try {
				sem.acquire();
			} catch (Exception e) {
				System.out.println("sem.acquire() geeft problemen");
			}
			Block b = scheme.unlinkFree(); // -> synchronized
			b.setNumber(Math.random() * 10); // produceer informatie in blok b
			scheme.link1(b);
		}
	}
}
