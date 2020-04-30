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
import java.io.File;
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

class Lomake {

    private String nimi;
    private String puhnro;
    private String sposti;
    private String laatu;
    private String kokemus;
    private String arvio;

    void getData(Context context)
    {
        try {
            DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            FileInputStream fis = context.openFileInput("Lomake.xml");
            Document doc = builder.parse(fis);
            doc.getDocumentElement().normalize();

            NodeList nList = doc.getDocumentElement().getElementsByTagName("id");

            Node node;

            node = nList.item(0);

            if (node.getNodeType() == Node.ELEMENT_NODE) {
                Element element = (Element) node;
                nimi = element.getElementsByTagName("nimi").item(0).getTextContent();
                puhnro = element.getElementsByTagName("puhnro").item(0).getTextContent();
                sposti = element.getElementsByTagName("sposti").item(0).getTextContent();
                laatu = element.getElementsByTagName("laatu").item(0).getTextContent();
                kokemus = element.getElementsByTagName("kokemus").item(0).getTextContent();
                arvio = element.getElementsByTagName("arvio").item(0).getTextContent();
            }

        } catch (SAXException e) {
            e.printStackTrace();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    String getNimi()
    {
        return nimi;
    }

    String getPuhnro()
    {
        return puhnro;
    }

    String getSposti()
    {
        return sposti;
    }

    String getLaatu()
    {
        return laatu;
    }

    String getKokemus()
    {
        return kokemus;
    }

    String getArvio()
    {
        return arvio;
    }

    void laheta(Context context, String id, String nimi, String puhnro, String sposti, String laatu, String kokemus, String arvio) {
        XmlSerializer serializer = Xml.newSerializer();
        StringWriter writer = new StringWriter();
        try {
            serializer.setOutput(writer);
            serializer.startDocument(null, false);
            serializer.startTag("", "id" + id);

            serializer.startTag("", "nimi");
            serializer.text(nimi);
            serializer.endTag("", "nimi");

            serializer.startTag("", "puhnro");
            serializer.text(puhnro);
            serializer.endTag("", "puhnro");

            serializer.startTag("", "sposti");
            serializer.text(sposti);
            serializer.endTag("", "sposti");

            serializer.startTag("", "laatu");
            serializer.text(laatu);
            serializer.endTag("", "laatu");

            serializer.startTag("", "kokemus");
            serializer.text(kokemus);
            serializer.endTag("", "kokemus");

            serializer.startTag("", "arvio");
            serializer.text(arvio);
            serializer.endTag("", "arvio");

            serializer.endTag("", "id" + id);
            serializer.endDocument();
            String result = writer.toString();
            result = result.substring(result.indexOf(">") + 1);
            writer.close();


            StringBuilder sb = new StringBuilder();
            InputStream is = context.openFileInput("Kommentit.xml");
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


            FileOutputStream fos = context.openFileOutput("Kommentit.xml", Context.MODE_PRIVATE);
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

            FileOutputStream fos2 = context.openFileOutput("Lomake.xml", Context.MODE_PRIVATE);
            fos2.write(result2.getBytes(), 0, result2.getBytes().length);
            fos2.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    void tallenna(Context context, String nimi, String puhnro, String sposti, String laatu, String kokemus, String arvio)
    {
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
            serializer.text(nimi);
            serializer.endTag("", "nimi");

            serializer.startTag("", "puhnro");
            serializer.text(puhnro);
            serializer.endTag("", "puhnro");

            serializer.startTag("", "sposti");
            serializer.text(sposti);
            serializer.endTag("", "sposti");

            serializer.startTag("", "laatu");
            serializer.text(laatu);
            serializer.endTag("", "laatu");

            serializer.startTag("", "kokemus");
            serializer.text(kokemus);
            serializer.endTag("", "kokemus");

            serializer.startTag("", "arvio");
            serializer.text(arvio);
            serializer.endTag("", "arvio");

            serializer.endTag("", "id");
            serializer.endTag("", "lista");
            serializer.endDocument();
            String result = writer.toString();

            FileOutputStream fos = context.openFileOutput("Lomake.xml", Context.MODE_PRIVATE);
            fos.write(result.getBytes(), 0, result.getBytes().length);
            fos.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
