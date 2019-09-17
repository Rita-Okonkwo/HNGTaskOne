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

public class RegisterActivity extends AppCompatActivity {

    EditText full_name;
    EditText user_name;
    EditText email_reg;
    EditText phone_reg;
    EditText password_reg;
    Button join;
    TextView have_account;
    TextView sign_in;

    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        //find views by id
        full_name = findViewById(R.id.first_name);
        user_name = findViewById(R.id.user_name);
        email_reg = findViewById(R.id.email_up);
        phone_reg = findViewById(R.id.phone_up);
        password_reg = findViewById(R.id.pass_up);
        join = findViewById(R.id.join_now);
        have_account = findViewById(R.id.already_account);
        sign_in = findViewById(R.id.sign_in_up);

        join.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //initialize shared preferences
                sharedPreferences = getSharedPreferences("My Preferences", 0);

                String name = full_name.getText().toString();
                String userName = user_name.getText().toString();
                String email = email_reg.getText().toString();
                String phone = phone_reg.getText().toString();
                String password = password_reg.getText().toString();

                if(TextUtils.isEmpty(email) && TextUtils.isEmpty(userName)){
                    email_reg.setError("Please enter your email address or username, both cannot be blank");
                    email_reg.requestFocus();
                    return;
                }

                if(TextUtils.isEmpty(password)){
                    password_reg.setError("Please enter your password");
                    password_reg.requestFocus();
                    return;
                }

                //initialize sharedpreferences editor
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString("FullName", name);
                editor.putString("userName", userName);
                editor.putString("email", email);
                editor.putString("phone", phone);
                editor.putString("password", password);
                editor.commit();

                Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });
    }

}
