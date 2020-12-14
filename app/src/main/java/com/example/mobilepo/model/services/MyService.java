package com.example.mobilepo.model.services;

import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

import androidx.annotation.Nullable;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MyService extends Service {
    public MyService() {
    }

    ExecutorService es;
    Timer timer;

    public void onCreate() {
        super.onCreate();
        es = Executors.newFixedThreadPool(2);
    }

    public void onDestroy() {
        timer.stop();
        super.onDestroy();
    }

    public int onStartCommand(Intent intent, int flags, int startId) {
    //    PendingIntent pendingIntent = intent.getParcelableExtra(MainActivity3.PENDING_INTENT_KEY);
      //  timer = new Timer(pendingIntent);
        es.execute(timer);
        return super.onStartCommand(intent, flags, startId);
    }


    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }


    class Timer implements Runnable {
        Boolean stop;
        PendingIntent pi;

        public Timer(PendingIntent pi) {
            this.pi = pi;
            this.stop = false;
        }

        public void run() {
            for(int i = 0; i < 10000 && !stop; ++i){
                try {
                    Thread.sleep( 1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
             //   sendActivity(new Intent().putExtra(MainActivity3.COUNTER_ANSWER_KEY, i),
               //         MainActivity3.COUNTER_ANSWER);
            }
        }

        void stop() {
            this.stop = true;
        }

        void sendActivity(Intent intent, int code){
            try {
                pi.send(MyService.this, code, intent);
            }
            catch (PendingIntent.CanceledException e){
                e.printStackTrace();
            }
        }
    }
}
