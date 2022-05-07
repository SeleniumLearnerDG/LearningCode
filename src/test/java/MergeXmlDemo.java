import java.io.File;
import java.io.IOException;
import java.util.List;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

class ReadAndModifyXMLFile {
    public static final String xmlFilePath = "testFile.xml";
    public static final String xmlFilePath1 = "testFile1.xml";
    public static void main(String argv[]) {
        try {
            DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
            Document document = documentBuilder.parse(xmlFilePath1);
            DocumentBuilderFactory documentBuilderFactory1 = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder1 = documentBuilderFactory1.newDocumentBuilder();
            Document document1 = documentBuilder1.parse(xmlFilePath);
            NodeList nodeList = document.getElementsByTagName("testsuite");
            Node testsuite = document.getElementsByTagName("testsuite").item(0);
            Node testsuiteNode = document1.getElementsByTagName("testsuite").item(0);
            NamedNodeMap attribute = testsuite.getAttributes();
            Node nodeAttr = attribute.getNamedItem("tests");
            Integer totalTestCase = Integer.parseInt(testsuiteNode.getAttributes().getNamedItem("tests").getTextContent()) + Integer.parseInt(testsuite.getAttributes().getNamedItem("tests").getTextContent());
            nodeAttr.setTextContent(totalTestCase.toString());
            nodeAttr = attribute.getNamedItem("errors");
            Integer totalerrors = Integer.parseInt(testsuiteNode.getAttributes().getNamedItem("errors").getTextContent()) + Integer.parseInt(testsuite.getAttributes().getNamedItem("errors").getTextContent());
            nodeAttr.setTextContent(totalerrors.toString());
            nodeAttr = attribute.getNamedItem("skipped");
            Integer skippedTestCase = Integer.parseInt(testsuiteNode.getAttributes().getNamedItem("skipped").getTextContent()) + Integer.parseInt(testsuite.getAttributes().getNamedItem("skipped").getTextContent());
            nodeAttr.setTextContent(skippedTestCase.toString());
            nodeAttr = attribute.getNamedItem("failures");
            Integer failureTestCase = Integer.parseInt(testsuiteNode.getAttributes().getNamedItem("failures").getTextContent()) + Integer.parseInt(testsuite.getAttributes().getNamedItem("failures").getTextContent());
            nodeAttr.setTextContent(failureTestCase.toString());
            nodeAttr = attribute.getNamedItem("time");
            Float time = Float.parseFloat(testsuiteNode.getAttributes().getNamedItem("time").getTextContent()) + Float.parseFloat(testsuite.getAttributes().getNamedItem("time").getTextContent());
            nodeAttr.setTextContent(time.toString());

            for (int i=0; i<document1.getElementsByTagName("testcase").getLength();i++) {
                Node node = document.importNode(document1.getElementsByTagName("testcase").item(i).cloneNode(true), true);
                document.getDocumentElement().appendChild(node);
            }
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource domSource = new DOMSource(document);
            StreamResult streamResult = new StreamResult(new File(xmlFilePath));
            transformer.transform(domSource, streamResult);
            System.out.println("The XML File was ");
        } catch (ParserConfigurationException pce) {
            pce.printStackTrace();
        } catch (TransformerException tfe) {
            tfe.printStackTrace();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        } catch (SAXException sae) {
            sae.printStackTrace();
        }
    }
    public static void copyXMLFile(String xmlFilePath1) throws ParserConfigurationException, IOException, SAXException, TransformerException {
        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
        Document document = documentBuilder.parse(xmlFilePath1);
        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        DOMSource domSource = new DOMSource(document);
        StreamResult streamResult = new StreamResult(new File("result.xml"));
        transformer.transform(domSource, streamResult);
        System.out.println("The XML File was ");
    }

    /*public static void main(String[] args) throws ParserConfigurationException, IOException, TransformerException, SAXException {
        copyXMLFile(xmlFilePath);
    }*/
}