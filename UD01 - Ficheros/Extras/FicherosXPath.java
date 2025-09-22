package ficheros;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class FicherosXPath {

	private void doFind() {

		DocumentBuilderFactory factory = null;
		DocumentBuilder builder = null;

		try {

			// Get the Factory
			factory = DocumentBuilderFactory.newInstance();

			// Get the DocumentBuilder
			builder = factory.newDocumentBuilder();

			// Parse the XML file into a Document
			Document xPathDoc = builder.parse(new File("xPathExample.xml"));

			// The XPath
			XPath xPath = XPathFactory.newInstance().newXPath();

			// The expression ("query")
			String expression = "/students/student";

			// Searching...
			NodeList nodeList = (NodeList) xPath.evaluate(expression, xPathDoc, XPathConstants.NODESET);

			// Let's iterate 
			for (int i = 0; i < nodeList.getLength(); i++) {
				Node node = nodeList.item(i);
				if (node.getNodeType() == Node.ELEMENT_NODE) {
					Element element = (Element) node;
					System.out.println("student: " + i);
					System.out.println("id: " + element.getAttribute("id"));

					NodeList childNodes = node.getChildNodes();
					for (int j = 0; j < childNodes.getLength(); j++) {
						Node childNode = childNodes.item(j);
						if (childNode.getNodeType() == Node.ELEMENT_NODE) {
							Element childElement = (Element) childNode;
							System.out.println("childElement: " + childElement.getTextContent());
						}
					}
				}
			}
			
		} catch (Exception e) {
			System.out.println("An error occurred.");
		}
	}

	public static void main(String[] args) {
		FicherosXPath ficherosXPath = new FicherosXPath();
		ficherosXPath.doFind();
	}
}
