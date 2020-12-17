package com.example.mobilepo.model.services;

import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

import androidx.annotation.Nullable;

import com.example.mobilepo.OpenLinkActivity;
import com.example.mobilepo.viewmodel.OpenLinkVM;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

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
        PendingIntent pendingIntent = intent.getParcelableExtra(OpenLinkActivity.PENDING_INTENT_KEY);
        timer = new Timer(pendingIntent);
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
            int i;
            for(i = 0; i < 100 && !stop; ++i){
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                sendActivity(new Intent().putExtra(OpenLinkActivity.TIMER_ANSWER_KEY, i),
                        OpenLinkActivity.TIMER_ANSWER);
            }
            sendActivity(new Intent().putExtra(OpenLinkActivity.TIMER_ANSWER_KEY, i),
                    OpenLinkActivity.TIMER_FINISH);
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
