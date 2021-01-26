package com.example.lesson_.menu_activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;

import com.example.lesson_.R;

public class MenuActivity2 extends AppCompatActivity implements View.OnClickListener {
    Button btn_Back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu1);
        setContentView(R.layout.activity_menu2);

        btn_Back = findViewById(R.id.btn_back);
        btn_Back.setOnClickListener(this);
        Button press_btn = (Button)findViewById(R.id.btn_press);
        registerForContextMenu(press_btn);
    }


    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.btn_back) {
            Intent main = new Intent(this, MainActivity.class);
            startActivity(main);
        }
    }


    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.context_menu, menu);
    }

    public boolean onContextItemSelected(MenuItem item) {
        //find out which menu item was pressed
        switch (item.getItemId()) {
            case R.id.create_option:
                doOptionOne();
                return true;
            case R.id.open_option:
                doOptionTwo();
                return true;
            default:
                return false;
        }
    }
    private void doOptionOne() {
        Toast.makeText(this, "Option One Chosen...", Toast.LENGTH_LONG).show();
    }

    private void doOptionTwo() {
        Toast.makeText(this, "Option Two Chosen...", Toast.LENGTH_LONG).show();
    }
}