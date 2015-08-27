package com.example.KeyboardListener;

import android.content.Context;
import android.graphics.Color;
import android.graphics.PixelFormat;
import android.os.Handler;
import android.os.Looper;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;

import java.io.IOException;
import java.util.logging.LoggingPermission;

/**
 * Created by Simon on 13/08/2015.
 */
public class KeyView extends View
    {
        private WindowManager windowManager;
        private WindowManager.LayoutParams params;
        private Object lock;

        public KeyView(Context context)
        {
            super(context);
            lock = new Object();
            windowManager = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
            params = new WindowManager.LayoutParams(
                    WindowManager.LayoutParams.WRAP_CONTENT,
                    WindowManager.LayoutParams.WRAP_CONTENT,
                    WindowManager.LayoutParams.TYPE_PHONE,
                    WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE,
                    PixelFormat.TRANSLUCENT
            );

            params.gravity = Gravity.TOP | Gravity.RIGHT;
            params.x = 0;
            params.y = 1150;

            DisplayMetrics metrics = new DisplayMetrics();
            windowManager.getDefaultDisplay().getMetrics(metrics);
            params.width = 1080;
            params.height = 770;
            this.setBackgroundColor(Color.TRANSPARENT);
        }
    public void draw()
    {
        windowManager.addView(this, params);
    }

    public void clear()
    {
        windowManager.removeViewImmediate(this);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event)
    {
        super.onTouchEvent(event);
        if(event.getAction() == MotionEvent.ACTION_DOWN)
        {
            final float x = event.getRawX();
            final float y = event.getRawY();
            System.out.println("X : " + x + " Y : " + y);
//            try
//            {
//                injectKey(x,y);
//            }
//            catch (Exception e)
//            {
//
//            }
        }

        return false;
    }

        private void injectKey(float x , float y) throws IOException
        {
            Runtime runtime = Runtime.getRuntime();
            runtime.exec("input keyevent 30");
        }
    }
