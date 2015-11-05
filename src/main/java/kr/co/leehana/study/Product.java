package kr.co.leehana.study;

import java.math.BigDecimal;

public class Product {

	private Long id;
	private String name;
	private BigDecimal price;

	public Product(Long id, String name, BigDecimal price) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
	}

	public Product() {
	}
}