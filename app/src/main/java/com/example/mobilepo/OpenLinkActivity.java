package com.example.mobilepo;

import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.app.PendingIntent;
import android.app.SearchManager;
import android.content.Intent;
import android.graphics.Path;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.mobilepo.databinding.ActivityOpenLinkBinding;
import com.example.mobilepo.model.services.MyService;
import com.example.mobilepo.viewmodel.OpenLinkVM;

public class OpenLinkActivity extends AppCompatActivity {
    public static final String PENDING_INTENT_KEY = "pending_intent";
    public static final String TIMER_ANSWER_KEY = "ans";

    private static final int TIMER_SERVICE = 1;
    public static final int TIMER_ANSWER = 2;
    public static final int TIMER_FINISH = 3;

    private OpenLinkVM openLinkVM;
    private ActivityOpenLinkBinding activityOpenLinkBinding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_open_link);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        Intent intent = getIntent();
        String messageText = intent.getStringExtra(intent.EXTRA_TEXT);
        activityOpenLinkBinding = DataBindingUtil.setContentView(this, R.layout.activity_open_link);
        openLinkVM = new OpenLinkVM(this, messageText);
        activityOpenLinkBinding.setVm(openLinkVM);
    }


    public void startmyService(){
        PendingIntent pendingIntent = createPendingResult(TIMER_SERVICE, new Intent(), 0);
        Intent intent = new Intent(this, MyService.class);
        intent.putExtra(PENDING_INTENT_KEY, pendingIntent);
        startService(intent);
    }

    public void stopmyService(){
        Intent intent = new Intent(this, MyService.class);
        stopService(intent);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if (requestCode == TIMER_SERVICE) {
            int timer = data.getIntExtra(TIMER_ANSWER_KEY, 0);
            switch (resultCode) {
                case TIMER_ANSWER:
                    Toast.makeText(this, String.valueOf(timer), Toast.LENGTH_SHORT).show();
                    break;
                case TIMER_FINISH:
                    openLinkVM.saveTimer(String.valueOf(timer));
                    String res = openLinkVM.getTimer();
                    res = "Result from file "+res;
                    Toast.makeText(this, res, Toast.LENGTH_LONG).show();
                    break;
            }
        }
        super.onActivityResult(requestCode, resultCode, data);
    }
}