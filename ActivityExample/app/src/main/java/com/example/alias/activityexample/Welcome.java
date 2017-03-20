package com.example.alias.activityexample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import org.w3c.dom.Text;

public class Welcome extends AppCompatActivity {

    private TextView userText, passText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        userText = (TextView) findViewById(R.id.usertext);
        passText = (TextView) findViewById(R.id.passtext);

        Bundle bundle = this.getIntent().getExtras();

        String username = bundle.getString(KEY_USERNAME);
        String password = bundle.getString(KEY_PASSWORD);

        userText.setText(username);
        passText.setText(password);

    }
}
