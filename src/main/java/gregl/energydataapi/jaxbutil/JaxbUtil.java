package gregl.energydataapi.jaxbutil;

import javax.xml.XMLConstants;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;
import jakarta.xml.bind.Unmarshaller;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;
import java.io.*;
import org.xml.sax.SAXException;

public class JaxbUtil {


    public static void marshalToFile(Object object, String filePath) throws JAXBException {
        JAXBContext jaxbContext = JAXBContext.newInstance(object.getClass());
        Marshaller marshaller = jaxbContext.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

        try (FileWriter writer = new FileWriter(filePath)) {
            marshaller.marshal(object, writer);
        } catch (IOException e) {
            throw new JAXBException("Error writing XML to file: " + filePath, e);
        }
    }

    public static <T> T unmarshalFromFile(String filePath, Class<T> clazz) throws JAXBException {
        JAXBContext jaxbContext = JAXBContext.newInstance(clazz);
        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();

        try (FileReader reader = new FileReader(filePath)) {
            return clazz.cast(unmarshaller.unmarshal(reader));
        } catch (IOException e) {
            throw new JAXBException("Error reading XML from file: " + filePath, e);
        }
    }

    public static void validateFile(String xmlFilePath, String schemaPath) throws SAXException, IOException {
        SchemaFactory factory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
        Schema schema = factory.newSchema(new StreamSource(JaxbUtil.class.getClassLoader().getResourceAsStream(schemaPath)));
        javax.xml.validation.Validator validator = schema.newValidator();
        try (FileReader reader = new FileReader(xmlFilePath)) {
            validator.validate(new StreamSource(reader));
        }
    }

}