package kr.co.leehana.study;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

public class ExSerialization implements Externalizable {

	private static final long serialVersionUID = -6048056040479828349L;
	private String name;
	private int age;
	private double height;
	private char sex;

//	public ExSerialization() {
//	}

	public ExSerialization(String name, int age, double height, char sex) {
		this.name = name;
		this.age = age;
		this.height = height;
		this.sex = sex;
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

	@Override
	public void writeExternal(ObjectOutput out) throws IOException {
		out.writeObject(name);
		out.writeInt(age);
		out.writeDouble(height);
	}

	@Override
	public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
		name = (String) in.readObject();
		age = in.readInt();
		height = in.readDouble();
	}
}
