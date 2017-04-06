package com.example.alias.broadcastreceivertest;

import android.content.Intent;
import android.content.IntentFilter;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private InstallUninstallReciever installUninstallReciever;
    private CustomBroadcastReceiver customBroadcastReceiver;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button registerLocalBroadcast = (Button) findViewById(R.id.registerLocalBroadcast);
        Button unregisterLocalBroadcast = (Button) findViewById(R.id.unregisterLocalBroadcast);
        Button sendLocalBroadcast = (Button) findViewById(R.id.sendLocalBroadcast);
        Button registerSystemBroadcast = (Button) findViewById(R.id.registerSystemBroadcast);
        Button unregisterSystemBroadcast = (Button) findViewById(R.id.unregisterSystemBroadcast);

        registerLocalBroadcast.setOnClickListener(this);
        unregisterLocalBroadcast.setOnClickListener(this);
        sendLocalBroadcast.setOnClickListener(this);
        registerSystemBroadcast.setOnClickListener(this);
        unregisterSystemBroadcast.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.registerLocalBroadcast:
                registerLocalBroadcast();
                break;
            case R.id.unregisterLocalBroadcast:
                unregisterLocalBroadcast();
                break;
            case R.id.registerSystemBroadcast:
                registerSystemBroadcast();
                break;
            case R.id.unregisterSystemBroadcast:
                unregisterSystemBroadcast();
                break;
            case R.id.sendLocalBroadcast:
                sendLocalBroadcast();
                break;
        }

    }

    private void registerLocalBroadcast() {

        customBroadcastReceiver = new CustomBroadcastReceiver();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("broadcast");
        LocalBroadcastManager.getInstance(this).registerReceiver(customBroadcastReceiver,intentFilter);

    }

    private void unregisterLocalBroadcast() {
        if(customBroadcastReceiver!=null){
            LocalBroadcastManager.getInstance(this).unregisterReceiver(customBroadcastReceiver);
            customBroadcastReceiver = null;
        }
    }

    private void sendLocalBroadcast() {

        Intent intent = new Intent();
        intent.setAction("broadcast");
        intent.putExtra("message", "This is a local broadcast!");
        LocalBroadcastManager.getInstance(this).sendBroadcast(intent);
    }

    private void registerSystemBroadcast() {

        installUninstallReciever = new InstallUninstallReciever();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(Intent.ACTION_PACKAGE_ADDED);
        intentFilter.addAction(Intent.ACTION_PACKAGE_REMOVED);
        intentFilter.addAction(Intent.ACTION_PACKAGE_CHANGED);
        intentFilter.addDataScheme("package");
        registerReceiver(installUninstallReciever,intentFilter);

    }

    private void unregisterSystemBroadcast() {

        if(installUninstallReciever!=null){
            unregisterReceiver(installUninstallReciever);
            installUninstallReciever = null;
        }
    }
}
