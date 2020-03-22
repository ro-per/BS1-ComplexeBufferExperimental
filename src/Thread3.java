import java.util.concurrent.Semaphore;

public class Thread3 extends Thread {
	private Semaphore sem;
	private int M;
	private Scheme scheme;

	public Thread3(Scheme scheme, Semaphore sem, int M) {
		this.scheme = scheme;
		this.sem = sem;
		this.M = M;
	}

	public void run() {
		for (int i = 0; i < M; i++) {
			// UNLINKING
			Block c = scheme.unlink2();// -> synchronized
			// BEWERKING:output

			// LINKING
			scheme.linkFree(c);

		}
	}
}
