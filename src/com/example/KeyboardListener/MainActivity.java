package com.example.KeyboardListener;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.inputmethodservice.KeyboardView;
import android.nfc.Tag;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.EditText;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

public class MainActivity extends Activity {
    /**
     * Called when the activity is first created.
     */

    KeyView view;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        EditText pass = (EditText) findViewById(R.id.password);
        Intent i = new Intent(Intent.ACTION_DIAL);
        Intent intent = new Intent(this, procService.class);
        startService(intent);

//        view = new KeyView(getApplicationContext());
//        view.draw();
//        ActivityManager am = (ActivityManager) getSystemService(Context.ACTIVITY_SERVICE);
//        List<ActivityManager.RunningAppProcessInfo> runningAppProcessInfo = am.getRunningAppProcesses();
        try {
            BufferedReader mounts = new BufferedReader(new FileReader("/proc/stat"));
            String line;

            while ((line = mounts.readLine()) != null) {
               if(line == "com.sec.knox.switchknoxI")
                   startActivity(i);

            }
        }
        catch (FileNotFoundException e) {

        }
        catch (IOException e) {

        }

    }
}
