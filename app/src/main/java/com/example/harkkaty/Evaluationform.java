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


public class Evaluationform extends AppCompatActivity {

    String food;
    String id;
    TextView text;
    EditText name;
    EditText phonenbr;
    EditText email;
    EditText quality;
    EditText experience;
    EditText evaluation;
    Context context;
    String name1;
    String phonenbr1;
    String email1;
    String quality1;
    String experience1;
    String evaluation1;

    Form form = new Form();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_arvostelulomake);
        context = this;
        //gets intent and sets the food name and id into variables
        Intent intent3 = getIntent();
        food = intent3.getStringExtra("food");
        id = intent3.getStringExtra("id");
        setData();
    }

    public void setData() {
        //sets the texts into TextViews and EditViews
        //Text in the EditViews are read from the Form.xml or it can be default
        text = (TextView) findViewById(R.id.textView16);
        text.setText(food);
        name = (EditText) findViewById(R.id.editText);
        phonenbr = (EditText) findViewById(R.id.editText2);
        email = (EditText) findViewById(R.id.editText3);
        quality = (EditText) findViewById(R.id.editText4);
        experience = (EditText) findViewById(R.id.editText5);
        evaluation = (EditText) findViewById(R.id.editText6);
        form.getData(context);

        name.setText(form.getName());
        phonenbr.setText(form.getPhonenbr());
        email.setText(form.getEmail());
        quality.setText(form.getQuality());
        experience.setText(form.getExperience());
        evaluation.setText(form.getEvaluation());

    }

    @SuppressLint("SetTextI18n")
    public void send(View v) {
        //gets the texts from the text fields and pass them as variables to the send method
        //after sent, toast pops up and the field values are set to default
        name1 = name.getText().toString();
        phonenbr1 = phonenbr.getText().toString();
        email1 = email.getText().toString();
        quality1 = quality.getText().toString();
        experience1 = experience.getText().toString();
        evaluation1 = evaluation.getText().toString();

        form.send(context, id, name1, phonenbr1, email1, quality1, experience1, evaluation1);

        Toast toast = Toast.makeText(getApplicationContext(), "Arvostelu on lähetetty", Toast.LENGTH_SHORT);
        toast.show();

        name.setText("Nimi");
        phonenbr.setText("Puhelinnumero");
        email.setText("Sähköposti");
        quality.setText("");
        experience.setText("");
        evaluation.setText("");
    }

    public void save(View v)
    {
        //gets the texts from the text fields and pass them as variables to the save method
        //toast pops up
        String name1 = name.getText().toString();
        String phonenbr1 = phonenbr.getText().toString();
        String email1 = email.getText().toString();
        String quality1 = quality.getText().toString();
        String experience1 = experience.getText().toString();
        String evaluation1 = evaluation.getText().toString();

        form.save(context, name1, phonenbr1, email1, quality1, experience1, evaluation1);

        Toast toast = Toast.makeText(getApplicationContext(), "Tiedot on tallennettu väliaikaisesti",Toast.LENGTH_SHORT);
        toast.show();
    }

}
