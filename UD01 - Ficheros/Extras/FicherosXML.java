package ficheros;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class FicherosXML {

	public void writeFile() {

		DocumentBuilderFactory factory = null;
		DocumentBuilder builder = null;

		try {
			// Get the Factory
			factory = DocumentBuilderFactory.newInstance();

			// Get the DocumentBuilder
			builder = factory.newDocumentBuilder();

			// Create the new document (in memory)
			Document document = builder.newDocument();

			// Let's add the different elements to the document
			// First, the root element
			Element root = document.createElement("students");
			document.appendChild(root); // Add root to the document

			// Now, the child (student)
			Element student = document.createElement("student");
			Attr attrID = document.createAttribute("id");
			attrID.setValue("1");
			student.setAttributeNode(attrID);

			// Now then, the children of student
			Element name = document.createElement("name");
			name.appendChild(document.createTextNode("Juan"));
			student.appendChild(name); // Add nodes to the student

			Element surname = document.createElement("surname");
			surname.appendChild(document.createTextNode("Torres"));
			student.appendChild(surname);

			Element asignature = document.createElement("asignature");
			asignature.appendChild(document.createTextNode("ADT"));
			student.appendChild(asignature);

			root.appendChild(student); // Add student to the root

			// Transformer to write
			TransformerFactory transformerFactory = TransformerFactory.newInstance();
			Transformer transformer = transformerFactory.newTransformer();

			// DOM
			DOMSource source = new DOMSource(document);
			StreamResult result = new StreamResult(new File("example.xml"));
			transformer.transform(source, result);

		} catch (Exception e) {
			System.out.println("An error occurred.");
		}
	}

	public void readFile() {

		DocumentBuilderFactory factory = null;
		DocumentBuilder builder = null;

		try {

			// Get the Factory
			factory = DocumentBuilderFactory.newInstance();

			// Get the DocumentBuilder
			builder = factory.newDocumentBuilder();

			// Parse the XML file into a Document
			Document document = builder.parse(new File("example.xml"));
			document.getDocumentElement().normalize();

			// Root
			Element root = document.getDocumentElement();
			System.out.println("Root: " + root.getNodeName());

			// The root's children (student)
			NodeList rootNodeList = document.getElementsByTagName("student");

			// Let's iterate and get all students
			for (int i = 0; i < rootNodeList.getLength(); i++) {
				Node node = rootNodeList.item(i);
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

	public void alterFile() {
		DocumentBuilderFactory factory = null;
		DocumentBuilder builder = null;

		try {

			// Get the Factory
			factory = DocumentBuilderFactory.newInstance();

			// Get the DocumentBuilder
			builder = factory.newDocumentBuilder();

			// Parse the XML file into a Document
			Document document = builder.parse(new File("example.xml"));
			document.getDocumentElement().normalize();

			// Root
			Element root = document.getDocumentElement();
			System.out.println("Root: " + root.getNodeName());

			// The root's children (student)
			NodeList rootNodeList = document.getElementsByTagName("student");

			// Let's iterate and get the student with id = 1
			for (int i = 0; i < rootNodeList.getLength(); i++) {
				Node node = rootNodeList.item(i);
				if (node.getNodeType() == Node.ELEMENT_NODE) {
					Element element = (Element) node;
					String id = element.getAttribute("id");

					// Set id to 999
					if (id.equalsIgnoreCase("1")) {
						Attr attrID = document.createAttribute("id");
						attrID.setValue("999");
						element.setAttributeNode(attrID);
						break;
					}
				}
			}

			// Transformer to write
			TransformerFactory transformerFactory = TransformerFactory.newInstance();
			Transformer transformer = transformerFactory.newTransformer();

			// DOM
			DOMSource source = new DOMSource(document);
			StreamResult result = new StreamResult(new File("example.xml"));
			transformer.transform(source, result);

		} catch (Exception e) {
			System.out.println("An error occurred.");
		}
	}

	public static void main(String[] args) {
		FicherosXML ficherosXML = new FicherosXML();
		ficherosXML.writeFile();
		// ficherosXML.readFile();
		// ficherosXML.alterFile();
	}
}
