package cn.maxlu.xml.dom;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.IOException;
import java.io.InputStream;

public class DomBaseTest {
    public static void main(String[] args) throws Exception {
        modify();
    }

    private static void modify() throws Exception {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        InputStream resource = Thread.currentThread().getContextClassLoader().getResourceAsStream("dom_parse.xml");
        Document doc = builder.parse(resource);

        Node node = doc.getElementsByTagName("student").item(0);
        doc.getFirstChild().removeChild(node);

        //dom输出
        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        DOMSource domSource = new DOMSource(doc);
        StreamResult streamResult = new StreamResult(System.out);
        transformer.transform(domSource, streamResult);
    }

    private static void parse() throws ParserConfigurationException, IOException, SAXException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        InputStream resource = Thread.currentThread().getContextClassLoader().getResourceAsStream("dom_parse.xml");
        Document doc = builder.parse(resource);

        Element root = doc.getDocumentElement();
        System.out.println("root node: " + root.getNodeName());

        NodeList nodeList = doc.getElementsByTagName("student");
        for (int i = 0; i < nodeList.getLength(); i++) {
            Node node = nodeList.item(i);
            if (node.getNodeType() == Node.ELEMENT_NODE) {
                System.out.println("\nCurrent Element :" + node.getNodeName());
                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element eElement = (Element) node;
                    System.out.println("Student roll no : " + eElement.getAttribute("rollno"));
                    System.out.println("First Name : " + eElement.getElementsByTagName("firstname").item(0).getTextContent());
                    System.out.println("Last Name : " + eElement.getElementsByTagName("lastname").item(0).getTextContent());
                    System.out.println("Nick Name : " + eElement.getElementsByTagName("nickname").item(0).getTextContent());
                    System.out.println("Marks : " + eElement.getElementsByTagName("marks").item(0).getTextContent());
                }
            }
        }
    }
}
