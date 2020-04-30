package com.example.harkkaty;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import android.widget.TextView;
import android.widget.Toast;


public class Arvostelulomake extends AppCompatActivity {

    String ruoka;
    String id;
    TextView teksti;
    EditText nimi;
    EditText puhnro;
    EditText sposti;
    EditText laatu;
    EditText kokemus;
    EditText arvio;
    Context context;
    String nimi1;
    String puhnro1;
    String sposti1;
    String laatu1;
    String kokemus1;
    String arvio1;

    Lomake lomake = new Lomake();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_arvostelulomake);
        context = this;
        Intent intent3 = getIntent();
        ruoka = intent3.getStringExtra("ruoka");
        id = intent3.getStringExtra("id");
        setData();
    }

    public void setData() {
        teksti = (TextView) findViewById(R.id.textView16);
        teksti.setText(ruoka);
        nimi = (EditText) findViewById(R.id.editText);
        puhnro = (EditText) findViewById(R.id.editText2);
        sposti = (EditText) findViewById(R.id.editText3);
        laatu = (EditText) findViewById(R.id.editText4);
        kokemus = (EditText) findViewById(R.id.editText5);
        arvio = (EditText) findViewById(R.id.editText6);
        lomake.getData(context);

        nimi.setText(lomake.getNimi());
        puhnro.setText(lomake.getPuhnro());
        sposti.setText(lomake.getSposti());
        laatu.setText(lomake.getLaatu());
        kokemus.setText(lomake.getKokemus());
        arvio.setText(lomake.getArvio());

    }

    @SuppressLint("SetTextI18n")
    public void laheta(View v) {
        nimi1 = nimi.getText().toString();
        puhnro1 = puhnro.getText().toString();
        sposti1 = sposti.getText().toString();
        laatu1 = laatu.getText().toString();
        kokemus1 = kokemus.getText().toString();
        arvio1 = arvio.getText().toString();

        lomake.laheta(context, id, nimi1, puhnro1, sposti1, laatu1, kokemus1, arvio1);

        Toast toast = Toast.makeText(getApplicationContext(), "Arvostelu on lähetetty", Toast.LENGTH_SHORT);
        toast.show();

        nimi.setText("Nimi");
        puhnro.setText("Puhelinnumero");
        sposti.setText("Sähköposti");
        laatu.setText("");
        kokemus.setText("");
        arvio.setText("");
    }

    public void tallenna(View v)
    {
        String nimi1 = nimi.getText().toString();
        String puhnro1 = puhnro.getText().toString();
        String sposti1 = sposti.getText().toString();
        String laatu1 = laatu.getText().toString();
        String kokemus1 = kokemus.getText().toString();
        String arvio1 = arvio.getText().toString();

        lomake.tallenna(context, nimi1, puhnro1, sposti1, laatu1, kokemus1, arvio1);

        Toast toast = Toast.makeText(getApplicationContext(), "Tiedot on tallennettu väliaikaisesti",Toast.LENGTH_SHORT);
        toast.show();
    }

}
