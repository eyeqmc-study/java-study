package com.heesun.test.sample_project;

import java.io.Serializable;

public class People implements Serializable {

	/**
	 *
	 */
	private static final long serialVersionUID = 8965044775487219849L;
	private String name;
	private int age;
	private float height;

	public People(String name, int age, float height) {
		super();
		this.name = name;
		this.age = age;
		this.height = height;
	}

	public String getName() {
		return name;
	}

	public int getAge() {
		return age;
	}

	public float getHeight() {
		return height;
	}

	public void print() {
		System.out.println("이름 : " + name + ", " + "나이 : " + age);
	}

	public void print(String msg) {
		System.out.println("메세지:" + msg);
	}

}
