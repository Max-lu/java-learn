package xml.dom4j;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Node;
import org.dom4j.io.SAXReader;

import java.io.InputStream;
import java.util.List;

public class DOM4JParserDemo {
    public static void main(String[] args) throws DocumentException {
        SAXReader saxReader = new SAXReader();
        InputStream resource = Thread.currentThread().getContextClassLoader().getResourceAsStream("dom_parse.xml");
        Document document = saxReader.read(resource);

        List<Node> nodes = document.selectNodes("class/student");
        for (Node node : nodes) {
            System.out.println("\nCurrent Element :" + node.getName());
            System.out.println("Student roll no : " + node.valueOf("@rollno"));
            System.out.println("First Name : " + node.selectSingleNode("firstname").getText());
            System.out.println("Last Name : " + node.selectSingleNode("lastname").getText());
            System.out.println("First Name : " + node.selectSingleNode("nickname").getText());
            System.out.println("Marks : " + node.selectSingleNode("marks").getText());
        }

    }
}
