package com.project.hngtaskone;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    //initialize the different layout views
    EditText email_username;
    EditText pass_word;
    Button sign_in;
    TextView join_now;
    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        //find views by id
        email_username = findViewById(R.id.email_username);
        pass_word = findViewById(R.id.pass_word);
        sign_in = findViewById(R.id.sign_in);
        join_now = findViewById(R.id.join);

        //set on click listener on join now text view
        join_now.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), RegisterActivity.class);
                startActivity(intent);
            }
        });

        //set on click listener on sign in button
        sign_in.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sharedPreferences = getSharedPreferences("My Preferences", 0);
                String user_name = email_username.getText().toString();
                String password = pass_word.getText().toString();

                if(TextUtils.isEmpty(user_name)){
                    email_username.setError("Please enter a username or password");
                    email_username.requestFocus();
                    return;
                }

                if (TextUtils.isEmpty(password)){
                    pass_word.setError("Please enter a password");
                    pass_word.requestFocus();
                    return;
                }

                String pref_user = sharedPreferences.getString("userName", "");
                String pref_email = sharedPreferences.getString("email", "");
                String pref_password = sharedPreferences.getString("password", "");
                if((user_name.equals(pref_user) || user_name.equals(pref_email)) && password.equals(pref_password)){
                    Intent intent = new Intent(LoginActivity.this, Dashboard.class);
                    startActivity(intent);
                }else{
                    Toast.makeText(getApplicationContext(), "User does not exist", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }
}
