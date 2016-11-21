package com.example.rm31374.broadcastreceiver.broadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

/**
 * Created by rm31374 on 21/11/2016.
 */
public class MyOrderedReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        Toast.makeText(context, "Receiver 1", Toast.LENGTH_LONG).show();
    }
}
