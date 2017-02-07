package xml.jdom;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class JDomParserDemo {
    public static void main(String[] args) throws JDOMException, IOException {
        SAXBuilder saxBuilder = new SAXBuilder();
        InputStream resource = Thread.currentThread().getContextClassLoader().getResourceAsStream("dom_parse.xml");
        Document document = saxBuilder.build(resource);

        Element rootElement = document.getRootElement();
        List<Element> children = rootElement.getChildren();
        for (Element child : children) {
            System.out.println(child.getName());
            System.out.println(child.getAttribute("rollno").getValue());
            System.out.println(child.getChild("firstname").getText());
            System.out.println(child.getChild("lastname").getText());
            System.out.println(child.getChild("nickname").getText());
            System.out.println(child.getChild("marks").getText());
        }
    }
}
