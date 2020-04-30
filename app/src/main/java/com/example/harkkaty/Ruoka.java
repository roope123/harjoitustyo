package com.example.harkkaty;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;


public class Ruoka extends AppCompatActivity {

    String ruoka;
    String id;
    TextView teksti;
    TextView teksti2;
    Context context;

    Kommentit kommentit = new Kommentit();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ruoka);
        context = this;
        kommentit.tiedosto(context);
        setData();
    }

    @Override
    protected void onResume() {
        super.onResume();
        setData();
    }

    public void setData() {
        Intent intent2 = getIntent();
        ruoka = intent2.getStringExtra("ruoka");
        id = intent2.getStringExtra("id");
        teksti = (TextView) findViewById(R.id.textView9);
        teksti.setText(ruoka);
        teksti2 = (TextView) findViewById(R.id.textView13);
        teksti2.setText(kommentit.kommentit(context, id));
    }


    public void openLomake(View v) {
        Intent intent3 = new Intent(this, Arvostelulomake.class);
        intent3.putExtra("ruoka", ruoka);
        intent3.putExtra("id", id);
        startActivity(intent3);
    }

}
