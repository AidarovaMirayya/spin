package com.example.lesson_.authentification;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.lesson_.R;
import com.example.lesson_.database.StoreDatabase;

import java.util.List;

import static com.example.lesson_.authentification.StoreDatabase.TABLE_STUDENTS;
import static com.example.lesson_.database.StoreDatabase.COLUMN_USER_EMAIL;
import static com.example.lesson_.database.StoreDatabase.COLUMN_USER_NAME;
import static com.example.lesson_.database.StoreDatabase.COLUMN_USER_PASSWORD;
import static com.example.lesson_.database.StoreDatabase.COLUMN_USER_PHONE;
import static com.example.lesson_.database.StoreDatabase.TABLE_USERS;

public class RegistrationForm extends AppCompatActivity implements View.OnClickListener {

    private static final String TABLE_LANGUAGE = "";
    private static final String COLUMN_LANGUAGE = "";
    private static final String COLUMN_LANGUAGE_ID = "";
    EditText username, email, password, phone;
    Button btn_submit, btn_login;
    Spinner groupSpinner, countrySpinner;


    StoreDatabase storeDatabase;
    SQLiteDatabase sqLiteDatabase;
    List<String> list = new Arraylist<String>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration_form);

        initViews();
    }

    public void initViews() {
        storeDatabase = new StoreDatabase(this);
        sqLiteDatabase = storeDatabase.getWritableDatabase();

        username = findViewById(R.id.et_person_name);
        email = findViewById(R.id.et_email);
        password = findViewById(R.id.et_password);
        phone = findViewById(R.id.et_phone);
        btn_submit = findViewById(R.id.btn_submit);
        btn_login = findViewById(R.id.btn_login);
        groupSpinner = findViewById(R.id.groupSpinner);

        storeDatabase = new StoreDatabase(this);
        sqLiteDatabase = storeDatabase.getWritableDatabase();

        list.add("class1");
        list.add("class1");
        list.add("class1");

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, list);
        groupSpinner.setAdapter(adapter);

        btn_submit.setOnClickListener(this);
        btn_login.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {

        switch (view.getId()) {
            case R.id.btn_submit:

                boolean submit = true;
                if (username.getText().toString().isEmpty()) {
                    username.setError("Try again");
                    submit = false;
                }

                if (email.getText().toString().isEmpty()) {
                    email.setError("Try again");
                    submit = false;
                }

                if (password.getText().toString().isEmpty()) {
                    password.setError("Try again");
                    submit = false;
                }

                if (phone.getText().toString().isEmpty()) {
                    phone.setError("Try again");
                    submit = false;
                }

                if (submit) {
                    ContentValues Values = new ContentValues();
                    Values.put(COLUMN_USER_NAME, username.getText().toString());
                    Values.put(COLUMN_USER_EMAIL, email.getText().toString());
                    Values.put(COLUMN_USER_PASSWORD, password.getText().toString());
                    Values.put(COLUMN_USER_PHONE, phone.getText().toString());

                    sqLiteDatabase.insert(TABLE_USERS, null, Values);
                    Toast.makeText(this, "Submit success!", Toast.LENGTH_SHORT).show();
                    showDatabaseData();
                } else {
                    Toast.makeText(this, "Fill all info, try again!", Toast.LENGTH_SHORT).show();
                }

                break;

            case R.id.btn_login:
                Intent intent = new Intent(this, LoginActivity.class);
                startActivity(intent);
                break;
        }
    }

    private void showDatabaseData() {

        @SuppressLint("Recycle") Cursor cursor = sqLiteDatabase.rawQuery("SELECT * FROM " + TABLE_STUDENTS, null);
        @SuppressLint("Recycle") Cursor cursor1 = sqLiteDatabase.rawQuery("SELECT * FROM " + TABLE_LANGUAGE, null);

        if ((cursor != null && cursor.getCount() > 0)) {
            while (cursor.moveToNext()) {
                String fname = cursor.getString(cursor.getColumnIndex(COLUMN_USER_NAME));
                String email = cursor.getString(cursor.getColumnIndex(COLUMN_USER_EMAIL));
                String pass = cursor.getString(cursor.getColumnIndex(COLUMN_USER_PASSWORD));


                Log.i("Database", "username: " + fname);
                Log.i("Database", "email: " + email);
                Log.i("Database", "password: " + pass);
                list.add(email);
            }
        }
        if ((cursor1 != null && cursor1.getCount() > 0)) {
            while (cursor1.moveToNext()) {
                String cityname = cursor.getString(cursor1.getColumnIndex(COLUMN_LANGUAGE));
                String cityid = cursor.getString(cursor1.getColumnIndex(COLUMN_LANGUAGE_ID));

                Log.i("Database", "CITY Name: " + cityname);
                Log.i("Database", "id: " + cityid);

                list.add(cityname);
            }
        }
    }
}

