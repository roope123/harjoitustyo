package com.example.harkkaty;

import android.content.Context;
import android.util.Xml;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import org.xmlpull.v1.XmlSerializer;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.StringWriter;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

class Form {

    private String name;
    private String phonenbr;
    private String email;
    private String quality;
    private String experience;
    private String evaluation;

    void getData(Context context)
    {
        //reads the Form.xml which contains temporarily saved input data of the evaluation form
        try {
            DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            FileInputStream fis = context.openFileInput("Form.xml");
            Document doc = builder.parse(fis);
            doc.getDocumentElement().normalize();

            NodeList nList = doc.getDocumentElement().getElementsByTagName("id");

            Node node;

            node = nList.item(0);

            if (node.getNodeType() == Node.ELEMENT_NODE) {
                Element element = (Element) node;
                name = element.getElementsByTagName("nimi").item(0).getTextContent();
                phonenbr = element.getElementsByTagName("puhnro").item(0).getTextContent();
                email = element.getElementsByTagName("sposti").item(0).getTextContent();
                quality = element.getElementsByTagName("laatu").item(0).getTextContent();
                experience = element.getElementsByTagName("kokemus").item(0).getTextContent();
                evaluation = element.getElementsByTagName("arvio").item(0).getTextContent();
            }

        } catch (SAXException e) {
            e.printStackTrace();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    String getName()
    {
        return name;
    }

    String getPhonenbr()
    {
        return phonenbr;
    }

    String getEmail()
    {
        return email;
    }

    String getQuality()
    {
        return quality;
    }

    String getExperience()
    {
        return experience;
    }

    String getEvaluation()
    {
        return evaluation;
    }

    void send(Context context, String id, String name, String phonenbr, String email, String quality, String experience, String evaluation) {
        //saves input data into comments file by reading the file first, removing end tag "lista" and appending input data in xml format and end tag "lista" in to it
        //in the end changes the saved data of the form into default
        XmlSerializer serializer = Xml.newSerializer();
        StringWriter writer = new StringWriter();
        try {
            serializer.setOutput(writer);
            serializer.startDocument(null, false);
            serializer.startTag("", "id" + id);

            serializer.startTag("", "nimi");
            serializer.text(name);
            serializer.endTag("", "nimi");

            serializer.startTag("", "puhnro");
            serializer.text(phonenbr);
            serializer.endTag("", "puhnro");

            serializer.startTag("", "sposti");
            serializer.text(email);
            serializer.endTag("", "sposti");

            serializer.startTag("", "laatu");
            serializer.text(quality);
            serializer.endTag("", "laatu");

            serializer.startTag("", "kokemus");
            serializer.text(experience);
            serializer.endTag("", "kokemus");

            serializer.startTag("", "arvio");
            serializer.text(evaluation);
            serializer.endTag("", "arvio");

            serializer.endTag("", "id" + id);
            serializer.endDocument();
            String result = writer.toString();
            result = result.substring(result.indexOf(">") + 1);
            writer.close();


            StringBuilder sb = new StringBuilder();
            InputStream is = context.openFileInput("Comments.xml");
            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            String s;

            while ((s = br.readLine()) != null) {
                sb.append(s);
            }
            is.close();

            sb = sb.replace(sb.length() - 8, sb.length() + 1, "");
            sb.append(result);
            sb.append("</lista>");
            String string = sb.toString();


            FileOutputStream fos = context.openFileOutput("Comments.xml", Context.MODE_PRIVATE);
            fos.write(string.getBytes(), 0, string.getBytes().length);
            fos.close();


            context.getFilesDir();
            System.out.println(context.getFilesDir());

            XmlSerializer serializer2 = Xml.newSerializer();
            StringWriter writer2 = new StringWriter();

            serializer2.setOutput(writer2);
            serializer2.startDocument("UTF-8", true);
            serializer2.startTag("", "lista");
            serializer2.startTag("", "id");

            serializer2.startTag("", "nimi");
            serializer2.text("Nimi");
            serializer2.endTag("", "nimi");

            serializer2.startTag("", "puhnro");
            serializer2.text("Puhelinnumero");
            serializer2.endTag("", "puhnro");

            serializer2.startTag("", "sposti");
            serializer2.text("Sähköposti");
            serializer2.endTag("", "sposti");

            serializer2.startTag("", "laatu");
            serializer2.text("");
            serializer2.endTag("", "laatu");

            serializer2.startTag("", "kokemus");
            serializer2.text("");
            serializer2.endTag("", "kokemus");

            serializer2.startTag("", "arvio");
            serializer2.text("");
            serializer2.endTag("", "arvio");

            serializer2.endTag("", "id");
            serializer2.endTag("", "lista");
            serializer2.endDocument();
            String result2 = writer2.toString();

            FileOutputStream fos2 = context.openFileOutput("Form.xml", Context.MODE_PRIVATE);
            fos2.write(result2.getBytes(), 0, result2.getBytes().length);
            fos2.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    void save(Context context, String name, String phonenbr, String email, String quality, String experience, String evaluation)
    {
        //saves input data temporarily into xml file
        context.getFilesDir();
        System.out.println(context.getFilesDir());

        XmlSerializer serializer = Xml.newSerializer();
        StringWriter writer = new StringWriter();
        try {
            serializer.setOutput(writer);
            serializer.startDocument("UTF-8", true);
            serializer.startTag("", "lista");
            serializer.startTag("", "id");

            serializer.startTag("", "nimi");
            serializer.text(name);
            serializer.endTag("", "nimi");

            serializer.startTag("", "puhnro");
            serializer.text(phonenbr);
            serializer.endTag("", "puhnro");

            serializer.startTag("", "sposti");
            serializer.text(email);
            serializer.endTag("", "sposti");

            serializer.startTag("", "laatu");
            serializer.text(quality);
            serializer.endTag("", "laatu");

            serializer.startTag("", "kokemus");
            serializer.text(experience);
            serializer.endTag("", "kokemus");

            serializer.startTag("", "arvio");
            serializer.text(evaluation);
            serializer.endTag("", "arvio");

            serializer.endTag("", "id");
            serializer.endTag("", "lista");
            serializer.endDocument();
            String result = writer.toString();

            FileOutputStream fos = context.openFileOutput("Form.xml", Context.MODE_PRIVATE);
            fos.write(result.getBytes(), 0, result.getBytes().length);
            fos.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
