package com.example.harkkaty;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class Ruokalista extends AppCompatActivity {
    String nimi;
    String nimi1;
    String nimi2;
    String nimi3;
    String nimi4;
    String id1;
    String id2;
    String id3;
    String id4;
    TextView teksti;
    TextView pvm;
    Button ruoka1_button;
    Button ruoka2_button;
    Button keitto_button;
    Button kasvis_button;

    Ajat ajat = new Ajat();
    Setruokalista ruokalista = new Setruokalista();

    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ruokalista);
        context = this;
        startData();
    }

    public void seuraavaPvm(View v)
    {
        pvm.setText(ajat.setPvm(1));
        ruokalista.setRuokalista(nimi, ajat.pvmCheck(), context);
        setData();
    }

    public void edellinenPvm(View v)
    {
        pvm.setText(ajat.setPvm(-1));
        ruokalista.setRuokalista(nimi, ajat.pvmCheck(), context);
        setData();
    }

    public void startData()
    {
        ruoka1_button = (Button) findViewById(R.id.ruoka1);
        ruoka2_button = (Button) findViewById(R.id.ruoka2);
        keitto_button = (Button) findViewById(R.id.keitto);
        kasvis_button = (Button) findViewById(R.id.kasvis);
        Intent intent = getIntent();
        nimi = intent.getStringExtra("nimi");
        teksti = (TextView) findViewById(R.id.textView3);
        teksti.setText(nimi);
        pvm = (TextView) findViewById(R.id.textView4);
        pvm.setText(ajat.getFormatted_date());
        ruokalista.setRuokalista(nimi, ajat.pvmCheck(),context);
        setData();
    }

    public void setData()
    {
        nimi1 = ruokalista.getNimi1();
        id1 = ruokalista.getId1();
        ruoka1_button.setText(nimi1);

        nimi2 = ruokalista.getNimi2();
        id2 = ruokalista.getId2();
        ruoka2_button.setText(nimi2);

        nimi3 = ruokalista.getNimi3();
        id3 = ruokalista.getId3();
        keitto_button.setText(nimi3);

        nimi4 = ruokalista.getNimi4();
        id4 = ruokalista.getId4();
        kasvis_button.setText(nimi4);

    }


    public void onClick(View v)
    {
        openRuoka(nimi1, id1);
    }

    public void onClick2(View v)
    {
        openRuoka(nimi2, id2);
    }

    public void onClick3(View v)
    {
        openRuoka(nimi3, id3);
    }

    public void onClick4(View v)
    {
        openRuoka(nimi4, id4);
    }

    public void openRuoka(String ruoka, String id)
    {
        Intent intent2 = new Intent(this, Ruoka.class);
        intent2.putExtra("ruoka", ruoka);
        intent2.putExtra("id", id);
        startActivity(intent2);
    }

}
