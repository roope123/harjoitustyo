package com.example.harkkaty;

import android.content.Context;
import android.util.Xml;

import org.xmlpull.v1.XmlSerializer;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.StringWriter;

class Createform {


    void file(Context context) {
        //creating an xml file which contains default data of the evaluation form of the food
        //serializer formats the text right for xml
        //FileOutputStream writes the text to a file
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
            serializer.text("Nimi");
            serializer.endTag("", "nimi");

            serializer.startTag("", "puhnro");
            serializer.text("Puhelinnumero");
            serializer.endTag("", "puhnro");

            serializer.startTag("", "sposti");
            serializer.text("Sähköposti");
            serializer.endTag("", "sposti");

            serializer.startTag("", "laatu");
            serializer.text("");
            serializer.endTag("", "laatu");

            serializer.startTag("", "kokemus");
            serializer.text("");
            serializer.endTag("", "kokemus");

            serializer.startTag("", "arvio");
            serializer.text("");
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
