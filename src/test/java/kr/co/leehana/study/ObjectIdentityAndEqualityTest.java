package kr.co.leehana.study;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

import static java.util.stream.Collectors.joining;

/**
 * @author Hana Lee
 * @since 2015-11-08 13:07
 */
public class ObjectIdentityAndEqualityTest {

	private static final Logger log = Logger.getLogger(ObjectIdentityAndEqualityTest.class.getName());

	@Test
	public void test1() {
		// object identity and equality
		// 같은 메모리에 할당되어 있으면 identity
		// object 의 value 가 같으면 equality

		// identity : 동일한 객체인가?
		// equality : 동등한 객체인가? (값이 같은가 = 속성값 일치)

		final Object obj1 = new Object();
		final Object obj2 = new Object();

		if (obj1 == obj2) {
			log.log(Level.INFO, "Object1 == Object2");
		}

		if (obj1.equals(obj2)) { // Object 의 equals 는 == 비교를 한다.
			log.log(Level.INFO, "Object equals Object2");
		}

		final String str1 = new String("a");
		final String str2 = new String("a");
		if (str1 == str2) {
			log.log(Level.INFO, "Object3 == Object4");
		}

		if (str1.equals(str2)) {
			log.log(Level.INFO, "Object3 equals Object4");
		}

		final Product prod1 = new Product(1L, "A", new BigDecimal("100"));
		final Product prod2 = new Product(2L, "B", new BigDecimal("200"));
		final Product prod3 = new Product(3L, "C", new BigDecimal("300"));
		final Product prodA = new Product(1L, "A", new BigDecimal("100"));

		final Set<Product> products = new HashSet<>();
		products.add(prod1);
		products.add(prod2);
		products.add(prod3);
		products.add(prodA);

		System.out.println(products.stream().map(String::valueOf).collect(joining("\n\t", "[\n\t", "\n]")));

		final LomProduct lomProd1 = new LomProduct(1L, "A", new BigDecimal("100"));
		final LomProduct lomProd2 = new LomProduct(2L, "B", new BigDecimal("200"));
		final LomProduct lomProd3 = new LomProduct(3L, "C", new BigDecimal("300"));
		final LomProduct lomProdA = new LomProduct(1L, "A", new BigDecimal("100"));

		final Set<LomProduct> lomProducts = new HashSet<>();
		lomProducts.add(lomProd1);
		lomProducts.add(lomProd2);
		lomProducts.add(lomProd3);
		lomProducts.add(lomProdA);
		System.out.println(lomProducts.stream().map(String::valueOf).collect(joining("\n\t", "[\n\t", "\n]")));

		final Map<Product, Integer> productIntegerMap = new HashMap<>();
		productIntegerMap.put(prod1, 1);
		productIntegerMap.put(prod2, 2);
		productIntegerMap.put(prod3, 3);

		// Hash based 컬렉션에 뭔가를 넣으면 값(상태)의 변경을 하면 안된다. (hashcode 와 equals 에 영향을 주는 필드는 수정하면 안된다)

		// Good practice
		// 1. HashMap 의 key 는 되도록 immutable 타입을 사용한다
		// 2. Mutable 타입을 사용할 경우 key 로 사용 후 상태를 변경하지 않는다
		// 3. HashSet 의 경우도 일단 Set 안에 넣은 object 는 상태를 변경하지 않는다
		prod1.setPrice(new BigDecimal("999"));

		productIntegerMap.put(prod1, 10);

		System.out.println(productIntegerMap.entrySet().stream()
				.map(entry -> entry.getKey() + " : " + entry.getValue())
				.collect(joining("\n\t", "{\n\t", "\n}")));

		// JPA 에서의 문제점
		final Product p1 = new Product(null, "A", new BigDecimal("888"));
		Set<Product> newProducts = new HashSet<>();
		newProducts.add(p1);
		System.out.println(newProducts);

		p1.setId(1L);

		// 실수든 아니든 한번 더 입력 -> Set 이기때문에 그리고 같은 object 이기 때문에 하나만 있을꺼라 예상되지만 실제로는 그렇지 않다.
		// id 같이 데이터베이스에서만 의미 있는 필드보다 비지니스상의 중요한 데이터를 equals 랑 hashcode 에 사용 하는것이 좋다.
		// 비지니스 키로 UUID 를 사용할 수도 있다.
		// 참고 자료 http://www.databaser.net/moniwiki/wiki.php/SurrogateKeyhttp://www.databaser.net/moniwiki/wiki.php/SurrogateKey
		newProducts.add(p1);
		System.out.println(newProducts);
	}

	@NoArgsConstructor
	@AllArgsConstructor
	@Data
	class LomProduct {
		private Long id;
		private String name;
		private BigDecimal price;
	}

	class Product {
		private Long id;
		private String name;
		private BigDecimal price;

		public Product() {
			throw new AssertionError("기본 생성자는 사용 할 수 없습니다");
		}

		public Product(Long id, String name, BigDecimal price) {
			this.id = id;
			this.name = name;
			this.price = price;
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || getClass() != o.getClass()) return false;

			Product product = (Product) o;

			if (id != null ? !id.equals(product.id) : product.id != null) return false;
			if (name != null ? !name.equals(product.name) : product.name != null) return false;
			return !(price != null ? !price.equals(product.price) : product.price != null);

		}

		@Override
		public int hashCode() {
			int result = id != null ? id.hashCode() : 0;
			result = 31 * result + (name != null ? name.hashCode() : 0);
			result = 31 * result + (price != null ? price.hashCode() : 0);
			return result;
		}

		public void setId(Long id) {
			this.id = id;
		}
		public Long getId() {
			return id;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public BigDecimal getPrice() {
			return price;
		}

		public void setPrice(BigDecimal price) {
			this.price = price;
		}

		@Override
		public String toString() {
			return new StringBuilder("Product{").append("id=").append(id).append(", name='").append(name).append('\'')
					.append(", price=").append(price).append('}').toString();
		}
	}
}
