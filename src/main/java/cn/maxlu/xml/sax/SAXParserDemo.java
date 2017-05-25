package cn.maxlu.xml.sax;

import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.IOException;
import java.io.InputStream;

public class SAXParserDemo {
    public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
        InputStream resource = Thread.currentThread().getContextClassLoader().getResourceAsStream("dom_parse.xml");
        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser saxParser = factory.newSAXParser();
        saxParser.parse(resource, new MyHandler());
    }
}
