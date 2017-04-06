package com.example.alias.broadcastreceivertest;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

/**
 * Created by alias on 1/31/2017.
 */

public class InstallUninstallReciever extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {

        String packageName = intent.getData().getSchemeSpecificPart();

        if(intent.getAction().equals(Intent.ACTION_PACKAGE_ADDED)){
            Toast.makeText(context, "Installed " + packageName, Toast.LENGTH_LONG).show();
        }
        if(intent.getAction().equals(Intent.ACTION_PACKAGE_REMOVED)){
            Toast.makeText(context, "Uninstalled " + packageName, Toast.LENGTH_LONG).show();
        }

    }
}
