package com.example.ngnng;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.os.Build;
import android.os.Bundle;
import android.util.DisplayMetrics;

import java.util.Locale;

public class DangNhap extends Activity {
    SharedPreferences shrPf;
    Locale mLocale;
    private final String NAME="ngonngu";
    private final String NGONNGU="value";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dang_nhap);
        shrPf= getSharedPreferences(NAME, Context.MODE_PRIVATE);
        String language= shrPf.getString(NGONNGU,"null");
        if(language.toString().compareTo("vi")==0){
            mLocale = new Locale("vi", "VN");
            onChangeLanguage(mLocale);
        }
        else {
            mLocale = new Locale("en", "US");
            onChangeLanguage(mLocale);
        }
    }
    private void onChangeLanguage(Locale locale){
        DisplayMetrics displayMetrics = getBaseContext().getResources().getDisplayMetrics();
        Configuration configuration= new Configuration();
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1){
            configuration.setLocale(locale);

        }
        getBaseContext().getResources().updateConfiguration(configuration,displayMetrics);
        Intent intent= new Intent(DangNhap.this, DangNhap.class);
        startActivity(intent);
        finish();
    }
//    public void check(){
//        shrPf= getSharedPreferences(NAME, Context.MODE_PRIVATE);
//        String language= shrPf.getString(NGONNGU,"null");
//
//    }
}
