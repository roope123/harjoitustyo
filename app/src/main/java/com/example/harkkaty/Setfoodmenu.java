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

class Setfoodmenu {

    private String name1;
    private String name2;
    private String name3;
    private String name4;
    private String id1;
    private String id2;
    private String id3;
    private String id4;


    void setFoodmenu(String name, int i, Context context)
    {
        //changes the name of restaurant into a file name by erasing space and appending ".xml"
        //reads data from the xml file where the i is the index of the day of the week, which was given in the times class
        String restaurant = name.replaceAll(" ", "");
        try
        {
            DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            InputStream is = context.getAssets().open(restaurant + ".xml");
            Document doc = builder.parse(is);
            doc.getDocumentElement().normalize();

            NodeList nList = doc.getDocumentElement().getElementsByTagName("paiva");

            Node node;

            node = nList.item(i);

            if (node.getNodeType() == Node.ELEMENT_NODE)
            {
                Element element = (Element) node;

                name1 = element.getElementsByTagName("nimi1").item(0).getTextContent();
                id1 = element.getElementsByTagName("id1").item(0).getTextContent();

                name2 = element.getElementsByTagName("nimi2").item(0).getTextContent();
                id2 = element.getElementsByTagName("id2").item(0).getTextContent();

                name3 = element.getElementsByTagName("nimi3").item(0).getTextContent();
                id3 = element.getElementsByTagName("id3").item(0).getTextContent();

                name4 = element.getElementsByTagName("nimi4").item(0).getTextContent();
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

    String getName1()
    {
        return name1;
    }

    String getName2()
    {
        return name2;
    }

    String getName3()
    {
        return name3;
    }

    String getName4()
    {
        return name4;
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
