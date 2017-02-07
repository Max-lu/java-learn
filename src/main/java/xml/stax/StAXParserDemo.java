package xml.stax;

import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.Characters;
import javax.xml.stream.events.EndElement;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;
import java.io.InputStream;

public class StAXParserDemo {
    public static void main(String[] args) throws XMLStreamException {
        XMLInputFactory factory = XMLInputFactory.newFactory();
        InputStream resource = Thread.currentThread().getContextClassLoader().getResourceAsStream("dom_parse.xml");
        XMLEventReader xmlEventReader = factory.createXMLEventReader(resource);
        while (xmlEventReader.hasNext()) {
            XMLEvent xmlEvent = xmlEventReader.nextEvent();
            switch (xmlEvent.getEventType()) {
                case XMLStreamConstants.START_ELEMENT:
                    StartElement startElement = xmlEvent.asStartElement();
                    System.out.println("start:" + startElement.getName().getLocalPart());
                    break;
                case XMLStreamConstants.CHARACTERS:
                    Characters characters = xmlEvent.asCharacters();
                    System.out.println(characters.getData());
                    break;
                case XMLStreamConstants.END_ELEMENT:
                    EndElement endElement = xmlEvent.asEndElement();
                    System.out.println("end:" + endElement.getName().getLocalPart());
                    break;
            }
        }
    }
}
