package com.example.ngnng;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    Button btnTV, btnTA;
    private final String NAME="ngonngu";
    private final String NGONNGU="value";
    SharedPreferences shrPf;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnTV = (Button)this.findViewById(R.id.button);
        btnTA= (Button) this.findViewById(R.id.button2);
        shrPf = getSharedPreferences(NAME, Context.MODE_PRIVATE);
        final SharedPreferences.Editor editor= shrPf.edit();
        btnTV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                editor.putString(NGONNGU,"vi");
                editor.apply();
                Intent mIntent= new Intent(MainActivity.this,DangNhap.class);
                startActivity(mIntent);
                finish();
            }
        });
        btnTA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                editor.putString(NGONNGU,"en");
                editor.apply();
                Intent mIntent= new Intent(MainActivity.this,DangNhap.class);
                startActivity(mIntent);
                finish();
            }
        });
    }
}
