package ua.kiev.prog;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;

public class XMLWorker {

    public static void loadStatisticFromXMLFile(File file, UserStatistic userStatistic) {
        //UserStatistic userStatistic = new UserStatistic();
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        try {
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(file);
            Element root = document.getDocumentElement();
            Node node = root.getFirstChild();
            if (node.getNodeType() == Node.ELEMENT_NODE) {
                Element element = (Element) node;
                userStatistic.setUserCount(Integer.parseInt(element.getElementsByTagName("user_count").item(0).getTextContent()));
                userStatistic.setUserFirstName(element.getElementsByTagName("user_firstName").item(0).getTextContent());
                userStatistic.setUserLastName(element.getElementsByTagName("user_lastName").item(0).getTextContent());
                userStatistic.setStatAge(Integer.parseInt(element.getElementsByTagName("stat_age").item(0).getTextContent()));
                userStatistic.setStatSport(Integer.parseInt(element.getElementsByTagName("stat_sport").item(0).getTextContent()));
                userStatistic.setStatBooks0(Integer.parseInt(element.getElementsByTagName("stat_books0").item(0).getTextContent()));
                userStatistic.setStatBooks1(Integer.parseInt(element.getElementsByTagName("stat_books1").item(0).getTextContent()));
                userStatistic.setStatBooks11(Integer.parseInt(element.getElementsByTagName("stat_books11").item(0).getTextContent()));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void saveStatisticToXMLFile(File file, UserStatistic userStatistic) {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        try {
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(file);
            document.getElementsByTagName("user_count").item(0).setTextContent(Integer.toString(userStatistic.getUserCount()));
            document.getElementsByTagName("user_firstName").item(0).setTextContent(userStatistic.getUserFirstName());
            document.getElementsByTagName("user_lastName").item(0).setTextContent(userStatistic.getUserLastName());
            document.getElementsByTagName("stat_age").item(0).setTextContent(Integer.toString(userStatistic.getStatAge()));
            document.getElementsByTagName("stat_sport").item(0).setTextContent(Integer.toString(userStatistic.getStatSport()));
            document.getElementsByTagName("stat_books0").item(0).setTextContent(Integer.toString(userStatistic.getStatBooks0()));
            document.getElementsByTagName("stat_books1").item(0).setTextContent(Integer.toString(userStatistic.getStatBooks1()));
            document.getElementsByTagName("stat_books11").item(0).setTextContent(Integer.toString(userStatistic.getStatBooks11()));

            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource domSource = new DOMSource(document);
            StreamResult streamResult = new StreamResult(file);
            transformer.transform(domSource, streamResult);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
