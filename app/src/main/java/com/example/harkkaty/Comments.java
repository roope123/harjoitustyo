package com.example.harkkaty;

import android.content.Context;
import android.util.Xml;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import org.xmlpull.v1.XmlSerializer;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.StringWriter;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

class Comments {

    void file(Context context) {
        //creates and formats new xml-file for comments if it doesn't already exist
        context.getFilesDir();
        File file = new File(context.getFilesDir() + "/Comments.xml");
        System.out.println(context.getFilesDir());
        if (!file.exists())
        {
            XmlSerializer serializer = Xml.newSerializer();
            StringWriter writer = new StringWriter();
            try {
                serializer.setOutput(writer);
                serializer.startDocument("UTF-8", true);
                serializer.startTag("", "lista");
                serializer.text("");
                serializer.endTag("", "lista");
                serializer.endDocument();
                String result = writer.toString();

                FileOutputStream fos = context.openFileOutput("Comments.xml", Context.MODE_PRIVATE);
                fos.write(result.getBytes(), 0, result.getBytes().length);
                fos.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    StringBuilder comments(Context context, String id) {
        //gets id as parameter which makes the method to read all comment data of the specific id
        //string builder appends every comment data and formats it suitable for setting it to comments in "food" activity
        StringBuilder sb = new StringBuilder();
        try {
            DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            FileInputStream fis = context.openFileInput("Comments.xml");
            Document doc = builder.parse(fis);
            doc.getDocumentElement().normalize();

            NodeList nList = doc.getDocumentElement().getElementsByTagName("id" + id);

            Node node;

            for (int i = 0; i < nList.getLength(); i++) {
                node = nList.item(i);

                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element element = (Element) node;
                    sb.append("Nimi: ").append(element.getElementsByTagName("nimi").item(0).getTextContent()).append("\n");
                    sb.append("Ruoan laatu: ").append(element.getElementsByTagName("laatu").item(0).getTextContent()).append("\n");
                    sb.append("Ruokailukokemus: ").append(element.getElementsByTagName("kokemus").item(0).getTextContent()).append("\n");
                    sb.append("Arvio: ").append(element.getElementsByTagName("arvio").item(0).getTextContent()).append("\n\n");
                }
            }

            fis.close();

        } catch (SAXException e) {
            e.printStackTrace();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return sb;
    }

}
