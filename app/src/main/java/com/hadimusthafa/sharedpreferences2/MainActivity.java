package com.hadimusthafa.sharedpreferences2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.appcompat.widget.AppCompatTextView;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    AppCompatEditText nameE, emailE, genderE, mobileE, locationE;
    AppCompatButton saveB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nameE = findViewById(R.id.nameE);
        emailE = findViewById(R.id.emailE);
        genderE = findViewById(R.id.genderE);
        mobileE = findViewById(R.id.mobileE);
        locationE = findViewById(R.id.locationE);

        saveB = findViewById(R.id.saveB);

        saveB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                saveData();
            }
        });
    }

    public void saveData() {

        String name = nameE.getText().toString().trim();
        String email = emailE.getText().toString().trim();
        String gender = genderE.getText().toString().trim();
        String mobile = mobileE.getText().toString().trim();
        String location = locationE.getText().toString().trim();

        if (!name.isEmpty() && !email.isEmpty() && !gender.isEmpty() && !mobile.isEmpty() && !location.isEmpty()) {
            SharedPreferences sharedPreferences = getSharedPreferences("com.hadimusthafa.sharedpreferences2", MODE_PRIVATE);
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putString("key_name", name);
            editor.putString("key_email", email);
            editor.putString("key_gender", gender);
            editor.putString("key_mobile", mobile);
            editor.putString("key_location", location);
            editor.apply();
            Toast.makeText(getApplicationContext(), "Save data successfully", Toast.LENGTH_SHORT).show();

            Intent intent = new Intent(this, ViewDataActivity.class);
            startActivity(intent);
        } else {
            Toast.makeText(getApplicationContext(), "Enter full details", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    protected void onResume() {
        nameE.setText("");
        emailE.setText("");
        genderE.setText("");
        mobileE.setText("");
        locationE.setText("");
        super.onResume();
    }
}