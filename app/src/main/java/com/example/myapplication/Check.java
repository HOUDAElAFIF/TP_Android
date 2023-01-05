package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class Check extends AppCompatActivity {
    TextView textView1 ;
    TextView textView2 ;
    EditText editText;
    int c1;
    int c2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check);
        textView1 = findViewById(R.id.challenge1);
        textView2 = findViewById(R.id.challenge2);
        Intent intent = getIntent();
        if(intent.hasExtra("challenge1")){
            c1 = Integer.parseInt(intent.getStringExtra("challenge1").toString());
            c2 = Integer.parseInt(intent.getStringExtra("challenge2").toString());
            textView1.setText(intent.getStringExtra("challenge1").toString());
            textView2.setText(intent.getStringExtra("challenge2").toString());
        }
    }

    public void check(View view) {
        editText = findViewById(R.id.result);
        Intent intent = new Intent(this, MainActivity.class);
        intent.putExtra("result",editText.getText().toString());
        intent.putExtra("c1",String.valueOf(c1));
        intent.putExtra("c2",String.valueOf(c2));
        startActivity(intent);
    }
}