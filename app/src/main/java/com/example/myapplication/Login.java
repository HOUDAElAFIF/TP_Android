package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class Login extends AppCompatActivity {
    EditText editText1;
    EditText editText2;
    String number;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        editText1 = findViewById(R.id.username);
        editText2 = findViewById(R.id.password);
    }

    public void login(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        intent.putExtra("username",editText1.getText());
        intent.putExtra("password",editText2.getText());
        startActivity(intent);
    }
}