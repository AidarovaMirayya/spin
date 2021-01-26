package com.example.lesson_.menu_activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.lesson_.R;

public class MenuActivity3 extends AppCompatActivity implements View.OnClickListener {
    Button btn_Back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu1);

        btn_Back = findViewById(R.id.btn_back);
        btn_Back.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.btn_back) {
            Intent main = new Intent(this, MainActivity.class);
            startActivity(main);
        }
    }
}