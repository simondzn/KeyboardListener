package com.example.KeyboardListener;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/**
 * Created by Simon on 27/08/2015.
 */
public class KnoxBroad extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
//        Intent i = new Intent(getAplicationContext(),MainActivity.class);
        context.startActivity(intent);
    }
}
