package kr.co.leehana.jdk.v14;

import junit.framework.TestCase;
import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class AssertTest extends TestCase {

	@Test
	public void test1() {
		int a = 10;

		assert a > 1 : "a는 1 보다 작아야 합니다";

		int b = 0;
		assert b < 1 : "b 도 1보다 작아야 합니다.";
	}
}
