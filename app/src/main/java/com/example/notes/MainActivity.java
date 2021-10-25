package com.example.notes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    public static String usernameKey = "username";

    public void clickFunction(View view) {
        EditText myTextField = (EditText) findViewById(R.id.editName);
        String username = myTextField.getText().toString();

        SharedPreferences sharedPreferences = getSharedPreferences("<Notes>", Context.MODE_PRIVATE);
        sharedPreferences.edit().putString(usernameKey, username).apply();

        Intent intent = new Intent(this, MainActivity2.class);
        startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        SharedPreferences sharedPreferences = getSharedPreferences("<Notes>", Context.MODE_PRIVATE);

        if (!sharedPreferences.getString(usernameKey,"").equals("")) {
            usernameKey = sharedPreferences.getString(usernameKey, "");
            Intent intent = new Intent(this, MainActivity2.class);
            startActivity(intent);
        } else {
            setContentView(R.layout.activity_main);
        }
    }
}