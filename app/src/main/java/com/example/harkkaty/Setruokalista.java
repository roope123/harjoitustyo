package com.example.harkkaty;

import android.content.Context;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import java.io.IOException;
import java.io.InputStream;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

class Setruokalista {

    private String nimi1;
    private String nimi2;
    private String nimi3;
    private String nimi4;
    private String id1;
    private String id2;
    private String id3;
    private String id4;


    void setRuokalista(String nimi, int i, Context context)
    {
        String ravintola = nimi.replaceAll(" ", "");
        try
        {
            DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            InputStream is = context.getAssets().open(ravintola + ".xml");
            Document doc = builder.parse(is);
            doc.getDocumentElement().normalize();

            NodeList nList = doc.getDocumentElement().getElementsByTagName("paiva");

            Node node;

            node = nList.item(i);

            if (node.getNodeType() == Node.ELEMENT_NODE)
            {
                Element element = (Element) node;

                nimi1 = element.getElementsByTagName("nimi1").item(0).getTextContent();
                id1 = element.getElementsByTagName("id1").item(0).getTextContent();

                nimi2 = element.getElementsByTagName("nimi2").item(0).getTextContent();
                id2 = element.getElementsByTagName("id2").item(0).getTextContent();

                nimi3 = element.getElementsByTagName("nimi3").item(0).getTextContent();
                id3 = element.getElementsByTagName("id3").item(0).getTextContent();

                nimi4 = element.getElementsByTagName("nimi4").item(0).getTextContent();
                id4 = element.getElementsByTagName("id4").item(0).getTextContent();
            }
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
    }

    String getNimi1()
    {
        return nimi1;
    }

    String getNimi2()
    {
        return nimi2;
    }

    String getNimi3()
    {
        return nimi3;
    }

    String getNimi4()
    {
        return nimi4;
    }

    String getId1()
    {
        return id1;
    }

    String getId2()
    {
        return id2;
    }

    String getId3()
    {
        return id3;
    }

    String getId4()
    {
        return id4;
    }
}
