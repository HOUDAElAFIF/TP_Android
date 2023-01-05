package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    String number;
    String username;
    String password;
    TextView c1;
    TextView c2;
    int result;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_actvity);
        c1=findViewById(R.id.c1);
        c2=findViewById(R.id.c2);
//        check the login and password
        Intent intent = getIntent();
//        if(intent.hasExtra("username")) {
//            this.username = intent.getStringExtra("username");
//            this.password = intent.getStringExtra("password");
//            test();
//        }
        if(intent.hasExtra("result")) {
            if(Integer.parseInt(intent.getStringExtra("result").toString())==Integer.parseInt(intent.getStringExtra("c1").toString())+Integer.parseInt(intent.getStringExtra("c2").toString())){
                String url = "http://www.emi.ac.ma";
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                startActivity(i);
            }
        }
    }


    public void test(){
        ActivityCompat.requestPermissions(this, new String[]
                {Manifest.permission.CALL_PHONE}, 1);
    }
    public void call(View view) {
        EditText editText = findViewById(R.id.number);
        this.number = editText.getText().toString();
        Intent intent = new Intent(this,Login.class);
        startActivity(intent);

    }
    @SuppressLint("SuspiciousIndentation")
    @Override
    public void onRequestPermissionsResult(int requestCode,
                                           String[] permissions, int[] grantResults) {
        super.onRequestPermissionsResult(requestCode,
                permissions, grantResults);
        //check the permission type using the requestCode
        if (requestCode == 1) {
            //the array is empty if not granted
            if (grantResults.length>0 &&
                    grantResults[0]== PackageManager.PERMISSION_GRANTED)
                Toast.makeText(this, "GRANTED CALL",
                Toast.LENGTH_SHORT).show();
                if(this.username.equals("TPandINFO") && this.password.equals("secret")){
                    Intent intent2 = new Intent(Intent.ACTION_CALL);
                    intent2.setData(Uri.parse("tel:"+this.number));
                    startActivity(intent2);
                }
        }
    }

    public void goToInternet(View view) {
        Intent intent = new Intent(this,Check.class);
        intent.putExtra("challenge1",c1.getText().toString());
        intent.putExtra("challenge2",c2.getText().toString());
        startActivity(intent);
    }
}