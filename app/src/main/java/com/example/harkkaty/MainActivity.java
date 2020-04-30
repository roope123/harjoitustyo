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
        Lomakkeenluonti tiedosto = new Lomakkeenluonti();
        tiedosto.tiedosto(context);
    }

    public void onClick(View v)
    {
        openRuokalista("Ravintola 1");
    }

    public void onClick2(View v)
    {
        openRuokalista("Ravintola 2");
    }

    public void onClick3(View v)
    {
        openRuokalista("Ravintola 3");
    }

    public void openRuokalista(String nimi)
    {
        Intent intent = new Intent(this, Ruokalista.class);
        intent.putExtra("nimi", nimi);
        startActivity(intent);
    }

}
