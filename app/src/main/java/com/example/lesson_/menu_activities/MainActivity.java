package com.example.lesson_.menu_activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.lesson_.R;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button btn_Menu1, btn_Menu2, btn_Menu3, btn_Menu4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_Menu1 = findViewById(R.id.btn_menu1);
        btn_Menu2 = findViewById(R.id.btn_menu2);
        btn_Menu3 = findViewById(R.id.btn_menu3);
        btn_Menu4 = findViewById(R.id.btn_menu4);
        btn_Menu1.setOnClickListener(this);
        btn_Menu2.setOnClickListener(this);
        btn_Menu3.setOnClickListener(this);
        btn_Menu4.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.btn_menu1) {
            Intent menu_1 = new Intent(this, MenuActivity1.class);
            startActivity(menu_1);
        } else if (view.getId() == R.id.btn_menu2) {
            Intent menu_2 = new Intent(this, MenuActivity2.class);
            startActivity(menu_2);
        } else if (view.getId() == R.id.btn_menu3) {
            Intent menu_3 = new Intent(this, MenuActivity3.class);
            startActivity(menu_3);
        } else if (view.getId() == R.id.btn_menu4) {
            Intent menu_4 = new Intent(this, MenuActivity4.class);
            startActivity(menu_4);
        }
    }
}