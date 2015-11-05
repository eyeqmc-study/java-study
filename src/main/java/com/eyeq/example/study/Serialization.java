package com.eyeq.example.study;

import java.io.Serializable;

public class Serialization implements Serializable {

	private static final long serialVersionUID = 3104620613458717485L;
	private String name;
	private int age;
	private double height;
	private transient char sex;

	public Serialization(String name, int age, double height, char sex) {
		this.name = name;
		this.age = age;
		this.height = height;
		this.sex = sex;
	}

	public Serialization() {
	}

	public String getName() {
		return name;
	}

	public int getAge() {
		return age;
	}

	public double getHeight() {
		return height;
	}

	public char getSex() {
		return sex;
	}
}