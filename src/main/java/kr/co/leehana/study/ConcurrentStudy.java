package kr.co.leehana.study;

/**
 * @author Hana Lee
 * @since 2015-11-10 08:32
 */
public class ConcurrentStudy implements Runnable {

	@Override
	public void run() {
		System.out.println( ">>>" + Thread.currentThread().getName() + ": started");
		if( Thread.currentThread().getName().equals("one") ){
			cal(1000);
		} else {
			cal(10000);
		}
	}

	private void cal(int maxValue) {
		int sum = 0;
		for (int i = 0; i < maxValue; i++) {
			sum += i;
		}

		System.out.println(sum);
	}

	public static void main(String[] args) {
		ConcurrentStudy helloRun = new ConcurrentStudy();

		Thread t1 = new Thread(helloRun, "one");
		Thread t2 = new Thread(helloRun, "two");
		t1.start();
		t2.start();

		System.out.println("Thread end");
	}
}
