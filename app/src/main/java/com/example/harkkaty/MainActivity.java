package com.example.harkkaty;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;


public class MainActivity extends AppCompatActivity {

    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        context = this;
        Createform file = new Createform();
        file.file(context);
    }

    public void onClick(View v)
    {
        openFoodmenu("Ravintola 1");
    }

    public void onClick2(View v)
    {
        openFoodmenu("Ravintola 2");
    }

    public void onClick3(View v)
    {
        openFoodmenu("Ravintola 3");
    }

    public void openFoodmenu(String name)
    {
        //intent passes the name of selected restaurant to the next activity
        Intent intent = new Intent(this, Foodmenu.class);
        intent.putExtra("name", name);
        startActivity(intent);
    }

}
