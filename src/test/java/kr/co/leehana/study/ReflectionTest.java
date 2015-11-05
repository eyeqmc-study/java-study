package kr.co.leehana.study;

import com.heesun.test.sample_project.People;
import org.junit.Test;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author Hana Lee
 * @since 2015-11-05 09:34
 */
public class ReflectionTest {

	@Test
	public void test1() throws ClassNotFoundException, NoSuchFieldException, IllegalAccessException {
		People p = new People("Hana", 28, 190);
		System.out.println("변경 전 : " + p.getName());

		Class clazz = p.getClass();
//		Field[] fields = clazz.getDeclaredFields();
		Field f1 = clazz.getDeclaredField("name");
		f1.setAccessible(true);
		f1.set(p, "Lee");

		System.out.println("변경 후:" + p.getName());
	}

	@Test
	public void test2() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
		People p = new People("Hana", 25, 170);
		Class<? extends People> clazz = p.getClass();
		Method m = clazz.getDeclaredMethod("print");
		m.invoke(p);
	}

	@Test
	public void test3() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
		People p = new People("Hana", 25, 170);
		Class<? extends People> clazz = p.getClass();
		Method m = clazz.getDeclaredMethod("print", String.class);
		m.invoke(p, "TEST");

		Method m2 = clazz.getMethod("print", String.class);
		m2.invoke(p, "TEST2");
	}
}
