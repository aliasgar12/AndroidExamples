package com.example.alias.activityexample;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class Login extends AppCompatActivity implements View.OnClickListener{

    private static final String KEY_USERNAME = "username";
    private static final String KEY_PASSWORD = "password";

    private EditText usernameEditText , passwordEditText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        usernameEditText = (EditText) findViewById(R.id.username);
        passwordEditText = (EditText) findViewById(R.id.password);

        Button login = (Button) findViewById(R.id.login);
        Button reset = (Button) findViewById(R.id.reset);

        login.setOnclickListener(this);
        reset.setOnClickListener(this);

    }

    @Override
    public void onClick(View v){
        switch(v.getId()){
            case R.id.login:
                showWelcomeScreen();
                break;
            case R.id.reset:
                resetContents();
        }
    }


    private void showWelcomeScreen(){
        Intent intent = new Intent(this, WelcomeActivity.class);
        Bundle bundle = new Bundle();
        bundlle.putString(KEY_USERNAME, usernameEditText.getText().toString());
        bundle.putString(KEY_PASSWORD, passwordEditText.getText().toString());
        intent.putExtras(bundle);
        startActivity(intent);
    }

    private void resetContents(){
        usernameEditText.setText("");
        passwordEditText.setText("");
        usernameEditText.requestFocus();
    }
}
