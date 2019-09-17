package com.project.hngtaskone;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

public class Dashboard extends AppCompatActivity {
    TextView userName;
    TextView fullName;
    TextView phoneNumber;
    TextView emailAddress;
    Button btnLogOut;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        //findViews by ID
        userName = findViewById(R.id.username_dash);
        fullName = findViewById(R.id.fullname_dash);
        phoneNumber = findViewById(R.id.phone_dash);
        emailAddress = findViewById(R.id.email_dash);
        btnLogOut = findViewById(R.id.button_dash);

        //get user detaild in preferences
        SharedPreferences sharedPreferences = getSharedPreferences("My Preferences", 0);
        String pref_user = sharedPreferences.getString("userName", "");
        String pref_full_name = sharedPreferences.getString("FullName", "");
        String pref_phone_number = sharedPreferences.getString("phone", "");
        String pref_email = sharedPreferences.getString("email", "");

        //set texts in different views
        userName.setText(pref_user);
        fullName.setText(pref_full_name);
        phoneNumber.setText(pref_phone_number);
        emailAddress.setText(pref_email);

        //implement logout
        btnLogOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Dashboard.this, LoginActivity.class);
                startActivity(intent);
            }
        });

    }
}
