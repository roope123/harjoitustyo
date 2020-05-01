package com.example.harkkaty;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class Foodmenu extends AppCompatActivity {
    String name;
    String name1;
    String name2;
    String name3;
    String name4;
    String id1;
    String id2;
    String id3;
    String id4;
    TextView text;
    TextView date;
    Button food1_button;
    Button food2_button;
    Button soup_button;
    Button vege_button;

    Times times = new Times();
    Setfoodmenu foodmenu = new Setfoodmenu();

    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ruokalista);
        context = this;
        startData();
    }

    public void nextDate(View v)
    {
        //sets next date into TextView and daily menu of the restaurant in class Setfoodmenu
        date.setText(times.setDate(1));
        foodmenu.setFoodmenu(name, times.dateCheck(), context);
        setData();
    }

    public void previousDate(View v)
    {
        //sets previous date into TextView and daily menu of the restaurant in class Setfoodmenu
        date.setText(times.setDate(-1));
        foodmenu.setFoodmenu(name, times.dateCheck(), context);
        setData();
    }

    public void startData()
    {
        //gets intent and sets name of the restaurant, daily menu and current date into TextViews
        food1_button = (Button) findViewById(R.id.ruoka1);
        food2_button = (Button) findViewById(R.id.ruoka2);
        soup_button = (Button) findViewById(R.id.keitto);
        vege_button = (Button) findViewById(R.id.kasvis);
        Intent intent = getIntent();
        name = intent.getStringExtra("name");
        text = (TextView) findViewById(R.id.textView3);
        text.setText(name);
        date = (TextView) findViewById(R.id.textView4);
        date.setText(times.getFormatted_date());
        foodmenu.setFoodmenu(name, times.dateCheck(),context);
        setData();
    }

    public void setData()
    {
        //Gets names and id's of foods of the day and sets them into variables and into TextViews
        name1 = foodmenu.getName1();
        id1 = foodmenu.getId1();
        food1_button.setText(name1);

        name2 = foodmenu.getName2();
        id2 = foodmenu.getId2();
        food2_button.setText(name2);

        name3 = foodmenu.getName3();
        id3 = foodmenu.getId3();
        soup_button.setText(name3);

        name4 = foodmenu.getName4();
        id4 = foodmenu.getId4();
        vege_button.setText(name4);

    }


    public void onClick(View v)
    {
        openFood(name1, id1);
    }

    public void onClick2(View v)
    {
        openFood(name2, id2);
    }

    public void onClick3(View v)
    {
        openFood(name3, id3);
    }

    public void onClick4(View v)
    {
        openFood(name4, id4);
    }

    public void openFood(String food, String id)
    {
        //intent passes the name of selected food and its id to the next activity
        Intent intent2 = new Intent(this, Food.class);
        intent2.putExtra("food", food);
        intent2.putExtra("id", id);
        startActivity(intent2);
    }

}
