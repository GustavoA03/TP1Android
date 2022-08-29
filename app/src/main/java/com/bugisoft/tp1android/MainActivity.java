package com.bugisoft.tp1android;

import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    private Connections connection;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        permission();

    }

    @Override
    protected void onResume() {
        this.connection = new Connections();
        registerReceiver(this.connection, new IntentFilter("android.net.wifi.supplicant.CONNECTION_CHANGE"));
        super.onResume();
    }

    @Override
    protected void onPause() {
        unregisterReceiver(connection);
        super.onPause();
    }

    private void permission() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M
                && checkSelfPermission(Manifest.permission.CALL_PHONE)
                != PackageManager.PERMISSION_GRANTED) {
            requestPermissions(new String[]{Manifest.permission.CALL_PHONE}, 1000);
        }
    }
}