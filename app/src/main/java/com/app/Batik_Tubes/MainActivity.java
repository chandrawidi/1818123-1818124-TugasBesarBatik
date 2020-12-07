package com.app.Batik_Tubes;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void btn_read(View view) {
        Intent b = new Intent(MainActivity.this, ReadActivity.class);
        startActivity(b);
    }
}
