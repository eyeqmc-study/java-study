package kr.co.leehana.study;

import static org.junit.Assert.assertEquals;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import org.junit.Ignore;
import org.junit.Test;

import com.eyeq.example.study.Serialization;

public class SerializationTest {

	@Test
	public void exSerialization_test() throws IOException, ClassNotFoundException {
		ExSerialization exSerialization = new ExSerialization("Hana", 38, 170.0, 'F');
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("user.data"));
		oos.writeObject(exSerialization);
		oos.close();
		
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream("user.data"));
		ExSerialization newExSerialization = (ExSerialization) ois.readObject();
		ois.close();
		
		assertEquals("Hana", newExSerialization.getName());
		assertEquals(38, newExSerialization.getAge());
		assertEquals(170.0, newExSerialization.getHeight(), 0.0);
		assertEquals('\u0000', newExSerialization.getSex());
	}
	
	@Test
	public void serialization_test() throws FileNotFoundException, IOException, ClassNotFoundException {
		Serialization serialization = new Serialization("Hana Lee", 38, 171.5, 'M');
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("user.data"));
		oos.writeObject(serialization);
		oos.close();
		
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream("user.data"));
		Serialization deSerialization = (Serialization) ois.readObject();
		ois.close();
		
		assertEquals("Hana Lee", deSerialization.getName());
		assertEquals(38, deSerialization.getAge());
		assertEquals(171.5, deSerialization.getHeight(), 0.0);
		assertEquals('M', deSerialization.getSex());
	}
	
	@Test
	@Ignore
	public void serialization_test2() throws FileNotFoundException, IOException, ClassNotFoundException {
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream("heesun.data"));
		Serialization deSerialization = (Serialization) ois.readObject();
		ois.close();
		
		assertEquals("Hana Lee", deSerialization.getName());
		assertEquals(38, deSerialization.getAge());
		assertEquals(171.5, deSerialization.getHeight(), 0.0);
		assertEquals('M', deSerialization.getSex());
	}
	
	@Test
	public void serialization_test3() throws FileNotFoundException, IOException, ClassNotFoundException {
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream("kjg.data"));
		Serialization deSerialization = (Serialization) ois.readObject();
		ois.close();
		
		assertEquals("Jeong-gu", deSerialization.getName());
		assertEquals(27, deSerialization.getAge());
		assertEquals(172.5, deSerialization.getHeight(), 0.0);
		assertEquals('M', deSerialization.getSex());
	}
}
