package kr.co.leehana.study;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * @author Hana Lee
 * @since 2015-11-10 09:14
 */
public class ConcurrentStudy2 {

	public static void main(String[] args) {
		ExecutorService exec = Executors.newCachedThreadPool();
		List<Future<Integer>> results = new ArrayList<>();

		for (int i = 0; i < 10; i++) {
			results.add(exec.submit(new CallableStudy(i * 100)));
		}

		for (Future<Integer> fs : results) {
			try {
				// get()은 종료시까지 Block 된다.
				System.out.println("Sum result is : " + fs.get());
			} catch (InterruptedException | ExecutionException e) {
			} finally {
				exec.shutdown();
			}
		}

		System.out.println("프로그램 종료");
	}

}

class CallableStudy implements Callable<Integer> {
	private int maxValue = 0;

	public CallableStudy(int maxValue) {
		this.maxValue = maxValue;
	}

	@Override
	public Integer call() throws Exception {
		int sum = 0;
		for (int i = 0; i < maxValue; i++) {
			sum += i;
		}

		return sum;
	}
}
