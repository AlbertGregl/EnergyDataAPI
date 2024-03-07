package gregl.energydataapi.jaxbutil;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import java.io.File;

public class XmlSearchUtil {

    public static void findEnergyDataAndAdjustDate(String filePath) throws Exception {
        File xmlFile = new File(filePath);
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
        Document doc = dBuilder.parse(xmlFile);
        doc.getDocumentElement().normalize();

        XPathFactory xPathFactory = XPathFactory.newInstance();
        XPath xpath = xPathFactory.newXPath();
        String expression = "//dtm";
        NodeList nodeList = (NodeList) xpath.evaluate(expression, doc, XPathConstants.NODESET);

        for (int i = 0; i < nodeList.getLength(); i++) {
            String dateValue = nodeList.item(i).getTextContent();
            String adjustedDateValue = dateValue.replaceAll("(\\d{4}-\\d{2}-\\d{2}T\\d{2}:\\d{2}:\\d{2})[+\\-]\\d{2}:\\d{2}", "$1Z");
            nodeList.item(i).setTextContent(adjustedDateValue);
        }

        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        DOMSource source = new DOMSource(doc);
        StreamResult result = new StreamResult(xmlFile);
        transformer.transform(source, result);
    }
}