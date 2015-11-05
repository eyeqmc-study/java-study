package kr.co.leehana.jdk.v14;

import java.io.IOException;
import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 * 
 * @author leehana
 * 
 * http://javacan.tistory.com/entry/33
 *
 */
public class Jdk14 {

	public static void main(String[] args) {
		JaxpAPI();
		LoggingAPI();
	}
	
	public static void JaxpAPI() {
		DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
		try {
			DocumentBuilder builder = builderFactory.newDocumentBuilder();
			InputStream resourceStream = Jdk14.class.getResourceAsStream("/test.xml");
			Document document = builder.parse(resourceStream);
			NodeList modelVersionList = document.getElementsByTagName("modelVersion");

			System.out.println("== jdk1.4 에 추가된 XML 처리 예제코드 (JAXP API) ==");
			System.out.println("Model Version : " + modelVersionList.item(0).getTextContent());
			System.out.println("==============================================");
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void LoggingAPI() {
		final Logger log = Logger.getLogger(Jdk14.class.getName());
		log.log(Level.INFO, "Logger INFO {0}", "TEST");
		log.log(Level.WARNING, "Logger WARNING {0}", "TEST");
		log.log(Level.OFF, "Logger OFF {0}", "TEST");
		log.log(Level.SEVERE, "Logger SEVERE {0}", "TEST");
	}
	
	public static void NIO() {
		
	}
}
