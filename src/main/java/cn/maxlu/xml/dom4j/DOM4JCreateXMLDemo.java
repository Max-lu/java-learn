package cn.maxlu.xml.dom4j;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.XMLWriter;

import java.io.IOException;

public class DOM4JCreateXMLDemo {
    public static void main(String[] args) {
        try {
            Document document = DocumentHelper.createDocument();
            Element root = document.addElement("cars");
            Element supercarElement = root.addElement("supercars").addAttribute("company", "Ferrai");

            supercarElement.addElement("carname").addAttribute("type", "Ferrari 101").addText("Ferrari 101");
            supercarElement.addElement("carname").addAttribute("type", "sports").addText("Ferrari 202");

            // Pretty print the document to System.out
            OutputFormat format = OutputFormat.createPrettyPrint();
            XMLWriter writer = new XMLWriter(System.out, format);
            writer.write(document);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
