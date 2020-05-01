package com.example.harkkaty;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;


public class Food extends AppCompatActivity {

    String food;
    String id;
    TextView text;
    TextView text2;
    Context context;

    Comments comments = new Comments();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ruoka);
        context = this;
        comments.file(context);
        setData();
    }

    @Override
    protected void onResume() {
        //keeps the comments updated
        super.onResume();
        setData();
    }

    public void setData() {
        //gets intent and sets food name and id into variables, also food into TextView
        //gets comments from the comments file and sets them into TextView
        Intent intent2 = getIntent();
        food = intent2.getStringExtra("food");
        id = intent2.getStringExtra("id");
        text = (TextView) findViewById(R.id.textView9);
        text.setText(food);
        text2 = (TextView) findViewById(R.id.textView13);
        text2.setText(comments.comments(context, id));
    }


    public void openForm(View v) {
        //intent passes the name of selected food and its id to the next activity
        Intent intent3 = new Intent(this, Evaluationform.class);
        intent3.putExtra("food", food);
        intent3.putExtra("id", id);
        startActivity(intent3);
    }

}
