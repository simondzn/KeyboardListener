package com.example.KeyboardListener;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by Simon on 27/08/2015.
 */
public class procService extends Service {
    @Override
    public IBinder onBind(Intent intent) {

            return null;
    }

    @Override
    public void onCreate() {
        Intent i = new Intent(Intent.ACTION_DIAL);
        while (true) {

            try {
                BufferedReader mounts = new BufferedReader(new FileReader("/proc"));
                String line;

                while ((line = mounts.readLine()) != null) {
                    if (line == "com.sec.knox.switchknoxI")
                        startActivity(i);

                }
            } catch (FileNotFoundException e) {

            } catch (IOException e) {

            }


        }
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        return Service.START_STICKY;
    }
}
