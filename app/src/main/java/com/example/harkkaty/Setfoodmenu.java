package com.example.harkkaty;

import android.content.Context;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;


class Setfoodmenu {

    private ArrayList<FoodItem> fooditem_array = new ArrayList<>();

    void setFoodmenu(String name, int i, Context context)
    {
        //changes the name of restaurant into a file name by erasing space and appending ".xml"
        //reads data from the xml file where the i is the index of the day of the week, which was given in the times class
        fooditem_array.clear();
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

                for(int j = 0; j < 4; j++) {
                    int k = j + 1;
                    fooditem_array.add(new FoodItem(element.getElementsByTagName("nimi" + k).item(0).getTextContent(), element.getElementsByTagName("id" + k).item(0).getTextContent()));
                }
            }
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
    }

    String getName(int x)
    {
        return fooditem_array.get(x - 1).getName();
    }

    String getId(int x)
    {
        return fooditem_array.get(x - 1).getId();
    }

}
