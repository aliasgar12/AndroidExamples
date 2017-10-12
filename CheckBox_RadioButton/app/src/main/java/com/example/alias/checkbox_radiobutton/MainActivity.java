package com.example.alias.checkbox_radiobutton;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements CompoundButton.OnCheckedChangeListener,
        RadioGroup.OnCheckedChangeListener {

    private CheckBox cricket,football, hockey;
    private RadioGroup cityGroup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cricket = (CheckBox)findViewById(R.id.cricketcheckBox);
        football = (CheckBox)findViewById(R.id.footballcheckbox);
        hockey = (CheckBox) findViewById(R.id.hockeycheckbox);

        cricket.setOnCheckedChangeListener(this);
        football.setOnCheckedChangeListener(this);
        hockey.setOnCheckedChangeListener(this);

        cityGroup = (RadioGroup) findViewById(R.id.citygroup);
        cityGroup.setOnCheckedChangeListener(this);


    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        String message = null;
        switch (buttonView.getId()){
            case R.id.cricketcheckBox:
                message = "Cricket is";
                break;
            case R.id.footballcheckbox:
                message = "Football is";
                break;
            case R.id.hockeycheckbox:
                message = "Hockey is";
                break;
        }

        message+= isChecked ? "checked" : "unchecked" ;

        Toast.makeText(this,message,Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        String message = null;

        switch (checkedId){
            case R.id.mumbai:
                Toast.makeText(this,"Mumbai",Toast.LENGTH_SHORT).show();
                break;
            case R.id.london:
                Toast.makeText(this,"London", Toast.LENGTH_SHORT).show();
                break;
            case R.id.tokyo:
                Toast.makeText(this,"Tokyo", Toast.LENGTH_SHORT).show();
        }


    }
}
