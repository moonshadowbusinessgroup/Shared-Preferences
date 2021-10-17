package com.hadimusthafa.sharedpreferences2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.appcompat.widget.AppCompatTextView;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Toast;

public class ViewDataActivity extends AppCompatActivity {

    AppCompatTextView nameT, emailT, genderT, mobileT, locationT;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_data);

        nameT = findViewById(R.id.nameT);
        emailT = findViewById(R.id.emailT);
        genderT = findViewById(R.id.genderT);
        mobileT = findViewById(R.id.mobileT);
        locationT = findViewById(R.id.locationT);
        loadData();
    }

    public void loadData() {
        SharedPreferences sharedPreferences = getSharedPreferences("com.hadimusthafa.sharedpreferences2", MODE_PRIVATE);
        nameT.setText("Name : " + sharedPreferences.getString("key_name", "default-name"));
        emailT.setText("Email : " + sharedPreferences.getString("key_email", "default-email"));
        genderT.setText("Gender : " + sharedPreferences.getString("key_gender", "default-gender"));
        mobileT.setText("Mobile : " + sharedPreferences.getString("key_mobile", "default-mobile"));
        locationT.setText(" Location : " + sharedPreferences.getString("key_location", "default-location"));
    }
}