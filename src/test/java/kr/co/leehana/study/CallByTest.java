package kr.co.leehana.study;

import org.junit.Test;

import java.math.BigDecimal;

/**
 * @author Hana Lee
 * @since 2015-11-06 13:52
 */
public class CallByTest {

	@Test
	public void test1() {
		Product p1 = new Product("아이폰", new BigDecimal(1000));
		Product p2 = new Product("안드로이드", new BigDecimal(900));
		System.out.println("======================================");
		System.out.println("변경전 Product1 : " + p1);
		System.out.println("변경전 Product2 : " + p2);
		swap(p1, p2);

		System.out.println("변경후 Product1 : " + p1);
		System.out.println("변경후 Product2 : " + p2);
		System.out.println("======================================");
	}

	@Test
	public void test2() {
		Product p1 = new Product("아이폰", new BigDecimal(1000));
		Product p2 = new Product("안드로이드", new BigDecimal(900));
		System.out.println("변경전 Product1 : " + p1);
		System.out.println("변경전 Product2 : " + p2);
		swap2(p1, p2);

		System.out.println("변경후 Product1 : " + p1);
		System.out.println("변경후 Product2 : " + p2);
		System.out.println("======================================");
	}

	private void swap(Product p1, Product p2) {
		Product temp = p1;
		p1 = p2;
		p2 = temp;

		System.out.println(p1);
		System.out.println(p2);
	}

	private void swap2(Product p1, Product p2) {
		Product temp = new Product(p1.getName(), p1.getPrice());
		p1.setName(p2.getName());
		p2.setName(temp.getName());
	}

	class Product {
		private String name;
		private BigDecimal price;

		public Product() {
		}

		public Product(String name, BigDecimal price) {
			this.name = name;
			this.price = price;
		}

		public BigDecimal getPrice() {
			return price;
		}

		public void setPrice(BigDecimal price) {
			this.price = price;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		@Override
		public String toString() {
			return "이름 : " + this.name + ", 가격 : " + this.price.toString();
		}
	}
}
