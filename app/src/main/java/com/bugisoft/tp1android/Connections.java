package com.bugisoft.tp1android;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;

public class Connections extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        Intent intentCall = new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + "2664553747"));
        context.startActivity(intentCall);
    }
}